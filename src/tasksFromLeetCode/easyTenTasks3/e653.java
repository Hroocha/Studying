package tasksFromLeetCode.easyTenTasks3;

import java.util.ArrayList;

public class e653 {
    /* 653. Two Sum IV - Input is a BST */

    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean answer = false;
        arrayCreator(arr, root);
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i != j && arr.get(i) + arr.get(j) == k) {
                    answer = true;
                    break;
                }
            }
            if (answer) {
                break;
            }
        }
        return answer;
    }
    private void arrayCreator(ArrayList<Integer> arr, TreeNode root) {
        if (root != null) {
            arr.add(root.val);
            arrayCreator(arr, root.left);
            arrayCreator(arr, root.right);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
