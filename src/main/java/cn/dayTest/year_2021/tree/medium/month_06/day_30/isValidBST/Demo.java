package cn.dayTest.year_2021.tree.medium.month_06.day_30.isValidBST;

import java.util.Deque;
import java.util.LinkedList;

/*
 *   question: 给定一个二叉树，判断其是否是一个有效的二叉搜索树.
 *
 *
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *   answer1: 递归
 *   step: 访问左右子树时，将边界值一并传入，判断左右子树是否满足二叉搜索树的性质条件
 * */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val > max || root.val < min) return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}

/*
 *   answer: 中序遍历
 *   step1: 二叉搜索树中序遍历得到的值是一个递增的数组。
 *   step2: 二叉树中序遍历的三种方式（递归、迭代、morris算法）。
 * */
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inordr = Double.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inordr) return false;
            inordr = root.val;
            root = root.right;
        }
        return true;
    }
}

