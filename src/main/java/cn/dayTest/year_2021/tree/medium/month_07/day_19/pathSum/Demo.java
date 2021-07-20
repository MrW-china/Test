package cn.dayTest.year_2021.tree.medium.month_07.day_19.pathSum;

import java.util.*;

/*
 *  question: 路径总和 II
 *  step: 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * */
public class Demo {
    public static void main(String[] args) {
System.out.println(1);
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

/*
*  answer2: 广度优先搜索;
*  step:
* */
class Solution2{
    List<List<Integer>> lists=new LinkedList<List<Integer>>();
    Map<TreeNode,TreeNode> map=new HashMap<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null){
            return lists;
        }
        Queue<TreeNode> queueNode =new LinkedList<>();
        Queue<Integer> queueSum=new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);
        while(!queueNode.isEmpty()){
            TreeNode poll = queueNode.poll();
            int rec = queueSum.poll()+ poll.val;
            if (poll.left == null && poll.right == null) {
                if (rec==targetSum){
                    getPath(poll);
                }
            }else{
                if (poll.left != null) {
                    map.put(poll.left,poll);
                    queueNode.offer(poll.left);
                    queueSum.offer(rec);
                }
                if (poll.right != null) {
                    map.put(poll.right,poll);
                    queueNode.offer(poll.right);
                    queueSum.offer(rec);
                }
            }
        }
        return lists;
    }
    public void getPath(TreeNode node){
        List<Integer> tmp=new LinkedList<>();
        while (node!=null){
            tmp.add(node.val);
            node=map.get(node);
        }
        Collections.reverse(tmp);
        lists.add(new LinkedList<>(tmp));
    }
}