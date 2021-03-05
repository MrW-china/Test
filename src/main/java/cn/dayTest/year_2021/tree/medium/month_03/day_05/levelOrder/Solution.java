package cn.dayTest.year_2021.tree.medium.month_03.day_05.levelOrder;

import java.util.*;

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root==null) return null;
        List<Integer> list =new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
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
        }

        return dfs(list);
    }

    public int[] dfs(List<Integer> list){
        int size = list.size();
        int[] a=new int[size];
        for (int i = 0; i < size; i++) {
            a[i]=list.get(i);
        }
        return a;
    }
}
