package Tutorial;

import java.util.Random;

// A Stack implmentation that supports oush, top, and getting the min. element
public class MinStack<T extends Comparable> 
{
    class Node<T extends Comparable>
    {
        private T value;
        private Node<T> next;
        private Node<T> prev;
    }

    public static void main(String[] args) 
    {
        Random rand = new Random();
        MinStack<Integer> stack = new MinStack<Integer>();
        for (int i = 0; i < 9; i++)
        {
            int randNum = rand.nextInt(1000);
            stack.push(randNum);
        }
        stack.print();
        stack.push(1);
        stack.print();
        stack.pop();
        stack.print();

        int minVal = stack.getMin();
        System.out.printf("\nMin = %s", minVal);
        
    }

    private int size;
    private Node<T> topNode;

    public MinStack()
    {
        size = 0;
        topNode = null;
    }
    

    public void push(T x)
    {
        Node<T> nn = new Node<>();
        nn.value = x;

        if (topNode == null)
        {
            topNode = nn;
        }
        else
        {
            topNode.next = nn;
            nn.prev = topNode;
            topNode = nn;
        }
        size++;
    }

    public T pop()
    {
        T tmp = topNode.value;
        topNode = topNode.prev;
        if (topNode != null)
            topNode.next = null;
        size--;
        return tmp;
    }

    /**
     * Returns the value at the top of the Stack, does not remove it.
     * @return a generic type.
     */
    public T peek()
    {
        return topNode.value;
    }

    /**
     * 
     * @return
     */
    public T getMin()
    {
        Node<T> tmp = topNode.prev;
        T min = topNode.value;
        for (int i = 0; i < size-1; i++)
        {
            if (tmp.value.compareTo(min) <= 0)
                min = tmp.value;
            tmp = tmp.prev;
        }
        
        return min;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    /**
     * Unbounded min stack, so it is never full.
     * @return
     */
    public boolean isFull()
    {
        return false;
    }

    public void print()
    {
        Node<T> tmp = topNode;
        System.out.print("\nTop -> ");
        for (int i = 0; i < size; i++)
        {
            System.out.printf("%s <- ", tmp.value);
            tmp = tmp.prev;
        }
        System.out.print("null \n");
    }
}
