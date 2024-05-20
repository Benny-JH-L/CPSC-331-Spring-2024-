package otherTests;

// CPSC 331 -Spring 2024- Assignment 1 | Complexity of Algorithms
// Name: Benny Liang | UCID: 30192142

public class recur 
{
    // Recursive Shell Sort using novel gap sequence
    public static void shellSortRecursive(int[] array)
    {
        if (array == null)
            throw new NullPointerException("Can't sort null array.");

        System.out.println("Initial Array:");
        printArrayMyVer(array);
        int n = array.length;
        int gap = 1;

        while (gap < n)
            gap = gap * 3;
        System.out.println("\nInitial gap before recursion: " + gap);
        shellSortRecursiveHelper(array, n, gap/3);
    }

    private static void shellSortRecursiveHelper(int[] array, int n, int gap)
    {
        System.out.println("\ngap = " + gap);
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
                System.out.printf("\ni = %s | j = %s | Array:\n", i, j);
                printArrayMyVer(array);
            }
            shellSortRecursiveHelper(array, n, gap/3);
        }
    }


    public static void main(String[] args)
    {
        // Input array to the recursive shell sort (Note-To-Self: Get test arrays from 'test file' on D2L)            
        int[] arrayRecursive = {9, 8, 3, 5, 13, 6, 4, 1, 12, 14, 30, 5};
        
        // Recursive Shell Sort
        shellSortRecursive(arrayRecursive);
        System.out.println("Array sorted using the recursive function:");
        printArrayMyVer(arrayRecursive);

        int[] arrayRecursizeAppended = new int[arrayRecursive.length+1];

        for(int i = 0; i < arrayRecursizeAppended.length-1; i++)
            arrayRecursizeAppended[i] = arrayRecursive[i];
        arrayRecursizeAppended[arrayRecursizeAppended.length-1] = 7;

        System.out.println("\n\nAppended recursize array:");
        printArray(arrayRecursizeAppended);

        shellSortRecursive(arrayRecursizeAppended);
        System.out.println("\nAppended Array sorted using the recursive function:");
        printArrayMyVer(arrayRecursizeAppended);
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
    
    private static void printArrayMyVer(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.printf("|%s|\t", arr[i]);
        }
    }

}

