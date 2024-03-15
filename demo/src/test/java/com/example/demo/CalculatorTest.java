package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(3, 4);

        assertNotNull(result);
        assertEquals(7 , result);
        assertTrue(result > 1);
    }

    @Test
    public void divide(){
        Calculator calculator = new Calculator();

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }

}