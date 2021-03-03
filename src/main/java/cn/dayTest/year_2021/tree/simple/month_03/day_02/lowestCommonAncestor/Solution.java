package cn.dayTest.year_2021.tree.simple.month_03.day_02.lowestCommonAncestor;

public class Solution {
    //最近的公共祖先
    TreeNode ans;
    public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public TreeNode dfs (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (root == p || root == q) {
            if (left == null && right == null) return root;
            else ans = root;
        }
        if (left != null && right != null) ans = root;
        if (left!=null||right!=null) return left==null?right:left;
        return null;
    }
}