package ADT;

import java.util.Random;

/**
 * Implementation of an unbounded sorted list ADT using single linking
 * 
 * Implementation is by contract and by reference
 *
 * @author Jalal Kawash
 */


public class SortedSinglyLinkedList<T extends Comparable> implements ListInterface<T>
{
    private static class Node<T extends Comparable>
    {
        private T value;
        private Node<T> next;
    }

    public static void main(String[] args) 
    {
        Random rand = new Random();
        SortedSinglyLinkedList<Integer> l1 = new SortedSinglyLinkedList<>();
        SortedSinglyLinkedList<Integer> l2 = new SortedSinglyLinkedList<>();
        
        for (int i = 0; i < 9; i++)
        {
            int int_random = rand.nextInt(1000); 
            l1.add(int_random);
            int int_random2 = rand.nextInt(1000); 
            l2.add(int_random2);
        }
        
        l1.printList();
        l2.printList();
        merge(l1, l2);
    }
    
    private Node<T> list, currentIndex;
    private int size;

    /**
     * Constructor for objects of class SortedSinglyLinkedList
     */
    public SortedSinglyLinkedList()
    {
        list = null;
        size = 0;
        currentIndex = null;
    }

    /**
     * Precondition: None
     * Postcondition: returns true if list is empty
     */
    public boolean isEmpty()
    {
        return (list == null);
    }
    
    /**
     * Precondition: None
     * Postcondition: returns false
     */
    public boolean isFull()
    {
        return false;
    }
    
    /**
     * Precondition: None
     * Postcondition: returns size of the list
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Precondition: None
     * Postcondition: deletes all the elements in the list and resests it to theinitial condition
     */
    public void clear()
    {
        list = null;
        currentIndex = null;
        size = 0;
    }
    
    /**
     * Precondition: None
     * Postcondition: resets the current index to the begining of the list
     */
    public void reset() 
    {
        currentIndex = list;
    }
    
    /**
     * Precondition: currentIndex points to an element in the list and the list is not empty
     * Postcondition: returns the next element in the list
     */
    public T getNext() 
    {
        T tmp =  currentIndex.value;
        currentIndex = currentIndex.next;
        return tmp;
    }
    
    /**
     * Precondition: None
     * Postcondition: Adds a new element to the list
     */
    public void add(T item) 
    {
        Node<T> newNode = new Node<T>();
        newNode.value = item;
        
        if (list == null) // adding to an empty list
        {
            list = newNode;
            size++;
            return;
        }
    
        Node<T> tmp = list, prev = null;
        while (tmp != null && item.compareTo(tmp.value) > 0 )
            {
                prev = tmp;
                tmp = tmp.next;
            }
        
        prev.next = newNode;
        newNode.next = tmp;
        size++;
    }
    
    /**
     * Precondition: None
     * Postcondition: returns true if a given item is in the list; otherwise returns false
     */
    public int contains(T item) 
    {
        int i = 0;
        Node<T> tmp = list;
        while(tmp != null) 
            {
                if (item.compareTo(tmp.value) < 0) return -1;
                if (item.compareTo(tmp.value) == 0) return i;
                tmp = tmp.next;
                i++;
            }
        return -1;
    }
    
    /**
     * Precondition: None
     * Postcondition: removes an item from the list
     */
    public void remove(T item) 
    {
        Node<T> tmp = list, prev = null;
        if (tmp != null && item.compareTo(tmp.value) == 0) // removing the first item in the list
        {
            list = list.next;
            size--;
            return;
        }
        
        while (tmp != null && item.compareTo(tmp.value) != 0) // search for item
        {
            prev = tmp;
            tmp = tmp.next;        
        }
        
        if (tmp == null) return; // item not found
        prev.next = tmp.next; // delete item
        size--;
    }
    
    /**
     * Precondition: None
     * Postcondition: sorts list in ascending order
     */
    public void sort()
    {
       
    }
    
    /**
     * Precondition: None
     * Postcondition: prints the contents of the list
     */
    public void printList()
    {
       System.out.print("list: ");
       Node<T> tmp = list;
       while (tmp!=null)
       {
            System.out.print(tmp.value + ", ");
            tmp = tmp.next;
       }
       System.out.println("end-list");
    }

    public static void merge(SortedSinglyLinkedList l1, SortedSinglyLinkedList l2)
    {
        SortedSinglyLinkedList newList = new SortedSinglyLinkedList();
        int size1 = l1.size;
        int size2 = l2.size;
        Node n1 = l1.list;
        Node n2 = l2.list;
        for (int i = 0; i < size1 && i < size2; i++)
        {
            if (n1.value.compareTo(n2.value) < 0)
            {
                newList.add(n1.value);
                n1 = n1.next;
            }
            else if (n1.value.compareTo(n2.value) == 0)
            {
                newList.add(n1.value);
                newList.add(n2.value);
                n1 = n1.next;
                n2 = n2.next;
            }
            else
            {
                newList.add(n2.value);
                n2 = n2.next;
            }
        }
        newList.printList();
    }
}
