package cn.dayTest.year_2021.tree.simple.month_07.day_04.isSymmetric;

import java.util.LinkedList;
import java.util.Queue;

/*
 *   question: 给定一个二叉树，检查它是否是镜像对称的。
 * */
public class Demo {

    public static void main(String[] args) {

    }
}

/*
 *   answer1: 递归
 * */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

/*
 *   answer2: 迭代
 * */
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        Queue<TreeNode> lefts = new LinkedList<>();
        Queue<TreeNode> rights = new LinkedList<>();
        lefts.offer(root.left);
        rights.offer(root.right);
        while (!lefts.isEmpty() && !rights.isEmpty()) {
            TreeNode left = lefts.poll();
            TreeNode right = rights.poll();
            if (left.val != right.val) return false;
            if (left.left == null ^ right.right == null) return false;
            if (left.right == null ^ right.left == null) return false;
            if (left.left != null) {
                lefts.offer(left.left);
                rights.offer(right.right);
            }
            if (left.right != null) {
                lefts.offer(left.right);
                rights.offer(right.left);
            }
        }
        return lefts.isEmpty() && rights.isEmpty();
    }
}



