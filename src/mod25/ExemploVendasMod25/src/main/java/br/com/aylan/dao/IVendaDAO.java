/**
 * 
 */
package br.com.aylan.dao;

import br.com.aylan.dao.generic.IGenericDAO;
import br.com.aylan.domain.Venda;
import br.com.aylan.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author aylan
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
