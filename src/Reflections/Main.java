package Reflections;

public class Main {
    public static void main(String[] args) {
        String nomeTabela = Cliente.class
                .getAnnotation(Tabela.class)
                .nome();

        System.out.println(nomeTabela);
    }
}
