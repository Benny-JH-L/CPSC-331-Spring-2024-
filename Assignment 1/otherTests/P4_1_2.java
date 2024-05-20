package otherTests;

public class P4_1_2 
{
    private static int forLoopEx = 0, funcExecutions = 0;

    public static void main(String[] args)
    {
        int n = 999999999;
        func(n);
        System.out.printf("\nFunc executions = %s | Loop executions = %s", funcExecutions, forLoopEx);
    }

    static int func(int n)
    {
        funcExecutions++;
        for (double i = 0; i < n; i += 0.5)
        {
            forLoopEx++;
            // System.out.printf("\nHello #%s", forLoopEx);
        }
        if (n <= 0)
            return 1;
        else
            return 1 + func(n/5);
    }
}
