package cn.dayTest.year_2021.tree.simple.month_07.day_13.minDepth;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  question: 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *  answer1: 递归
 * */
class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int n) {
        if (root == null) return n;
        if (root.left == null ^ root.right == null) return Math.max(dfs(root.left, n + 1), dfs(root.right, n + 1));
        if (root.left == null && root.right == null) return n + 1;
        return Math.min(dfs(root.left,n+1),dfs(root.right, n+1));
    }
}

/*
*  answer2: 迭代
* */
class Solution2{
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        int height=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length =queue.size();
            for (int i=0;i<length;i++){
                TreeNode poll = queue.poll();
                if (poll.left==null&&poll.right==null) return height;
                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
            height++;
        }
        return height;
    }
}