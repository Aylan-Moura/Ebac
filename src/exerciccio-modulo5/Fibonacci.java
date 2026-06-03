package com.exercicios;

/**
 * Utilitário para cálculo da sequência de Fibonacci de forma recursiva.
 *
 * <p>A sequência de Fibonacci é definida como:</p>
 * <pre>
 *   F(0) = 0
 *   F(1) = 1
 *   F(n) = F(n-1) + F(n-2),  para n &gt;= 2
 * </pre>
 *
 * @author Exercício Backend Java - Módulo 05
 * @version 1.0
 */
public class Fibonacci {

    /**
     * Calcula o n-ésimo termo da sequência de Fibonacci de forma recursiva.
     *
     * @param n posição na sequência (deve ser &gt;= 0)
     * @return o valor F(n) na sequência de Fibonacci
     * @throws IllegalArgumentException se {@code n} for negativo
     */
    public int calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "A posição não pode ser negativa. Valor recebido: " + n);
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        return calcular(n - 1) + calcular(n - 2);
    }
}
