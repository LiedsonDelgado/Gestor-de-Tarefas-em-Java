package model;

/**
 * Representa um usuário do sistema.
 * </br>
 * Cada usuário possui um identificador único (gerado automaticamente),
 * além de informações pessoais (nome, e-mail e telefone)
 * e uma lista de tarefas associada.
 */

public class User {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private TaskList userTaskList;

    private static int userNextId = 1;

    public User(int userId, String userName, String userEmail, String userPhone, TaskList userTaskList) {
        this.userId = userNextId++;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userTaskList = userTaskList;
    }

    //Getters
    public int getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public String getUserPhone() { return userPhone; }
    public TaskList getUserTaskList() { return userTaskList; }

    //setters
    public void setUserTaskList(TaskList userTaskList) { this.userTaskList = userTaskList; }
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setUserName(String userName) { this.userName = userName; }
}
