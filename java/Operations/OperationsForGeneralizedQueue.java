/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Data.GeneralizedQueue;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Frida Johansson
 */
public class OperationsForGeneralizedQueue {
    GeneralizedQueue genQueue;
    
    public OperationsForGeneralizedQueue()
    {
        genQueue = new GeneralizedQueue<Integer>();
    }
    
    public void start(Scanner scanner)
    {
        char answer;
        String removedItem;
        do    
        {
            
            System.out.println("\nCircular Doubly Linked List Operations\n");
            System.out.println("\nPlease choose your operation from menu.\n");
            System.out.println("1. Insert integer in queue");
            System.out.println("2. Remove the last added integer of the queue");
            System.out.println("3. Remove integer at specified position of the queue");
            System.out.println("4. Check empty");
            System.out.println("5. Get size\n");
 
            int choice = scanner.nextInt();            
            switch (choice)
            {
            case 1 : 
                try
                {
                    genQueue.enqueue(scanner.nextInt());
                    System.out.println("Your queue: " + genQueue.toString());
                    break; 
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You did not enter an integer! ");
                    break;
                }    
                          
            case 2 : 
                removedItem = genQueue.peek();
                
                if(genQueue.getSize() == 0)
                {
                    genQueue.dequeue();
                    System.out.println("Your queue: " + genQueue.toString());
                    break;
                }
                else
                {
                    genQueue.dequeue();
                    System.out.println(removedItem + " is removed. ");
                    System.out.println("Your queue: " + genQueue.toString());
                    break;  
                }

            case 3:
                System.out.println("Choose an position where to remove integer. ");
                int position = scanner.nextInt();
                String removed = genQueue.dequeueAtPosition(position);
                System.out.println("Integer : " + removed + "has been removed from queue. ");
                System.out.println("Your queue: " + genQueue.toString());
                break;  
                
            case 4 : 
                if(genQueue.isEmpty())
                {
                    System.out.println("Your queue is empty!");
                    break;
                }
                else
                {
                    System.out.println("Queue is not empty!"); 
                    break;
                }
            case 5 : 
                System.out.println("Size of queue: "+ genQueue.getSize() + " \n");
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
