
package Operations;

import Data.Stack;
import java.util.Scanner;

/**
 * Class that handles operations with the class Stack.
 * @author Frida Johansson
 */
public class OperationsForStack {
        Stack stack;
        Stack revStack;
        
    public OperationsForStack()
    {
        
    }
    /**
     * Method "start" handles a sequence of number from users input and calls methods
     * to print the stack in reverse. 
     * Pushes the digit on th stack with modulu operator to get the last digit of the integer.
     * @param scanner scans inputs from user
     */
    public void start(Scanner scanner)
    {
        System.out.println("Please enter a number. \n ");
        while(scanner.hasNextInt())
        {
            int number = scanner.nextInt();
            int length = String.valueOf(number).length();
            stack = new Stack(length);
            revStack = new Stack(length);
            while(number>0)
            {
                int digit = number%10;
                
                stack.push(digit);
                number = number/10;
            }
            printStack(stack);
            if(scanner.hasNextLine())
                break;
        }
    }
    private void printStack(Stack stack)
    {
        System.out.println("Your original stack: " + stack.toString());
        printStackIterative(stack);
        while(!revStack.isEmpty())
       {
            stack.push(revStack.pop());
       }
        printStackRecursive(stack);
        System.out.println("Your recursive reversed stack: " + revStack.toString());
    }
    /**
     * Method will iterate through stack until it is empty and
     * due to LIFO-stack it can just use method pop and push that integer 
     * to another stack, revStack and it will be reversed.
     * 
     * @param stack represent the stack with integers
     */
    private void printStackIterative(Stack stack)
    {
       while(!stack.isEmpty())
       {
            revStack.push(stack.pop());
       }
       System.out.println("Your iterative reversed stack: " + revStack.toString());
    }
    /**
     * Method will call itself while it pops from the stack 
     * and pushes the integer into another stack, revStack.
     * 
     * @param stack represents the stack with integers.
     */
    private void printStackRecursive(Stack stack)
    {
        revStack.push(stack.pop());
        printStackRecursive(stack); 
    }
}
