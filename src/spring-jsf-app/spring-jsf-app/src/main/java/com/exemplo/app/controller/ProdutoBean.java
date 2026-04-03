package com.exemplo.app.controller;

import com.exemplo.app.model.Produto;
import com.exemplo.app.service.ProdutoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigDecimal;
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

    private final ProdutoService produtoService;

    private List<Produto> produtos;
    private Produto produtoSelecionado;
    private String termoBusca;
    private boolean modoEdicao = false;

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
        produtos = produtoService.listarTodos();
        log.debug("Carregados {} produtos", produtos.size());
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
            carregarProdutos();
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
            carregarProdutos();
            novoProduto();
        } catch (Exception e) {
            log.error("Erro ao deletar produto ID: {}", produto.getId(), e);
            addMensagem(FacesMessage.SEVERITY_ERROR, "Erro!", "Não foi possível remover o produto.");
        }
    }

    public void buscar() {
        if (termoBusca != null && !termoBusca.trim().isEmpty()) {
            produtos = produtoService.buscarPorNome(termoBusca.trim());
        } else {
            carregarProdutos();
        }
    }

    public void limparBusca() {
        termoBusca = null;
        carregarProdutos();
    }

    public void cancelar() {
        novoProduto();
    }

    public long getTotalProdutos() {
        return produtoService.contarTotal();
    }

    private void addMensagem(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
