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
        Event e0 = new Event("name0", 100, 30);
        Event e1 = new Event("name1", 120, 25);
        boolean c0 = bst.checkConflict(e0, e1);  // should return true for conflict
        System.out.printf("\nDoes Event<%s> added conflict when compared to Event<%s> | %s", e1.toString(), e0.toString(), c0);
    }
}
