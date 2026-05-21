package exercicio_ebac_3;

import java.util.ArrayList;
import java.util.List;

public class Subconjuntos {

    public static void encontrarSubconjuntos(int[] S, int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        backtrack(S, n, 0, new ArrayList<>(), resultado);

        for (int i = 0; i < resultado.size(); i++) {
            System.out.print(resultado.get(i));
            if (i < resultado.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static void backtrack(int[] S, int n, int inicio, List<Integer> atual, List<List<Integer>> resultado) {

        if (atual.size() == n) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        if (atual.size() + (S.length - inicio) < n) {
            return;
        }

        for (int i = inicio; i < S.length; i++) {

            atual.add(S[i]);

            backtrack(S, n, i + 1, atual, resultado);

            atual.remove(atual.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 1: Subconjuntos usando Backtracking ===");

        int[] S1 = { 1, 2, 3 };
        int n1 = 2;
        System.out.println("Entrada: S = [1, 2, 3], n = " + n1);
        System.out.print("Saída: ");
        encontrarSubconjuntos(S1, n1);

        System.out.println();

        int[] S2 = { 1, 2, 3, 4 };
        int n2 = 1;
        System.out.println("Entrada: S = [1, 2, 3, 4], n = " + n2);
        System.out.print("Saída: ");
        encontrarSubconjuntos(S2, n2);
    }
}
