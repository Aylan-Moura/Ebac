package br.com.ebac.categoryservice.controllers;

import br.com.ebac.categoryservice.entities.CategoriaMeme;
import br.com.ebac.categoryservice.services.CategoriaMemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaMemeController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaMemeController.class);
    private final CategoriaMemeService service;

    public CategoriaMemeController(CategoriaMemeService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoriaMeme> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaMeme> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    logger.warn("Categoria com id={} não encontrada", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PostMapping
    public ResponseEntity<CategoriaMeme> create(@RequestBody CategoriaMeme categoria) {
        CategoriaMeme saved = service.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
