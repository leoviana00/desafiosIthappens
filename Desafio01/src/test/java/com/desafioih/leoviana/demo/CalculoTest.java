package com.desafioih.leoviana.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculoTest {

    @Test
    void executaCalculo() {
        float PassaValor1 = 1;
        float PassaValor2 = 1;
        float RetornoEsperado = 2;

        float RetornoFeito = Calculo.ExecutaCalculo(PassaValor1, PassaValor2);
        assertEquals(RetornoEsperado, RetornoFeito,0);
    }
}