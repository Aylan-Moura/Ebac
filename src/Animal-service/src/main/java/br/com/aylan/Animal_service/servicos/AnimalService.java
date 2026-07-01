package br.com.aylan.Animal_service.servicos;

import br.com.aylan.Animal_service.dto.FuncionarioResgateDTO;
import br.com.aylan.Animal_service.repositorios.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public List<FuncionarioResgateDTO> relatorioResgatesPorFuncionario(LocalDate dataInicial, LocalDate dataFinal) {
        if (dataInicial == null || dataFinal == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "As datas inicial e final são obrigatórias.");
        }

        if (dataInicial.isAfter(dataFinal)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data inicial não pode ser maior que a data final.");
        }

        long daysBetween = ChronoUnit.DAYS.between(dataInicial, dataFinal);
        
        // 1 ano pode ter 365 ou 366 dias (bissexto), mas a regra mais estrita de "1 ano" geralmente é 365.
        // Vamos considerar até 366 dias (1 ano bissexto) ou adicionar 1 ano à data inicial e comparar.
        if (dataInicial.plusYears(1).isBefore(dataFinal)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O intervalo máximo permitido entre as datas é de exatamente 1 ano.");
        }

        return repository.countResgatesPorFuncionario(dataInicial, dataFinal);
    }
}
