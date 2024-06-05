package Section_3;

// implementation of the priority task scheduler and main method
public class TaskScheduler 
{
    private Task[] maxHeap;

    /**
     * The current index that we will enqueue/add to the max heap.
     */
    private int currentIndex;

    /**
     * The size of the heap, number of Tasks currently in the heap.
     */
    private int size;

    /**
     * Constructor for TaskScheduler, creates an instance of this class. 
     * @param heightOfHeap an int. The height of the max heap.
     */
    public TaskScheduler(int heightOfHeap)
    {
        double maxNumNodes = Math.pow(2, heightOfHeap + 1) - 1;
        maxHeap = new Task[((int)maxNumNodes)];
        size = 0;
    }

    public void addTask(Task task)
    {
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
            Task parentTask =  maxHeap[parentIndex];
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
                maxHeap[i] = null;  // prolly not needed
                Task replacementTask = maxHeap[currentIndex-1]; // get the most recently added Task from the heap,
                maxHeap[currentIndex-1] = null;                 // and remove it from that index,
                maxHeap[i] = replacementTask;                   // then put it where the removed Task was located.
                sink(i);                                        // fix the max-heap.
                size--;
                currentIndex--;                                 // decrement index of where a new task will be added. 
            }
        }
    }

    /**
     * Fixes the max-heap after removing a Task.
     */
    private void sink(int currentIndex)
    {
        Task taskToCheck = maxHeap[currentIndex];
        Task leftChild = maxHeap[2*currentIndex + 1];
        Task rightChild = maxHeap[2*currentIndex + 2];

        if (leftChild != null && leftChild.priority > taskToCheck.priority)
        {
            // Swap positions
            maxHeap[currentIndex] = leftChild;
            maxHeap[2*currentIndex + 1] = taskToCheck;
            sink(2*currentIndex + 1);           // keep checking
        }
        else if (rightChild != null && rightChild.priority > taskToCheck.priority)
        {
            // Swap positions
            maxHeap[currentIndex] = rightChild;
            maxHeap[2*currentIndex + 2] = taskToCheck;
            sink(2*currentIndex + 2);           // keep checking
        }
    }

    // public Task getNextTask()
    // {

    // }

    /**
     * Prints all tasks in the scheduler in order of priority
     */
    public void printAllTasks()
    {

    }

    public static void main(String[] args)
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

        scheduler.removeTask("103");    // removing task with Task ID: 103
    }
}
