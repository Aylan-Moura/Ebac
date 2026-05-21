package exercicio_ebac_2;

import java.util.Scanner;

public class FatorialRecursivo {

    public static long fatorial(int n) {
        // condição de parada
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * fatorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = sc.nextInt();

        System.out.println(fatorial(numero));

        sc.close();
    }
}
