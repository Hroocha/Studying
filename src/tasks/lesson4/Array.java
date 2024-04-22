package tasks.lesson4;

import java.util.ArrayList;
import java.util.List;

public class Array <T> {

    public void changeElements(T [] array, int index1, int index2){
        T value = array[index1];
        array[index1] = array[index2];
        array[index2] = value;
    }

    public ArrayList <T> arrayToArrayList(T [] array){
        return new ArrayList<>(List.of(array));
    }


}
