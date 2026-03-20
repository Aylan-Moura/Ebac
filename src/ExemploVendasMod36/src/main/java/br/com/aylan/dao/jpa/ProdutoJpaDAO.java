/**
 * 
 */
package br.com.aylan.dao.jpa;

import br.com.aylan.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.aylan.domain.jpa.ProdutoJpa;

/**
 * @author aylan
 *
 */
public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
