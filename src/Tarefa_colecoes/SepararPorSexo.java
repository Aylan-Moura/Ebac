package Tarefa_colecoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SepararPorSexo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite nomes e sexo separados por vírgula (Ex: João-M, Maria-F, Pedro-M):");
        String entrada = sc.nextLine();

        String[] pessoas = entrada.split(",");

        List<String> masculinos = new ArrayList<>();
        List<String> femininos = new ArrayList<>();

        for (String p : pessoas) {
            p = p.trim();
            String[] dados = p.split("-");
            if (dados.length == 2) {
                String nome = dados[0].trim();
                String sexo = dados[1].trim().toUpperCase();

                if (sexo.equals("M")) {
                    masculinos.add(nome);
                } else if (sexo.equals("F")) {
                    femininos.add(nome);
                }
            }
        }

        System.out.println("\n--- Grupo Masculino ---");
        for (String nome : masculinos) {
            System.out.println(nome);
        }

        System.out.println("\n--- Grupo Feminino ---");
        for (String nome : femininos) {
            System.out.println(nome);
        }

        sc.close();
    }
}
