package com.exemplo.app.service;

import com.exemplo.app.model.Produto;
import com.exemplo.app.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<Produto> listarTodos() {
        log.debug("Listando todos os produtos");
        return produtoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Produto> buscarPorId(Long id) {
        log.debug("Buscando produto por ID: {}", id);
        return produtoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Produto> buscarPorNome(String nome) {
        log.debug("Buscando produtos por nome: {}", nome);
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Transactional
    public Produto salvar(Produto produto) {
        log.debug("Salvando produto: {}", produto.getNome());

        if (produto.getId() == null && produtoRepository.existsByNomeIgnoreCase(produto.getNome())) {
            throw new IllegalArgumentException("Já existe um produto com o nome: " + produto.getNome());
        }

        Produto salvo = produtoRepository.save(produto);
        log.info("Produto salvo com sucesso. ID: {}", salvo.getId());
        return salvo;
    }

    @Transactional
    public Produto atualizar(Produto produto) {
        log.debug("Atualizando produto ID: {}", produto.getId());

        if (!produtoRepository.existsById(produto.getId())) {
            throw new IllegalArgumentException("Produto não encontrado com ID: " + produto.getId());
        }

        Produto atualizado = produtoRepository.save(produto);
        log.info("Produto atualizado com sucesso. ID: {}", atualizado.getId());
        return atualizado;
    }

    @Transactional
    public void deletar(Long id) {
        log.debug("Deletando produto ID: {}", id);

        if (!produtoRepository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado com ID: " + id);
        }

        produtoRepository.deleteById(id);
        log.info("Produto deletado com sucesso. ID: {}", id);
    }

    @Transactional(readOnly = true)
    public long contarTotal() {
        return produtoRepository.count();
    }
}
