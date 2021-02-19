package cn.dayTest.year_2021.tree.simple.month_02.day_19.searchBST;

public class Solution {
//    public TreeNode searchBST (TreeNode root, int val) {
//        if (root == null || root.val == val) return root;
//        return root.val>val?searchBST(root.left,val):searchBST(root.right,val);
//    }

    public TreeNode searchBST (TreeNode root, int val) {
        while (true) {
            if (root == null || root.val == val) return root;
            root = root.val > val ? root.left : root.right;
        }
    }
}
