package com.exemplo.app.controller;

import com.exemplo.app.model.Produto;
import com.exemplo.app.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para operações de Produto.
 * Expõe endpoints da API para integração externa.
 * A interface visual é gerenciada pelo JSF (ProdutoBean).
 */
@Slf4j
@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        log.info("GET /api/produtos - Listando todos os produtos");
        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        log.info("GET /api/produtos/{} - Buscando produto por ID", id);
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> buscarPorNome(@RequestParam String nome) {
        log.info("GET /api/produtos/buscar?nome={} - Buscando por nome", nome);
        List<Produto> produtos = produtoService.buscarPorNome(nome);
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto) {
        log.info("POST /api/produtos - Criando produto: {}", produto.getNome());
        Produto criado = produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id,
                                              @Valid @RequestBody Produto produto) {
        log.info("PUT /api/produtos/{} - Atualizando produto", id);
        produto.setId(id);
        Produto atualizado = produtoService.atualizar(produto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("DELETE /api/produtos/{} - Deletando produto", id);
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total")
    public ResponseEntity<Long> contarTotal() {
        return ResponseEntity.ok(produtoService.contarTotal());
    }
}
