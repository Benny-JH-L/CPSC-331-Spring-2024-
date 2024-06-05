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
            fixHeap(currentIndex);
        }
        currentIndex++;                     // Increment the index for the next task to be added in the heap (array)
        size++;
    }

    /**
     * Fixes Max heap after adding a Task.
     * @param currentIndex an int. The index at which the new task was added.
     */
    private void fixHeap(int currentIndex)
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

    public void removeTask()
    {

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
    }
}
