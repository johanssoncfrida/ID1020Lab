/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Data.CircularLinkedList;
import Data.GeneralizedQueue;
import Data.OrderedQueue;
import Operations.BalancedExpression;
import Operations.OperationsCircLinkList;
import Operations.OperationsDoubleLinkedCirkList;
import Operations.OperationsForGeneralizedQueue;
import Operations.OperationsForOrderedQueue;
import Operations.OperationsForStack;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
 

/**
 * Mainclass where all calls to operations starts from.
 * The DataPackage is imported only for tests in menu "Testprogram".
 * Otherwise datapackages is not imported and menu has only access to operations. 
 * This is to improve encapsulation.
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
            System.out.println("7. Testprogram");

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
                System.out.println ("This " + Arrays.toString(expression) + " is balanced: True/False\n" + balanced.isBalancedExpression(expression));
                BalancedExpression otherBalance = new BalancedExpression();
                System.out.println ("This " + Arrays.toString(other) + " is balanced: True/False\n" + otherBalance.isBalancedExpression(other));
                
                System.out.println("Timecomplexity is linear. O(n), n = number of chars.\nRunning time is direct proportional to N.");
                System.out.println("Linear space locality: n + 1. n: number of chars plus 1 char to iterate through the loop.");
                break;
            case 7 :
                testprogram();
                break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            
            System.out.println("\nDo you want to continue and get back to main menu?\nType y for yes and n for no\n");
            answer = scanner.next().charAt(0);                        
        } while (answer == 'Y'|| answer == 'y');
  
        //***********TEST**********
        // ADD OTHER THAN INTEGER.
    }

    private static void testprogram() 
    {
        System.out.println("**************TEST TOSTRING-METHOD**************");
        CircularLinkedList list = new CircularLinkedList<Integer>();
        int number1 = 1;
        int number2 = 2;
        list.enqueueAtEnd(number1);
        list.enqueueAtEnd(number2);
        System.out.println(list.toString());
        if(list.toString().equals("[1], [2]"))
            System.out.println(list.toString() + " is the same as [1], [2]");
        else
            System.out.println("fail. not the same");
       
        System.out.println("\n\n**************TEST ITERATOR**************");
            Iterator<Integer> iterator = list.iterator();
            System.out.println(list.toString());

        while(iterator.hasNext()) 
        {
            Integer integer = iterator.next();
            System.out.println(integer.toString());
        }
        
        System.out.println("\n\n**************TEST DEQUEUE AT POSITION**************");
        GeneralizedQueue genQueue = new GeneralizedQueue<Integer>();
        for(int i = 1; i <=4; i++)
        {
            genQueue.enqueue(i);
            System.out.println(genQueue.toString());
        }
        genQueue.dequeueAtPosition(1);
        System.out.println(genQueue.toString());
        
        System.out.println("\n\n**************TEST DEQUEUE AT ORDERED QUEUE**************");
        OrderedQueue orderedQueue = new OrderedQueue();
        for(int i = 1; i <=4; i++)
        {
            orderedQueue.enqueue(i);
            System.out.println(orderedQueue.toString());
        }
        orderedQueue.dequeue();
        System.out.println(orderedQueue.toString());
        
        System.out.println("\n\n**************TEST ENQUEUE SOMETHING ELSE TAN THE GENERIC SPECIFIED TYPE**************");
        System.out.println("\nCircular linked list can only take integers. Enter something else.\n");
        Scanner testScanner = new Scanner(System.in);
        String word = testScanner.next();
        try
        {
            list.enqueue(word);
            Integer.parseInt(word);
            System.out.println( word + "is a valid number");
        }
        catch(NumberFormatException | InputMismatchException exc)
        {
                System.out.println("Not a valid integer");
        }
       
    }
       
}
    

        
    
