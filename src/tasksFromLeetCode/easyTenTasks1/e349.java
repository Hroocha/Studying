package tasksFromLeetCode.easyTenTasks1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class e349 {
    /* 349. Intersection of Two Arrays*/

    public static void main(String[] args) {
        int[] nums = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums, nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);

        int [] answer = new int[set1.size()];
        Object [] s = set1.toArray();
        for (int i = 0; i < s.length; i++) {
            answer[i] = (int) s[i];
        }

        return answer;
    }
}
