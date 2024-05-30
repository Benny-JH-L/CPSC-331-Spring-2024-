package Assignment2_OLD.Submition.ADT;
// package Assignment2.Submition.ADT;

// /**
//  * Implementation of an unbounded list ADT using double linking
//  * 
//  * Implementation is by contract and by reference
//  *
//  * @author Jalal Kawash
//  */


// public class DoublyLinkedList<T extends Comparable> implements ListInterface<T>
// {
//     class Node<T extends Comparable>
//     {
//         private T value;
//         private Node<T> next;
//         private Node<T> prev;
//     }
    
//     private Node<T> list, currentIndex;
//     private int size;

//     /**
//      * Constructor for objects of class DoublyLinkedList
//      */
//     public DoublyLinkedList()
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
//      * Postcondition: Adds a new element at the begining of the list
//      */
//     public void add(T item) 
//     {
//         Node<T> newNode = new Node<T>();
//         newNode.value = item;
//         if (list == null) list = newNode; //adding to an empty list
//         else 
//         {
//             newNode.next = list;
//             list.prev = newNode;
//             list = newNode;
            
//         }
//         currentIndex = list;
//         size++;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: returns true if a given item is in the list; otherwise returns false
//      */
//     public int contains(T item) 
//     {
//         Node<T> tmp = list;
//         int i = 0;
//         while(tmp != null)
//             if (item.compareTo(tmp.value) == 0) return i;
//             else 
//             { 
//                 tmp = tmp.next;
//                 i++;
//             }
//         return -1;
//     }
    
//     /**
//      * Precondition: None
//      * Postcondition: removes first occurence of an item from the list
//      */
//     public void remove(T item) 
//     {
//         if (list == null) return; // list is empty
        
//         if (list != null && item.compareTo(list.value) == 0) // removing the first item in the list
//         {
//             list = list.next;
//             if (list != null) list.prev = null; // list size is 2 or more
//             size--;
//             return;
//         }
               
//         Node<T> tmp = list;
//         while (tmp != null && item.compareTo(tmp.value) != 0) // search for item
//             tmp = tmp.next;        
        
//         if (tmp == null) return; // item not found
             
//         // else tmp points to node to be removed; remove it
//         tmp.prev.next = tmp.next;
//         if (tmp.next != null) tmp.next.prev = tmp.prev; // node being removed is not the last node
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
