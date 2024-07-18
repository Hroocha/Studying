package tasksFromLeetCode.easyTenTasks2;

public class e2331 {
    /*2331. Evaluate Boolean Binary Tree */

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
    public static void comparator(TreeNode root){
        if (root.left != null && root.right != null &&
                (root.left.val == 0 || root.left.val == 1) &&
                (root.right.val == 0 || root.right.val == 1)){
            if(root.val == 2){
                root.val = root.left.val | root.right.val;
            } else if (root.val == 3) {
                root.val = root.left.val & root.right.val;
            }
        }
    }
    public void passAndCalculateTree(TreeNode root){
        if (root != null) {
            evaluateTree(root.left);
            comparator(root);
            evaluateTree(root.right);
            comparator(root);

        }
    }

    public boolean evaluateTree(TreeNode root) {
        if (root != null){
            passAndCalculateTree(root);
            return root.val != 0;
        } else return false;
    }
}

