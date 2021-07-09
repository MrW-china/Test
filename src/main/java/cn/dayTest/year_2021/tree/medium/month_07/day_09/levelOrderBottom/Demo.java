package cn.dayTest.year_2021.tree.medium.month_07.day_09.levelOrderBottom;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.reverse(list);
        List<List<Integer>> lists=new ArrayList<>();
        System.out.println(list);
        lists.add(list);
        System.out.println(lists);
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                list.add(pop.val);
                if (pop.left != null) queue.offer(pop.left);
                if (pop.right != null) queue.offer(pop.right);
            }
            lists.add(list);
        }
        int len = lists.size();
        int num = 1;
        List<List<Integer>> listss = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            List<Integer> list = lists.get(i);
            if (num % 2 == 1) {
                listss.add(list);
            } else {
                Collections.reverse(list);
                listss.add(list);
            }
            num++;
        }

        return listss;
    }
}

class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
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
            lists.add(0, list);
        }


        return lists;
    }
}