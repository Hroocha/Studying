package tasksFromLeetCode.easyTenTasks5;

public class e2520 {
    /* 2520. Count the Digits That Divide a Number*/

    public static void main(String[] args) {
        System.out.println(countDigits(564));
    }

    public static int countDigits(int num) {
        int counter = 0;
        String n = String.valueOf(num);
        char[] chars = n.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (num % Character.getNumericValue(chars[i]) == 0){
                counter++;
            }
        }
        return counter;
    }
}
