package edu.upc.swarch.lesson01.part1;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {
    private List<Double> stack = new ArrayList<>();

    @Override
    public void push(double n) {
        stack.add(n);
    }

    @Override
    public double pop() throws StackSizeException {
        if (stack.isEmpty()) {
            throw new StackSizeException("stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public void add() throws StackSizeException {
        if (stack.size() < 2) {
            throw new StackSizeException("need at least two operators in the stack");
        }
        push(pop() + pop());
    }

    @Override
    public void mult() throws StackSizeException {
        if (stack.size() < 2) {
            throw new StackSizeException("need at least two operators in the stack");
        }
        push(pop() * pop());
    }
}
