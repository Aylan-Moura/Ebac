
package br.com.aylan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.aylan.dao.ClienteDaoMock;
import br.com.aylan.dao.IClienteDAO;
import br.com.aylan.domain.Cliente;
import br.com.aylan.exceptions.DAOException;
import br.com.aylan.exceptions.TipoChaveNaoEncontradaException;
import br.com.aylan.services.ClienteService;
import br.com.aylan.services.IClienteService;


public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Aylan");
		cliente.setCidade("Fortaleza");
		cliente.setEnd("End");
		cliente.setEstado("CE");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setEmail("moura@gmail");
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Aylan Moura");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Aylan Moura", cliente.getNome());
	}
}
