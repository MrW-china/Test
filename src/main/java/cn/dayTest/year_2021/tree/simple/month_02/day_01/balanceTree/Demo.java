package cn.dayTest.year_2021.tree.simple.month_02.day_01.balanceTree;

public class Demo {
    public static void main (String[] args) {

    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        return digui(root)!=-1;
    }

    public int digui(TreeNode root){
        if (root==null) return 0;
        int left = digui(root.left);
        if (left==-1) return -1;
        int right=digui(root.right);
        if (right==-1) return -1;
        return Math.abs(left-right)<2? Math.max(left,right)+1:-1;
    }
}