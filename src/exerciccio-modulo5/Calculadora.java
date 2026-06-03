package com.exercicios;

/**
 * Classe que representa uma calculadora simples com operações aritméticas básicas.
 *
 * <p>Esta calculadora suporta as quatro operações fundamentais: adição, subtração,
 * multiplicação e divisão, todas operando sobre números inteiros.</p>
 *
 * <p>Atenção: a operação de divisão lança uma exceção caso o divisor seja zero.</p>
 *
 * @author Exercício Backend Java - Módulo 05
 * @version 1.0
 */
public class Calculadora {

    /**
     * Soma dois números inteiros.
     *
     * @param a o primeiro operando
     * @param b o segundo operando
     * @return a soma de {@code a} e {@code b}
     */
    private int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número inteiro do primeiro.
     *
     * @param a o minuendo (número do qual se subtrai)
     * @param b o subtraendo (número a ser subtraído)
     * @return a diferença entre {@code a} e {@code b}
     */
    private int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a o primeiro fator
     * @param b o segundo fator
     * @return o produto de {@code a} e {@code b}
     */
    private int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide o primeiro número inteiro pelo segundo.
     *
     * <p><strong>Atenção:</strong> este método lança {@link ArithmeticException}
     * caso o divisor {@code b} seja igual a zero, evitando o erro de
     * <em>division by zero</em>.</p>
     *
     * @param a o dividendo
     * @param b o divisor (não pode ser zero)
     * @return o quociente inteiro da divisão de {@code a} por {@code b}
     * @throws ArithmeticException se {@code b} for igual a zero
     */
    private int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        return a / b;
    }

    // -------------------------------------------------------------------------
    // Métodos package-private para que os testes unitários consigam invocá-los
    // sem precisar de reflexão. Em um projeto real os métodos seriam públicos ou
    // a visibilidade seria ajustada de acordo com o design da aplicação.
    // -------------------------------------------------------------------------

    int adicionarVisivel(int a, int b)    { return adicionar(a, b); }
    int subtrairVisivel(int a, int b)     { return subtrair(a, b); }
    int multiplicarVisivel(int a, int b)  { return multiplicar(a, b); }
    int dividirVisivel(int a, int b)      { return dividir(a, b); }
}
