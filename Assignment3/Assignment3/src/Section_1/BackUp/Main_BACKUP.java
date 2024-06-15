
// // THIS FILE SHOULD NOT BE INCLUDED IN SUBMITION. THIS FILE CONTAINS LOTS OF TEST CASES THAT 
// // WAS REMOVED FOR SUBMITION

// package Section_1.BackUp;

// import java.util.List;

// import Section_1.BackUp.*;

// // CPSC 331 -Spring 2024- Assignment 3 | Advanced ADT With Applications
// // Name: Benny Liang | UCID: 30192142

// public class Main_BACKUP 
// {
//     public static void main(String[] args) throws Exception 
//     {
//         assignmentTests();
//     }

//     /**
//      * Tests outlined in the assignment.
//      */
//     private static void assignmentTests()
//     {
//         DTBST_BACKUP bst = new DTBST_BACKUP();

//         // Adding Events from 1. - 7. Requires no printing
//         bst.addEvent(new Event("Project Kickoff", 480, 60));
//         bst.addEvent(new Event("Team Meeting", 600, 30));
//         bst.addEvent(new Event("Client Call", 630, 45));
//         bst.addEvent(new Event("Lunch Break", 400, 60));
//         bst.addEvent(new Event("Code Review", 465, 15));
//         bst.addEvent(new Event("Stand Up", 550, 10));
//         bst.addEvent(new Event("Design Discussion", 960, 60));

//         // Rest of tasks that require printing

//         // 8.   // Conflict
//         boolean noConflict = bst.addEvent(new Event("Emergency Meeing", 610, 15));
//         if (!noConflict)
//             System.out.println("Conflict");

//         // 9.   // "Client Call"
//         Event eventAtTime645 = bst.findEventAtTime(645);
//         printHelper(eventAtTime645);
        
//         // 10.  // "Code Review"
//         Event event = bst.findNextEvent("Lunch Break");
//         printHelper(event);
        
//         // 11.  // "Team Meeting"
//         event = bst.findPreviousEvent("Client Call");
//         printHelper(event);

//         // 12.  // No Such Event
//         event = bst.findPreviousEvent(410);
//         printHelper(event);

//         // 13.  // "Code Review"
//         event = bst.findPreviousEvent(490);
//         printHelper(event);

//         // 14.  // "Team Meeting"
//         event = bst.findNextEvent(570);
//         printHelper(event);

//         // ----- Deleting portion -----
//         // 15.  // Deleted event
//         boolean deleted = bst.deleteEvent("Design Discussion");
//         printHelperDelete(deleted);

//         // 16.  // No Such Event
//         deleted = bst.deleteEvent(565);
//         printHelperDelete(deleted);

//         // 17.  // Deleted event
//         deleted = bst.deleteEvent(625);
//         printHelperDelete(deleted);

//         // ----- End of Deleting portion -----

//         // 18.  // Added event
//         noConflict = bst.addEvent(new Event("Wrap Up Meeting", 1010, 15));
//         if (!noConflict)
//             System.out.println("Conflict");
        
//         // 19. 
//         /* Prints Events with these names (in this order): 
//          * "Project Kickoff", "Stand Up", "Client Call", "Wrap Up Meeting",
//         */
//         List<Event> list = bst.getEventsInRange(480, 1020);

//         for (Event e : list)
//             System.out.println(e);
        
//         // 20.
//         /*
//          * Prints Events with these names (in this order):
//          * "Lunch Break", "Code Review", "Project Kickoff", "Stand Up", "Client Call"
//          */
//         list = bst.getEventsInRange(0, 720);

//         for (Event e : list)
//             System.out.println(e);

//     }

//     private static void printHelper(Event event)
//     {
//         if (event == null)
//             System.out.println("No Such Event");
//         else
//             System.out.println(event);
//     }

//     private static void printHelperDelete(boolean b)
//     {
//         if (!b)
//             System.out.println("No Such Event");
//     }

//     /**
//      * My test cases, will be deleted before submition.
//      */

//     private static DTBST createDefaultBST(int defaultTime)
//     {
//         DTBST bst = new DTBST();

