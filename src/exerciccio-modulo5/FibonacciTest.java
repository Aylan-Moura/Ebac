package com.exercicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para a classe {@link Fibonacci}.
 *
 * Exercício 2 – Ainda sobre testes unitários
 *
 * Sequência esperada: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
 */
@DisplayName("Testes do Fibonacci Recursivo")
class FibonacciTest {

    private Fibonacci fib;

    @BeforeEach
    void setUp() {
        fib = new Fibonacci();
    }

    // -------------------------------------------------------------------------
    // Teste 1 – Casos base
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("F(0) deve ser 0 e F(1) deve ser 1 (casos base da recursão)")
    void casosBase() {
        assertEquals(0, fib.calcular(0), "F(0) deve ser 0");
        assertEquals(1, fib.calcular(1), "F(1) deve ser 1");
    }

    // -------------------------------------------------------------------------
    // Teste 2 – Termos conhecidos da sequência
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Termos conhecidos: F(2) a F(10)")
    void termosConhecidos() {
        int[] esperados = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        for (int i = 0; i <= 10; i++) {
            assertEquals(esperados[i], fib.calcular(i),
                    "Falha em F(" + i + ")");
        }
    }

    // -------------------------------------------------------------------------
    // Teste 3 – Número maior (sem estouro de pilha para valores razoáveis)
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("F(20) deve ser 6765")
    void fibonacciF20() {
        assertEquals(6765, fib.calcular(20));
    }

    // -------------------------------------------------------------------------
    // Teste 4 – Propriedade da sequência: F(n) = F(n-1) + F(n-2)
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Propriedade recursiva: F(n) == F(n-1) + F(n-2) para n entre 2 e 15")
    void propriedadeRecursiva() {
        for (int n = 2; n <= 15; n++) {
            assertEquals(
                    fib.calcular(n - 1) + fib.calcular(n - 2),
                    fib.calcular(n),
                    "Propriedade violada para n=" + n
            );
        }
    }

    // -------------------------------------------------------------------------
    // Teste 5 – Entrada inválida (negativa)
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Entrada negativa deve lançar IllegalArgumentException")
    void entradaNegativaLancaExcecao() {
        assertThrows(
                IllegalArgumentException.class,
                () -> fib.calcular(-1),
                "Deveria lançar exceção para entrada negativa"
        );
    }

    // -------------------------------------------------------------------------
    // Teste 6 – Dois termos consecutivos geram o próximo corretamente
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("A soma de F(5) e F(6) deve ser igual a F(7)")
    void somaDeDoisTermosGeroProximo() {
        assertEquals(fib.calcular(7), fib.calcular(5) + fib.calcular(6));
    }
}
