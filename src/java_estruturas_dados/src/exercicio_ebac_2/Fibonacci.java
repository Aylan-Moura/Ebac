package exercicio_ebac_2;

public class Fibonacci {

    // Fibonacci recursivo simples
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Fibonacci com programação dinâmica
    public static int fibonacciDP(int n) {

        int[] dp = new int[n + 1];

        // Adicionada uma verificação de tamanho para evitar index out of bounds em n = 0
        if (n >= 0) {
            dp[0] = 0;
        }
        if (n >= 1) {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
