
package br.com.aylan;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.aylan.dao.IProdutoDAO;
import br.com.aylan.dao.ProdutoDaoMock;
import br.com.aylan.domain.Produto;
import br.com.aylan.exceptions.DAOException;
import br.com.aylan.exceptions.TipoChaveNaoEncontradaException;
import br.com.aylan.services.IProdutoService;
import br.com.aylan.services.ProdutoService;


public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produto.setDescricao("ds");
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Aylan Moura");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Aylan Moura", produto.getNome());
	}
}
