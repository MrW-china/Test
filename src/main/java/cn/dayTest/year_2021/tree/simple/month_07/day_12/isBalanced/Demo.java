package cn.dayTest.year_2021.tree.simple.month_07.day_12.isBalanced;

/*
 *  question: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *  answer1: 自顶向下递归
 * */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}

/*
 *  answer2: 自底向上递归。
 * */
class Solution2 {
    public boolean isBalanced(TreeNode root) {
        return height(root)>=0;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight==-1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}