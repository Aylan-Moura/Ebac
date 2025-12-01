package Pessoas;

import java.util.Scanner;

public class MenuInterativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Dizer Olá");
            System.out.println("2 - Mostrar a hora atual");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Olá, usuário!");
                    break;
                case 2:
                    System.out.println("Hora atual: " + java.time.LocalTime.now());
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 3); // repete até o usuário escolher sair

        sc.close();
    }
}
