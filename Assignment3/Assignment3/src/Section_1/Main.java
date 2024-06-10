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

        // Testing checkConflict() of events. (wont work when method is 'private')
        // Event e0 = new Event("name0", 5000, 30);
        // Event e1 = new Event("name1", 120, 25);
        // boolean c0 = bst.checkConflict(e0, e1);  // expect to return true (conflict)
        // System.out.printf("\nDoes Event<%s> added conflict when compared to Event<%s> | %s\n\n\n", e1.toString(), e0.toString(), c0);

        // addTest1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    /**
     * My test cases, will be deleted before submition.
     */

    private static DTBST createDefaultBST()
    {
        DTBST bst = new DTBST();

        int duration = 1;

        Event e = new Event("n20", 20, duration);
        boolean b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n10", 10, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n30", 30, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n5",5, 4);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n16", 16, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n14", 14, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n17", 17, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n13", 13, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        return bst;
    }

    private static void addTest1()
    {
        System.out.println("\n----Add Test 1---");
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
     * Test cases I created are for the tree:
     * https://www.youtube.com/watch?v=vkqdI9gNLww&ab_channel=Let%27sLearn @7:01
     */
    private static void test2()
    {
        System.out.println("\n\n----Add Test 2---");
        DTBST bst = new DTBST();

        int duration = 1;
        Event e = new Event("n20", 20, duration);
        boolean b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n10", 10, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n30", 30, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n5",5, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n16", 16, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n14", 14, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n17", 17, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n13", 13, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        // Note these wont work once i make 'root' private in DTBST
        // System.out.println("Predecessor of root is: " + bst.getPredecessor(bst.root).event.toString());
        // System.out.println("Successor of root is: " + bst.getSuccessor(bst.root).event.toString());

        // 30 should be the root of the 'bst' with right child null.
        boolean deleted1 = bst.deleteEvent(20);    // delete root, testing case 3.
        System.out.printf("\nEvent at time %d was deleted: %s\n", 20, deleted1);

        boolean deleted2 = bst.deleteEvent(16);    // deleting a node with 2 children 
        System.out.printf("Event at time %d was deleted: %s\n\n", 16, deleted2);
    }

    private static void test3()
    {
        System.out.println("\n----Add Test 3---");
        DTBST bst = new DTBST();

        int duration = 1;
        Event e = new Event("n20", 20, duration);
        boolean b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n10", 10, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n30", 30, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n5",5, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n16", 16, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n14", 14, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n17", 17, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n13", 13, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        // Note these wont work once i make 'root' private in DTBST
        // System.out.println("Predecessor of root is: " + bst.getPredecessor(bst.root).event.toString());
        // System.out.println("Successor of root is: " + bst.getSuccessor(bst.root).event.toString());

        // 30 should be the root of the 'bst' with right child null.
        boolean deleted1 = bst.deleteEvent("n20"); // (Testing String inupt for delete) delete root, testing case 3.
        System.out.printf("\nEvent at time %d was deleted (Using String name): %s\n", 20, deleted1);

        boolean deleted2 = bst.deleteEvent("n16");
        System.out.printf("Event at time %d was deleted (USing String name): %s\n\n", 16, deleted2);
    }

    private static void test4()
    {
        System.out.println("\n\n----Add Test 4---");
        DTBST bst = new DTBST();

        int duration = 1;
        Event e = new Event("n200", 200, duration);
        boolean b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n10", 100, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n30", 300, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n5",50, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n16", 160, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n14", 140, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n17", 170, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n13", 130, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        Event e1 = bst.findEventAtTime(170);        // expected result is n17
        System.out.printf("FindEventAtTime(%d) = %s", 170, e1.toString());
    }

    private static void test5()
    {
        System.out.println("\n\n----Add Test 5----");
        DTBST bst = new DTBST();

        int duration = 1;
        Event e = new Event("n20", 20, duration);
        boolean b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n10", 10, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n30", 30, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n5",5, 4);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n16", 16, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n14", 14, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n17", 17, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        e = new Event("n13", 13, duration);
        b = bst.addEvent(e);
        System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

        Event e1 = bst.findEventAtTime(17);     // expected result is n16
        System.out.printf("\nFindEventAtTime(%d) = %s", 17, e1.toString());

        e1 = bst.findEventAtTime(16);           // expected result is n16
        System.out.printf("\nFindEventAtTime(%d) = %s", 16, e1.toString());

        e1 = bst.findEventAtTime(18);           // expected result is n17
        System.out.printf("\nFindEventAtTime(%d) = %s", 18, e1.toString());

        try
        {
            e1 = bst.findEventAtTime(19);           // expected result is null
            System.out.printf("\nFindEventAtTime(%d) = %s", 19, e1.toString());
        }
        catch(Exception ex)
        {
            System.out.printf("\nFindEventAtTime(%d) = %s", 19, null);
        }

        e1 = bst.findEventAtTime(7);           // expected result is n5
        System.out.printf("\nFindEventAtTime(%d) = %s", 7, e1.toString());
    }

    private static void test6()
    {
        System.out.println("\n\n----Test 6----");
        DTBST bst = createDefaultBST();

        int[] testCases = {0, 20, 8, 9, 2, 7, 21, 31, 34, 16, 18, 17};
        // Note, for case 34, it should return a null event
        // 0 should return 5
        // 20 should return n20     
        // 8 should return n10
        // 9 should return n10
        // 2 should return n5
        // 7 should return n5
        // 21 should return n30     // because n20's event ended at 21, so find after
        // 31 should return null    // because n30 event ends at 31 and we want event start/happening/occuring 31.
        // 34 should return null
        // 16 should return n16
        // 18 should return n20
        // 17 should return n17

        Event e;
        
        for (int integer : testCases)
        {
            try 
            {
                e = bst.findNextEvent(integer);
                System.out.printf("\nfindNextEvent(%d) = Event<%s>", integer, e.toString());
            } 
            catch (Exception ex) 
            {
                System.out.printf("\nfindNextEvent(%d) = Event<%s>", integer, null);
            }
        }
    }
}
