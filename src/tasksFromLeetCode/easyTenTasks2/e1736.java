package tasksFromLeetCode.easyTenTasks2;

public class e1736 {
    /*1736. Latest Time by Replacing Hidden Digits*/

    public static void main(String[] args) {
        System.out.println(maximumTime("?0:15"));
    }
    public static String maximumTime(String time) {
        char[] arr = time.toCharArray();
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '?') {
                if (i == 0) {
                    if (arr[i + 1] != '?') {
                        String x = String.valueOf(arr[i + 1]);
                        int y = Integer.parseInt(x);
                        if (y > 3) {
                            arr[i] = '1';
                        }else {
                            arr[i] = '2';
                        }
                    } else {
                        arr[i] = '2';
                    }
                } else if (i == 1) {
                    if (arr[i - 1] == '2') {
                        arr[i] = '3';
                    } else {
                        arr[i] = '9';
                    }
                } else if (i == 3) {
                    arr[i] = '5';
                } else if (i == 4) {
                    arr[i] = '9';
                }
            }
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}
