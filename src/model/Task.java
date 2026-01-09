package model;

import enums.Priority;

import java.time.LocalDateTime;

public class Task{
    public double taskDuration;
    public int taskID;
    private static int taskNextID = 1; //usado para o auto incremento do ID sempre o primeiro objeto tera id=1
    public String taskName;
    public String taskDescription;
    public Priority taskPriority;
    public boolean taskStatus; //determina se a tarefa ja foi concluida (true-SIM ou false-NAO)
    public LocalDateTime creationDate;

    //Task Constructor
    public Task(String p_taskName,String p_taskDescription,double p_taskDuration,Priority p_taskPriority){
        this.taskDuration = p_taskDuration;
        this.taskID = taskNextID++;
        this.taskName = p_taskName;
        this.taskDescription = p_taskDescription;
        this.taskPriority = p_taskPriority;
        this.taskStatus = false; //a tarefa sempre que for criada tem o estado de nao concluido
        this.creationDate = LocalDateTime.now();
    }

    //Methods
    //Getters
    public double getTaskDuration(){
        return taskDuration;
    }

    public int getTaskID(){
        return taskID;
    }

    public String getTaskName(){
        return taskName;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    public Priority getTaskPriority(){
        return taskPriority;
    }

    public boolean getTaskStatus(){
        return taskStatus;
    }

    public LocalDateTime getCreationDate(){
        return creationDate;
    }

    //Setters
    public void setTaskDuration(double p_taskDuration){
        this.taskDuration = p_taskDuration;
    }

    public void setTaskName(String p_taskName){
        this.taskName = p_taskName;
    }

    public void setTaskDescription(String p_taskDescription){
        this.taskDescription = p_taskDescription;
    }

    public void setTaskPriority(Priority p_taskPriority){
        this.taskPriority = p_taskPriority;
    }

    public void setTaskStatus(boolean p_taskStatus){
        this.taskStatus = p_taskStatus;
    }

    public String showTaskInfo(){
        StringBuilder string = new StringBuilder();
        String msg;

        if(taskStatus == true){
            msg = "Concluida!";
        }else{
            msg = "Em andamento!";
        }

        string.append("-Nome da Tarefa: " +getTaskName() +"\n");
        string.append("-Duracao da Tarefa: " +getTaskDuration() +"\n");
        string.append("-Descricao da Tarefa: " +getTaskDescription() +"\n");
        string.append("-Estado da Tarefa: " +msg +"\n");
        string.append("-ID da Tarefa: " +getTaskID() +"\n");
        string.append("-Prioridade da Tarefa: " +getTaskPriority().getDescription() +"\n");
        string.append("-Data/Hora de Criacao da Tarefa: " +getCreationDate());

        return string.toString();
    }
}
