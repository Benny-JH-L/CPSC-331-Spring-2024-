package otherTests;

import java.util.ArrayList;

public class other2 
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < 10; i++)
            list.add(String.valueOf(i+1));
        printList(list);

        // there are 2 different remove methods, 1) removes at the specific index, 2) removes the specific object
        list.remove("0");   // removes specific object
        list.remove(4); // removes at specific index
        printList(list);
        list.add("[added :)]");
        printList(list);
        list.set(1, "[set at position 1]");
        printList(list);
    }

    static void printList(ArrayList list)
    {
        System.out.println("\nArray List contents: ");
        int size = list.size();
        for (int i = 0; i < size; i++)
            System.out.print(list.get(i) + ", ");
    }
}
