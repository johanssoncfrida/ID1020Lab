/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Data.OrderedQueue;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Frida Johansson
 */
public class OperationsForOrderedQueue {
    OrderedQueue orderedQueue;
    
    public OperationsForOrderedQueue()
    {
        orderedQueue = new OrderedQueue<Integer>();
    }
    
    public void start(Scanner scanner)
    {
        char answer;
        
        do   
        {
            System.out.println("\nOrdered Queue\n");
            System.out.println("\nPlease choose your operation from menu.\n");
            System.out.println("1. Insert integer ");
            System.out.println("2. Remove the least integer ");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter a number");
                    orderedQueue.enqueue(scanner.nextInt());
                    System.out.println("Your queue: " + orderedQueue.toString());
                    break;
                case 2:
                    orderedQueue.dequeue();
                    System.out.println("Your queue: " + orderedQueue.toString());
                    break;
            }
        
        System.out.println("\nDo you want to continue?\nType y for yes and n for no\n");
        answer = scanner.next().charAt(0);                        
        }while (answer == 'Y'|| answer == 'y'); 
    }
}
/*try
                {
                    genQueue.enqueue(scanner.nextInt());
                    System.out.println("Your queue: " + genQueue.toString());
                    break; 
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You did not enter an integer! ");
                    break;
                } */   