package edu.upc.swarch.lesson01;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {
    private List<Float> stack = new ArrayList<>();

    @Override
    public void push(Float n) {
        stack.add(n);
    }

    @Override
    public Float pop() throws StackSizeException {
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
    public Float[] getStack() {
        return stack.toArray(new Float[0]);
    }
}
