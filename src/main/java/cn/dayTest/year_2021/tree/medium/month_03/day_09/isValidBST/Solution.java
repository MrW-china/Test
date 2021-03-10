package cn.dayTest.year_2021.tree.medium.month_03.day_09.isValidBST;

public class Solution {

    public static void main (String[] args) {
        int maxValue = Integer.MAX_VALUE;
        long nmsl = Long.MAX_VALUE;
        System.out.println(nmsl);
    }
    public boolean isValidBST (TreeNode root) {
//        if (root.left != null && root.left.val >= root.val) return false;
//        if (root.right != null && root.right.val <= root.val) return false;
//        return dfs(root.left, root.val) && dfs(root.right, root.val);
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        return false;
    }

    public boolean dfs (TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);

    }
}
