package Genericos;

public class Main {
    public static void main(String[] args) {
        Garagem<Carro> garagem = new Garagem<>();

        garagem.adicionarCarro(new Sedan("Civic"));
        garagem.adicionarCarro(new Suv("Compass"));

        System.out.println("=== Lista de carros ===");
        garagem.listarCarros();

    }
}