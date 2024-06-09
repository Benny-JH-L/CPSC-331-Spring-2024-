package Section_1;

import java.util.ArrayList;
import java.util.List;

// CPSC 331 -Spring 2024- Assignment 3 | Advanced ADT With Applications
// Name: Benny Liang | UCID: 30192142

public class DTBST 
{

    private TreeNode root = null;

    public DTBST()
    {
        root = null;
    }

    /**
    * Adds an event to the tree. Returns true if successful, false if unsuccessful.
    *
    * Precondition:
    * - event is not null.
    * - event.startTime >= 0 (valid start time in minutes since midnight).
    * - event.duration > 0 (valid duration in minutes).
    *
    * Postcondition:
    * - The event has been added to the tree sorted by start time if no conflict
    exists.
    * - Returns true if the event was successfully added.
    * - Returns false if there was a conflict or the event was not added for any
    reason.
    */
    public boolean addEvent(Event event)
    {
        boolean returnBool = false;
        TreeNode nn = new TreeNode(event);
        nn.leftThread = false;   //?
        nn.rightThread = false;  //?
        if (root == null)
        {
            // nn.leftThread = false;   //?
            // nn.rightThread = false;  //?
            root = nn;
            returnBool = true;
        }
        else
        {
            returnBool = recursiveAddEvent(root, nn);
            // BAD---
            // if (event.startTime < root.event.startTime)
            //     returnBool = recursiveAddEvent(event, root, root.left);
            // else if (event.startTime > root.event.startTime)
            //     returnBool = recursiveAddEvent(event, root, root.right);
            // else // If the event to be added has a startTime that's the same as the root's startTime --> conflit.
            //     System.out.println("Conflict");
        }
        return returnBool;
    }


    protected boolean recursiveAddEvent(TreeNode root, TreeNode nodeToAdd)      // change to private
    {
        if (checkConflict(root.event, nodeToAdd.event))    
        {
            System.out.println("Conflict");
            return false;
        }
        // If 'nodeToAdd' event's start time is < its root's event start time, go to left subtree and keep checking
        else if (nodeToAdd.event.startTime < root.event.startTime)
        {
            TreeNode leftChild = root.left;
            if (!root.leftThread && leftChild != null)                          // If left child is not null and root is not threaded, keep checking
                return recursiveAddEvent(leftChild, nodeToAdd);
            else                                            // Otherwise, add the node here
            {
                if (root.leftThread == true)                // Set left thread of nodeToAdd
                {
                    nodeToAdd.left = root.left;
                    nodeToAdd.leftThread = true;
                    root.leftThread = false;
                }

                root.left = nodeToAdd;
                nodeToAdd.right = root;                     // Right thread to it's parent
                nodeToAdd.rightThread = true;

                return true;                                // Node added successfully
            }
        }
        // Otherwise, 'nodeToAdd' event's start time is >= its root's event start time, go to right subtree and keep checking
        else
        {
            TreeNode rightChild = root.right;
            if (!root.rightThread && rightChild != null)                         // If right child is not null and root is not threaded, keep checking
                return recursiveAddEvent(rightChild, nodeToAdd);
            else                                            // otherwise, add node here
            {
                if (root.rightThread == true)              // set right thread of nodeToAdd
                {
                    nodeToAdd.right = root.right;
                    nodeToAdd.rightThread = true;
                    root.rightThread = false;
                }

                root.right = nodeToAdd;
                nodeToAdd.left = root;                      // Left thread to it's parent
                nodeToAdd.leftThread = true;

                return true;                                // Node added successfully
            }
        }        
    }
    
    /**
     * Checks if there is a conflict between two Events, 'rootEvent' and 'eventToCheck'.
     * @param rootEvent an Event, the root event already in the DTBST.
     * @param eventToCheck an Event, the Event to be added.
     * @return a boolean. Returns true if 'eventToCheck' conflicts with 'rootEvent', otherwise returns false.
     */
    protected boolean checkConflict(Event rootEvent, Event eventToCheck)    // change to private
    {
        int rootEndTime = rootEvent.startTime + rootEvent.duration;
        
        // if the eventToCheck's start time is > rootEvent's start time And 
        // eventToCheck's start time < rootEvent's end time, then we have a conflict
        if (eventToCheck.startTime >= rootEvent.startTime && eventToCheck.startTime < rootEndTime)
            return true;
        
        // Otherwise there is no conflict.
        return false;
    }

    /**
    * Deletes the event occurring at the provided time. The time could point to the
    start or middle of an event.
    * Returns true if successful, false if unsuccessful.
    *
    * Precondition:
    * - time >= 0 (valid time in minutes since midnight).
    *
    * Postcondition:
    * - If an event starting or ongoing at the given time is found, it is removed
    from the tree.
    * - Returns true if the event was successfully deleted.
    * - Returns false if no event was found at the given time.
    */
    public boolean deleteEvent(int time)
    {

    }

