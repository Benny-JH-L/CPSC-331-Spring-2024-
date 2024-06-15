package Section_1;

import java.util.List;

import Section_1.Event;
import Section_1.TreeNode;

// CPSC 331 -Spring 2024- Assignment 3 | Advanced ADT With Applications
// Name: Benny Liang | UCID: 30192142

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        assignmentTests();
    }

    /**
     * Tests outlined in the assignment.
     */
    private static void assignmentTests()
    {
        DTBST bst = new DTBST();

        // Adding Events from 1. - 7. Requires no printing
        bst.addEvent(new Event("Project Kickoff", 480, 60));
        bst.addEvent(new Event("Team Meeting", 600, 30));
        bst.addEvent(new Event("Client Call", 630, 45));
        bst.addEvent(new Event("Lunch Break", 400, 60));
        bst.addEvent(new Event("Code Review", 465, 15));
        bst.addEvent(new Event("Stand Up", 550, 10));
        bst.addEvent(new Event("Design Discussion", 960, 60));

        // Rest of tasks that require printing

        // 8.   // Conflict
        boolean noConflict = bst.addEvent(new Event("Emergency Meeing", 610, 15));
        if (!noConflict)
            System.out.println("Conflict");

        // 9.   // "Client Call"
        Event eventAtTime645 = bst.findEventAtTime(645);
        printHelper(eventAtTime645);
        
        // 10.  // "Code Review"
        Event event = bst.findNextEvent("Lunch Break");
        printHelper(event);
        
        // 11.  // "Team Meeting"
        event = bst.findPreviousEvent("Client Call");
        printHelper(event);

        // 12.  // No Such Event
        event = bst.findPreviousEvent(410);
        printHelper(event);

        // 13.  // "Code Review"
        event = bst.findPreviousEvent(490);
        printHelper(event);

        // 14.  // "Team Meeting"
        event = bst.findNextEvent(570);
        printHelper(event);

        // ----- Deleting portion -----
        // 15.  // Deleted event
        boolean deleted = bst.deleteEvent("Design Discussion");
        printHelperDelete(deleted);

        // 16.  // No Such Event
        deleted = bst.deleteEvent(565);
        printHelperDelete(deleted);

        // 17.  // Deleted event
        deleted = bst.deleteEvent(625);
        printHelperDelete(deleted);

        // ----- End of Deleting portion -----

        // 18.  // Added event
        noConflict = bst.addEvent(new Event("Wrap Up Meeting", 1010, 15));
        if (!noConflict)
            System.out.println("Conflict");
        
        // 19. 
        /* Prints Events with these names (in this order): 
         * "Project Kickoff", "Stand Up", "Client Call", "Wrap Up Meeting",
        */
        List<Event> list = bst.getEventsInRange(480, 1020);

        for (Event e : list)
            System.out.println(e);
        
        // 20.
        /*
         * Prints Events with these names (in this order):
         * "Lunch Break", "Code Review", "Project Kickoff", "Stand Up", "Client Call"
         */
        list = bst.getEventsInRange(0, 720);

        for (Event e : list)
            System.out.println(e);

    }

    /**
     * Helper printer method.
     * @param event an Event.
     */
    private static void printHelper(Event event)
    {
        if (event == null)
            System.out.println("No Such Event");
        else
            System.out.println(event);
    }

    /**
     * Helper printer method.
     * @param b a boolean.
     */
    private static void printHelperDelete(boolean b)
    {
        if (!b)
            System.out.println("No Such Event");
    }

    
}
