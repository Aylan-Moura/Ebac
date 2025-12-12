package Mod23Test;

public class ContratoService implements IcontratoService {
    @Override
    public String salvar() {
        return "Sucesso";
    }

    @Override
    public String excluir() {
        return "Excluído";
    }

    @Override
    public String buscar() {
        return "Encontrado";
    }

    @Override
    public String atualizar() {
        return "Atualizado";
    }
}
