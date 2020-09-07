/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;
import java.util.Stack;
/**
 *
 * @author Frida Johansson
 */
public class BalancedExpression {
    
    public boolean isBalancedExpression(char[] input)
    {
        if((input.length % 2) == 1)
        {
            return false;
        }
        else
        {
            Stack<Character> stack = new Stack<>();
            for(char chars: input)
                switch(chars)
                {
                case '(':
                    stack.push(')');
                    
                    break;
                case '{':
                    stack.push('}');
                    
                    break;
                case '[':
                    stack.push(']');
                    
                    break;
                default:
                    if(stack.isEmpty() || chars != stack.peek())
                    {
                        return false;
                    }
                    System.out.println(stack.toString());
                    stack.pop();
                    System.out.println(stack.toString());
                }
            return stack.isEmpty();
        }
    }
}
