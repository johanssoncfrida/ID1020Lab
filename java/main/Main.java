/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Operations.BalancedExpression;
import Operations.OperationsCircLinkList;
import Operations.OperationsDoubleLinkedCirkList;
import Operations.OperationsForGeneralizedQueue;
import Operations.OperationsForOrderedQueue;
import Operations.OperationsForStack;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Frida Johansson
 */
public class Main
{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        char [] expression = {'(', ')', '[', ']', '{', '}'};
        char [] other = {'(', '[', ')', ']', '{', '}'};
        char answer;
        
        do    
        {
            
            System.out.println("\nLab 1\n");
            System.out.println("\nPlease choose what you want to test.\n");
            System.out.println("1. Stack to read a sequence of integers and prints them in reverse");
            System.out.println("2. Generic Iterable FIFO-queue based on doubly linked circular list");
            System.out.println("3. Generic iterable circular list");
            System.out.println("4. Generalized queue");
            System.out.println("5. Ordered queue");
            System.out.println("6. Higher grade - parentheses, balanced or not?");
 
            int choice = scanner.nextInt();            
            switch (choice)
            {
            case 1 : 
                OperationsForStack operations = new OperationsForStack();
                operations.start(scanner);
                break;
            case 2 : 
                OperationsDoubleLinkedCirkList operationsDLCList = new OperationsDoubleLinkedCirkList();
                operationsDLCList.start(scanner);
                break;
            case 3:
               OperationsCircLinkList operationsCLList = new OperationsCircLinkList();
               operationsCLList.start(scanner);
               break;
            case 4:
                OperationsForGeneralizedQueue opGenQueue = new OperationsForGeneralizedQueue();
                opGenQueue.start(scanner);
                break;
            case 5 : 
                OperationsForOrderedQueue opOrderedQueue = new OperationsForOrderedQueue();
                opOrderedQueue.start(scanner);
                break;
            case 6 :
                BalancedExpression balanced = new BalancedExpression();
                System.out.println ("This " + expression + " is balanced: True/False\n" + balanced.isBalancedExpression(expression));
                BalancedExpression otherBalance = new BalancedExpression();
                System.out.println ("This " + other + " is balanced: True/False\n" + otherBalance.isBalancedExpression(other));
                
                System.out.println("Timecomplexity is linear. O(n), n = number of chars.\nRunning time is direct proportional to N.");
                System.out.println("");
                break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            
            System.out.println("\nDo you want to continue?\nType y for yes and n for no\n");
            answer = scanner.next().charAt(0);                        
        } while (answer == 'Y'|| answer == 'y');
   
    }
        
}
    

        
    
