package tasks.lesson5;

import java.util.HashMap;

public class Task1 {

    public void magicWithHashMap() {
        String[] words = {"поле", "озеро", "река", "мяч", "время", "суп", "мышь", "поле", "суп", "вода"};

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                int newValue = map.get(words[i]) + 1;
                map.put(words[i], newValue);
            } else map.put(words[i], 0);
        }

        System.out.println(map);

    }

}
