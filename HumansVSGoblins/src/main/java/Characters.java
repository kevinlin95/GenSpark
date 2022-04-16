public interface Characters {

    default String speak(){
        return "Who am I?";
    }
    String attack(Object other);
}
