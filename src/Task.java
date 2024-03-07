import java.util.ArrayList;

public class Task {
    private String taskDescription;
    private boolean taskCompleted;

    private int id;

    public Task(int id, String taskDescription, boolean taskCompleted) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.taskCompleted = taskCompleted;
    }

    public int getId () {
        return id;
    }
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nDescription: " + taskDescription + "\nCompleted: " + taskCompleted;
    }
}