package Old.Assignment2_OLD.Submition;

import java.util.Stack;

import Old.Assignment2_OLD.Submition.ADT.Queue;

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
        Queue<String> list = new Queue<String>();

        for (int i = 0; i < expression.length(); i++)
        {
            String str = String.valueOf(expression.charAt(i));    // Converting the character at index 'i' of the expression to a string.
            
            if (isOperand(str))         // Checking if the converted character is an operand.
                list.enqueue(str);      // if it is an operand, add it to the list/output.
            else if (!operatorStack.isEmpty())              // otherwise, it is an operator.
            {
                String topOperator = operatorStack.peek();
                if (hasHigherPrecedence(topOperator, str))  // if 'str' has higher precedence than the top operator in the stack,
                    operatorStack.push(str);                // push 'str' onto the stack.
                else                                        // otherwise, 'str' has less precedence than the top operator.
                {
                    topOperator = operatorStack.pop();      // pop the top operator that has less precedence and,
                    list.enqueue(topOperator);              // add it to the output list.

                    for (int k = 0; k < operatorStack.size(); k++)  
                    {
                        topOperator = operatorStack.peek();
                        if (!hasHigherPrecedence(topOperator, str)) // topOperator has more precedence than 'str'
                        {
                            String poppedOperator = operatorStack.pop();    // pop the stack and,
                            list.enqueue(poppedOperator);                   // add it to the output list.
                        }
                        else                                        // otherwise, topOperator has less precedence than 'str'
                        {
                            operatorStack.add(str);                 // add 'str' to the operator stack.
                            break;                                  // exit the loop.
                        }
                    }
                    operatorStack.add(str);                 // push the lowest precedence operator onto the stack.
                }
            }
            else    // add the operator if the stack is empty
                operatorStack.add(str);
        }
        String postFix = "";
        String character;
        int size = list.size();
        for (int i = 0; i < size; i++)
        {
            character = list.dequeue();
            postFix = postFix + character;
        }

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
        // Will return false if op2 has less precendence than op1, and return true if op2 has higher (or equal) precedence than op1.
        int precedenceOp1 = getPrecedence(op1);
        int precedenceOp2 = getPrecedence(op2);
        if (precedenceOp1 > precedenceOp2)
            return false;
        else 
            return true;
    }

    // getPrecedence is used to set up a precedence score to the operator passed
    private static int getPrecedence(String operator)
    {
        // BEDMAS
        String[] operators = {"^", "/", "*", "+", "-"};
        int precedence = operators.length;
        // the precedence for: "^" is 5, "/" is 4, ... , "-" is 1.
        for (int i = 0; i < operators.length; i++)
        {
            if (operator.equals(operators[i]))
                return precedence - i;
        }
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
        System.out.printf("\n5/2 = %s", (5/2));
        System.out.println("\n5%2 = " + (5 % 2) + "\n");

        String expression1 = "2+3*1";
        String expression2 = "3*2^4-7";     // side note: numbers larger than 9, or less than 0, or are doubles can't be converted/calculated properly.

        String postfix1 = convertToPostfix(expression1);
        String postfix2 = convertToPostfix(expression2);

        System.out.println(expression1 + " -> Postfix: " + postfix1 + " , Evaluation: " + evaluatePostfix(postfix1));
        System.out.println(expression2 + " -> Postfix: " + postfix2 + " , Evaluation: " + evaluatePostfix(postfix2));
    }
}
