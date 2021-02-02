package cn.dayTest.year_2021.tree.simple.month_02.day_02.printUp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo {
    public static void main (String[] args) {

    }
}

class Solution {
    public List<List<Integer>> levelOrder (TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> p = new LinkedList<>();
        //Queue<TreeNode> q = new LinkedList<>();
        p.offer(root);
        //q.offer(root);
        while (!p.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            while (!p.isEmpty()) {
                TreeNode poll = p.poll();
                //q.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
            p = q;
            lists.add(list);
        }
        return lists;
    }

}

class Solution2 {
    public List<List<Integer>> levelOrder (TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> p = new LinkedList<>();
        p.offer(root);
        while (!p.isEmpty()){
            int length = p.size();
            List<Integer> list = new ArrayList<>();
            for (int i = length; i >0; i--) {
                TreeNode poll = p.poll();
                list.add(poll.val);
                if (poll.left!=null) p.offer(poll.left);
                if (poll.right!=null) p.offer(poll.right);
            }
            lists.add(list);
        }
        return lists;
    }
}