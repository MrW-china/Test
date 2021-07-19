package cn.dayTest.year_2021.tree.medium.month_07.day_19.pathSum;

import java.util.*;

/*
 *  question: 路径总和 II
 *  step: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *  answer1: 深度优先搜索
 * */
class Solution {
    Deque<Integer> list = new LinkedList<>();
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum);
        return lists;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        list.offerLast(root.val);
        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
            lists.add(new LinkedList<Integer>(list));
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        list.pollLast();
    }
}