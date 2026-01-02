/**
 * 
 */
package br.com.aylan.services;

import br.com.aylan.domain.Cliente;
import br.com.aylan.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author aylan
 *
 */
public interface IClienteService {

	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

	Cliente buscarPorCPF(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