//         int duration = defaultTime;

//         Event e = new Event("n20", 20, duration);
//         boolean b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n10", 10, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n30", 30, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n5",5, 4);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n16", 16, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n14", 14, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n17", 17, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n13", 13, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         return bst;
//     }

//     private static void addTest1()
//     {
//         System.out.println("\n----Add Test 1---");
//         DTBST bst = new DTBST();
//         Event e0 = new Event("name0", 5000, 30);
//         boolean b0 = bst.addEvent(e0);
//         System.out.printf("Added Event<%s> | %s\n\n", e0.toString(), b0);
//         Event e1 = new Event("name1", 120, 25);
//         boolean b1 = bst.addEvent(e1);
//         System.out.printf("Added Event<%s> | %s\n\n", e1.toString(), b1);
//         Event e2 = new Event("name2", 200, 5);
//         boolean b2 = bst.addEvent(e2);
//         System.out.printf("Added Event<%s> | %s\n\n", e2.toString(), b2);
//         Event e3 = new Event("name3", 300, 5);
//         boolean b3 = bst.addEvent(e3);
//         System.out.printf("Added Event<%s> | %s\n\n", e3.toString(), b3);
//         Event e4 = new Event("Name4", 100, 15);
//         boolean b4 = bst.addEvent(e4);
//         System.out.printf("Added Event<%s> | %s\n\n", e4.toString(), b4);
//     }

//     /**
//      * Test cases I created are for the tree:
//      * https://www.youtube.com/watch?v=vkqdI9gNLww&ab_channel=Let%27sLearn @7:01
//      */
//     private static void test2_deleteEvent_int_time()
//     {
//         System.out.println("\n\n----Add Test 2---");
//         DTBST bst = new DTBST();

//         int duration = 1;
//         Event e = new Event("n20", 20, duration);
//         boolean b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n10", 10, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n30", 30, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n5",5, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n16", 16, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n14", 14, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n17", 17, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n13", 13, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         // 30 should be the root of the 'bst' with right child null.
//         // bst.deleteEvent(30);
//         boolean deleted1 = bst.deleteEvent(20);    // delete root, testing case 3.
//         System.out.printf("\nEvent at time %d was deleted: %s\n", 20, deleted1);

//         // boolean deleted2 = bst.deleteEvent(16);    // deleting a node with 2 children 
//         // System.out.printf("Event at time %d was deleted: %s\n\n", 16, deleted2);

//         bst = new DTBST();
//         bst.addEvent(new Event("Root100-150", 100, 50));
//         bst.deleteEvent(120);
//     }

//     private static void test3()
//     {
//         System.out.println("\n----Add Test 3---");
//         DTBST bst = new DTBST();

//         int duration = 1;
//         Event e = new Event("n20", 20, duration);
//         boolean b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n10", 10, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n30", 30, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n5",5, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n16", 16, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n14", 14, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n17", 17, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n13", 13, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         // Note these wont work once i make 'root' private in DTBST
//         // System.out.println("Predecessor of root is: " + bst.getPredecessor(bst.root).event.toString());
//         // System.out.println("Successor of root is: " + bst.getSuccessor(bst.root).event.toString());

//         // 30 should be the root of the 'bst' with right child null.
//         boolean deleted1 = bst.deleteEvent("n20"); // (Testing String inupt for delete) delete root, testing case 3.
//         System.out.printf("\nEvent at time %d was deleted (Using String name): %s\n", 20, deleted1);

//         boolean deleted2 = bst.deleteEvent("n16");
//         System.out.printf("Event at time %d was deleted (USing String name): %s\n\n", 16, deleted2);
//     }

//     private static void test4()
//     {
//         System.out.println("\n\n----Add Test 4---");
//         DTBST bst = new DTBST();

//         int duration = 1;
//         Event e = new Event("n200", 200, duration);
//         boolean b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n10", 100, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n30", 300, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n5",50, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n16", 160, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n14", 140, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n17", 170, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n13", 130, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         Event e1 = bst.findEventAtTime(170);        // expected result is n17
//         System.out.printf("FindEventAtTime(%d) = %s", 170, e1.toString());
//     }

