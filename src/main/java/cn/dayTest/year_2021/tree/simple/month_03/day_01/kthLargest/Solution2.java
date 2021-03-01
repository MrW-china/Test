package cn.dayTest.year_2021.tree.simple.month_03.day_01.kthLargest;

public class Solution2 {
    int num;
    int numMax;
    public int kthLargest (TreeNode root, int k) {
        num = k;
        return 0;
    }

    public void dfs (TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (num==0) return;
        if (--num==0) numMax=root.val;
        dfs(root.left);
    }
}
