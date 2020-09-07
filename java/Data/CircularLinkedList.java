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
                tail.setNextLink(newNode);

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

            while(current != tail)
            {
                current = current.next;
            }
            tail = current;
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
        String result = "";
        Node current = head;
        int index = 0;
        while (index < this.size) 
        {
            result += "[";
            result += current.getElement();
            current = current.getNextLink();
            result += "]";
            index++;
            if(index < this.size)
            {
                result += ", ";
            }

        }
        return result;
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
 
        private CircularLinkedList<Element>.Node head;
         
        public QueueIterator(CircularLinkedList<Element>.Node head) 
        {
            super();
            this.head = head;
        }
 
        @Override
        public boolean hasNext() 
        {
            return head !=null;
        }
 
        @Override
        public Element next() 
        {
            if(head != null){
                
                Element element = head.element;
                head = head.next;
                return element;
            }else {
                throw new RuntimeException("Iterator Exhuested Exception");
            }
        }       
    }
}


