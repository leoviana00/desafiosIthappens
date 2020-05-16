package com.desafioih.leoviana.demo;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class CalculoTest extends TestCase {
    private Calculo calc = new Calculo();

    @Test
    public void testSomar() {
            assertEquals(2,  calc.somar(1, 1), 0);
        }

     @Test
     public void testSubtrair() {
             assertEquals(4,  calc.subtrair(5, 1), 0);
     }

    }
