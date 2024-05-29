package Assignment2.tests;

public class testThings
{
    private static int numWhileLoopEx = 0;
    private static int numForLoopEx = 0;
    static int numTimesLastElementExOnWhileLoop = 0;
    public static void main(String[] args) 
    {
        // int[] randomNumbers = {66, 59, 60, 14, 82, 85, 47, 22, 92, 44}; // test case
        int[] randomNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // test case 2
        printArrayMyVer(randomNumbers);
        Sorting_Queue(randomNumbers);
        printArrayMyVer(randomNumbers);

        System.out.printf("Array size = %s\nNum for-loop body executions = %s\nNum while-loop body executions = %s\n", randomNumbers.length, numForLoopEx, numWhileLoopEx);
        System.out.println("last element executed for: " + numTimesLastElementExOnWhileLoop);
    }

    public static void Sorting_Queue(int[] array)
    {
        for (int i = 1; i <= array.length - 1; i++)
        {
            numForLoopEx++;
            int j = i;
            while (j > 0 && array[j] > array[j-1])      // used '>' instead of '<' to get array sorted in the order: largest -> smallest
            {
                // Swap elements
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
                j--;                                    // j = j - 1
                numWhileLoopEx++;
                if (i == array.length-1)
                    numTimesLastElementExOnWhileLoop++;
            }
        }
    }

    private static void printArrayMyVer(int[] array)
    {
        System.out.println("Array values: ");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
    }
}
