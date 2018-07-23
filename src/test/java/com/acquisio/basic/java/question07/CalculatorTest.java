package com.acquisio.basic.java.question07;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() throws Exception{
        int result = Calculator.applyOperation(1, 3, '+');
        assertEquals(4, result, 0.00001);
    }
    @Test
    public void testSubstraction() throws Exception{
        int result = Calculator.applyOperation(2, 2, '-');
        assertEquals(0, result, 0.00001);
    }
    @Test
    public void testMultiplication() throws Exception{
        int result = Calculator.applyOperation(5, 5, '*');
        assertEquals(25, result, 0.00001);
    }
    @Test
    public void testDeletion() throws Exception{
        int result = Calculator.applyOperation(18, 3, '/');
        assertEquals(6, result, 0.00001);
    }
    @Test
    public void testDeletionByZero() throws Exception{
        Integer result = Calculator.applyOperation(18, 0, '/');
        assertNull(result);
    }
    @Test
    public void testOperator() throws Exception{
        try {
            int result = Calculator.applyOperation(2, 2, '=');
        }
        catch(Exception e) {
            assertEquals("Operator '/' not supported","Operator '/' not supported");
        }
    }

    @Test
    public void test_withMaxInt() throws Exception{
        int result = Calculator.applyOperation(Integer.MAX_VALUE, 1, '+');
        assertEquals(-2.147483648E9, result, 0.00001);
    }

}
