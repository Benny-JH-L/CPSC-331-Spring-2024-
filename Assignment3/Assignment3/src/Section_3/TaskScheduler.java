package Section_3;

// CPSC 331 -Spring 2024- Assignment 3 | Advanced ADT With Applications
// Name: Benny Liang | UCID: 30192142

// implementation of the priority task scheduler and main method
public class TaskScheduler 
{
    private Task[] maxHeap;

    /**
     * The current index that we will enqueue/add to the Max heap.
     */
    private int currentIndex;

    /**
     * The size of the Max heap, number of Tasks currently in the heap.
     */
    private int size;

    private int maxHeightOfHeap = 0;

    /**
     * Constructor for TaskScheduler, creates an instance of this class. 
     * @param heightOfHeap an int. The max height of the Max heap.
     * @throws Exception an exception, if heightOfHeap is negative.
     */
    public TaskScheduler(int heightOfHeap) throws Exception
    {
        if (heightOfHeap < 0)
            throw new Exception("Cannot have a Heap with a negative height.");
        
        double maxNumNodes = Math.pow(2, heightOfHeap + 1) - 1;
        maxHeap = new Task[((int)maxNumNodes)];
        size = 0;
        maxHeightOfHeap = heightOfHeap;
    }

    /**
     * Inserts a new Task into the scheduler.
     * @param task a Task, to be added.
     * @throws Exception an exception, if task is null.
     */
    public void addTask(Task task) throws Exception
    {
        if (task == null)
            throw new Exception("Cannot add a Null Task.");

        if (maxHeap[0] == null)
            maxHeap[0] = task;
        else
        {
            maxHeap[currentIndex] = task;   // Add the task to the specified index of the array
            fixAfterAdd(currentIndex);
        }
        currentIndex++;                     // Increment the index for the next task to be added in the heap (array)
        size++;
    }

    /**
     * Fixes Max heap after adding a Task.
     * @param currentIndex an int. The index at which the new task was added.
     */
    private void fixAfterAdd(int currentIndex)
    {
        Task task = maxHeap[currentIndex];
        while (currentIndex > 0)
        {
            int parentIndex = (currentIndex - 1)/2;
            Task parentTask = maxHeap[parentIndex];
            if (task.priority > parentTask.priority)  
            // if the task we added has a larger priority value than its parent, swap them, and keep checking up the heap.
            {
                Task tmp = maxHeap[parentIndex];
                maxHeap[parentIndex] = task;
                maxHeap[currentIndex] = tmp;
                currentIndex = parentIndex;
            }
            else    // If the task we added has less (or equal) priority than its parent, break.
                break;
        }
    }

    /**
     * Remove's a task using it's taskID.
     * @param taskID a String, the taskID of the task that needs to be removed.
     */
    public void removeTask(String taskID)
    {
        for (int i = 0; i < size; i++)
        {
            if (maxHeap[i].taskID.equals(taskID))
            {
                Task replacementTask = maxHeap[currentIndex - 1];   // get the most recently added Task from the heap,
                maxHeap[currentIndex - 1] = null;                   // and remove it from that index,
                maxHeap[i] = replacementTask;                       // then put it where the removed Task was located.
                sink(i);                                            // fix the max-heap.
                size--;
                currentIndex--;                                     // decrement index of where a new task will be added. 
                break;
            }
        }
    }

    /**
     * Fixes the Max heap after removing a Task. 
     * @param currentIndex an int, the index where the most recent Task was inserted to to replace the previously removed Task.
     */
    private void sink(int currentIndex)
    {
        Task taskToCheck = maxHeap[currentIndex];

        // There is no need to fix the Max heap since it is empty.
        if (taskToCheck == null)
            return;

        int leftChildPriority = Integer.MIN_VALUE, rightChildPriority = Integer.MIN_VALUE;
        Task leftChild = maxHeap[2*currentIndex + 1];
        Task rightChild = maxHeap[2*currentIndex + 2];

        if (leftChild != null)
            leftChildPriority = leftChild.priority;    
        if (rightChild != null)
            rightChildPriority = rightChild.priority;
        
        // Swap posiiton with greater priority child if the task we are checking also has less priority than that child.
        if (leftChildPriority > rightChildPriority && leftChildPriority > taskToCheck.priority)
        {
            // Swap positions with left child
            maxHeap[currentIndex] = leftChild;
            maxHeap[2*currentIndex + 1] = taskToCheck;
            sink(2*currentIndex + 1);           // keep checking
        }
        else if (rightChildPriority > taskToCheck.priority)
        {
            // Swap positions with right child
            maxHeap[currentIndex] = rightChild;
            maxHeap[2*currentIndex + 2] = taskToCheck;
            sink(2*currentIndex + 2);           // keep checking
        }
    }

    /**
     * Returns and removes the highest priority task from the scheduler. 
     * @return the highest priority Task.
     */
    public Task getNextTask()
    {
        Task returnTask = null;

        if (currentIndex > 0)
        {
            returnTask = maxHeap[0];
            maxHeap[0] = maxHeap[currentIndex - 1];
            maxHeap[currentIndex - 1] = null;
            sink(0);                   // fix Max heap
            size--;
            currentIndex--;
        }

        return returnTask;
    }

    /**
     * Prints all tasks in the scheduler in order of priority
     * @throws Exception an exception.
     */
    public void printAllTasks() throws Exception
    {
        // Create a copy of the Max heap and use the copy to print out the tasks in priority.
        TaskScheduler schedulerCopy = new TaskScheduler(maxHeightOfHeap);

        for (int i = 0; i < size; i++)
            schedulerCopy.addTask(maxHeap[i]);

        System.out.println("\n---Print All Tasks---");
        Task nextTask = schedulerCopy.getNextTask();
        while (nextTask != null)
        {
            System.out.println(nextTask.toString());
            nextTask = schedulerCopy.getNextTask();
        }
    }

    public static void main(String[] args) throws Exception
    {
        TaskScheduler scheduler = new TaskScheduler(3);
        Task t1 = new Task("101", 5, "Complete Project report");
        scheduler.addTask(t1);
        Task t2 = new Task("102", 1, "Organize meeting");
        scheduler.addTask(t2);
        Task t3 = new Task("103", 3, "Review code");
        scheduler.addTask(t3);
        Task t4 = new Task("104", 4, "Test new feature");
        scheduler.addTask(t4);

        scheduler.printAllTasks();

        System.out.println("\nAdding new Task with Task ID 105");
        Task t5 = new Task("105", 2, "Update documentation");
        scheduler.addTask(t5);

        Task retrievedTask = scheduler.getNextTask();
        System.out.println("\nGetNextTask, retrieved Task: " + retrievedTask.toString());

        System.out.println("\nRemoving Task with Task ID 103");
        scheduler.removeTask("103");

        scheduler.printAllTasks();

        System.out.println("\n---GetNextTask & Print---");
        Task nextTask = scheduler.getNextTask();
        while (nextTask != null)
        {
            System.out.println(nextTask.toString());
            nextTask = scheduler.getNextTask();
        }
    }
}
