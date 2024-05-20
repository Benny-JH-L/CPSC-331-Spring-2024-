package otherTests;

public class P4_1_4 
{
    static int numCounterEx = 0, numSumEx = 0;

    public static void main(String[] args) 
    {
        int num = 99999;
        func(num);
    }
    
    private static void func(int num)
    {
        int counter = 1;
        int sum = 1;
        System.out.println("Num = " + num);
        do 
        {
            counter++;
            sum += counter;
            // System.out.println("Hello #" + (counter-1));
            System.out.printf("\ncounter++ = %s\nsum = %s", counter, sum);
            numCounterEx++;
            numSumEx++;
        } while (sum <= num);
        System.out.printf("\ncounter++ = %s\nsum = %s", counter, sum);

        System.out.println("\nHello/loop-executions = " + (counter-1));
    }    
}
