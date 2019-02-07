package edu.upc.swarch.lesson01.part1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CalculatorImplTest {
    @Test
    public void testPush() {
        // Given a calculator
        Calculator c = new CalculatorImpl();

        // When several numbers are pushed to the stack
        c.push(1.0);
        c.push(2.0);
        c.push(3.0);
        c.push(4.0);

        // The stack contains exactly those numbers, being the tail the first pushed number and the
        // head the last pushed number
        assertArrayEquals(new Double[]{1.0, 2.0, 3.0, 4.0}, c.getStack());
    }
}
