
package br.com.aylan.dao;

import br.com.aylan.dao.generic.IGenericDAO;
import br.com.aylan.domain.Venda;
import br.com.aylan.exceptions.DAOException;
import br.com.aylan.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
