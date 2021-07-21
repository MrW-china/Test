package cn.dayTest.year_2021.tree.medium.month_07.day_20.flatten;

import java.util.ArrayList;
import java.util.List;

/*
 *  question: 二叉树展开为链表
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *  answer1: 前序遍历递归
 *  step1: 给一个树root，转化为链表，root本身左右子树已经确定。
 *  step2: 链表与二叉树先序遍历顺序相同。
 * */
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        int size=list.size();
        for (int i=1;i<size;i++){
            TreeNode treeNode = list.get(i - 1);
            TreeNode treeNode1 = list.get(i);
            treeNode.left=null;
            treeNode.right=treeNode1;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}

