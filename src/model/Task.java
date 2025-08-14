package model;

import java.time.LocalDateTime;

public class Task {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private TaskPriority  taskPriority;
    private boolean taskCompleted;
    private LocalDateTime taskCreationDate;

    /**
     * Priority levels for tasks
     */
    public enum TaskPriority  { HIGH, MEDIUM, LOW }
    private static  int taskNextId = 1;

    /**
     * Constructs a fully specified Task with all attributes.
     * @param name The name/title of the task
     * @param description Detailed description of the task
     * @param priority Priority level (HIGH, MEDIUM, LOW)
     * @param completed Completion status
     */
    public Task(String name, String description, TaskPriority priority, boolean completed) {
        this.taskId = taskNextId++;
        this.taskName = name;
        this.taskDescription = description;
        this.taskPriority = priority;
        this.taskCompleted = completed;
        this.taskCreationDate = LocalDateTime.now();
    }

    /**
     * Constructs a Task without a description (defaults to empty string).
     * @param name The name/title of the task
     * @param priority Priority level (HIGH, MEDIUM, LOW)
     * @param completed Completion status
     */
    public Task(String name, TaskPriority priority, boolean completed) {
        this.taskId = taskNextId++;
        this.taskName = name;
        this.taskDescription = "";
        this.taskPriority = priority;
        this.taskCompleted = completed;
        this.taskCreationDate = LocalDateTime.now();
    }

    //Getters
    public int getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getTaskDescription() { return taskDescription; }
    public TaskPriority getTaskPriority() { return taskPriority; }
    public boolean isTaskCompleted() { return taskCompleted; }
    public LocalDateTime getTaskCreationDate() { return taskCreationDate; }

    //Setters
    public void setTaskId(int taskId) { this.taskId = taskId; }
    public void setTaskName(String taskName) { this.taskName = taskName; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }
    public void setTaskPriority(TaskPriority taskPriority) { this.taskPriority = taskPriority; }
    public void setTaskCompleted(boolean taskCompleted) { this.taskCompleted = taskCompleted; }
    public void setTaskCreationDate(LocalDateTime taskCreationDate) { this.taskCreationDate = taskCreationDate; }

    //Methods
    public  String showTaskInfo(){
        StringBuilder taskInfo = new StringBuilder();
        String statusMessage = taskCompleted ? "Completed" : "In progress";

        taskInfo.append("- Task ID: ").append(taskId).append("\n");
        taskInfo.append("- Task Name: ").append(taskName).append("\n");
        taskInfo.append("- Description: ").append(taskDescription).append("\n");
        taskInfo.append("- Priority: ").append(taskPriority).append("\n");
        taskInfo.append("- Status: ").append(taskCompleted).append("\n");
        taskInfo.append("- Creation Date: ").append(taskCreationDate).append("\n");

        return taskInfo.toString();
    }
}