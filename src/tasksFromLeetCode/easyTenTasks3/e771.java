package tasksFromLeetCode.easyTenTasks3;

public class e771 {
    /* 771. Jewels and Stones*/

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels,stones));
    }
    public static int numJewelsInStones(String jewels, String stones) {
        int sum = 0;
        char[] st = stones.toCharArray();
        char[] jw = jewels.toCharArray();
        for (int i = 0; i < st.length; i++) {
            for (int j = 0; j < jw.length; j++) {
                if (st[i] == jw[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
