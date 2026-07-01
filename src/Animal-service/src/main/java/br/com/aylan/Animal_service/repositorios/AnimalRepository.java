package br.com.aylan.Animal_service.repositorios;




import br.com.aylan.Animal_service.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import br.com.aylan.Animal_service.dto.FuncionarioResgateDTO;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("SELECT new br.com.aylan.Animal_service.dto.FuncionarioResgateDTO(a.nomerecebedor, COUNT(a)) " +
           "FROM Animal a " +
           "WHERE a.dataEntrada >= :dataInicial AND a.dataEntrada <= :dataFinal " +
           "GROUP BY a.nomerecebedor")
    List<FuncionarioResgateDTO> countResgatesPorFuncionario(
            @Param("dataInicial") LocalDate dataInicial, 
            @Param("dataFinal") LocalDate dataFinal);

}