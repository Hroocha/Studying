package tasksFromLeetCode.easyTenTasks4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class e2511 {
    /* 2511. Maximum Enemy Forts That Can Be Captured */
    public static void main(String[] args) {
        int [] forts = {1,0,0,-1,0,0,0,0,1};
        System.out.println(captureForts(forts));
    }
    public static int captureForts(int[] forts) {
        if (forts.length < 3) {
            return 0;
        }
        List<Integer> listCap = new ArrayList<>();
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                for (int j = i + 1; j < forts.length; j++) {
                    if (forts[j] == 1) {
                        break;
                    } else if (forts[j] == -1) {
                        listCap.add(j - i - 1);
                        break;
                    }
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (forts[j] == 1) {
                        break;
                    } else if (forts[j] == -1) {
                        listCap.add(i - j - 1);
                        break;
                    }
                }

            }
        }
        Optional<Integer> maxElement = listCap.stream()
                .max(Comparator.naturalOrder());
        return maxElement.orElse(0);
    }

//
//            if (forts[i] == 0) {
//                countEn++;
//            } else if (forts[i] == -1) {
//                if (hasOne) {
//                    listCap.add(countEn);
//                } else {
//                    countEn = 0;
//                }
//                isEmpty = true;
//            } else {
//                hasOne = true;
//                if (isEmpty) {
//                    listCap.add(countEn);
//                    countEn = 0;
//                } else {
//                    countEn = 0;
//                }
//            }
//        }


}
