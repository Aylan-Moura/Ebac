package TestJunit;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pessoa {
    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Sexo: " + sexo;
    }
}

public class CadastroPessoas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coleções separadas
        List<Streams.Pessoa> homens = new ArrayList<>();
        List<Streams.Pessoa> mulheres = new ArrayList<>();

        while (true) {
            System.out.print("Digite o nome da pessoa (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o sexo da pessoa (M/F): ");
            String sexo = scanner.nextLine();

            Streams.Pessoa p = new Streams.Pessoa(nome, sexo);

            // Decide em qual lista guardar
            if (p.getSexo().equalsIgnoreCase("M")) {
                homens.add(p);
            } else if (p.getSexo().equalsIgnoreCase("F")) {
                mulheres.add(p);
            } else {
                System.out.println("⚠ Sexo inválido! Use apenas M ou F.");
            }
        }


        System.out.println("\n=== Lista de Homens ===");
        for (Streams.Pessoa h : homens) {
            System.out.println(h);
        }

        System.out.println("\n=== Lista de Mulheres ===");
        for (Streams.Pessoa m : mulheres) {
            System.out.println(m);
        }

        System.out.println("\n Apenas nomes femininos (com Streams)");
        mulheres.stream()
                .map(Streams.Pessoa::getNome)
                .forEach(System.out::println);


        scanner.close();
    }
}