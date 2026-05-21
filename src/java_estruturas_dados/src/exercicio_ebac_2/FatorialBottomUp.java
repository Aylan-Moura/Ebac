package exercicio_ebac_2;

import java.math.BigInteger;
import java.util.Scanner;

public class FatorialBottomUp {

    public static BigInteger fatorial(int n) {

        BigInteger resultado = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        return resultado;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero = sc.nextInt();

        System.out.println(fatorial(numero));

        sc.close();
    }
}
