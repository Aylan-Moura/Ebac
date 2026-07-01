package br.com.aylan.Animal_service.controllers;

import org.springframework.web.bind.annotation.*;
import br.com.aylan.Animal_service.repositorios.AnimalRepository;
import br.com.aylan.Animal_service.entidades.Animal;
import br.com.aylan.Animal_service.servicos.AnimalService;
import br.com.aylan.Animal_service.dto.FuncionarioResgateDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository repository;
    private final AnimalService service;

    public AnimalController(AnimalRepository repository, AnimalService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    private List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/resgates-por-funcionario")
    public List<FuncionarioResgateDTO> relatorioResgatesPorFuncionario(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return service.relatorioResgatesPorFuncionario(dataInicial, dataFinal);
    }
}