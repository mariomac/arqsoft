package edu.upc.swarch.lesson01.part1;

public interface Calculator {
    void push(double n);

    double pop() throws StackSizeException;

    void add() throws StackSizeException;

    void mult() throws StackSizeException;
}
