package cn.dayTest.year_2021.tree.simple.month_07.day_14.hasPathSum;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  question: 二叉树路径总和
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *  answer1: 递归
 *  step: root targetSum-root.val
 * */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root.left != null || root.right != null) {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        } else if (root != null && targetSum - root.val == 0) {
            return true;
        }
        return false;
    }
}

/*
*  answer2: 迭代
* */
class Solution2{
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) return false;
        Queue<TreeNode> treeNodes=new LinkedList<>();
        Queue<Integer>  integers=new LinkedList<>();
        treeNodes.offer(root);
        integers.offer(root.val);
        while (!treeNodes.isEmpty()){

        }
        return false;
    }
}








