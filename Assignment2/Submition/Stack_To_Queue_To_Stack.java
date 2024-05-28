package Assignment2.Submition;

import java.util.Random;

public class Stack_To_Queue_To_Stack 
{
    
    // Step 1: Inserting the random numbers created in main() to a stack
    public static void Unsorted_Stack(int[] array)
    {
        
    }

    // Step 2: Pop the numbers and enqueue in the queue.
    public static void Stack_To_Queue(int[] array)
    {

    }

    // Step 3: Sort the queue.
    public static void Sorting_Queue(int[] array)
    {

    }

    // Step 4: Push sorted numbers to get a sorted stack
    public static void Sorted_Stack(int[] array)
    {

    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int[] randomNumbers = new int[10];  // Array to store 10 random numbers

        // Generate random numbers and store them in thbe array
        for (int i = 0; i < randomNumbers.length; i++)
            randomNumbers[i] = random.nextInt(100) + 1;

        // Print the generated random numbers
        System.out.println("Unsorted Numbers numbers:");
        for (int number : randomNumbers)
            System.out.println(number);
        
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
}
