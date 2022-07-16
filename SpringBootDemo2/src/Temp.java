import java.util.ArrayList;
import java.util.Set;

public class Temp {

    // create a arraylist , isnert 5 entries 1, 2, 2, 4, 4, 5, and then remove duplicates //unique




    public static void main(String[] args){
        ArrayList <Integer> myarray = new ArrayList<>();
        myarray.add(1);
        myarray.add(2);
        myarray.add(2);
        myarray.add(4);
        myarray.add(4);
        myarray.add(5);



        for(int i = 0; i < myarray.size() -1; i++){
            int j = myarray.get(i);
            if(myarray. == myarray.get(i)){
                myarray.remove(j);
            }
        }
        System.out.println(myarray);

    }

}
