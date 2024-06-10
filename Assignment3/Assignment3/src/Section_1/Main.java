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
        System.out.printf("\nDoes Event<%s> added conflict when compared to Event<%s> | %s\n\n\n", e1.toString(), e0.toString(), c0);

        // addTest1();
        test2();
    }

    /**
     * My test cases, will be deleted before submition.
     */
    private static void addTest1()
    {
        System.out.println("----Add Test 1---");
        DTBST bst = new DTBST();
        Event e0 = new Event("name0", 5000, 30);
        boolean b0 = bst.addEvent(e0);
        System.out.printf("Added Event<%s> | %s\n\n", e0.toString(), b0);
        Event e1 = new Event("name1", 120, 25);
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

    /**
     * Test cases are from:
     * https://www.youtube.com/watch?v=vkqdI9gNLww&ab_channel=Let%27sLearn 
     */
    private static void test2()
    {
        System.out.println("----Add Test 2---");
        DTBST bst = new DTBST();

        int duration = 1;
        Event e = new Event("n20", 20, duration);
        boolean b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n\n", e.toString(), b);

        e = new Event("n10", 10, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n\n", e.toString(), b);

        e = new Event("n30", 30, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n\n", e.toString(), b);

        e = new Event("n5",5, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n\n", e.toString(), b);

        e = new Event("n16", 16, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n\n", e.toString(), b);

        e = new Event("n14", 14, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n\n", e.toString(), b);

        e = new Event("n17", 17, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n\n", e.toString(), b);

        e = new Event("n13", 13, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n\n", e.toString(), b);

        // Note these wont work once i make 'root' private in DTBST
        System.out.println("Predecessor of root is: " + bst.getPredecessor(bst.root).event.toString());
        System.out.println("Successor of root is: " + bst.getSuccessor(bst.root).event.toString());
    }
}