    /**
    * Deletes the event named "eventName". Returns true if successful, false if
    unsuccessful.
    *
    * Precondition:
    * - eventName is not null and not empty.
    *
    * Postcondition:
    * - If an event with the given name is found, it is removed from the tree.
    * - Returns true if the event was successfully deleted.
    * - Returns false if no event with the given name was found.
    */
    public boolean deleteEvent(String eventName)
    {

    }

    /**
    * Returns the event occurring at the specified time. Returns null if no event is
    found at this time.
    *
    * Precondition:
    * - time >= 0 (valid time in minutes since midnight).
    *
    * Postcondition:
    * - Returns the event that is occurring at the specified time.
    * -
    */
    public Event findEventAtTime(int time)
    {

    }

    /**
    * Returns the first event that starts after the specified time. Returns null if
    no such event is found.
    *
    * Precondition:
    * - time >= 0 (valid time in minutes since midnight).
    *
    * Postcondition:
    * - Returns the first event that starts after the specified time.
    * - Returns null if no such event is found.
    */
    public Event findNextEvent(int time)
    {

    }

    
    /**
    * Returns the first event that starts after the event with the specified name.
    Returns null if no such event is found.
    *
    * Precondition:
    * - eventName is not null and not empty.
    *
    * Postcondition:
    * - Returns the first event that starts after the event with the specified name.
    * - Returns null if no such event is found.
    */
    public Event findNextEvent(String eventName)
    {

    }

    /**
    * Returns the event that occurred (started and finished) immediately before the
    specified time. Returns null if no such event is found.
    *
    * Precondition:
    * - time >= 0 (valid time in minutes since midnight).
    *
    * Postcondition:
    * Returns the event that occurred (started and finished) immediately before the
    specified time. Returns null if no such event is found.
    * - Returns null if no such event is found.
    */
    public Event findPreviousEvent(int time)
    {

    }

    /**
    * Returns the event that occurred immediately before the event with the specified
    name. Returns null if no such event is found.
    *
    * Precondition:
    * - eventName is not null and not empty.
    *
    * Postcondition:
    * - Returns the event that occurred immediately before the event with the
    specified name.
    * - Returns null if no such event is found.
    */
    public Event findPreviousEvent(String eventName) 
    {
    // Implement this method
    }

    /**
    * Returns true if a conflict is found between event e and the events in the tree.
    Returns false otherwise.
    *
    * Precondition:
    * - e is not null.
    * - e.startTime >= 0 (valid start time in minutes since midnight).
    * - e.duration > 0 (valid duration in minutes).
    *
    * Postcondition:
    * - Returns true if there is a conflict between event e and any event in the tree.
    * - Returns false if no conflict is found.
    */
    public boolean checkEventConflict(Event e)
    {

    }

    /**
    * Returns a list of events occurring between startTimeRange and endTimeRange,
    inclusive. If endTimeRange is negative, returns all events starting from
    startTimeRange onwards.
    *
    * Precondition:
    * - startTimeRange >= 0 (valid time in minutes since midnight).
    * - endTimeRange >= startTimeRange or endTimeRange < 0 (indicating no upper
    bound).
    *
    * Postcondition:
    * - Returns a list of events occurring between startTimeRange and endTimeRange,
    inclusive.
    * - If endTimeRange is negative, returns all events starting from startTimeRange
    onwards.
    */
    public List<Event> getEventsInRange(int startTimeRange, int endTimeRange) 
    {
        // Do not change this
        List<Event> events = new ArrayList<>();
        collectEventsInRange(root, startTimeRange, endTimeRange, events);
        return events;
    }

    /**
    * Returns a list of events occurring between the "start" and "end" times in
    chronological order. Includes the event that is already happening at the
    "start". If the "end" time is negative, all events from the "start" time
    onwards are included.
    *
    * Precondition:
    * - node is either null or a valid TreeNode.
    * - start >= 0 (valid start time in minutes since midnight).
    * - end >= start or end < 0 (indicating no upper bound).
    * - events is not null.
    *
    * Postcondition:
    * - Events in the specified time range are added to the list ’events’ in
    chronological order.
    * - If end is negative, all events from start time onwards are included.
    */
    private void collectEventsInRange(TreeNode node, int start, int end, List<Event> events) 
    {
    // Implement this method
    }
    
}

    // ------------------ Other Classes needed for DTBST ------------------
    class Event
    {
        String name;
        int startTime;  // Start time of the event, in minutes since midnight 
        // - to be used as the key to sort events in the BST
        int duration;   // Duration of the event, in minutes

        public Event (String name, int startTime, int duration)
        {
            this.name = name;
            this.startTime = startTime;
            this.duration = duration;
        }

        @Override
        public String toString()
        {
            return name + " starts at " + startTime + " for " + duration + " minutes.";
        }
    }

    class TreeNode
    {
        Event event;
        TreeNode left, right;
        boolean leftThread, rightThread;

        public TreeNode(Event event)
        {
            this.event = event;
            this.left = null;
            this.right = null;
            this.leftThread = true;
            this.rightThread = true;
        }
    }

    // ------------------ End of Other Classes needed for DTBST ------------------
