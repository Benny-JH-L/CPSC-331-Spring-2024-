package Tutorial;

/**
 * A tester class for the SinglyLinkedList ADT
 *
 * @author Jalal Kawash
 */
public class SinglyLinkedListTester
{
    public static void main(String[] args) 
    {
        System.out.println("Creating a new list of integers");
        SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
        System.out.println("List size is : " + l.size());
        l.printList();
        l.add(new Integer(4));
        l.printList();
        System.out.println("List size is " + l.size());
        System.out.println("Removing the only element in the list");
        l.remove(new Integer(4));
        l.printList();
        System.out.println("List size is " + l.size());
        l.add(new Integer(2));
        l.printList();
        l.add(new Integer(5));
        l.printList();
        l.add(new Integer(4));
        l.printList();
        System.out.println("List size is " + l.size());
        l.reset();
        for (int i = 0; i < l.size(); i++) 
            System.out.println("Next item is:" + l.getNext().toString());
            
        l.reset();
        l.printList();
        int index = l.contains(new Integer(4)); 
        if (index != -1) System.out.println("The list contains 4 at postion " + index);
        else System.out.println("The list does not contain 4");
        index = l.contains(new Integer(2)); 
        if (index != -1) System.out.println("The list contains 2 at postion " + index);
        else System.out.println("The list does not contain 2");
        l.remove(new Integer(4));
        l.printList();
        index = l.contains(new Integer(4));
        if (index != -1) System.out.println("The list contains 4");
        else System.out.println("The list does not contain 4");   
        
        System.out.println("Clearing the list");
        l.clear();
        System.out.println("List size is " + l.size());
        if (l.isEmpty()) System.out.println("The list is empty now");
        System.out.println("Trying to remove a non-existing item");
        l.remove(new Integer(5));
                
        System.out.println("Creating a new list");
        for (int i = 0; i < 10; i++)
        {
            l.add(new Integer(i));
            l.printList();
        }
        
        l.printList();
               
        System.out.println("Removing 5 from the list");
        l.remove(new Integer(5));
        l.printList();
        
        System.out.println("Removing last item");
        l.remove(new Integer(0));
        l.printList();
        
        System.out.println("Removing first item");
        l.remove(new Integer(9));
        l.printList();
        
        System.out.println("Adding a duplicate item");
        l.add(new Integer(7));
        l.printList();
        
        System.out.println("Trying to remove a non-existing item");
        l.remove(new Integer(20));
        l.printList();
        System.out.println("List size is " + l.size());
        
    }
}
