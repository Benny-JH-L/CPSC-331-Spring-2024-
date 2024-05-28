package Assignment2.Submition;

import java.util.Random;

// CPSC 331 -Spring 2024- Assignment 2 | Application of List, Stack and Queue
// Name: Benny Liang | UCID: 30192142

/**
 * 3.1 Exercise 1 - Sorting Stack using Queue.
 */
public class Stack_To_Queue_To_Stack 
{
    // Step 1: Inserting the random numbers created in main() to a stack
    public static void Unsorted_Stack(int[] array)
    {
        // Create a 'stack' that is reversed of array
        int[] stack = new int[array.length];
        for (int i = 0, j = array.length - 1; i < array.length; i++, j--)
            stack[i] = array[j];
        
        // Set the input array as 'stack'
        for (int i = 0; i < stack.length; i++)
            array[i] = stack[i];
    }

    // Step 2: Pop the numbers and enqueue in the queue.
    public static void Stack_To_Queue(int[] array)
    {
        // Create a 'queue' from input array/stack
        int[] queue = new int[array.length];
        for (int i = 0, j = array.length - 1; i < queue.length; i++, j--)
            queue[i] = array[j];
        
        // Set the input array/stack as 'queue'
        for (int i = 0; i < queue.length; i++)
            array[i] = queue[i];
    }

    // Step 3: Sort the queue. (Using Insertion Sort)
    public static void Sorting_Queue(int[] array)
    {
        for (int i = 1; i <= array.length - 1; i++)
        {
            int j = i;
            while (j > 0 && array[j] > array[j-1])      // used '>' instead of '<' to get array sorted in the order: largest -> smallest
            {
                // Swap elements
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
                j--;                                    // j = j - 1
            }
        }
    }

    // Step 4: Push sorted numbers to get a sorted stack
    public static void Sorted_Stack(int[] array)
    {
        // Create a 'stack' with the input array
        int[] stack = new int[array.length];
        for (int i = 0, j = array.length - 1; i < stack.length; i++, j--)
            stack[i] = array[j];
        
        // Set the input array as the 'stack'
        for (int i = 0; i < stack.length; i++)
            array[i] = stack[i];
    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int[] randomNumbers = new int[10];  // Array to store 10 random numbers

        // Generate random numbers and store them in thbe array
        for (int i = 0; i < randomNumbers.length; i++)
            randomNumbers[i] = random.nextInt(100) + 1;

        // int[] randomNumbers = {66, 59, 60, 14, 82, 85, 47, 22, 92, 44}; // test case
        
        // Print the generated random numbers
        System.out.println("Unsorted Numbers numbers:");
        // Assignment version
        for (int number : randomNumbers)
            System.out.println(number);

        // My version (To see numbers easier)
        // for (int number : randomNumbers)
        //     System.out.print(number + " ");
        // System.out.println();
        
        // Call the functions to execute the steps
        Unsorted_Stack(randomNumbers);
        System.out.println("Unsorted numbers in Stack:");
        printArray(randomNumbers);

        Stack_To_Queue(randomNumbers);
        System.out.println("Unsorted numbers in Queue:");
        printArray(randomNumbers);

        Sorting_Queue(randomNumbers);
        System.out.println("Sorted numbers in Queue:");
        printArray(randomNumbers);

        Sorted_Stack(randomNumbers);
        System.out.println("Sorted numbers in Stack:");
        printArray(randomNumbers);
    }

    private static void printArray(int[] array)
    {
        for (int num : array)
            System.out.println(num + " ");
        System.out.println();
    }

    // (To see numbers easier between method calls)
    // private static void printArrayMyVer(int[] array)
    // {
    //     for (int num : array)
    //         System.out.print(num + " ");
    //     System.out.println();
    // }
}
