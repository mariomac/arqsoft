package edu.upc.swarch.lesson01.part1;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {
    private List<Double> stack = new ArrayList<>();

    @Override
    public void push(Double n) {
        stack.add(n);
    }

    @Override
    public Double pop() throws StackSizeException {
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

    @Override
    public Double[] getStack() {
        return stack.toArray(new Double[0]);
    }
}
