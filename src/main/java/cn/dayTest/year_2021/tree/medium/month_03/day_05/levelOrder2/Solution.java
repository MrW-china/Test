package cn.dayTest.year_2021.tree.medium.month_03.day_05.levelOrder2;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root==null) return lists;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        int num=1;
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left!=null) {
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            if (num%2==0){
                Collections.reverse(list);
            }
            lists.add(list);
            num++;
        }


        return lists;
    }
}
