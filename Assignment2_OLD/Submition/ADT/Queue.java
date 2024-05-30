package Assignment2_OLD.Submition.ADT;

/**
 * Unbounded Queue Implmentation by using a doubly-linked-list-like ADT by Benny Liang.
 * UCID: 30192142
 */
public class Queue<T extends Comparable>
{
    class Node
    {
        private T value;
        private Node next;
        private Node prev;
    }

    private Node head, tail;
    private int size;

    /**
     * Constructor for Queue.
     */
    public Queue()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Enqueues the item to the back of the Queue.
     * @param item a generic type.
     */
    public void enqueue(T item)
    {
        Node nn = new Node();
        nn.value = item;

        if (head == null)
        {
            head = nn;
            tail = head;
            head.prev = tail;
            tail.next = head;
        }
        else
        {
            tail.prev = nn;
            nn.next = tail;
            tail = nn;
        }
        size++;
    }

    /**
     * Dequeues the item at the front of the Queue.
     * @return a generic type.
     */
    public T dequeue()
    {
        T returnVal = null;
        if (size == 1)
        {
            returnVal = head.value;
            head = null;
            tail = null;
        }
        else
        {
            returnVal = head.value;
            head = head.prev;
            head.next = null;
        }
        size--;
        return returnVal;
    }

    /**
     * Returns the number of nodes/items in the Queue.
     * @return an int.
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns if the Queue is empty.
     * @return a boolean.
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }

    /**
     * Clears the Queue.
     */
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Not needed for Assignment 2, so I'm not going to implement it.
     * Returns false!
     * @return a boolean.
     */
    public boolean contains()
    {
        // code.
        return false;
    }

    /**
     * Not needed for Assignment 2, so I'm not going to implement it.
     * @param item a generic type.
     */
    public void remove(T item)
    {
        // code
    }

    /**
     * Not needed for Assignment 2, so I'm not going to implement it.
     */
    public void sort()
    {
        // code
    }
}
