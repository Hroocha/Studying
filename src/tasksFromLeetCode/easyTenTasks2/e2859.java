package tasksFromLeetCode.easyTenTasks2;

import java.util.ArrayList;
import java.util.List;

public class e2859 {
    /*2859. Sum of Values at Indices With K Set Bits*/

    public static void main(String[] args) {
        List <Integer> nums = List.of(5, 10, 1, 5, 2);
        int k = 1;
        System.out.println(sumIndicesWithKSetBits(nums,k));
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result = 0;
        List<String> nd = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int count = 0;
            nd.add(Integer.toBinaryString(i));
            for (char c : String.valueOf(nd.get(i)).toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            if (count == k) {
                result += nums.get(i);
            }
        }
        return result;
    }
}
