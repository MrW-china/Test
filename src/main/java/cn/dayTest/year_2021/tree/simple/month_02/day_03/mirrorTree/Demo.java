package cn.dayTest.year_2021.tree.simple.month_02.day_03.mirrorTree;

public class Demo {
    public static void main (String[] args) {

    }
}
//镜像二叉树
class Solution{
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return root;
        TreeNode p=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(p);
        return root;
    }

    public TreeNode digui(TreeNode p){
        return null;
    }
}