/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Data.DoubleLinkedCircularList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Me
 */
public class OperationsDoubleLinkedCirkList 
{
    DoubleLinkedCircularList queue;
    public OperationsDoubleLinkedCirkList()
    {
        queue = new DoubleLinkedCircularList<Integer>();
    }
    
    public void start(Scanner scanner)
    {
        char answer;
        String removedItem;
        do    
        {
            
            System.out.println("\nCircular Doubly Linked List Operations\n");
            System.out.println("\nEnter integer your would like to store.\n");
            System.out.println("1. Insert integer");
            System.out.println("2. Remove integer ");
            System.out.println("3. Check empty");
            System.out.println("4. Get size\n");
 
            int choice = scanner.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer to insert");
                try
                {
                    queue.enqueue(scanner.nextInt());
                    System.out.println("Your queue: " + queue.toString());
                    break; 
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You did not enter an integer! ");
                    break;
                }                         
            case 2 : 
                removedItem = queue.peek();
                
                if(queue.getSize() == 0)
                {
                    queue.dequeue();
                    System.out.println("Your queue: " + queue.toString());
                    break;
                }
                else
                {
                    queue.dequeue();
                    System.out.println(removedItem + " is removed. ");
                    System.out.println("Your queue: " + queue.toString());
                    break;  
                }                       
            case 3 : 
                if(queue.isEmpty())
                {
                    System.out.println("Your queue is empty!");
                    break;
                }
                else
                {
                    System.out.println("Queue is not empty!"); 
                    break;
                }
            case 4 : 
                System.out.println("Size of queue: "+ queue.getSize() + " \n");
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
