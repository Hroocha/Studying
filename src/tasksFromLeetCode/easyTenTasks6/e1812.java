package tasksFromLeetCode.easyTenTasks6;

public class e1812 {
    public static void main(String[] args) {
        System.out.println(squareIsWhite("h3"));
    }

    public static boolean squareIsWhite(String coordinates) {
        boolean answer = true;
        int num1 = Math.abs(97 - coordinates.charAt(0));
        int num2 = Integer.parseInt(String.valueOf(coordinates.charAt(1))) + num1;
        while (num2 != 0){
            num2--;
            answer = !answer;
        }
        return answer;
    }
}
