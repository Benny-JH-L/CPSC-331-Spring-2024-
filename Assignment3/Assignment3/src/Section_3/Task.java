package Section_3;

// CPSC 331 -Spring 2024- Assignment 3 | Advanced ADT With Applications
// Name: Benny Liang | UCID: 30192142

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
