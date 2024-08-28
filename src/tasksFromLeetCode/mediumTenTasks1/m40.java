package tasksFromLeetCode.mediumTenTasks1;

import java.util.*;

public class m40 {

    public static void main(String[] args) {
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

//        int[] candidates = {4, 4};
        int target = 30;
        System.out.println(combinationSum2(candidates, target));
    }


    public static void solve(int[] candidates, int target,int idx, List<Integer> temp, List<List<Integer>> res, int sum) {
        if (idx > candidates.length || sum > target) {
            return;
        }
        if(sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j = idx; j < candidates.length; j++) {
            if (j > idx && candidates[j] == candidates[j-1]) continue;
            temp.add(candidates[j]);
            solve(candidates, target, j+1, temp, res, sum+candidates[j]);
            temp.remove(temp.size()-1);
        }

        return;
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<>(), res, 0);
        return res;
    }

//    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> combinations = new ArrayList<>();
//
//        if (candidates.length == 1) {
//            if (candidates[0] == target) {
//                ArrayList<Integer> subList = new ArrayList<>();
//                subList.add(candidates[0]);
//                combinations.add(subList);
//            }
//            return combinations;
//        }
//
//        Map<Integer,Integer> numbersQuantity = new HashMap<>();
//        for (int i = 0; i < candidates.length; i++) {
//            numbersQuantity.merge(candidates[i], 1, Integer::sum);
//        }
//        Set<Integer> key = numbersQuantity.keySet();
//        if(key.size() == 1){
//            int num = (Integer) key.toArray()[0];
//            if (num * numbersQuantity.get(num) > target){
//                ArrayList<Integer> subList = new ArrayList<>();
//                int var = target;
//                while (var > 0 || var != 0) {
//                    subList.add(num);
//                    var -= num;
//                }
//                if(var == 0) {
//                    combinations.add(subList);
//                }
//                return combinations;
//            }
//        }
//
//        candidates = Arrays.stream(candidates).sorted().toArray();
//
//        int counter = 0;
//        int index = 0;
//        ArrayList<Integer> subList = new ArrayList<>();
//        finder(candidates,index,target,counter,combinations,subList);
//
//        return combinations.stream().distinct().toList();
//    }
//
//    public static void finder(int[] candidates, int index, int target, int counter, List<List<Integer>> combinations, ArrayList<Integer> subList) {
//
//        for (int i = index; i < candidates.length; i++) {
//            int curCandidate = candidates[i];
//            if (counter + curCandidate < target) {
//                counter += curCandidate;
//                subList.add(curCandidate);
//                finder(candidates, i + 1, target, counter, combinations, subList);
//                subList.remove(subList.size() - 1);
//                counter -= curCandidate;
//            } else if (counter + curCandidate == target) {
//                counter += curCandidate;
//                subList.add(curCandidate);
//                combinations.add(new ArrayList<>(List.copyOf(subList)));
//                subList.remove(subList.size() - 1);
//                counter -= curCandidate;
//                finder(candidates, i + 1, target, counter, combinations, subList);
//            }
//        }
//    }
}
