package cn.dayTest.year_2021.tree.medium.month_03.day_03.buildTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode ( ) {

    }

    TreeNode (int val) {
        this.val = val;
    }

    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
