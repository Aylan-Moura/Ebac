package br.com.ebac.categoryservice.services;

import br.com.ebac.categoryservice.entities.CategoriaMeme;
import br.com.ebac.categoryservice.repositories.CategoriaMemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaMemeService {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaMemeService.class);
    private final CategoriaMemeRepository repository;

    public CategoriaMemeService(CategoriaMemeRepository repository) {
        this.repository = repository;
    }

    public List<CategoriaMeme> findAll() {
        logger.info("Buscando todas as categorias");
        return repository.findAll();
    }

    public Optional<CategoriaMeme> findById(Long id) {
        logger.info("Buscando categoria com id={}", id);
        return repository.findById(id);
    }

    public CategoriaMeme save(CategoriaMeme categoria) {
        logger.info("Salvando nova categoria: {}", categoria.getNome());
        if(categoria.getDataCadastro() == null) {
            categoria.setDataCadastro(new java.sql.Date(System.currentTimeMillis()));
        }
        return repository.save(categoria);
    }
}
