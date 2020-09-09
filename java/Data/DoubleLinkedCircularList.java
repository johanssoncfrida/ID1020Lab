
package Data;

import java.util.Iterator;

/**
 * Class represents a FIFO-Queue based on a double linked cirkular list. 
 * The class is of generic type so it can be reused with different inputs.
 * @author Frida Johansson
 * 
 * @param <Element> represents a generic element so that this class 
 * can be reused with other input.
 */
public class DoubleLinkedCircularList<Element> implements Queue<Element>
{
    private Node head;
    private Node tail;
    public int size;
    
    public DoubleLinkedCircularList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Method that adds element to the end of the queue.
     * @param element represents the element that user want to add.
     */
    @Override
    public void enqueue(Element element) 
    {
        Node newNode = new Node(element, null, null);
        
        if (head == null)
        {
            newNode.setNextLink(newNode);
            newNode.setPreviousLink(newNode);
            head = newNode;
            tail = head;
        }
        else
        {
            newNode.setPreviousLink(tail);
            tail.setNextLink(newNode);
            newNode.setNextLink(head); 
            head.setPreviousLink(newNode);
            head = newNode;
        }
        size++;
        
    }
    /**
     * Method that removed the least recently added element of the queue. 
     */
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
                tail.setPreviousLink(tail.getPreviousLink());
                head.setNextLink(head.getNextLink());
                size--;
                break;
        }
     
    }
     
    /**
     * Method that allow user to peek at the current of the queue. 
     * @return the current
     */
    @Override
    public String peek() 
    {
        if(head != null) 
        {
            return head.element.toString();
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
    
    /**
     * Returns a string representation of this queue.
     * @return 
     */
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
    /**
     * A privated nested class Node that represents the content of the queue.
     */
    private class Node
    {
        Element element;
        Node next;
        Node prev;
        
        public Node()
        {
            next = null;
            prev = null;
            element = null;
        }
        public Node(Element e, Node n, Node p)
        {
            next = n;
            prev = p;
            element = e;
        }
        public void setNextLink(Node nextNode)
        {
            next = nextNode;
        }
        /* Function to set link to previous node */
        public void setPreviousLink(Node previous)
        {
            prev = previous;
        }  
        public Node getNextLink()
        {
            return next;
        }
        
        public Node getPreviousLink()
        {
            return prev;
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
    /**
     * Implemented Iterator that creates a private iterator for this queue that starts at current.
     * @return 
     */
    @Override
    public Iterator<Element> iterator() 
    {
        return new QueueIterator(head);
    }
     
    private class QueueIterator<Element> implements Iterator<Element>
    {
 
        private DoubleLinkedCircularList<Element>.Node current;
        boolean visitingAgain = false;
         
        public QueueIterator(DoubleLinkedCircularList<Element>.Node head) 
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
                throw new RuntimeException("Can't iterate");
            }
        }       
    }
}