//     private static void test5_findEventAtTime()
//     {
//         System.out.println("\n\n----Add Test 5----");
//         DTBST bst = new DTBST();

//         int duration = 1;
//         Event e = new Event("n20", 20, duration);
//         boolean b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n10", 10, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n30", 30, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n5",5, 4);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n16", 16, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n14", 14, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n17", 17, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         e = new Event("n13", 13, duration);
//         b = bst.addEvent(e);
//         System.out.printf("Added Event<%s> | %s\n", e.toString(), b);

//         Event e1 = bst.findEventAtTime(17);     // expected result is n16
//         System.out.printf("\nFindEventAtTime(%d) = %s", 17, e1.toString());

//         e1 = bst.findEventAtTime(16);           // expected result is n16
//         System.out.printf("\nFindEventAtTime(%d) = %s", 16, e1.toString());

//         e1 = bst.findEventAtTime(18);           // expected result is n17
//         System.out.printf("\nFindEventAtTime(%d) = %s", 18, e1.toString());

//         try
//         {
//             e1 = bst.findEventAtTime(19);           // expected result is null
//             System.out.printf("\nFindEventAtTime(%d) = %s", 19, e1.toString());
//         }
//         catch(Exception ex)
//         {
//             System.out.printf("\nFindEventAtTime(%d) = %s", 19, null);
//         }

//         e1 = bst.findEventAtTime(7);           // expected result is n5
//         System.out.printf("\nFindEventAtTime(%d) = %s", 7, e1.toString());
//     }

//     /**
//      * Tests 'findNextEvent(int time)' method
//      */
//     private static void test6_findNextEvent_int_time()
//     {
//         // As of June 10 11:47pm 'findNextEvent(int time)' passed all tests.

//         System.out.println("\n\n----Test 6 | findNextEvent(int time)----");
//         DTBST bst = createDefaultBST(1);

//         int[] testCases = {0, 20, 8, 9, 2, 7, 21, 31, 34, 16, 18, 17};

//         Event e;
        
//         for (int integer : testCases)
//         {
//             try 
//             {
//                 e = bst.findNextEvent(integer);
//                 System.out.printf("\nfindNextEvent(%d) = Event<%s>", integer, e.toString());
//             } 
//             catch (Exception ex) 
//             {
//                 System.out.printf("\nfindNextEvent(%d) = Event<%s>", integer, null);
//             }
//         }

//         // Expected Results:
//         /*
//         Note, for case 34, it should return a null event
//         0 should return 5
//         20 should return n30     -- return n20?
//         8 should return n10
//         9 should return n10
//         2 should return n5
//         7 should return n10
//         21 should return n30     // because n20's event ended at 21, so find after
//         31 should return null    // because n30 event ends at 31 and we want event start/happening/occuring 31.
//         34 should return null
//         16 should return n17
//         18 should return n20
//         17 should return n20    -- return n17?
//         */
//     }

//     /**
//      * Tests 'findNextEvent(String eventName)' method
//      */
//     private static void test7()
//     {
//         // As of June 10 11:05pm 'findNextEvent(String eventName)' passed all tests.
//         System.out.println("\n\n----Test 7 | findNextEvent(String eventName)----");
//         DTBST bst = createDefaultBST(1);

//         String[] testCases = {"n5", "n10", "n13", "n14", "n16", "n17", "n20", "n30", "n421"};

//         for (String cases : testCases)
//         {
//             Event event = bst.findNextEvent(cases);    

//             try 
//             {
//                 System.out.printf("\nEvent after eventName<%s> is: Event<%s>", cases, event.toString());
//             } catch (Exception e)
//             {
//                 System.out.printf("\nEvent after eventName<%s> is: Event<%s>", cases, event);
//             }
//         }

