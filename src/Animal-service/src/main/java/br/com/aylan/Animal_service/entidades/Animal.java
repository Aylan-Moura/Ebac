
package br.com.aylan.Animal_service.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    @Column(nullable = false)
    private String nomeProvisorio;

    public String getNomeProvisorio() {
        return nomeProvisorio;
    }

    public void setNomeProvisorio(String nomeProvisorio) {
        this.nomeProvisorio = nomeProvisorio;
    }

    @Column(nullable = false)
    private Integer idadeEstimada;

    public Integer getIdadeEstimada() {
        return idadeEstimada;
    }

    public void setIdadeEstimada(Integer idadeEstimada) {
        this.idadeEstimada = idadeEstimada;
    }

    @Column(nullable = false)
    private String raca;

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Column(nullable = false)
    private Date dataEntrada;

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Column
    private Date dataAdocao;

    public Date getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(Date dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    @Column(nullable = false)
    private String condicoeschegada;

    public String getCondicoeschegada() {
        return condicoeschegada;
    }

    public void setCondicoeschegada(String condicoeschegada) {
        this.condicoeschegada = condicoeschegada;
    }

    @Column(nullable = false)
    private String nomerecebedor;

    public String getNomerecebedor() {
        return nomerecebedor;
    }

    public void setNomerecebedor(String nomerecebedor) {
        this.nomerecebedor = nomerecebedor;
    }

    @Column
    private Date dataObito;

    public Date getDataObito() {
        return dataObito;
    }

    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }

    @Column(nullable = false)
    private String porte;

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    @Column(nullable = false)
    private String tipoAnimal;

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}
