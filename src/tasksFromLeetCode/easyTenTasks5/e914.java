package tasksFromLeetCode.easyTenTasks5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e914 {
    /* 914. X of a Kind in a Deck of Cards*/

    public static void main(String[] args) {
        int[] desk = {0,0,0,1,1,1,1,1,1,2,2,2,3,3,3};
        System.out.println(hasGroupsSizeX(desk));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : deck) {
            map.merge(j, 1, Integer::sum);
        }
        int gcd = 0;
        for (int count : map.values()) {
            gcd = findGCD(gcd, count);
        }

        return gcd > 1;
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}













