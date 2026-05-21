package exercicio_ebac_2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FatorialTopDown {

    static Map<Integer, BigInteger> memo = new HashMap<>();

    public static BigInteger fatorial(int n) {

        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        BigInteger resultado =
                BigInteger.valueOf(n).multiply(fatorial(n - 1));

        memo.put(n, resultado);

        return resultado;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero = sc.nextInt();

        System.out.println(fatorial(numero));

        sc.close();
    }
}
