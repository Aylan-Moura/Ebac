package Tarefa_ControleDeFluxo;

import java.util.Scanner;

public class CalculadoraNotas {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       double soma = 0;

       for (int i = 1; i <=4; i++) {
           System.out.println("Digite a nota " + i + ": ");
           double nota = scanner.nextDouble();
           soma+= nota;
}
       double media = soma/4;

       System.out.println("\nMédia final: " + media);

       if (media >=7){
           System.out.println("Aprovado");
       } else if (media >=5){
           System.out.println("Recuperação");
       } else {
           System.out.println("Reprovado");
       }
       scanner.close();
       }
    }
