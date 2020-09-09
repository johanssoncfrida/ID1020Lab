/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Data.CircularLinkedList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Me
 */
public class OperationsCircLinkList 
{
    CircularLinkedList circLinkedList;
    
    public OperationsCircLinkList()
    {
        circLinkedList = new CircularLinkedList<Integer>();
    }
    
    public void start(Scanner scanner)
    {
        char answer;
        String removedItem;
        do    
        {
            
            System.out.println("\nCircular Linked List Operations\n");
            System.out.println("\nPlease choose your operation from menu.\n");
            System.out.println("1. Insert integer in front of queue");
            System.out.println("2. Remove the first integer of the queue");
            System.out.println("3. Insert integer in the end of the queue");
            System.out.println("4. Remove the last integer of the queue");
            System.out.println("5. Check empty");
            System.out.println("6. Get size\n");
 
            int choice = scanner.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer to insert");
                try
                {
                    circLinkedList.enqueue(scanner.nextInt());
                    System.out.println("Your queue: " + circLinkedList.toString());
                    break;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You did not enter an integer! ");
                    break;
                }
                
            case 2 : 
                removedItem = circLinkedList.peek();
                
                if(circLinkedList.getSize() == 0)
                {
                    circLinkedList.dequeue();
                    System.out.println("Your queue: " + circLinkedList.toString());
                    break;
                }
                else
                {
                    circLinkedList.dequeue();
                    System.out.println(removedItem + " is removed. ");
                    System.out.println("Your queue: " + circLinkedList.toString());
                    break;  
                }
            case 3:
                System.out.println("Enter integer to insert");
                try
                {
                    circLinkedList.enqueueAtEnd(scanner.nextInt());
                    System.out.println("Your queue: " + circLinkedList.toString());
                    break;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You did not enter an integer! ");
                    break;
                }
            case 4:
                removedItem = circLinkedList.peekLastIndex();
        
                if(circLinkedList.getSize() == 0)
                {
                    circLinkedList.dequeueAtEnd();
                    System.out.println("Your queue: " + circLinkedList.toString());
                    break;
                }
                else
                {
                    circLinkedList.dequeueAtEnd();
                    System.out.println(removedItem + " is removed. ");
                    System.out.println("Your queue: " + circLinkedList.toString());
                    break;  
                }
            case 5 : 
                if(circLinkedList.isEmpty())
                {
                    System.out.println("Your queue is empty!");
                    break;
                }
                else
                {
                    System.out.println("Queue is not empty!"); 
                    break;
                }
            case 6 : 
                System.out.println("Size of queue: "+ circLinkedList.getSize() + " \n");
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