//         // Expected results:
//         /*
//         Event after eventName<n5> is: Event<n10 starts at 10 for 1 minutes.>
//         Event after eventName<n10> is: Event<n13 starts at 13 for 1 minutes.>
//         Event after eventName<n13> is: Event<n14 starts at 14 for 1 minutes.>
//         Event after eventName<n14> is: Event<n16 starts at 16 for 1 minutes.>
//         Event after eventName<n16> is: Event<n17 starts at 17 for 1 minutes.>
//         Event after eventName<n17> is: Event<n20 starts at 20 for 1 minutes.>
//         Event after eventName<n20> is: Event<n30 starts at 30 for 1 minutes.>
//         Event after eventName<n30> is: Event<null>
//         Event after eventName<n421> is: Event<null>
//         */
//     }

//     /**
//      * Tests both 'findNextEvent(int time)' and 'findNextEvent(String eventName)' methods and compares their results.
//      */
//     private static void test8()
//     {
//         // As of June 10 11:47pm 'findNextEvent(int time)' passed all tests.

//         System.out.println("\n\n----Test 8 | findNextEvent(int time) & findNextEvent(String eventName)----");

//         String[] eventNames = {"n5", "n10", "n13", "n14", "n16", "n17", "n20", "n30", "n421"};
//         int[] times =         {6, 10, 13, 14, 16, 18, 20, 31, 421};
//         DTBST bst = createDefaultBST(1);

//         System.out.printf("\nfindNextEvent(int time)\t\t\t\t|\tfindNextEvent(String eventName)\t\t\t|\tSame Result");
//         for (int i = 0; i < eventNames.length; i++)
//         {
//             Event nextEventByTime, nextEventByName;

//             nextEventByTime = bst.findNextEvent(times[i]);
//             nextEventByName = bst.findNextEvent(eventNames[i]);

//             boolean sameResult = true;
//             if (nextEventByTime != null && nextEventByName != null)
//                 sameResult = (nextEventByTime.toString().equals(nextEventByName.toString()));
//             else if ((nextEventByTime != null && nextEventByName == null) || (nextEventByTime == null && nextEventByName != null))
//                 sameResult = false;
//             System.out.printf("\nTime<%s> = <%s>\t|\tName<%s> = %s\t|\t%s", times[i], nextEventByTime, eventNames[i], nextEventByName, sameResult);

//         }
//     }

//     /**
//      * Tests 'checkEventConflict(Event e)'
//      */
//     private static void test9()
//     {
//         // As of June 11 9:37 pm 'checkEventConflict(Event e)' passed all tests.
//         System.out.println("\n\n----Test 9 | checkEventConflict(Event e)----");

//                                                                     // Expected results:
//         Event e1 = new Event("e1", 20, 1);  // conflict     (true)
//         Event e2 = new Event("e2", 21, 1);  // no conflict  (false)
//         Event e3 = new Event("e3", 7, 2);   // conflict     (true)
//         Event e4 = new Event("e4", 18, 2);  // no conflict  (false)
//         Event e5 = new Event("e5", 9, 1);   // no conflict  (false)
//         Event e6 = new Event("e6", 31, 5);  // no conflict  (false)
//         Event e7 = new Event("e7", 6, 100); // conflict     (true)
//         Event e8 = new Event("e8", 8, 23);  // conflict     (true)
//         Event e9 = new Event("e9", 16, 120);  // conflict     (true)
//         Event e10 = new Event("e10", 13, 200);  // conflict     (true)

//         DTBST bst = createDefaultBST(1);

//         Event[] events = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10};

//         for (Event event : events)
//         {
//             boolean isConflict = bst.checkEventConflict(event);

//             System.out.printf("\nEvent<%s> has conflict: %s", event, isConflict);
//         }
//     }

//     /**
//      * Tests 'findPreviousEvent(int time)'
//      */
//     private static void test10()
//     {
//         // As of June 12 6:30pm 'findPreviousEvent(int time)' passed all tests.

//         System.out.println("\n\n----Test 10 | findPreviousEvent(int time)----");

//         DTBST bst = createDefaultBST(1);
//         bst.addEvent(new Event("n40", 40, 10));
//         bst.addEvent(new Event("n33", 33, 2));
//         bst.addEvent(new Event("n60", 60, 1));

