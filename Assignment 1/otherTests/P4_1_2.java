package otherTests;

public class P4_1_2 
{
    private static int forLoopEx = 0;

    public static void main(String[] args)
    {
        int n = 51;
        func(n);
    }

    static int func(int n)
    {
        for (double i = 0; i < n; i += 0.5)
        {
            forLoopEx++;
            System.out.printf("\nHello #%s", forLoopEx);
        }
        if (n <= 0)
            return 1;
        else
            return 1 + func(n/5);
    }
}
