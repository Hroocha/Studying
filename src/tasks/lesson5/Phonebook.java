package tasks.lesson5;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private final HashMap <Integer, String> book;

    public Phonebook() {
        this.book = new HashMap<>();
    }

    public void add(Integer tel,String surname){
        book.put(tel,surname);
    }

    public void get(String surname){
        for(Map.Entry<Integer,String> entry : book.entrySet()){
            int tel = entry.getKey();
            if (book.get(tel).equals(surname)){
                System.out.println(tel);
            }
        }
    }
}
