
package Data;

import java.util.Iterator;

/**
 * Generalized queue of a generic type to make it reusable for other inputs.
 * 
 * @author Frida Johansson
 * @param <Element> represents the elements that's being added to this queue.
 */
public class GeneralizedQueue<Element> implements Queue<Element>
{
    private Node first;
    private Node last;
    private int size;
    
    public GeneralizedQueue()
    {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    /**
     * Inserts element in end of the queue 
     * @param element represents inserted element
     */
    @Override
    public void enqueue(Element element) {
        Node newNode = new Node(element, null);
        if (first == null)
        {
            
            newNode.setNext(newNode);
            first = last = newNode;
        }
        else
        {
            last.setNext(newNode);
            last = newNode;
            last.setNext(null);
   
        }
        size++;
    }
    
    /**
     * Removes the last element of the queue.
     */
    @Override
    public void dequeue() {
        switch (size) 
        {
            case 0:
                System.out.println("List is empty");
                break;
            case 1:
                first = null;
                last = null;
                size = 0;
                break;
            default:
                
            Node current = first;
            
            while(current.next != last)
            {
                current = current.next;
                
            }
            last = current;
            last.setNext(null); 
            first.setNext(first.getNext());
            size--;
            break;
        }   
        
    }
    
    /**
     * Removed an element on a certain position given by the parameter pos.
     * @param pos represents the position in queue where to remove an element.
     * @return a stringrepresentation of the removed element.
     */
    public String dequeueAtPosition(int pos)
    {
        String removed = "";
        if (this.size == 0) 
        {
            System.out.println("List is empty.");
	}

        if (pos < 0 || pos >= this.size) {
                System.out.println("Invalid Index.");
        }

        if (pos == 0) 
        {
            dequeue();
        } 
        else if (pos == this.size - 1) 
        {
            dequeue();

        } 
        else 
        {
            Node nodeBefore = getNodeAt(pos - 1);
            Node removedNode = nodeBefore.next;
            Node nodeAfterRemoved = removedNode.next;
            removed = removedNode.toString();
            nodeBefore.next = nodeAfterRemoved;
            this.size--;
        }
        return removed;
    }
    
    private Node getNodeAt(int index)  
    {
        Node temp = this.first;
        for (int i = 1; i <= index; i++) {
                temp = temp.next;
        }
        return temp;

    }
    
    @Override
    public String peek() {
        
        if(first != null) 
        {
            return last.element.toString();
        }
        return null;    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int getSize() {
        return size;
    }
    
    /**
     * 
     * @return s a stringrepresentation of this queue.
     */
    @Override
    public String toString() 
    {
        String result = "";
        Node current = first;
        int index = 0;
        while (index < this.size) 
        {
            result += "[";
            result += current.getElement();
            current = current.getNext();
            result += "]";
            index++;
            if(index < this.size)
            {
                result += ", ";
            }

        }
        return result;
    }
    /**
     * Implemented Iterator that creates a private iterator for this queue that starts at first.
     * @return 
     */
    @Override
    public Iterator<Element> iterator() 
    {
        return new QueueIterator<Element>(first);
    }
    private class QueueIterator<Element> implements Iterator<Element>
    {
 
        private GeneralizedQueue<Element>.Node first;
         
        public QueueIterator(GeneralizedQueue<Element>.Node first) 
        {
            super();
            this.first = first;
        }
 
        @Override
        public boolean hasNext() 
        {
            return first !=null;
        }
 
        @Override
        public Element next() 
        {
            if(first != null){
                
                Element element = first.element;
                first = first.next;
                return element;
            }else {
                throw new RuntimeException("Iterator Exhuested Exception");
            }
        }       
    }
    /**
     * Nested privated class Node that represents the content of the queue. 
     * 
     */
    private class Node {

    private Node next;
    private Element element;


    public Node(Element e){
        element = e;
    }
    public Node(Element e, Node n)
    {
        next = n;
        element = e;
    }

    public Element getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    @Override
    public String toString()
    {
        return "[ " + element + " ] ";
    }
}
}
