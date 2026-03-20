package br.com.aylan.domain.jpa;

/**
 * @author aylan
 *
 * Classe que representa todas as entidades ou objetos da aplicação que seram salvas no banco de dados
 */
public interface Persistente {

    //public Long getCodigo();
	
	public Long getId();
	
	public void setId(Long id);
}
