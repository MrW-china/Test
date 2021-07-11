package cn.dayTest.year_2021.tree.simple.month_07.day_11.sortedArrayToBST;

/*
 *   question: 将有序数组转换为二叉搜索树.
 *   step: 给定一个升序排列的整数数组，将其转换为一棵高度平衡二叉搜索树
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int index = (left + right) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = dfs(nums, left, index - 1);
        root.right = dfs(nums, index + 1, right);
        return root;
    }
}