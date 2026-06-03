package com.exercicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para a classe {@link Calculadora}.
 *
 * Exercício 1 – Testes unitários
 */
@DisplayName("Testes da Calculadora")
class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    // =========================================================================
    // ADIÇÃO
    // =========================================================================

    @Test
    @DisplayName("Adição de dois positivos")
    void adicionarDoisPositivos() {
        assertEquals(8, calc.adicionarVisivel(3, 5));
    }

    @Test
    @DisplayName("Adição com número negativo")
    void adicionarComNegativo() {
        assertEquals(-2, calc.adicionarVisivel(-5, 3));
    }

    @Test
    @DisplayName("Adição de dois negativos")
    void adicionarDoisNegativos() {
        assertEquals(-9, calc.adicionarVisivel(-4, -5));
    }

    @Test
    @DisplayName("Adição com zero")
    void adicionarComZero() {
        assertEquals(7, calc.adicionarVisivel(7, 0));
    }

    // =========================================================================
    // SUBTRAÇÃO
    // =========================================================================

    @Test
    @DisplayName("Subtração básica")
    void subtrairBasico() {
        assertEquals(3, calc.subtrairVisivel(7, 4));
    }

    @Test
    @DisplayName("Subtração resultando em negativo")
    void subtrairResultadoNegativo() {
        assertEquals(-3, calc.subtrairVisivel(4, 7));
    }

    @Test
    @DisplayName("Subtração com zero")
    void subtrairComZero() {
        assertEquals(5, calc.subtrairVisivel(5, 0));
    }

    @Test
    @DisplayName("Subtração de números iguais resulta em zero")
    void subtrairIguaisResultaZero() {
        assertEquals(0, calc.subtrairVisivel(10, 10));
    }

    // =========================================================================
    // MULTIPLICAÇÃO
    // =========================================================================

    @Test
    @DisplayName("Multiplicação de dois positivos")
    void multiplicarPositivos() {
        assertEquals(20, calc.multiplicarVisivel(4, 5));
    }

    @Test
    @DisplayName("Multiplicação por zero resulta em zero")
    void multiplicarPorZero() {
        assertEquals(0, calc.multiplicarVisivel(99, 0));
    }

    @Test
    @DisplayName("Multiplicação com número negativo")
    void multiplicarComNegativo() {
        assertEquals(-15, calc.multiplicarVisivel(3, -5));
    }

    @Test
    @DisplayName("Multiplicação de dois negativos resulta em positivo")
    void multiplicarDoisNegativos() {
        assertEquals(12, calc.multiplicarVisivel(-3, -4));
    }

    // =========================================================================
    // DIVISÃO – atenção especial ao division by zero!
    // =========================================================================

    @Test
    @DisplayName("Divisão exata de positivos")
    void dividirExato() {
        assertEquals(4, calc.dividirVisivel(20, 5));
    }

    @Test
    @DisplayName("Divisão inteira (quociente truncado)")
    void dividirInteiro() {
        // 7 / 2 = 3 (divisão inteira em Java descarta a fração)
        assertEquals(3, calc.dividirVisivel(7, 2));
    }

    @Test
    @DisplayName("Divisão de negativo por positivo")
    void dividirNegativoPorPositivo() {
        assertEquals(-3, calc.dividirVisivel(-9, 3));
    }

    @Test
    @DisplayName("Divisão por 1 retorna o próprio número")
    void dividirPorUm() {
        assertEquals(42, calc.dividirVisivel(42, 1));
    }

    @Test
    @DisplayName("Divisão por zero deve lançar ArithmeticException")
    void dividirPorZeroLancaExcecao() {
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> calc.dividirVisivel(10, 0)
        );
        // Verifica que a mensagem é informativa
        assertTrue(ex.getMessage().toLowerCase().contains("zero"),
                "A mensagem da exceção deve mencionar 'zero'");
    }

    @Test
    @DisplayName("Divisão de zero por qualquer número resulta em zero")
    void dividirZeroPorNumero() {
        assertEquals(0, calc.dividirVisivel(0, 5));
    }
}
