package otherTests;



public class other 
{
    public static void main(String[] args)
    {
        // func4_4(256);
        int n = 5;
        int fibcount = fib(n);
        System.out.printf("\nFib(%s) = %s | recur count = %s", n, fibcount, count);

        for (int i = 0; i < 100; i++)
        {
            count = 0;
            int fibcount2 = fib(i);
            System.out.printf("\nFib(%s) = %s | recur count = %s", i, fibcount2, count);
        }
    }    

    private static void func4_4(int num)
    {
        int counter = 1;
        int sum = 1;
        System.out.println("Num = " + num);
        do 
        {
            counter++;
            sum += counter;
            System.out.println("Hello #" + (counter-1));
        } while (sum <= num);
    }

    private static int count = 0;
    private static int fib(int n)
    {
        count++;
        if (n <= 1)
            return n;
        else
            return fib(n-1) + fib(n-2);
    }
}
