
package br.com.aylan.services;

import br.com.aylan.domain.Cliente;
import br.com.aylan.exceptions.DAOException;
import br.com.aylan.exceptions.TipoChaveNaoEncontradaException;
import br.com.aylan.services.generic.IGenericService;


public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
