package cn.dayTest.year_2021.tree.simple.month_06.day_29.generateTrees;

import java.util.LinkedList;
import java.util.List;

/*
 *  Question: 给你一个整数n，请你生成并返回所有由 n个节点组成且节点值从1到n互不相同的不同二叉搜索树。可以按任意顺序返回答案。
 *  step1: 二叉搜索树根节点的值大于左子树上所有值，小于右子树上所有值，左右子树也是二叉搜索树。
 *
 *
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *   Title: 回溯法
 *   generateTrees(start, end)函数表示当前值的集合为|start,end|,返回序列|start,end|生成的所有可行的二叉搜索树。
 *   生成根节点之后拼接操作很简单: root.left=left; root.right=right; 之前属实想复杂了。
 * */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 枚举所有可行的根节点
        for (int i = start; i <= end; i++) {
            // 所有可能的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // 所有可能的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            // 左、右集合各选一个拼接到一起
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    // 建立树的根节点
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
/*
 *   Title: 递归
 *
 *
 * */

