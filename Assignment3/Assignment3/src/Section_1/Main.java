package Section_1;

import Section_1.Event;
import Section_1.TreeNode;

// CPSC 331 -Spring 2024- Assignment 3 | Advanced ADT With Applications
// Name: Benny Liang | UCID: 30192142

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        DTBST bst = new DTBST();

        // Testing checkConflict() of events.
        Event e0 = new Event("name0", 5000, 30);
        Event e1 = new Event("name1", 120, 25);
        boolean c0 = bst.checkConflict(e0, e1);  // expect to return true (conflict)
        System.out.printf("\nDoes Event<%s> added conflict when compared to Event<%s> | %s\n\n", e1.toString(), e0.toString(), c0);

        bst = new DTBST();

        boolean b0 = bst.addEvent(e0);
        System.out.printf("Added Event<%s> | %s\n\n", e0.toString(), b0);
        boolean b1 = bst.addEvent(e1);
        System.out.printf("Added Event<%s> | %s\n\n", e1.toString(), b1);
        Event e2 = new Event("name2", 200, 5);
        boolean b2 = bst.addEvent(e2);
        System.out.printf("Added Event<%s> | %s\n\n", e2.toString(), b2);
        Event e3 = new Event("name3", 300, 5);
        boolean b3 = bst.addEvent(e3);
        System.out.printf("Added Event<%s> | %s\n\n", e3.toString(), b3);
        Event e4 = new Event("Name4", 100, 15);
        boolean b4 = bst.addEvent(e4);
        System.out.printf("Added Event<%s> | %s\n\n", e4.toString(), b4);
    }
}
