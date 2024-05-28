package Tutorial.May24;

import java.util.Random;

/**
 * Queue Implmentation using 2 Stacks.
 */
public class QueueTwoStacks<T extends Comparable> 
{
    private MinStack headStack;
    private MinStack tailStack;
    private int size;

    public static void main(String[] args) 
    {
        Random rand = new Random();
        QueueTwoStacks<Integer> q1 = new QueueTwoStacks<>();  
        for (int i = 0; i < 9; i++)
        {
            int randNum = rand.nextInt(100);
            q1.enqueue(randNum);
        }
        q1.print();
        int num1 = q1.dequeue();
        System.out.printf("\nDequeued: %s", num1);
        q1.print();
        int num2 = q1.peek();
        System.out.printf("\nPeek: %s", num2);
        int num3 = rand.nextInt(100);
        q1.enqueue(num3);
        System.out.printf("\nEnqueued: %s", num3);
        q1.print();
    }

    public QueueTwoStacks()
    {
        headStack = new MinStack();
        tailStack = new MinStack();
        size = 0;
    }

    public void enqueue(T item)
    {
        headStack.push(item);
        size++;
    }
    
    public T dequeue()
    {
        for (int i = 0; i < size; i++)
            tailStack.push(headStack.pop());
        
        T returnItem = (T) tailStack.pop();
        size--;

        // Putting elements back into the head stack.
        for (int i = 0; i < size; i++)
            headStack.push(tailStack.pop());
        return returnItem;
    }

    public T peek()
    {
        for (int i = 0; i < size; i++)
            tailStack.push(headStack.pop());

        T returnItem = (T) tailStack.peek();

        // Putting elements back into the head stack.
        for (int i = 0; i < size; i++)
            headStack.push(tailStack.pop());
        return returnItem;
    }

    public int size()
    {
        return size;
    }

    public void print()
    {
        headStack.print();
    }
}
