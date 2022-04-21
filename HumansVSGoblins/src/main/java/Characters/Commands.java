package Characters;

public interface Commands {

    default String speak(){
        return "Who am I?";
    }
    String attack(Object other);

}
