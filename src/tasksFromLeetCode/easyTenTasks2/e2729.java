package tasksFromLeetCode.easyTenTasks2;

import java.util.ArrayList;
import java.util.List;

public class e2729 {
    /*2729. Check if The Number is Fascinating*/

    public static void main(String[] args) {
        System.out.println(isFascinating(192));
    }
    public static boolean isFascinating(int n) {
        List<Character> numbers = new ArrayList<>();
        numbers = List.of('1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> resultNumber = new ArrayList<>();
        StringBuilder num = new StringBuilder(n);
        num.append(n);
        num.append(n * 2);
        num.append(n * 3);
        if (num.length() != 9) {
            return false;
        }
        for (int i = 0; i < num.length(); i++) {
            resultNumber.add(num.charAt(i));
        }
        return resultNumber.containsAll(numbers);
    }
}
