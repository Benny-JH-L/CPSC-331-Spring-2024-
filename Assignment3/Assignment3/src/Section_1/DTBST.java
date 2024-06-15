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
        nn.leftThread = false;              // Set threads to false initially.
        nn.rightThread = false;     

        if (root == null)                   // If tree is null, start the tree with this node
        {
            root = nn;
            returnBool = true;
        }
        else
            returnBool = recursiveAddEvent(root, nn);
        
        return returnBool;
    }

    /**
     * Goes through DTBST recursively to determine where to add the 'nodeToAdd'.
     * @param root a TreeNode, the root of the tree/sub-tree.
     * @param nodeToAdd a TreeNode, the node to be added.
     * @return a boolean. Return true if 'nodeToAdd' was added successfully, return false otherwise.
     */
    private boolean recursiveAddEvent(TreeNode root, TreeNode nodeToAdd)
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
    private boolean checkConflict(Event rootEvent, Event eventToCheck)
    {
        int rootEndTime = rootEvent.startTime + rootEvent.duration;
        
        // if the eventToCheck's start time is > rootEvent's start time And 
        // eventToCheck's start time < rootEvent's end time, then we have a conflict
        if (eventToCheck.startTime >= rootEvent.startTime && eventToCheck.startTime < rootEndTime)  // if 'eventToCheck' starts when 'rootEvent' ends it is not considered a conflict.
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
        return recursiveDeleteEventByTime(root, time);
    }

    /**
     * Recursively goes through the DTBST and checks if 'root' has the Event occuring within 'time'.
     * @param root a TreeNode, node to be checked.
     * @param time an int, the time at which an Event is occuring within that needs to be deleted.
     * @return a boolean. Returns true deleted an Event occuring wihtin 'time', otherwise return false.
     */
    private boolean recursiveDeleteEventByTime(TreeNode root, int time)
    {
        if (checkEventDeleteByTime(root.event, time))   // If true, the event at 'root' is the event we are going to delete
        {
            deleteEventHelper(root);
            return true;
        }
        else if (time < root.event.startTime && !root.leftThread)
            return recursiveDeleteEventByTime(root.left, time);
        else if (time > root.event.startTime && !root.rightThread)
            return recursiveDeleteEventByTime(root.right, time);

        return false;
    }

    /**
     * Checks if this event is the one we are looking for to delete. 
     * That is if 'event's start time <= 'time' <= event's end time,
     * 'event' is the one we are looking for to delete, 
     * return true, otherwise return false.
     * @param eventToCheck an Event, to be checked.
     * @param time an int. Time of event to be deleted.
     * @return a boolean. Return true if this is the event to be deleted (That is between 'event' start time <= 'time' <= 'event's end time), return false otherwise.
     */
    private boolean checkEventDeleteByTime(Event eventToCheck, int time)
    {
        int eventEndTime = eventToCheck.startTime + eventToCheck.duration;

        if (eventToCheck.startTime <= time && time <= eventEndTime)
            return true;
        
        return false;
    }

    /**
     * Helper method for 'recursiveDeleteEventByTime(...)' and recursiveHelperDeleteEventByName(...).
     * Delete's the 'root' and fixes threads and pointers to children (fixes tree in general after removal). 
     * @param root a TreeNode, node to be deleted.
     */
    private void deleteEventHelper(TreeNode root)
    {
            if (root.leftThread && root.rightThread)     // Case 1) Deleting a leaf node with 2 threaded children.
            {
                // deleteEventCase1(root);
                if (root == root.right.left)                // deleting left child
                {
                    root.right.left = root.left;            // set 'root's parent's left child as 'root's left thread
                    root.right.leftThread = true;
                }
                else                                        // deleting right child
                {
                    root.left.right = root.right;           // set 'root's parent's right child as 'root's right thread
                    root.left.rightThread = true;
                }
            }
            else if (!root.leftThread && root.rightThread)      // Case 2.1) deleting a node with a left child (non threaded)
            {
                // deleteEventCase2_1(root);
                TreeNode predecessor = getPredecessor(root);        // getting 'root's predecessor
        
                if (predecessor == null)                            // Special case: where 'root' is the left-most node of the tree (smallest value)
                {
                    root.right.left = null;                         // set 'root's parent's left child to null;
                    root = null;
                    return;
                }
        
                predecessor.right = root.right;                     // set predecessor's right thread to 'root's right thread.
                root.right.left = root.left;                        // set 'root's parent's left child as 'root's left child.
            }
            else if (!root.rightThread && root.leftThread)  // Case 2.2) deleting a node with a right child (non threaded)
            {
                // deleteEventCase2_2(root);
                TreeNode successor = getSuccessor(root);        // getting 'root's successor
        
                if (successor == null)                          // Special case: where 'root' is the right-most node of the tree (largest value)
                {
                    root.left.right = null;                     // set 'root's parent's right child to null;
                    root = null;
                    return;
                }
        
                successor.left = root.left;                     // set successor's left thread to 'root's left thread.
                root.left.right = root.right;                   // set 'root's parent's right child as 'root's right child.
            }
            else                                            // Case 3) deleting a node with 2 non-threaded children.
            // Set 'root's Event value to it's right child's Event value, then delete 'root's right child.
            {
                Event tmp = root.right.event;               // Store the Event value of 'root's right child
                TreeNode childToRemove = root.right;

                deleteEventHelper(childToRemove);
                // if (childToRemove.leftThread && childToRemove.rightThread)          // Case 1) Deleting a leaf node with 2 threaded children
                //     deleteEventCase1(childToRemove);
                // else if (!childToRemove.leftThread && childToRemove.rightThread)    // Case 2.1) deleting a node with a left child (non threaded)
                //     deleteEventCase2_1(childToRemove);
                // else                                                                // Case 2.2) deleting a node with a right child (non threaded)
                //     deleteEventCase2_2(childToRemove);
                
                root.event = tmp;

                return;     // Return here or else 'root' will be set to null later (don't want that).
            }

            root = null;                                // delete root
    }

    // /**
    //  * Precondition:
    //  * - (root.leftThread && root.rightThread)
    //  * 
    //  * Case 1) Deleting a leaf node with 2 threaded children.
    //  * @param root a TreeNode, the node to be deleted.
    //  */
    // private void deleteEventCase1(TreeNode root)
    // {
    //     if (root == root.right.left)            // delete left child (use .equals() ?)
    //     {
    //         root.right.left = root.left;        // set 'root's parent's left child as 'root's left thread
    //         root.right.leftThread = true;
    //     }
    //     else                                    // delete right child
    //     {
    //         root.left.right = root.right;       // set 'root's parent's right child as 'root's right thread
    //         root.left.rightThread = true;
    //     }
    // }

    // /**
    //  * Precondition: 
    //  * - (!root.leftThread && root.rightThread) is true.
    //  * 
    //  * Case 2: Deleting a node with 1 non-threaded child.
    //  * Case 2.1) deleting a node with a left child (non threaded).
    //  * Case 2.2) deleting a node with a right child (non threaded).
    //  * @param root a TreeNode, the node to be deleted.
    //  */
    // private void deleteEventCase2_1(TreeNode root)
    // {
    //     TreeNode predecessor = getPredecessor(root);    // getting 'root's predecessor
        
    //     if (predecessor == null)        // Special case: where 'root' is the left-most node of the tree (smallest value)
    //     {
    //         root.right.left = null;     // set 'root's parent's left child to null;
    //         root = null;
    //         return;
    //     }

    //     predecessor.right = root.right;                 // set predecessor's right thread to 'root's right thread.
    //     root.right.left = root.left;                    // set 'root's parent's left child as 'root's left child.
    // }

    // /**
    //  * Precondition: 
    //  * - (!root.rightThread && root.leftThread) is true.
    //  * 
    //  * Case 2: Deleting a node with 1 non-threaded child.
    //  * Case 2.1) deleting a node with a left child (non threaded).
    //  * Case 2.2) deleting a node with a right child (non threaded).
    //  * @param root a TreeNode, the node to be deleted.
    //  */
    // private void deleteEventCase2_2(TreeNode root)
    // {
    //     TreeNode successor = getSuccessor(root);        // getting 'root's successor
        
    //     if (successor == null)          // Special case: where 'root' is the right-most node of the tree (largest value)
    //     {
    //         root.left.right = null;     // set 'root's parent's right child to null;
    //         root = null;
    //         return;
    //     }

    //     successor.left = root.left;                     // set successor's left thread to 'root's left thread.
    //     root.left.right = root.right;                   // set 'root's parent's right child as 'root's right child.
    // }

    /**
     * Precondition:
     * - root.left is not threaded (ie !root.leftThread == true)
     * 
     * Gets the predecessor TreeNode of the 'root'.
     * @param root a TreeNode.
     * @return a TreeNode, the predecessor of the 'root'.
     */
    private TreeNode getPredecessor(TreeNode root)
    {
        TreeNode predecessor = root.left;       // Start at the left subtree

        while(predecessor != null && !predecessor.rightThread)  // go through right sub-tree's until we find the right most node
            predecessor = predecessor.right;
        
        return predecessor;
    }

    /**
     * Precondition:
     * - root.right is not threaded (ie !root.rightThread == true)
     * 
     * Gets the successor TreeNode of the 'root'.
     * @param root a TreeNode.
     * @return a TreeNode, the successor of the 'root'.
     */
    private TreeNode getSuccessor(TreeNode root)
    {
        TreeNode successor = root.right;       // Start at the right subtree

        while(successor != null && !successor.leftThread)   // go through left sub-tree's until we find the left most node
            successor = successor.left;
        
        return successor;
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
        return recursiveDeleteEventByName(root, eventName);
    }

    /**
     * Recursively goes through the DTBST while checking if 'root' contains 'eventName'. Using pre-order tree traversal.
     * @param root a TreeNode, node to be checked.
     * @param eventName a String, name of the event to be deleted.
     * @return a boolean. Return true if an Event with the name 'eventName' was found and deleted, 
     * otherwise return false.
     */
    private boolean recursiveDeleteEventByName(TreeNode root, String eventName)
    {
        boolean result = recursiveHelperDeleteEventByName(root, eventName); // check if 'root' contains 'eventName'
        if (!result)    // if root does not contain 'eventName', keep searching.
        {
            boolean resultLeft = false;
            boolean resultRight = false;

            if (root.left != null && !root.leftThread)
                resultLeft = recursiveDeleteEventByName(root.left, eventName);      // check 'root's left sub-tree (as long as child is not threaded).

            if (root.right != null && !resultLeft && !root.rightThread)             // if 'eventName' was not found on the left sub-tree, check right sub-tree (as long as child is not threaded),
                resultRight = recursiveDeleteEventByName(root.right, eventName);    // otherwise, 'eventName' was found on the left sub-tree don't check right sub-tree, and return true.
            
            // return the '||', or, of the 'resultLeft' with 'resultRight'. If one of these is true, we found the event. Otherwise 'eventName' was not found.
            return (resultLeft || resultRight);
        }
        else            // Otherwise return true as we found and deleted the 'root' that contained an Event named 'eventName'.
            return true;
    }
    
    /**
     * Helper method for 'recursiveDeleteEventByName(...)'.
     * @param root a TreeNode, node to be checked.
     * @param eventName a String, the event's name that needs to be deleted.
     * @return a boolean. Returns true, if 'root' contains 'eventName' 
     * ('root' is deleted from tree as well), otherwuise return false.
     */
    private boolean recursiveHelperDeleteEventByName(TreeNode root, String eventName)
    {
        if (root != null && root.event.name.equals(eventName))  // Checking if 'root's event is the one we are looking for
        {
            deleteEventHelper(root);                            // delete 'root' containing the 'eventName'
            return true;
        }
        return false;
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
        return recursiveFindEventAtTime(root, time);
    }

    /**
     * Recursively goes through DTBST and checks if 'root's event is occuring within 'time'. 
     * @param root a TreeNode, node to check.
     * @param time an int, the time of Event. 
     * @return an Event. Returns an Event if it is occuring within 'time', otherwise returns null if no event at 'time' is occuring.
     */
    private Event recursiveFindEventAtTime(TreeNode root, int time)
    {
        int rootEventEndTime = root.event.startTime + root.event.duration;

        // If the 'root's event start time <= 'time' <= event's end time, then this is the event occuring at 'time'
        if (root.event.startTime <= time && time <= rootEventEndTime)
            return root.event;      // return the Event
        
        // If 'time' < 'root' event's start time check left child (Non threaded).
        else if (time < root.event.startTime && !root.leftThread)
            return recursiveFindEventAtTime(root.left, time);
        
        // If 'time' > 'root' event's start time check left child (Non threaded).
        else if (time > root.event.startTime && !root.rightThread)
            return recursiveFindEventAtTime(root.right, time);
        
        return null;
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
        return recursiveFindNextEventByTime(root, time);
    }

    /**
     * Recursively goes through the DTBST and finds the next event after the specified 'time'.
     * @param root a TreeNode, node to check.
     * @param time an int, the specified time.
     * @return an Event. Returns the first event that stats after the specified time, otherwise returns null.
     */
    private Event recursiveFindNextEventByTime(TreeNode root, int time)
    {
        Event nextEvent = null;
        int rootEventStart = root.event.startTime;

        if (time < rootEventStart)
        {
            if (root.left == null)                  // Special case where 'root' is left-most node in the DTBST
                nextEvent = root.event;             // and since 'time' < 'root' event time, we can't keep checking left, return 'root's event.
            else if (!root.leftThread)                                  // If 'time' < 'root's event start time:
                return recursiveFindNextEventByTime(root.left, time);       // 1) and root is not left threaded, check left child/sub-tree.
            else if (root.leftThread)                                       // 2) and root is left threaded, time' is between 'root' and 'root.left', return 'root.event' as 'root' event start > 'root.left' event start,
                nextEvent = root.event;                                     // and ('root.left' event start < 'time' < 'root' event start).
        }
        else if (time > rootEventStart)
        {
            if (root.right == null)                 // Special case where 'root' is the right-most node in the DTBST     
                return null;                        // since we are finding the first event that starts after 'time', there is no event that exists, return null.
            else if (!root.rightThread)                                 // If 'time' >= 'root's event start time:
                return recursiveFindNextEventByTime(root.right, time);      // 1) and 'root' is not right threaded, check right child/sub-tree.
            else if (root.rightThread)                                      // 2) and 'root' is right threaded, 'time' is between 'root' and 'root.right',
                nextEvent = root.right.event;                               // return 'root.right.event'. As 'root' event start < 'time' < 'root.right' event start.
        }
        else if (time == rootEventStart)            // If 'time' is equal to 'root's event start, 
            return root.event;                      // return 'root's event as this will be the next event.
        
        // Return this event
        return nextEvent;
    }

    // OLD-------------
    // private Event recursiveFindNextEventByTime(TreeNode root, int time)
    // {
    //     int rootEventStart = root.event.startTime;

    //     if (time < rootEventStart)
    //     {
    //         if (root.left == null)                  // Special case where 'root' is left-most node in the DTBST
    //             return root.event;                  // and since 'time' < 'root' event time, we can't keep checking left, return 'root's event.
    //         else if (!root.leftThread)                                  // If 'time' < 'root's event start time:
    //             return recursiveFindNextEventByTime(root.left, time);       // 1) and root is not left threaded, check left child/sub-tree.
    //         else if (root.leftThread)                                       // 2) and root is left threaded, time' is between 'root' and 'root.left', return 'root.event' as 'root' event start > 'root.left' event start,
    //             return root.event;                                          // and ('root.left' event start < 'time' < 'root' event start).
    //     }
    //     else if (time > rootEventStart)
    //     {
    //         if (root.right == null)                 // Special case where 'root' is the right-most node in the DTBST     
    //             return null;                        // since we are finding the first event that starts after 'time', there is no event that exists, return null.
    //         else if (!root.rightThread)                                 // If 'time' > 'root's event start time:
    //             return recursiveFindNextEventByTime(root.right, time);      // 1) and 'root' is not right threaded, check right child/sub-tree.
    //         else if (root.rightThread)                                      // 2) and 'root' is right threaded, 'time' is between 'root' and 'root.right',
    //             return root.right.event;                                    // return 'root.right.event'. As 'root' event start < 'time' < 'root.right' event start.
    //     }
        
    //     // Otherwise, 'root's event start == 'time', return 'root's event.
    //     return root.event;
    // }

        // OLD
        // // doesn't really work with null nodes (special cases of left-most node and roght-most node)
        // if (time < rootEventStart && !root.leftThread)                  // If 'time' < 'root's event start time and root is not left threaded,
        //     return recursiveFindNextEventByTime(root.left, time);       // check left child/sub-tree.
        // else if (time < rootEventStart && root.leftThread)              // If 'time' < 'root's event start time and root is left threaded,
        //     return root.event;                                          // 'time' is between 'root' and 'root.left', return 'root.event' as 'root' event start > 'root.left' event start 
        //                                                                 // and ('root.left' event start < 'time' < 'root' event start).
        
        // else if (time > rootEventStart && !root.rightThread)            // If 'time' > 'root's event start time and 'root' is not right threaded,
        //     return recursiveFindNextEventByTime(root.right, time);      // check right child/sub-tree.
        // else if (time > rootEventStart && root.rightThread)             // If 'time' > 'root's event start time and 'root' is right threaded,
        //     return root.right.event;                                    // 'time' is between 'root' and 'root.right', return 'root.right.event'.
        
        // else
        //     return root.event;

    
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
        return recursiveFindNextEventByName(root, eventName);
    }

    /**
     * Calls a recursive helper method to get result. Returns an Event if it exists, otherwise returns null.
     * @param root a TreeNode, the actual root of the DTBST. (Start checking with this TreenNode)
     * @param eventName a String, the name of the Event whose successor is being searched for. (Ie the event that starts after this one).
     * @return an Event. Returns 'eventName's successor if it exists, otherwise return null.
     */
    private Event recursiveFindNextEventByName(TreeNode root, String eventName)
    {
        Object[] result = recursiveHelperFindNextEventByName(root, eventName);

        if (result[0] != null)          // If result[0] is not null, next event was found.
            return (Event)result[0];
        
        // Otherwise, return null as there is no such event found.
        return null;
    }

    /**
     * Recursively goes through the DTBST and checks if 'root' contains the Event with the name 'eventName'. Using pre-order tree traversal.
     * Then returns an Object[] of size 2, that contains an Event (index 0) and a boolean (index 1) of if the Event was found.
     * @param root a TreeNode, node to check.
     * @param eventName a String, the name of the Event being searched for.
     * @return an Object[2] of size 2. Index 0 contains an Event object (or null if it does not exist), and index 1 contains a boolean of if we need to keep searching.
     */
    private Object[] recursiveHelperFindNextEventByName(TreeNode root, String eventName)
    {
        Object[] returnArr = {null, true};     // index 1 = Event, index 2 = boolean (Keep searching or not)

        if (root != null && root.event.name.equals(eventName))  // Base cases
        {
            if (root.rightThread)
                returnArr[0] = root.right.event;
            else if (!root.rightThread && getSuccessor(root) != null)   // Case where 'root' is not right threaded so the next event is not its right child, but is their successor's event (As long as successor is not null).
                returnArr[0] = getSuccessor(root).event;                // If the successor is null, there is no event after 'root', so return null for event (In default already).
            else if (root.right == null)                // Case where 'root' is right-most node in the DTBST, so it contains the last event. No event after it, return null.
                returnArr[0] = null;
            
            returnArr[1] = false;                       // found the event/found that it does not exist, stop searching.

            return returnArr;
        }
        else if (root != null)      // As long as 'root' is not null, keep searching.
        {
            Object[] resultArrLeft = {null, true};
            Object[] resultArrRight = {null, true};

            if (root.left != null && !root.leftThread)                  // check left child/sub-tree, and ...
                resultArrLeft = recursiveHelperFindNextEventByName(root.left, eventName);
            
            if ((boolean)resultArrLeft[1] && !root.rightThread)         // ... if event is not found on the left sub-tree, search the right sub-tree (as long as 'root's right node is not threaded)
                resultArrRight = recursiveHelperFindNextEventByName(root.right, eventName);

            if (!(boolean)resultArrLeft[1])                 // If 'resultArrLeft[1]' is false -> stop searching because event was found,
                returnArr = resultArrLeft;                  // set return array to this.
            else if (!(boolean)resultArrRight[1])           // If 'resultArrRight[1]' is false -> stop searching because event was found,
                returnArr = resultArrRight;                 // set return array to this.
        }
        
        return returnArr;                                   // Return array. Default return array of {null, true}. Event = null, 'keep searching' = true.
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
        return recursiveFindPreviousEventByTime(root, time);
    }

    /**
     * Recursively goes through the DTBST and compares the 'root's event's ending time with 'time'. And finds the event 
     * that occured (started and finished) immediately before 'time'. 
     * @param root a TreeNode, node's event to be checked.
     * @param time an int. Used to find the event immediately before 'time'.
     * @return an Event. The event that occursed (started and finished) immediately before 'time'. Otherwise, returns null.
     */
    private Event recursiveFindPreviousEventByTime(TreeNode root, int time)
    {
        int eventEndTime = root.event.startTime + root.event.duration;

        if (time < eventEndTime)        // Searching left, as 'root's event has not yet ended relative to 'time'
        {
            if (root.left == null)      // If 'root.left' is null its reached the left most node in the DTBST, 
                return null;            // no more nodes to check and this node's event has not yet finished, return null.
            else if (root.leftThread)   // If 'root' is left threaded and 'time' < 'root's event end time, then 'root's event has not ended yet,
                return root.left.event; // so return 'root.left's event. (As this event will have ended right before 'root's event, thus being the immediate event before 'time').
            else                        // Otherwise, keep searching from the left child.
                return recursiveFindPreviousEventByTime(root.left, time);
        }
        else if (time > eventEndTime)   // Search right, as 'root's event has ended relative to 'time' but may not be the immediate event before 'time'
        {
            if (root.right == null)     // If 'root.right' is null we have reached the right most node in the DTBST, 
                return root.event;      // so return this node's event.
            else if (root.rightThread)  // If 'root' is right threaded, it will loop back to an event who'll have occured after 'root', 
                return root.event;      // so return 'root's event. (As it will be the most immediate event).
            else                        // Otherwise, keep searching from the right child.
                return recursiveFindPreviousEventByTime(root.right, time);
        }
        
        // Otherwise, 'time' == 'eventEndTime', so 'root's event will be the most immediate previous event relative to 'time'.
        return root.event;      // return 'root's event.
    }

    // See OneNote for better visualization and explaination for cases. The following I did very late while very tired...
    // Using default tree:
    // If time was 25, need to find the event to the right, as '20' (root) started and finished relative to 25 but it might 
    // not be the immediate previous event at 25. Going to the right root = 30, we see that in this node this event hasn't 
    // started nor ended relative to 25, so we return 'root's left node (if it is the left-most node in DTBST return null).  

    // If time was 12, we check 20, then see 12 < 20 (start time), check left. Now check 10, 12 > 10, so check right. 
    // now check 16, 12 < 16, check left. Check 14, 12 < 14, check left. Check 13, 12 < 13, 
    // check left BUT since 13 (is a leaf) is left threaded we return it's left threaded node's event.

    // OLD
        // Event returnEvent = null;
        // boolean startedAndFinished = hasEventStartedAndFinishedAtTime(root.event, time);

        // if (startedAndFinished)     // If the event in 'root' started and finished relative to 'time',
        //     return root.event;      // return event at 'root'.
        // else if (root != null)
        // {
        //     if (!root.leftThread && root.left != null)   // Checking left child (As long it is not null or left threaded).
        //         returnEvent = recursiveFindPreviousEventByTime(root.left, time);    // Set result
            
        //     if (returnEvent == null && !root.rightThread && root.right != null)     // If 'returnEvent' is null that means left didn't find such an event, 
        //         returnEvent = recursiveFindPreviousEventByTime(root.right, time);   // check right child *(s long as it is not null or righ threaded).
        // }

        // return returnEvent;                // return null otherwise.

    // OLD2
        // boolean startedAndFinished = hasEventStartedAndFinishedAtTime(root.event, time);

        // if (!startedAndFinished)
        // {
        //     int eventEndTime = root.event.startTime + root.event.duration;

        //     // Continue searching
        //     if (time >= eventEndTime)                               // If 'time' >= 'root's event end time then check left child as
        //         recursiveFindPreviousEventByTime(root.left, time);  // 'root's event hasn't started and finished relative to 'time'.
        //     else                                                    // Otherwise, 'time' < 'root's event end time 
        //         recursiveFindPreviousEventByTime(root.right, time);
        // }
        
        // // If 'root's event started and finished return it
        // return root.event;

    // OLD3
    // if (time <= root.event.startTime)   // If 'time' <= 'root' event's start, means 'root's event hasn't started relative to 'time'.
    // {
    //     if (root.leftThread)            // Base case, if 'root' is left threaded, we have reached a leaf node, return 'root.left.event',
    //         return root.left.event;     // as this will be the immediate event before 'time'.
    //     else if (root.left == null)     // Base case, traversed to the left most node in the DTBST which is also the event that 'occures first' (smallest value for start time).
    //         return null;                // There is no event previous of this and 'time' is still <= 'root's event start time, so return null.
    //     else
    //         return recursiveFindPreviousEventByTime(root.left, time);   // Otherwise, keep checking from left.
    // }
    // else                                // Otherwise 'time' > 'root' event's start time, means 'root's event has started relative to 'time'.
    // {
    //     if (root.rightThread && root.right.event.startTime < root.event.startTime)           // Base case, if 'root' is right threaded, and 'time' > 'root' event start time, we return 'root's event as the event to the right will 
    //         return root.event;                                     // be it's parent who we already checked (and went here), and to the left will not be the most immediate event that started and finished relative to 'time'.
    //     else if (root.leftThread && root.right.event.startTime > root.event.startTime)
    //         return root.event;
    //     // Base case, if 'root' is the right most node in the DTBST and 'root's event started and finished relative to 'time', return 'root's event as it is the immediate event before 'time'.    
    //     else if (hasEventStartedAndFinishedAtTime(root.event, time) && root.right == null)
    //         return root.event;
    //     // Base case, if 'root' is the right most node in the DTBST and 'root's event has not started and finished relative to 'time' and is left threaded, return it's left threaded nodes event.
    //     else if (!hasEventStartedAndFinishedAtTime(root.event, time) && root.leftThread)
    //         return root.left.event;
    //     // Base case, if 'root' is the right most node in the DTBST and 'root's event has not started and finished, then check 'root's left child.
    //     else if (!hasEventStartedAndFinishedAtTime(root.event, time) && !root.leftThread)
    //         return recursiveFindPreviousEventByTime(root.left, time);
    //     // Otherwise keep checking from right.
    //     else
    //         return recursiveFindPreviousEventByTime(root.right, time);  // Keep checking
    // }

    // OLD 4
        // if (time <= root.event.startTime)   // If 'time' <= 'root' event's start, means 'root's event hasn't started relative to 'time'.
        // {
        //     if (root.leftThread)            // Base case, if 'root' is left threaded, we have reached a leaf node, return 'root.left.event',
        //         return root.left.event;     // as this will be the immediate event before 'time'.
        //     else if (root.left == null)     // Base case, traversed to the left most node in the DTBST which is also the event that 'occures first' (smallest value for start time).
        //         return null;                // There is no event previous of this and 'time' is still <= 'root's event start time, so return null.
        //     else
        //         return recursiveFindPreviousEventByTime(root.left, time);   // Otherwise, keep checking from left.
        // }
        // else                                // Otherwise 'time' > 'root' event's start time, means 'root's event has started relative to 'time'.
        // {
        //     if (root.rightThread)           // Base case, if 'root' is right threaded, and 'time' > 'root' event start time, we return 'root's event as the event to the right will 
        //         return root.event;                                     // be it's parent who we already checked (and went here), and to the left will not be the most immediate event that started and finished relative to 'time'.
        //     // Base case, if 'root' is the right most node in the DTBST and 'root's event started and finished relative to 'time', return 'root's event as it is the immediate event before 'time'.    
        //     else if (hasEventStartedAndFinishedAtTime(root.event, time) && root.right == null)
        //         return root.event;
        //     // Base case, if 'root' is the right most node in the DTBST and 'root's event has not started and finished relative to 'time' and is left threaded, return it's left threaded nodes event.
        //     else if (!hasEventStartedAndFinishedAtTime(root.event, time) && root.leftThread)
        //         return root.left.event;
        //     // Base case, if 'root' is the right most node in the DTBST and 'root's event has not started and finished, then check 'root's left child.
        //     else if (!hasEventStartedAndFinishedAtTime(root.event, time) && !root.leftThread)
        //         return recursiveFindPreviousEventByTime(root.left, time);
        //     // Otherwise keep checking from right.
        //     else
        //         return recursiveFindPreviousEventByTime(root.right, time);  // Keep checking
        // }
        // // NOTE Does not work properly, look at test case with time 34.



    // Prolly not needed
    /**
     * Precondition:
     * - 'event' is not null.
     * - 'time' is >= 0.
     * 
     * Compares 'event's start time and end time (finished time) with 'time'.
     * If 'event's start time <= 'time' < 'event's end time, 
     * then 'event' hasn't started and finished yet when compared to 'time'. 
     * If 'time' >= 'event's ending time then 'event' started and finished relative to 'time'.
     * @param event an Event, event to be checked.
     * @param time an int, of if the 'event' has started and finished yet at this time.
     * @return a boolean. Returns true if the 'event' has started and finished compared to 'time', returns false otherwise.
     */
    private boolean hasEventStartedAndFinishedAtTime(Event event, int time)
    {
        int endTime = event.startTime + event.duration;

        if (time >= endTime)    // Checking if 'event' ended yet (if it ended that means it started at one point).
            return true;        // return true.
        // if (event.startTime <= time && time < endTime)  // Checking if 'event' has started and ended,
        //     return false;                               // return false as 'event' hasn't started and finished at 'time'.
        
        return false;           // otherwise return false
    }

    // OLD
    // Event nextEvent = null;
    // int rootEventStart = root.event.startTime;

    // if (time < rootEventStart)
    // {
    //     if (root.left == null)                  // Special case where 'root' is left-most node in the DTBST
    //         nextEvent = root.event;             // and since 'time' < 'root' event time, we can't keep checking left, return 'root's event.
    //     else if (!root.leftThread)                                  // If 'time' < 'root's event start time:
    //         return recursiveFindNextEventByTime(root.left, time);       // 1) and root is not left threaded, check left child/sub-tree.
    //     else if (root.leftThread)                                       // 2) and root is left threaded, time' is between 'root' and 'root.left', return 'root.event' as 'root' event start > 'root.left' event start,
    //         nextEvent = root.event;                                     // and ('root.left' event start < 'time' < 'root' event start).
    // }
    // else if (time >= rootEventStart)
    // {
    //     if (root.right == null)                 // Special case where 'root' is the right-most node in the DTBST     
    //         return null;                        // since we are finding the first event that starts after 'time', there is no event that exists, return null.
    //     else if (!root.rightThread)                                 // If 'time' >= 'root's event start time:
    //         return recursiveFindNextEventByTime(root.right, time);      // 1) and 'root' is not right threaded, check right child/sub-tree.
    //     else if (root.rightThread)                                      // 2) and 'root' is right threaded, 'time' is between 'root' and 'root.right',
    //         nextEvent = root.right.event;                               // return 'root.right.event'. As 'root' event start <= 'time' < 'root.right' event start.
    // }
    
    // Otherwise, 'root's event start == 'time', return 'root's event.
    // return nextEvent;



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
        return recursiveFindPreviousEventByName(root, eventName);
    }

    /**
     * Recursively goes through the DTBST and checks/searches for the TreeNode that contains the event with the name 'eventName'.
     * Using pre-order tree traversal. If it finds this node, returns the event immediately before this node.
     * @param root a TreeNode, the node to be checked.
     * @param eventName a String, the name of the event whose immediate event is being searched for.
     * @return an Event. Returns the Event that immediately occured before 'eventName', otherwise returns null. 
     */
    private Event recursiveFindPreviousEventByName(TreeNode root, String eventName)
    {
        if (!root.event.name.equals(eventName))
        {
            Event event = null;

            if (root.left != null && !root.leftThread)
                event = recursiveFindPreviousEventByName(root.left, eventName);   // keep checking from left child.

            if (event != null)                      // found the event we were looking for from the left child,
                return event;                       // return it.
            else if (root.right != null && !root.rightThread)   // otherwise keep checking from right child, if 'event' from left child results in null. (And 'root's right child is not null or threaded)
                return recursiveFindPreviousEventByName(root.right, eventName);

            return null;                            // Otherwise return null.
        }

        // Otherwise, 'root's event name matches 'eventName', return:
        if (!root.leftThread && root.left != null)  // As long as 'root' is not left threaded or null,
            return getPredecessor(root).event;      // return the previous event (will be its predecessor).
        else if (root.left == null)             // Special case, where 'root' is left most node in DTBST, so it wont have a previous immediate event, return null.
            return null;
        else                                    // Otherwise,
            return root.left.event;             // return 'root's left node's event as it wil be the event immediately before 'root's event. (For cases where 'root' is left threaded thus it won't have a predecessor)
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
        return recursiveEventConflict(root, e);
    }


    /**
     * Recursively goes through the DTBST and compares the Event in 'root' with Event 'e' 
     * and sees if there is a conflict. If 'e' conflicts with the Event in 'root' returns true, otherwise returns false.
     * @param root a TreeNode, node to check.
     * @param e an Event. 
     * @return a boolean. Returns true if Event 'e' conflicts with an Event in the DTBST.
     */
    private boolean recursiveEventConflict(TreeNode root, Event e)
    {
        boolean isConflict = checkConflict(root.event, e);
        boolean leftFoundConflict = false, rightFoundConflict = false;

        if (isConflict)     // If a conflict is found,
            return true;    // return true;
        
        // Check left sub-tree/child (As long as it exists and is not left threaded)
        if (root.left != null && !root.leftThread)
            leftFoundConflict = recursiveEventConflict(root.left, e);
        
        // Check right sub-tree/child (If we didn't find conflict on the left sub-tree/child, and right is not null or threaded)
        if (!leftFoundConflict && root.right != null && !root.rightThread)
            rightFoundConflict = recursiveEventConflict(root.right, e);

        return (leftFoundConflict || rightFoundConflict);               // Return the 'or' of the two booleans. If one is true, a conflict was found somewhere in the tree.
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
        // Get all events onward from 'start'
        if (end < 0)
        {
            Event eventToAdd = findNextEvent(start);

            while (eventToAdd != null)
            {
                events.add(eventToAdd);
                int eventEndTime = eventToAdd.startTime + eventToAdd.duration;
                eventToAdd = findNextEvent(eventEndTime);
            }
        }
        else 
            collectEventsInRangeHelper(start, end, events);
    }

    /**
     * Collects the events in range that are occuring between 'start' and 'end'.
     * @param start an int, the 'start' time.
     * @param end an int, the 'end' time.
     * @param events a List<Events> that collects the events in range.
     */
    private void collectEventsInRangeHelper(int start, int end, List<Event> events)
    {
        Event eventToAdd = findNextEvent(start);                    // First get the next event at time 'start'

        if (eventToAdd != null)                                     // If not null, get the previous event, as it could have started before time 'start' but not yet ended, where this events end time <= 'end'.
        {
            Event tmp = findPreviousEvent(eventToAdd.startTime);   

            if (tmp != null)                                        // If its previous event exists,
                eventToAdd = tmp;                                   // Make the previous event to be checked first.
        }
        else if (eventToAdd == null)                                // If it is null, find the previous event at 'start'.
        {
            Event tmp = null;
            eventToAdd = findPreviousEvent(start);
            if (eventToAdd != null)                                 // If the previous event is not null, check it,
                tmp = inRangeHelper(eventToAdd, start, end);
            
            if (tmp == null)                                        // If the previous event is not in range (returned null) then find the next event after this one.
                eventToAdd = findNextEvent(eventToAdd.startTime + eventToAdd.duration);
        }                        

        // Go through events
        while (eventToAdd != null)
        {
            int eventStart = eventToAdd.startTime;
            int eventEnd = eventStart + eventToAdd.duration;
            // Case 1: eventToAdd starts before 'start' and ends before time 'start', not in range.
            if (eventStart <= start && eventEnd <= start)
                break;
            // Case 2: eventToAdd starts after 'end' thus will end after time 'end', not in range.
            else if (eventStart > end)
                break;
            // Case 3: Otherwise, eventToAdd is between times 'start' and 'end', or starts before time 'start' and ends before or at time 'end',
            // or starts after 'start' and before 'end' and ends after 'end', or starts before 'start' and ends after 'end'. All these events are occuring within 'start' and 'end'
            else
                events.add(eventToAdd);
            eventToAdd = findNextEvent(eventEnd);
        }
    }

    /**
     * A helper method for collectEventsInRangeHelper(...). 
     * @param eventToAdd an Event, who is being checked.
     * @param start an int, 'start' time.
     * @param end an int, 'end' time.
     * @return an Event. Returns 'eventToAdd' if is in range, otherwise returns null.
     */
    private Event inRangeHelper(Event eventToAdd, int start, int end)
    {
        int eventStart = eventToAdd.startTime;
        int eventEnd = eventStart + eventToAdd.duration;
        // Case 1: eventToAdd starts before 'start' and ends before time 'start', not in range.
        if (eventStart <= start && eventEnd <= start)
            return null;
        // Case 2: eventToAdd starts after 'end' thus will end after time 'end', not in range.
        else if (eventStart > end)
            return null;
        // Otherwise it is in range.
        return eventToAdd;
    }

    // OLD
            // if (eventStart >= start && (eventEndTime <= end || eventStart == end))   // Event start and end times are between 'start' and 'end', add it to the List. Or event is occuring at time 'end', add it to the List.
            // {
            //     events.add(eventToAdd);
            // }
            // // need to consider edge cases, there is one i found, refer to tests.

            // eventToAdd = findNextEvent(eventEndTime);

    // OLD2
            // Event eventToAdd = findNextEvent(start);    // old
            // int durationOfStartToEnd = end - start;
    
            // while (eventToAdd != null)
            // {
            //     int eventStart = eventToAdd.startTime;
            //     int eventEndTime = eventToAdd.startTime + eventToAdd.duration;
    
            //     // Case 1: event's end time <= 'start', event is not in range, don't add, check next.
            //     if (eventEndTime <= start)
            //     {
            //         eventToAdd = findNextEvent(eventEndTime);     // Find next event from this event's end time
            //         continue;
            //     }
            //     // Case 2: event's end time is between 'start' and 'end', event is in range, add it.
            //     else if (eventEndTime > start && eventEndTime <= end)
            //     {
            //         events.add(eventToAdd);
            //         eventToAdd = findNextEvent(eventEndTime);     // Find next event from this even't end time
            //     }
            //     // Case 3: event's start time starts at time 'end', event is in range, add it.
            //     else if (eventStart == end)
            //     {
            //         events.add(eventToAdd);
            //         eventToAdd = findNextEvent(eventEndTime);     // Find next event from this even't end time
            //     }
            //     // Case 4: event starts before time 'start' and ends between 'start' and 'end', is in range add it.
            //     else if (eventStart + durationOfStartToEnd > start && eventStart + durationOfStartToEnd <= end)
            //     {
            //         events.add(eventToAdd);
            //         eventToAdd = findNextEvent(eventEndTime);     // Find next event from this even't end time
            //     }
            //     // Case 5: event starts before 'start' and ends after 'end', is in range add it then exit.
            //     else if (eventStart + durationOfStartToEnd <= end && eventEndTime >= end)
            //     {
            //         events.add(eventToAdd);
            //         break;
            //     }
            //     // Case 6: event starts after 'end', event is not in range, stop checking.
            //     else if (eventStart > end)
            //         break;
            // }
    
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
