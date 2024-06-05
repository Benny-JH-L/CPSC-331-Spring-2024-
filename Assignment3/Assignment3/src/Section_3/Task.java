package Section_3;

public class Task 
{
    String taskID;
    int priority;
    String description;

    public Task(String taskID, int priority, String description)
    {
        this.taskID = taskID;
        this.priority = priority;
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "Task ID: " + taskID + ", Priority: " + priority + ", Description: '" + description + "'"; 
    }
}
