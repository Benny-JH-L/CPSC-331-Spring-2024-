package Submition;

import java.util.Stack;
import Submition.ADT.Queue;

// CPSC 331 -Spring 2024- Assignment 2 | Application of List, Stack and Queue
// Name: Benny Liang | UCID: 30192142

/**
 * 3.3 Exercise 3 - Working with Modified Shunting Yard Algorithm
 */
public class Modified_ShuntingYard_Evaluation 
{
    // Implement the steps of Modified Shunting Yard Algorithm here 
    public static String convertToPostfix(String expression)
    {
        Stack<String> operatorStack = new Stack<String>();
        Queue<String> queue = new Queue<String>();

        for (int i = 0; i < expression.length(); i++)
        {
            String str = String.valueOf(expression.charAt(i));    // Converting the character at index 'i' of the expression to a string.
            
            if (isOperand(str))         // Checking if the converted character is an operand.
                queue.enqueue(str);     // if it is an operand, enqueue it to the output queue.
            else if (!operatorStack.isEmpty())              // otherwise, it is an operator.
            {
                String topOperator = operatorStack.peek();
                if (hasHigherPrecedence(topOperator, str))  // if 'str' has higher precedence than the top operator in the stack,
                    operatorStack.push(str);                // push 'str' onto the stack.
                else                                        // otherwise, 'str' has less precedence than the top operator.
                {
                    topOperator = operatorStack.pop();      // pop the top operator that has more precedence and,
                    queue.enqueue(topOperator);             // enqueue it to the output queue.

                    for (int k = 0; k < operatorStack.size(); k++)  // go through the stack and pop operators that have more precedence than 'str'
                    {
                        topOperator = operatorStack.peek();
                        if (!hasHigherPrecedence(topOperator, str)) // topOperator has more precedence than 'str'
                        {
                            String poppedOperator = operatorStack.pop();    // pop the stack and,
                            queue.enqueue(poppedOperator);                  // enqueue it to the output queue.
                        }
                        else                                        // otherwise, topOperator has less precedence than 'str'
                            break;                                  // exit the loop.
                    }
                    operatorStack.push(str);                 // push the lowest precedence operator onto the stack.
                }
            }
            else    // push the operator to the stack if stack is empty
                operatorStack.push(str);
        }

        // Converting the queue elements into a string
        String postFix = "", character;
        int size = queue.size();
        for (int i = 0; i < size; i++)
        {
            character = queue.dequeue();
            postFix = postFix + character;
        }

        // Adding the rest of the operators in the stack into the string.
        size = operatorStack.size();
        for (int i = 0; i < size; i++)
        {
            character = operatorStack.pop();
            postFix = postFix + character;
        }
        return postFix;
    }

    // isOperand checks if the string passed is an operand
    private static boolean isOperand(String token)
    {
        String[] operators = {"^", "/", "*", "+", "-"};

        // Checking if the token is an operator
        for (int i = 0; i < operators.length; i++)
        {
            if (token.equals(operators[i])) // if the token is an operator,
                return false;               // return false.
        }
        return true;                        // otherwise, return true.
    }

    // hasHigherPrecedence checks which operator has higher precedence
    private static boolean hasHigherPrecedence(String op1, String op2)
    {
        // Return true if op2 has HIGHER precedance than op1, return false otherwise.
        int precedenceOp1 = getPrecedence(op1);
        int precedenceOp2 = getPrecedence(op2);

        if (precedenceOp2 > precedenceOp1)
            return true;
        else 
            return false;
    }

    // getPrecedence is used to set up a precedence score to the operator passed
    private static int getPrecedence(String operator)
    {
        // BEDMAS
        String[] operators = {"^", "/", "*", "+", "-"};

        if (operator.equals(operators[0]))
            return 5;
        else if (operator.equals(operators[1]) || operator.equals(operators[2]))    // multiplication and division has the same precedence, execute whoever is left/appears first
            return 4;
        else if (operator.equals(operators[3]) || operator.equals(operators[4]))    // addition and subtraction have the same precedeence, execute whoever is left/appears first
            return 3;

        return -1;   // if operator is not in the operators array, return -1.
    }

    // evaluatePostfix takes the postfix expression to evaluate the result
    public static double evaluatePostfix(String expression)
    {
        Stack<String> evalStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++)
        {
            String str = String.valueOf(expression.charAt(i));

            if (isOperand(str))
                evalStack.push(str);
            else
            {
                double operand2 = Double.parseDouble(evalStack.pop());
                double operand1 = Double.parseDouble(evalStack.pop());
                double calculatedVal =  performOperation(operand1, operand2, str);  // calculate the operation
                evalStack.push(String.valueOf(calculatedVal));      // push the calculated value onto the stack
            }
        }
        return Double.parseDouble(evalStack.pop());                 // convert the calculated value from string to double.
    }

    // performOperation is used for actual operation to perform, 
    // such as addition, subtraction, multiplication, exponentiation, etc.
    // based on the operator.
    private static double performOperation(double operand1, double operand2, String operator)
    {
        // String[] operators = {"^", "/", "*", "+", "-"};  
        double calculatedVal = Double.POSITIVE_INFINITY;
        if (operator.equals("^"))
            calculatedVal = Math.pow(operand1, operand2);
        else if (operator.equals("/"))
            calculatedVal = operand1 / operand2;
        else if (operator.equals("*"))
            calculatedVal = operand1 * operand2;            // note: order doesn't matter
        else if (operator.equals("+"))
            calculatedVal = operand1 + operand2;            // note: order doesn't matter
        else if (operator.equals("-"))
            calculatedVal = operand1 - operand2;
        return calculatedVal;
    }

    public static void main(String[] args)
    {
        String expression1 = "2+3*1";
        String expression2 = "3*2^4-7";
        // String expression2 = "3*2^4-7+1-4+1*5";      // to be deleted.

        String postfix1 = convertToPostfix(expression1);
        String postfix2 = convertToPostfix(expression2);

        System.out.println(expression1 + " -> Postfix: " + postfix1 + " , Evaluation: " + evaluatePostfix(postfix1));
        System.out.println(expression2 + " -> Postfix: " + postfix2 + " , Evaluation: " + evaluatePostfix(postfix2));
    }
}
