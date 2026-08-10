package br.com.ebac.memeservice.controllers;

import br.com.ebac.memeservice.entities.Meme;
import br.com.ebac.memeservice.services.MemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private static final Logger logger = LoggerFactory.getLogger(MemeController.class);
    private final MemeService memeService;

    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping
    public List<Meme> getAll() {
        return memeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meme> getById(@PathVariable Long id) {
        return memeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    logger.warn("Meme com id={} não encontrado", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Meme meme) {
        try {
            Meme saved = memeService.save(meme);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/meme-do-dia")
    public ResponseEntity<Meme> getMemeDoDia() {
        Meme memeDoDia = memeService.getMemeDoDia();
        if (memeDoDia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memeDoDia);
    }
}
