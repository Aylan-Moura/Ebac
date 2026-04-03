package com.exemplo.app.repository;

import com.exemplo.app.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Busca por nome (contém, ignorando maiúsculas/minúsculas)
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    // Busca por preço máximo
    List<Produto> findByPrecoLessThanEqual(BigDecimal precoMaximo);

    // Busca produtos com estoque disponível
    List<Produto> findByEstoqueGreaterThan(Long quantidade);

    // Query JPQL customizada: produtos abaixo de um preço ordenados
    @Query("SELECT p FROM Produto p WHERE p.preco <= :preco ORDER BY p.preco ASC")
    List<Produto> buscarPorPrecoMaximo(@Param("preco") BigDecimal preco);

    // Verificar se nome já existe (para validação)
    boolean existsByNomeIgnoreCase(String nome);
}
