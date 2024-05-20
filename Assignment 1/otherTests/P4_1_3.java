package otherTests;

public class P4_1_3 
{
    static int loopBodyEx = 0, funcCalls = 0;

    public static void main(String[] args) 
    {
        int n = 1000, m = 0, o = 0;
        func(n, m, o);    
        System.out.printf("\nn = %s\nLoop Body Exeuctions = %s", n, loopBodyEx);
        System.out.printf("\nFunc calls = %s", funcCalls);
        int bound = funcBound(n);
        System.out.printf("\nBound = %s", bound);
    }

    static int func(int n, int m, int o)
    {
        funcCalls++;
        for (int i = 0; i < n; i += 2)
            loopBodyEx++;

        if (n <= 0)
            return 1;
        else
        {
            func(n-1, m+1, o);
            func(n-1, m, o+1);
        }
        return 0;
    }    

    // Benny Liang | 30192142
    static int funcBound(int n)
    {
        double bound = 1;
        for (int i = n; i > 1; i = i - 2)
        {
            bound = bound + Math.pow(2, i);
        }
        return (int)bound;
    }
}
