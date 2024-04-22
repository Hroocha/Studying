package hashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer,Integer> hm = new HashMap<>();

        Hashmap<Integer,Integer> hashmap = new Hashmap<>();
        hashmap.put(null,4);
        hashmap.put(0,6);
        hashmap.put(6,5);
        hashmap.remove(6);

        System.out.println(hashmap.keys);
        System.out.println(hashmap.containsValue(5));
        System.out.println();
        System.out.println(hashmap.get(null));
        System.out.println(hashmap.get(0));
        System.out.println();


        hashmap.print();



        // проверка как работает оригинальный мар
        System.out.println("-------------------");
        hm.put(null, 5);
        hm.put(0, 7);

        System.out.println(hm.keySet());
        System.out.println(hm.values());


    }
}
