/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Iterator;

/**
 * A queue that sorts added elements in ascending order. 
 * 
 * @author Frida Johansson
 * @param <Element> represents the content. 
 */
public class OrderedQueue <Element extends Comparable<Element>> 
{
    private Node front;
    
    
    public OrderedQueue()
    {
        this.front = null;
    }
    
    /**
     * Adds element to the queue in ascending order. 
     * @param element represents the element from the user
     */
    
    public void enqueue(Element element) 
    {
        Node newNode = new Node(element);
        if(front == null)
        {
            front = newNode;
            System.out.println("Node " + newNode.element + " inserted.");
            return;
        }
        else if(newNode.isSmallerThan(front.element))
        {
            newNode.next = front;
            front = newNode;
            System.out.println("Node " + newNode.element + " inserted.");
            return;
        }
        
        Node current = front;
        boolean added = false;
        
        while(current.next != null)
        {
            if(newNode.isSmallerThan(current.next.element))
            {
                newNode.next = current.next;
                current.next = newNode;
                added = true;
                break;
            }
            current = current.next;
        }
        if(!added)
            current.next = newNode;
        
    }
    
    /**
     * Removes the least integer of the queue. 
     */
    
    public void dequeue() 
    {
        if(isEmpty())
            System.out.println("List is empty");
        else
        {
            Node deletedNode = front;
            front = front.next;
            System.out.println(deletedNode.toString() + "has been removed from queue");
            
        }
        
    }
   
    
    public String peek() {
        if(front != null) 
        {
            return front.element.toString();
        }
        return null;
      
    }

    
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Represents a string representation of this queue.
     * @return 
     */
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        Node current = front;
        while (current != null) 
        {
            sb.append("[").append(current.getElement()).append("]");
            current = current.getNext();
   
            if(current != null)
            {
                sb.append(", ");
            }

        }
        return sb.toString();
    }
    
    /**
     * Nested prvate class Node the represents the content of this queue. 
     */
     private class Node 
     {
        Element element;
        Node next;
       

        Node() {

        }

        Node(Element e) {
            this.element = e;
        }
        
        Element getElement()
        {
            return element;
        }
        
        Node getNext()
        {
            return next;
        }
        
        @Override
        public String toString()
        {
            return "[ " + element + " ] ";
        }

        public boolean isSmallerThan(Element e) 
        {
            if (this.element.compareTo(e) < 0)
            {
                return true;
            }    
            return false;
        }
     }
    
}
