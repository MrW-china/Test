package cn.dayTest.year_2021.tree.medium.month_03.day_03.buildTree;
// 输入某二叉树的前序遍历和中序遍历的结果，
// 请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree (int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode dfs (int[] preorder, int[] inorder, int p_left, int p_right, int i_left, int i_right) {
        if (p_left > p_right) {
            return null;
        }
        int preoder_root = p_left;
        int inorder_root = map.get(preorder[preoder_root]);
        TreeNode root = new TreeNode(preorder[preoder_root]);
        int num_left_tree = inorder_root - i_left;
        root.left = dfs(preorder, inorder, p_left + 1, p_left + num_left_tree, i_left, inorder_root - 1);
        root.right = dfs(preorder, inorder, p_left + num_left_tree + 1, p_right, inorder_root + 1, i_right);
        return root;
    }


    public TreeNode dfs2 (int[] p, int[] q, int p_left, int p_right, int i_left, int i_right) {
        if (p_left > p_right) return null;
        TreeNode root = new TreeNode(p[p_left]);
        int i_root = map.get(p[p_left]);
        int left_tree = i_root - i_left;
        root.left=dfs2(p, q, p_left + 1, p_left + left_tree, i_left, i_root - 1);
        root.right=dfs2(p, q, p_left + left_tree + 1, p_right, i_root + 1, i_right);
        return root;
    }
}
