package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Acessorio> acessorios;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    public List<Acessorio> getAcessorios() { return acessorios; }
    public void setAcessorios(List<Acessorio> acessorios) { this.acessorios = acessorios; }
}
