package edu.upc.swarch.stackcalc;

/**
 * Calculator is an interface describing all the functionalities of a Stack calculator
 */
public interface Calculator {
    /**
     * Pushes a number to the top of the stack
     * @param n
     */
    void push(double n);

    /**
     * Remove a number from the top of the stack and returns it
     * @return
     * @throws StackSizeException if the stack is empty
     */
    double pop() throws StackSizeException;

    /**
     * Removes the two top numbers from the stack, adds them, and pushes the result on the top
     * of the stack.
     * @throws StackSizeException if there are less than two operators in the stack
     */
    void add() throws StackSizeException;

    /**
     * Removes the two top numbers from the stack, removes them, and pushes the result on the top
     * of the stack.
     * @throws StackSizeException if there are less than two operators in the stack
     */
    void mult() throws StackSizeException;
}
