/**
 * 
 */
package br.com.aylan.dao.jpa;

import br.com.aylan.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.aylan.domain.jpa.ClienteJpa;

/**
 * @author aylan
 *
 */
public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}

}
