package enums;

public enum Priority{
    HIGH("Prioridade Alta"),MEDIUM("Prioridade Media"),LOW("Prioridade Baixa");

    public final String description;

    //Priority Constructor
    Priority(String p_description){
        this.description = p_description;
    }

    //Methods
    //Getters
    public String getDescription(){
        return description;
    }
}
