package cn.dayTest.year_2021.tree.simple.month_03.day_01.sortedArrayToBST;

public class Solution {
    //最小高度
    public TreeNode sortedArrayToBST (int[] nums) {
        return dfs(nums,0,nums.length-1);
    }
    public TreeNode dfs (int[] nums, int left, int right) {
        if (right<left) return null;
        int cha=(right+left)/2;
        TreeNode treeNode=new TreeNode(nums[cha]);
        treeNode.left=dfs(nums,left,cha-1);
        treeNode.right=dfs(nums,cha+1,right);
        return treeNode;
    }
}
