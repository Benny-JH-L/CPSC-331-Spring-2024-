package Submition;


// CPSC 331 -Spring 2024- Assignment 1 | Complexity of Algorithms
// Name: Benny Liang | UCID: 30192142

public class SortRecursive 
{
    // Recursive Shell Sort using novel gap sequence
    public static void shellSortRecursive(int[] array)
    {
        if (array == null)
            throw new NullPointerException("Can't sort null array.");

        int n = array.length;
        int gap = 1;

        while (gap < n)
            gap = gap * 3;

        shellSortRecursiveHelper(array, n, gap/3);
    }

    /**
     * Helper method for Recursive shell sort.
     * @param array an integer array.
     * @param n an integer.
     * @param gap an integer.
     */
    private static void shellSortRecursiveHelper(int[] array, int n, int gap)
    {
        if (gap > 0)
        {
            for (int i = gap; i < n; i++)
            {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp)
                {
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = temp;
            }
            shellSortRecursiveHelper(array, n, gap/3);
        }
    }


    public static void main(String[] args)
    {
        // Input array to the recursive shell sort (Note-To-Self: Get test arrays from 'test file' on D2L)            
        int[] arrayRecursive = {9, 8, 3, 7, 5, 6, 4, 1};
        
        // Recursive Shell Sort
        shellSortRecursive(arrayRecursive);
        System.out.println("Array sorted using the recursive function:");
        printArray(arrayRecursive);
    }

    // Utility method to print an array
    public static void printArray (int [] array) 
    {
        for (int num : array)
            System.out.println(num + " ");
        System.out.println();
    }

    // /**
    //  * Prints the time taken for the version of sorting algorithm.
    //  * @param durationOfSort a long, nanoseconds taken for the sorting algorithm.
    //  * @param version a String, the version (Iterative or Recursive).
    //  */
    // public static void printTimeTaken(long durationOfSort, String version)
    // {
    //     double seconds, milliseconds;
    //     seconds = durationOfSort / 1_000_000_000;
    //     milliseconds = durationOfSort / 1_000_000;
    //     System.out.println(version + " sort time: " + seconds + " seconds, or " + milliseconds + " milliseconds, or " + durationOfSort + " nanoseconds.\n");
    // }
    
}

