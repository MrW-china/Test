package cn.dayTest.year_2021.tree.simple.month_03.day_01.kthLargest;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> arrayList=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return arrayList.get(k-1);
    }

    public void dfs(TreeNode root){
        if (root==null) return;
        dfs(root.right);
        arrayList.add(root.val);
        dfs(root.left);
    }
}
