package exercicio_ebac_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Troco {

    public static void calcularTroco(int quantia, int[] moedasDisponiveis) {

        Integer[] moedas = Arrays.stream(moedasDisponiveis).boxed().toArray(Integer[]::new);
        Arrays.sort(moedas, Collections.reverseOrder());

        int quantiaRestante = quantia;
        int totalMoedas = 0;

        List<Integer> moedasUtilizadas = new ArrayList<>();
        List<Integer> qtdsUtilizadas = new ArrayList<>();

        for (int moeda : moedas) {
            if (quantiaRestante <= 0) {
                break;
            }
            int qtd = quantiaRestante / moeda;
            if (qtd > 0) {
                totalMoedas += qtd;
                quantiaRestante -= qtd * moeda;
                moedasUtilizadas.add(moeda);
                qtdsUtilizadas.add(qtd);
            }
        }

        List<String> partes = new ArrayList<>();
        for (int i = 0; i < moedasUtilizadas.size(); i++) {
            int moeda = moedasUtilizadas.get(i);
            int qtd = qtdsUtilizadas.get(i);

            String qtdStr = obterNomeNumero(qtd);
            String moedaStr = obterNomeMoeda(moeda);

            if (i == 0) {
                String palavraMoeda = (qtd > 1) ? "moedas" : "moeda";
                partes.add(qtdStr + " " + palavraMoeda + " de " + moedaStr);
            } else {
                partes.add(qtdStr + " de " + moedaStr);
            }
        }

        StringBuilder descricao = new StringBuilder();
        for (int i = 0; i < partes.size(); i++) {
            descricao.append(partes.get(i));
            if (i < partes.size() - 2) {
                descricao.append(", ");
            } else if (i == partes.size() - 2) {
                descricao.append(" e ");
            }
        }

        System.out.println(totalMoedas + " (" + descricao.toString() + ")");
    }

    private static String obterNomeNumero(int n) {
        switch (n) {
            case 1:
                return "uma";
            case 2:
                return "duas";
            case 3:
                return "três";
            case 4:
                return "quatro";
            case 5:
                return "cinco";
            case 6:
                return "seis";
            case 7:
                return "sete";
            case 8:
                return "oito";
            case 9:
                return "nove";
            case 10:
                return "dez";
            default:
                return String.valueOf(n);
        }
    }

    private static String obterNomeMoeda(int valor) {
        switch (valor) {
            case 5:
                return "cinco";
            default:
                return String.valueOf(valor);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 2: Troco usando Algoritmo Guloso ===");

        int quantia = 18;
        int[] moedas = { 5, 2, 1 };

        System.out.println("Entrada: Quantia = " + quantia + ", Moedas disponíveis = " + Arrays.toString(moedas));
        System.out.print("Saída: ");
        calcularTroco(quantia, moedas);
    }
}
