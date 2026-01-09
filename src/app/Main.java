package app;

import enums.Priority;
import model.Task;
import model.TaskList;

import java.util.*;

public class Main{
    public void menu(){
        System.out.println("\n-------------------------------");
        System.out.println("--GESTOR DE TAREFAS--");
        System.out.println("1-Adicionar tarefa");
        System.out.println("2-Remover tarefa");
        System.out.println("3-Marcar tarefa como concluida");
        System.out.println("4-Buscar por ID");
        System.out.println("5-Listar tarefas");
        System.out.println("0-Sair!");
        System.out.println("-------------------------------");
    }

    public void priorities(){
        System.out.println("-------------------");
        System.out.println("1-Prioridade Alta");
        System.out.println("2-Prioridade Media");
        System.out.println("3-Prioridade Baixa");
        System.out.println("--------------------");
    }

    public static void main(String[] args){
        Main main = new Main();
        TaskList list = new TaskList("Lista de Tarefas","Armazena tarefas de forma organizada");

        Scanner sc = new Scanner(System.in);
        int opc;

        do{
            main.menu();
            System.out.print("Escolha uma opcao: ");
            opc = sc.nextInt();
            sc.nextLine();//limpa o buffer para resolver o problema de leitura de 2 Strings seguidas

            switch(opc){
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                case 1:
                    System.out.print("Nome da tarefa: ");
                    String taskName = sc.nextLine();

                    System.out.print("Descricao da tarefa: ");
                    String taskDescription = sc.nextLine();

                    System.out.print("Duracao da tarefa(minutos): ");
                    int taskDuration = sc.nextInt();

                    main.priorities();
                    System.out.print("Prioridade da tarefa: ");
                    Priority taskPriority = null;
                    int priority = sc.nextInt();

                    switch(priority){
                        case 1:
                            taskPriority = Priority.HIGH;
                            break;

                        case 2:
                            taskPriority = Priority.MEDIUM;
                            break;

                        case 3:
                            taskPriority = Priority.LOW;
                            break;

                        default:
                            System.out.println("Opcao invalida, tente novamente!");
                            break;
                    }


                    Task task = new Task(taskName,taskDescription,taskDuration,taskPriority);
                    list.addTaskToList(task);
                    break;

                case 2:
                    System.out.print("ID da tarefa que deseja remover: ");
                    break;

                case 3:
                    break;

                case 4:
                    System.out.print("ID da tarefa que deseja procurar: ");
                    int id = sc.nextInt();
                    list.searchTaskByID(id);
                    break;

                case 5:
                    list.listAllTheTasks();
                    break;

                default:
                    System.out.println("Opcao invalida, tente novamente!");
                    break;
            }
        }while(opc != 0);
    }
}