package edu.upc.swarch.lesson01;

public interface Calculator {
    void push(Float n);

    Float pop() throws StackSizeException;

    void add() throws StackSizeException;

    void mult() throws StackSizeException;

    Float[] getStack();
}
