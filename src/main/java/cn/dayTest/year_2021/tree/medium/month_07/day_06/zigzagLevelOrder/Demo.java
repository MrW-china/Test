package cn.dayTest.year_2021.tree.medium.month_07.day_06.zigzagLevelOrder;


import java.util.*;

/*
 *   question: 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * */
public class Demo {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Collections.reverse(list);
    }
}

/*
 *   answer: 迭代
 * */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(poll.val);
                }
                if (!isOrderLeft) {
                    levelList.offerFirst(poll.val);
                }
                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
            lists.add(new LinkedList<Integer>(levelList));
            isOrderLeft=!isOrderLeft;
        }

        return lists;
    }
}