//         int[] testCases = {5, 10, 13, 14, 16, 17, 20, 30, 34};

//         for (int test : testCases)
//         {
//             Event e = bst.findPreviousEvent(test);
//             System.out.printf("\nPrevious event at time<%d> is: Event<%s>", test, e);
//         }

//         // Expected Results:
//         /* 
//         Previous event at time<5> is Event<null>
//         Previous event at time<10> is Event<n5 starts at 5 for 4 minutes.>
//         Previous event at time<13> is Event<n10 starts at 10 for 1 minutes.>
//         Previous event at time<14> is Event<n13 starts at 13 for 1 minutes.>
//         Previous event at time<16> is Event<n14 starts at 14 for 1 minutes.>
//         Previous event at time<17> is Event<n16 starts at 16 for 1 minutes.>
//         Previous event at time<20> is Event<n17 starts at 17 for 1 minutes.>
//         Previous event at time<30> is Event<n20 starts at 20 for 1 minutes.>
//         Previous event at time<34> is Event<n30 starts at 30 for 1 minutes.>
//         */
//     }

//     /**
//      * Tests 'findPreviousEvent(String eventName)'
//      */
//     private static void test11()
//     {
//         // As of June 12 1:34am 'findPreviousEvent(String eventName)' passed all tests.

//         System.out.println("\n\n----Test 11 | findPreviousEvent(String eventName)----");

//         DTBST bst = createDefaultBST(1);
//         bst.addEvent(new Event("n40", 40, 10));
//         bst.addEvent(new Event("n33", 33, 2));

//         String[] testCases = {"n5", "n10", "n13", "n14", "n16", "n17", "n20", "n30", "n33", "n40"};

//         for (String test : testCases)
//         {
//             Event event = bst.findPreviousEvent(test);
//             System.out.printf("\nPrevious event at EventName<%s> is: Event<%s>", test, event);
//         }

//         // Expected results:
//         /*
//         Previous event at EventName<n5> is: Event<null>
//         Previous event at EventName<n10> is: Event<n5 starts at 5 for 4 minutes.>
//         Previous event at EventName<n13> is: Event<n10 starts at 10 for 1 minutes.>
//         Previous event at EventName<n14> is: Event<n13 starts at 13 for 1 minutes.>
//         Previous event at EventName<n16> is: Event<n14 starts at 14 for 1 minutes.>
//         Previous event at EventName<n17> is: Event<n16 starts at 16 for 1 minutes.>
//         Previous event at EventName<n20> is: Event<n17 starts at 17 for 1 minutes.>
//         Previous event at EventName<n30> is: Event<n20 starts at 20 for 1 minutes.>
//         Previous event at EventName<n33> is: Event<n30 starts at 30 for 1 minutes.>
//         Previous event at EventName<n40> is: Event<n33 starts at 33 for 2 minutes.>
//         */
//     }
    
//     /**
//      * Tests 'getEventsInRange(int startTimeRange, int endTimeRange)'
//      */
//     private static void test12_getEventsInRange()
//     {
//         // As of June 14 6:56pm 'getEventsInRange(int startTimeRange, int endTimeRange)' passed all tests.

//         System.out.println("\n\n----Test 12 | getEventsInRange(int startTimeRange, int endTimeRange)----");
//         DTBST bst = createDefaultBST(1);

//         // Test 1
//         List<Event> list = bst.getEventsInRange(0, -1);

//         System.out.printf("\nGet Events In Range: [%d, %d]:", 0, -1);

//         for (Event event : list)
//             System.out.printf("\nEvent<%s>,", event);

//         // Expected result:
//         /* (All events in DTBST)
//         Event<n5 starts at 5 for 4 minutes.>,
//         Event<n10 starts at 10 for 1 minutes.>,
//         Event<n13 starts at 13 for 1 minutes.>,
//         Event<n14 starts at 14 for 1 minutes.>,
//         Event<n16 starts at 16 for 1 minutes.>,
//         Event<n17 starts at 17 for 1 minutes.>,
//         Event<n20 starts at 20 for 1 minutes.>,
//         Event<n30 starts at 30 for 1 minutes.>,
//          */
        
