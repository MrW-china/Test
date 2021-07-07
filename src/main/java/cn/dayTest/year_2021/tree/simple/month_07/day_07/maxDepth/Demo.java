package cn.dayTest.year_2021.tree.simple.month_07.day_07.maxDepth;

import java.util.LinkedList;
import java.util.Queue;

/*
*   question: 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
* */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
*   answer1: 递归
* */
class Solution{
    public int maxDepth(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int num){
        if (root==null) return num;
        return Math.max(dfs(root.left,num+1),dfs(root.right,num+1));
    }
}

/*
*   answer: 迭代
* */
class Solution2{
    public int maxDepth(TreeNode root) {
        int num = 0;
        if (root==null) return num;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i<size;i++){
                TreeNode poll = queue.poll();
                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
            num++;
        }
        return num;
    }
}






