package com.exemplo.app.controller;

import com.exemplo.app.model.Produto;
import com.exemplo.app.service.ProdutoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * Bean JSF gerenciado pelo Spring.
 * Responsável pela interação entre as páginas XHTML e o ProdutoService.
 */
@Slf4j
@Getter
@Setter
@Component
@SessionScope
public class ProdutoBean implements Serializable {

    private static final int TAMANHO_PAGINA = 10;

    private final ProdutoService produtoService;

    private List<Produto> produtos = Collections.emptyList();
    private Produto produtoSelecionado;
    private String termoBusca;
    private boolean modoEdicao = false;

    // Paginação
    private int paginaAtual = 0;
    private int totalPaginas = 0;
    private long totalRegistros = 0;
    private boolean buscaAtiva = false;

    public ProdutoBean(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostConstruct
    public void init() {
        log.debug("Inicializando ProdutoBean");
        carregarProdutos();
        novoProduto();
    }

    public void carregarProdutos() {
        buscaAtiva = false;
        termoBusca = null;
        paginaAtual = 0;
        carregarPaginaAtual();
    }

    private void carregarPaginaAtual() {
        if (buscaAtiva && termoBusca != null && !termoBusca.trim().isEmpty()) {
            Page<Produto> page = produtoService.buscarPorNomePaginado(termoBusca.trim(), paginaAtual, TAMANHO_PAGINA);
            produtos = page.getContent();
            totalPaginas = page.getTotalPages();
            totalRegistros = page.getTotalElements();
        } else {
            Page<Produto> page = produtoService.listarPaginado(paginaAtual, TAMANHO_PAGINA);
            produtos = page.getContent();
            totalPaginas = page.getTotalPages();
            totalRegistros = page.getTotalElements();
        }
        log.debug("Carregados {} produtos (página {} de {})", produtos.size(), paginaAtual + 1, totalPaginas);
    }

    public void proximaPagina() {
        if (paginaAtual < totalPaginas - 1) {
            paginaAtual++;
            carregarPaginaAtual();
        }
    }

    public void paginaAnterior() {
        if (paginaAtual > 0) {
            paginaAtual--;
            carregarPaginaAtual();
        }
    }

    public void irParaPagina(int pagina) {
        if (pagina >= 0 && pagina < totalPaginas) {
            paginaAtual = pagina;
            carregarPaginaAtual();
        }
    }

    public void novoProduto() {
        produtoSelecionado = new Produto();
        produtoSelecionado.setEstoque(0L);
        produtoSelecionado.setPreco(BigDecimal.ZERO);
        modoEdicao = false;
    }

    public void salvar() {
        try {
            if (modoEdicao) {
                produtoService.atualizar(produtoSelecionado);
                addMensagem(FacesMessage.SEVERITY_INFO, "Sucesso!", "Produto atualizado com sucesso.");
            } else {
                produtoService.salvar(produtoSelecionado);
                addMensagem(FacesMessage.SEVERITY_INFO, "Sucesso!", "Produto cadastrado com sucesso.");
            }
            carregarPaginaAtual();
            novoProduto();
        } catch (IllegalArgumentException e) {
            addMensagem(FacesMessage.SEVERITY_WARN, "Atenção!", e.getMessage());
        } catch (Exception e) {
            log.error("Erro ao salvar produto", e);
            addMensagem(FacesMessage.SEVERITY_ERROR, "Erro!", "Ocorreu um erro ao salvar o produto.");
        }
    }

    public void editar(Produto produto) {
        // Cria uma cópia para edição
        this.produtoSelecionado = new Produto();
        this.produtoSelecionado.setId(produto.getId());
        this.produtoSelecionado.setNome(produto.getNome());
        this.produtoSelecionado.setDescricao(produto.getDescricao());
        this.produtoSelecionado.setPreco(produto.getPreco());
        this.produtoSelecionado.setEstoque(produto.getEstoque());
        this.modoEdicao = true;
        log.debug("Editando produto: {}", produto.getNome());
    }

    public void deletar(Produto produto) {
        try {
            produtoService.deletar(produto.getId());
            addMensagem(FacesMessage.SEVERITY_INFO, "Sucesso!", "Produto removido com sucesso.");
            // Se a página atual ficar vazia após deletar, voltar uma página
            if (produtos.size() == 1 && paginaAtual > 0) {
                paginaAtual--;
            }
            carregarPaginaAtual();
            novoProduto();
        } catch (Exception e) {
            log.error("Erro ao deletar produto ID: {}", produto.getId(), e);
            addMensagem(FacesMessage.SEVERITY_ERROR, "Erro!", "Não foi possível remover o produto.");
        }
    }

    public void buscar() {
        if (termoBusca != null && !termoBusca.trim().isEmpty()) {
            buscaAtiva = true;
            paginaAtual = 0;
            carregarPaginaAtual();
        } else {
            limparBusca();
        }
    }

    public void limparBusca() {
        termoBusca = null;
        buscaAtiva = false;
        paginaAtual = 0;
        carregarPaginaAtual();
    }

    public void cancelar() {
        novoProduto();
    }

    public long getTotalProdutos() {
        return produtoService.contarTotal();
    }

    public boolean isPrimeiraPagina() {
        return paginaAtual == 0;
    }

    public boolean isUltimaPagina() {
        return paginaAtual >= totalPaginas - 1;
    }

    public int getPaginaDisplay() {
        return paginaAtual + 1;
    }

    private void addMensagem(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
