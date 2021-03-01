package cn.dayTest.year_2021.tree.simple.month_02.day_26.minDiffInBST;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //二叉搜索树，中序遍历既是由小到大
    Integer min , prev;
    public int minDiffInBST(TreeNode root) {
        int min=Integer.MAX_VALUE;
        prev=null;
        bianli(root);
        return min;
    }

    public void bianli(TreeNode root){
        if (root==null) return;
        bianli(root.left);
        if (prev!=null){
            min=Math.min(min, root.val-prev );
        }
        prev=root.val;
        bianli(root.right);

    }
}
