/**
 * 
 */
package br.com.aylan.dao.jpa;

import br.com.aylan.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.aylan.domain.jpa.ClienteJpa;

/**
 * @author aylan
 *
 */
public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
