package br.com.ebac.categoryservice.repositories;

import br.com.ebac.categoryservice.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaMemeRepository extends JpaRepository<CategoriaMeme, Long> {
}
