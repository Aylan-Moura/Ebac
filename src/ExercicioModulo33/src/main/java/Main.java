import jakarta.persistence.*;
import model.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carroPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Marca marca = new Marca();
        marca.setNome("Toyota");

        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setAno(2022);
        carro.setMarca(marca);

        Acessorio a1 = new Acessorio();
        a1.setNome("Ar Condicionado");
        a1.setDescricao("Digital automático");
        a1.setCarro(carro);

        Acessorio a2 = new Acessorio();
        a2.setNome("Central Multimídia");
        a2.setDescricao("Tela 10 polegadas");
        a2.setCarro(carro);

        carro.setAcessorios(List.of(a1, a2));
        marca.setCarros(List.of(carro));

        em.persist(marca);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
