package tasksFromLeetCode.easyTenTasks1;

public class e28 {
    /* 28. Find the Index of the First Occurrence in a String */

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }
//    public static int strStr(String haystack, String needle) {
//        if(needle.length() > haystack.length()){
//            return -1;
//        }
//        int index = -1;
//        int matches = 0;
//        for (int i = 0; i < haystack.length(); i++) {
//            if (haystack.charAt(i) == needle.charAt(0)){
//                matches++;
//                index = i;
//                int y = i;
//                for (int j = 1; j < needle.length(); j++) {
//                    if(y+1 < haystack.length() && needle.charAt(j) == haystack.charAt(++y)){
//                        matches++;
//                    } else {
//                        index = -1;
//                        matches = 0;
//                        break;
//                    }
//                }
//                if (matches == needle.length()){
//                    return index;
//                }
//            }
//
//        }
//        return index;
//    }
}
