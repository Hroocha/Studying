package tasksFromLeetCode.easyTenTasks4;

public class e58 {
    /*  58. Length of Last Word */

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        char[] charText = s.toCharArray();
        int count = 0;
        int length = charText.length - 1;
        int findSpacesBefore = 1;
        for (int i = length; i != -1; i--) {
            if (charText[i] == ' ') {
                findSpacesBefore++;
            } else break;
        }
        for (int i = charText.length - findSpacesBefore; i != -1; i--) {
            if (charText[i] == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }

}
