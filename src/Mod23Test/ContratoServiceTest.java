package Mod23Test;

import org.junit.Assert;
import org.junit.Test;


public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IcontratoService service = new ContratoService();
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void excluirTest() {
        IcontratoService service = new ContratoService();
        String retorno = service.excluir();
        Assert.assertEquals("Excluído", retorno);
    }

    @Test
    public void buscarTest() {
        IcontratoService service = new ContratoService();
        String retorno = service.buscar();
        Assert.assertEquals("Encontrado", retorno);
    }

    @Test
    public void atualizarTest() {
        IcontratoService service = new ContratoService();
        String retorno = service.atualizar();
        Assert.assertEquals("Atualizado", retorno);
    }
}

