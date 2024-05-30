package Assignment2_OLD.Submition.ADT;
// package Assignment2.Submition.ADT;

// /**
//  * Implementation of an unbounded list ADT using single linking
//  * 
//  * Implementation is by contract and by reference
//  *
//  * @author Jalal Kawash
//  */


// public class SinglyLinkedList<T extends Comparable> implements ListInterface<T>
// {
//     private class Node<T extends Comparable>
//     {
//         private T value;
//         private Node<T> next;
//     }
    
//     private Node<T> list, currentIndex;
//     private int size;

//     /**
//      * Constructor for objects of class SinglyLinkedList
//      */
//     public SinglyLinkedList()
//     {
//         list = null;
//         size = 0;
//         currentIndex = null;
//     }

//     /**
//      * Precondition: None
//      * Postcondition: returns true if list is empty
//      */
//     public boolean isEmpty()
//     {
//         return (list == null);
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: returns false
//      */
//     public boolean isFull()
//     {
//         return false;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: returns size of the list
//      */
//     public int size()
//     {
//         return size;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: deletes all the elements in the list and resests it to theinitial condition
//      */
//     public void clear()
//     {
//         list = null;
//         currentIndex = null;
//         size = 0;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: resets the current index to the begining of the list
//      */
//     public void reset() 
//     {
//         currentIndex = list;
//     }
    
//     /**
//      * Precondition: currentIndex points to an element in the list and the list is not empty
//      * Postcondition: returns the next element in the list
//      */
//     public T getNext() 
//     {
//         T tmp =  currentIndex.value;
//         currentIndex = currentIndex.next;
//         return tmp;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: Adds a new element to the list
//      */
//     public void add(T item) 
//     {
//         Node<T> newNode = new Node<T>();
//         newNode.value = item;
//         newNode.next = list;
//         list = newNode;
//         size++;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: returns the first position of a given item in the list; returns -1 if the item is not in the list
//      */
//     public int contains(T item) 
//     {
//         Node<T> tmp = list;
//         int i = 0;
//         while(tmp != null)
//             if (item.compareTo(tmp.value) == 0) return i;
//             else 
//             {
//              tmp = tmp.next;
//              i++;
//             }
//         return -1;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: removes the first occurrence of an item from the list
//      */
//     public void remove(T item) 
//     {
//         Node<T> tmp = list, prev = null;
//         if (tmp != null && item.compareTo(tmp.value) == 0) // removing the first item in the list
//         {
//             list = list.next;
//             size--;
//             return;
//         }
        
//         while (tmp != null && item.compareTo(tmp.value) != 0) // search for item
//         {
//             prev = tmp;
//             tmp = tmp.next;        
//         }
        
//         if (tmp == null) return; // item not found
//         prev.next = tmp.next; // delete item
//         size--;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: sorts list in ascending order
//      */
//     public void sort()
//     {
       
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: prints the contents of the list
//      */
//     public void printList()
//     {
//        System.out.print("list: ");
//        Node<T> tmp = list;
//        while (tmp!=null)
//        {
//             System.out.print(tmp.value + ", ");
//             tmp = tmp.next;
//        }
//        System.out.println("end-list");
//     }
// }
