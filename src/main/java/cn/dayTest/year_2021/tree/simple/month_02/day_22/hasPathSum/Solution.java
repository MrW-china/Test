package cn.dayTest.year_2021.tree.simple.month_02.day_22.hasPathSum;

public class Solution {
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root==null) return false;
        int i = sum - root.val;
        if (root.left==null&&root.right==null&&i==0) return true;
        if (root.left==null&&root.right==null) return false;
        return hasPathSum(root.left,i)||hasPathSum(root.right,i);
    }
}
