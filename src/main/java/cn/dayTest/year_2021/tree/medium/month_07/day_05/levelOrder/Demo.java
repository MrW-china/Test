package cn.dayTest.year_2021.tree.medium.month_07.day_05.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *   question: 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * */
public class Demo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        solution.levelOrder(root);
    }
}

/*
 *   answer1: 迭代
 * */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue1.offer(root);
        // 只有一个队列为空
        while (queue1.isEmpty() ^ queue2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode treeNode = queue1.poll();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue2.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue2.offer(treeNode.right);
                    }
                }
                lists.add(list);
            }
            if (!list.isEmpty()) continue;
            while (!queue2.isEmpty()) {
                TreeNode treeNode = queue2.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue1.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue1.offer(treeNode.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}

/*
 *   answer2: 迭代2
 * */
class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            lists.add(list);
        }
        return lists;
    }
}


