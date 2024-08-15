package tasksFromLeetCode.easyTenTasks6;

public class e1816 {
    public static void main(String[] args) {

        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s,4));
    }

    public static String truncateSentence(String s, int k) {
        String [] str = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < k) {
            stringBuilder.append(str[i++]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return String.valueOf(stringBuilder);
    }
}
