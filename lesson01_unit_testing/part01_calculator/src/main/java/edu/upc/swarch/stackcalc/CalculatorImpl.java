package edu.upc.swarch.stackcalc;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the calculator interface
 */
public class CalculatorImpl implements Calculator {
    private List<Double> stack = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(double n) {
        stack.add(n);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double pop() throws StackSizeException {
        if (stack.isEmpty()) {
            throw new StackSizeException("stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add() throws StackSizeException {
        if (stack.size() < 2) {
            throw new StackSizeException("need at least two operators in the stack");
        }
        push(pop() + pop());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mult() throws StackSizeException {
        if (stack.size() < 2) {
            throw new StackSizeException("need at least two operators in the stack");
        }
        push(pop() * pop());
    }
}