//         // Test 2
//         list = bst.getEventsInRange(16, -1);
//         System.out.printf("\nGet Events In Range: [%d, %d]:", 16, -1);

//         for (Event event : list)
//             System.out.printf("\nEvent<%s>,", event);
        
//         // Expected result: -? still waiting on response for getNextEvent(int time) question
//         /* (All events starting from 16 onwards)
//         Event<n16 starts at 16 for 1 minutes.>,
//         Event<n17 starts at 17 for 1 minutes.>,
//         Event<n20 starts at 20 for 1 minutes.>,
//         Event<n30 starts at 30 for 1 minutes.>,
//          */
        
//         // Test 3
//         list = bst.getEventsInRange(8, 20);
//         System.out.printf("\nGet Events In Range: [%d, %d]:", 8, 20);

//         for (Event event : list)
//             System.out.printf("\nEvent<%s>,", event);
        
//         // Expected result: -? still waiting on response for getNextEvent(int time) question
//         /* (All events starting between times 8 and 20)
//         Event<n5 starts at 5 for 4 minutes.>,
//         Event<n10 starts at 10 for 1 minutes.>,
//         Event<n13 starts at 13 for 1 minutes.>,
//         Event<n14 starts at 14 for 1 minutes.>,
//         Event<n16 starts at 16 for 1 minutes.>,
//         Event<n17 starts at 17 for 1 minutes.>,
//         Event<n20 starts at 20 for 1 minutes.>,
//         */

//         // Test 4 (edge case)
//         list = bst.getEventsInRange(0, 8);
//         System.out.printf("\n\nGet Events In Range: [%d, %d]:", 0, 8);

//         for (Event event : list)
//             System.out.printf("\nEvent<%s>,", event);

//         // Expected result:
//         // Event<n5 starts at 5 for 4 minutes.>,


//         // Custom DTBST
//         bst = new DTBST();
//         bst.addEvent(new Event("n160-260", 160, 100));
//         bst.addEvent(new Event("n100-160", 100, 60));
//         bst.addEvent(new Event("n300-360", 300, 70));

//         // Test 5
//         list = bst.getEventsInRange(240, 360);
//         System.out.printf("\nGet Events In Range (New DTBST 1): [%d, %d]:", 240, 360);

//         for (Event event : list)
//             System.out.printf("\nEvent<%s>,", event);

//         // Expected result:
//         // Event<n160-260 starts at 160 for 100 minutes.>,
//         // Event<n300-370 starts at 300 for 70 minutes.>,

//         // Custom DTBST 2
//         bst = new DTBST();
//         bst.addEvent(new Event("n160-260", 160, 100));
//         bst.addEvent(new Event("n100-160", 100, 60));
//         bst.addEvent(new Event("n300-340", 300, 40));
//         bst.addEvent(new Event("n340-370", 340, 30));

//         // Test 6
//         list = bst.getEventsInRange(240, 360);
//         System.out.printf("\nGet Events In Range (New DTBST 2): [%d, %d]:", 240, 360);

//         for (Event event : list)
//             System.out.printf("\nEvent<%s>,", event);

//         // Expected result:
//         // Event<n160-260 starts at 160 for 100 minutes.>,
//         // Event<n300-340 starts at 300 for 40 minutes.>,
//         // Event<n340-370 starts at 340 for 30 minutes.>,

//         // Custom DTBST 3
//         bst = new DTBST();
//         bst.addEvent(new Event("n100-400", 100, 300));
//         bst.addEvent(new Event("n000-090", 0, 90));
//         bst.addEvent(new Event("n410-500", 410, 90));        

//         // Test 7
//         list = bst.getEventsInRange(240, 360);
//         System.out.printf("\nGet Events In Range (New DTBST 3): [%d, %d]:", 240, 360);

//         for (Event event : list)
//             System.out.printf("\nEvent<%s>,", event);
        
//         // Expected result:
//         // Event<n100-400 starts at 100 for 300 minutes.>,
//     }
// }
