/**
 * 
 */
package br.com.aylan.services;

import br.com.aylan.dao.IProdutoDAO;
import br.com.aylan.domain.Produto;
import br.com.aylan.services.generic.GenericService;

/**
 * @author aylan
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
