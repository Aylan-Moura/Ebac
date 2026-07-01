package br.com.aylan.Animal_service.dto;

public class FuncionarioResgateDTO {
    
    private String nomeFuncionario;
    private Long quantidade;

    public FuncionarioResgateDTO(String nomeFuncionario, Long quantidade) {
        this.nomeFuncionario = nomeFuncionario;
        this.quantidade = quantidade;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
