/**
 * 
 */
package br.com.aylan.dao.jpa;

import br.com.aylan.dao.generic.jpa.GenericJpaDB3DAO;
import br.com.aylan.domain.jpa.ClienteJpa2;

/**
 * @author aylan
 *
 */
public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
