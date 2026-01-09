package model;
import java.time.*;
import java.util.*;

public class TaskList{
    public int taskListID;
    public static int taskListIDNextID = 1;
    public ArrayList<Task> taskList;
    public String taskListName;
    public String taskListDescription;
    public LocalDateTime creationDate;
    public LocalDateTime modificationDate; //data e hora que a lista de tarefas foi modificada

    //TaskList Constructor
    public TaskList(String p_taskListName,String p_taskListDescription){
        this.taskListID = taskListIDNextID++;
        this.taskListName = p_taskListName;
        this.taskListDescription = p_taskListDescription;
        this.taskList = new ArrayList<Task>();
        this.creationDate = LocalDateTime.now();
        this.modificationDate = null;
    }

    //Getters
    public int getTaskListID(){
        return taskListID;
    }

    public ArrayList<Task> getTaskList(){
        return taskList;
    }

    public String getTaskListName(){
        return taskListName;
    }

    public String getTaskListDescription(){
        return taskListDescription;
    }

    public LocalDateTime getCreationDate(){
        return creationDate;
    }

    public LocalDateTime getModificationDate(){
        return modificationDate;
    }

    //Setters
    public void setTaskListID(int p_taskListID){
        this.taskListID = p_taskListID;
    }

    public void setTaskListName(String p_taskListName) {
        this.taskListName = p_taskListName;
    }

    public void setTaskListDescription(String p_taskListDescription) {
        this.taskListDescription = p_taskListDescription;
    }

    //Main Methods
    public void addTaskToList(Task task){
        if(task == null){
            throw new IllegalArgumentException("Erro: parametro passado esta vazio!");
        }
        taskList.add(task);
        this.modificationDate = LocalDateTime.now(); //atualiza a data/hora de modificacao
    }

    public Task removeTaskFromList(Task task){
        if(task == null){
            throw new IllegalArgumentException("Erro: parametro passado esta vazio!");
        }
        taskList.remove(task);
        this.modificationDate = LocalDateTime.now(); //atualiza a data/hora de modificacao

        return task;
    }

    public void listAllTheTasks(){
        for(Task task : taskList){
            System.out.println(task.showTaskInfo() +"\n");
        }
    }

    public void setTaskAsConcluded(int id){ //para marcar a tarefa como concluida e preciso procurar ela na lista de tarefas
        for(Task task : taskList){
            if(task.getTaskID() == id){
                task.setTaskStatus(true);
            }else{
                System.out.println("A tarefa nao existe para marcar sua conclusao!");
            }
        }
    }

    public void searchTaskByID(int id){
        for(Task task : taskList){
            if(task.getTaskID() == id){
                System.out.println(task.showTaskInfo() +"\n");
            }else{
                System.out.println("A tarefa nao foi encontrada!");
            }
        }
    }
}
