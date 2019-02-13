package edu.upc.swarch.stackcalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorImplTest {
    @Test
    public void testPushPop() throws Exception {
        // Given a calculator
        Calculator c = new CalculatorImpl();

        // When several numbers are pushed to the stack
        c.push(1.0);
        c.push(2.0);
        c.push(3.0);
        c.push(4.0);

        // The numbers are popped in a "Last-In, First-Out" way
        final double delta = 0.00001;
        assertEquals(4.0, c.pop(), delta);
        assertEquals(3.0, c.pop(), delta);
        assertEquals(2.0, c.pop(), delta);
        assertEquals(1.0, c.pop(), delta);
    }
}
