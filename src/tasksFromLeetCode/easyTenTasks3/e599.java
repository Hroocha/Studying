package tasksFromLeetCode.easyTenTasks3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class e599 {
    /* 599. Minimum Index Sum of Two Lists */

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    hashmap.put(list1[i], i + j);
                }
            }
        }
        int win = hashmap.values().stream().sorted().findFirst().orElseThrow();
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            if (win == (entry.getValue())) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
