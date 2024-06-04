package Section_1;

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


    

    public class Event
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

    public class TreeNode
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
}
