
package Data;


/**
 * Class representing a LIFO-Stack and its associated methods.
 * @author Frida Johansson
 */
public class Stack 
{
    private int[] integers;
    private int top;
    public int size;
    
    public Stack(int size)
    {
        integers = new int[size];
        top = integers[0];
        this.size = 0;
    }
    /**
     * Push adds the users input on top of the stack.Size of stack increases.
     * @param number represents the added number
     */
    public void push(int number)
    {
        for(int i = 0; i< integers.length; i++)
        {
            int temp = number;
            number = integers[i];
            integers[i] = temp;
        }
        top = integers[0];
        size ++;
    }
    /**
     * Pop removes the top of the stack, decrementing size.
     * @return number that is removed.
     */
    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Your stack is already empty.");
            System.exit(1);
        }
        int oldTop = top;
        for(int i = 0; i < integers.length - 1; i++)
        {
            
            integers[i] = integers[i + 1];
        }
        top = integers[0];
        size --;
        return oldTop;
    }
    /**
     * Method that checks if stack is empty
     * @return true or false depending if stack is empty.
    **/
    public boolean isEmpty()
    {
        return size == 0;
    }
    /**
     * 
     * @return size of the stack
     */
    public int size()
    {
        return size;
    }
    
    public int[] getIntegers()
    {
        return this.integers;
    }
    public int getLength()
    {
        return integers.length;
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for(int i = 0; i < integers.length; i++)
        {
            sb.append("[").append(integers[i]).append("]");
            if(integers.length -1 != i)
            {
                sb.append(", ");
            }
        }
        sb.append(" }");
        
        return sb.toString();
    }

  
}

