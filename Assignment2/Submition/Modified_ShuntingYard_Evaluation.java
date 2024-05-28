package Assignment2.Submition;

public class Modified_ShuntingYard_Evaluation 
{
    // Implement the steps of Modified Shunting Yard Algorithm here 
    public static String convertToPostfix(String expression)
    {
        String postFix = "";
        // code
        return postFix;
    }

    // isOperand checks if the string passed is an operand
    private static boolean isOperand(String token)
    {
        boolean isOperand = false;
        // code
        return isOperand;
    }

    // hasHigherPrecedence checks which operator has higher precedence
    private static boolean hasHigherPrecedence(String op1, String op2)
    {
        // code
    }

    // getPrecedence is used to set up a precedence score to the operator passed
    private static int getPrecedence(String operator)
    {
        // code
    }

    // evaluatePostfix takes the postfix expression to evaluate the result
    public static double evaluatePostfix(String expression)
    {
        // code
    }

    // performOperation is used for actual operation to perform, 
    // such as addition, subtraction, multiplication, exponentiation, etc.
    // based on the operator.
    private static double performOperation(double operand1, double operand2, String operator)
    {

    }

    public static void main(String[] args)
    {
        String expression1 = "2+3*1";
        String expression2 = "3*2^4-7";

        String postfix1 = convertToPostfix(expression1);
        String postfix2 = convertToPostfix(expression2);

        System.out.println(expression1 + "->Postfix: " + postfix1 + " , Evaluation: " + evaluatePostfix(postfix1));
        System.out.println(expression2 + "->Postfix: " + postfix2 + " , Evaluation: " + evaluatePostfix(postfix2));
    }
}
