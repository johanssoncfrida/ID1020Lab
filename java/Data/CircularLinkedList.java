/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Iterator;


/**
 *
 * @author Frida Johansson
 * @param <Element>
 */
public class CircularLinkedList<Element> implements Queue<Element>
{
    Node head;
    Node tail;
    int size;
    
    public CircularLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    
    @Override
    public void enqueue(Element element) 
    {
        
            Node newNode = new Node (element, null);
            if(head == null)
            {
                newNode.setNextLink(newNode);
                head = tail = newNode;
                tail.setNextLink(newNode);

            }
            else
            {
                newNode.setNextLink(head);
                head = newNode;
                tail.setNextLink(head);

            }
            size ++;
        
        
    }

    @Override
    public void dequeue() 
    {
        switch (size) 
        {
            case 0:
                System.out.println("List is empty");
                break;
            case 1:
                head = null;
                tail = null;
                size = 0;
                break;
            default:
                head = head.getNextLink();
                tail.setNextLink(head);
                head.setNextLink(head.getNextLink());
                size--;
                break;
        }
    }
    
    public void enqueueAtEnd(Element element)
    {
        
            
            Node newNode = new Node(element, null);
            if (head == null)
            {

                newNode.setNextLink(newNode);
                head = tail = newNode;
            }
            else
            {
                tail.setNextLink(newNode);
                tail = newNode;
                newNode.setNextLink(head);


            }
        size++;
        
    }
    public void dequeueAtEnd()
    {
        switch (size) 
        {
            case 0:
                System.out.println("List is empty");
                break;
            case 1:
                head = null;
                tail = null;
                size = 0;
                break;
            default:
            
            Node current = head;
            Node beforeCurrent = current;

            while(current != tail)
            {
                beforeCurrent = current;
                current = current.next;
                
            }
            tail = beforeCurrent;
            tail.setNextLink(head);   
            size--;
            break;

        }
        
    }

    @Override
    public String peek() 
    {
        
        if(head != null) 
        {
            return head.element.toString();
        }
        return null;
    }
    
    public String peekLastIndex()
    {
        
        if(head != null)
        {
            return tail.element.toString();
        }
        return null;
    }

    @Override
    public boolean isEmpty() 
    {
        return head == null;
    }

    @Override
    public int getSize() 
    {
        return size;
    }
  
    
 
    @Override
    public String toString() 
    {
       StringBuilder sb = new StringBuilder();
       int index = 0;
       for(Element e: this)
       {
           sb.append("[").append(e).append("]");
           index++;
           if(index < size)
           {
               sb.append(", ");
               
           }
       }
       
        return sb.toString();
    }
  
     
    private class Node
    {
        Element element;
        Node next;
        
        
        public Node()
        {
            next = null;
            element = null;
        }
        public Node(Element e, Node n)
        {
            next = n;
            element = e;
        }
        public void setNextLink(Node nextNode)
        {
            next = nextNode;
        }
        /* Function to set link to previous node */

        public Node getNextLink()
        {
            return next;
        }

        public void setElement(Element e)
        {
            element = e;
        }
        /* Function to get data from node */
        public Element getElement()
        {
            return element;
        }
    }
 
    @Override
    public Iterator<Element> iterator() 
    {
        return new QueueIterator<Element>(head);
    }
     
    private class QueueIterator<Element> implements Iterator<Element>
    {
 
        private CircularLinkedList<Element>.Node current;
        boolean visitingAgain = false;
         
        public QueueIterator(CircularLinkedList<Element>.Node head) 
        {
            super();
            this.current = head;
        }
 
        @Override
        public boolean hasNext() 
        {
            if(isEmpty() || (current == head && visitingAgain))
            {
                return false;
            }
            visitingAgain = true;
            return true;
        }
 
        @Override
        public Element next() 
        {
            if(current != null){
                
                Element element = current.element;
                current = current.next;
                return element;
            }else {
                throw new RuntimeException("Can't iterate!");
            }
        }       
    }
}


