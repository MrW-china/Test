package cn.dayTest.year_2021.tree.medium.month_07.day_09.buildTree;

import java.util.HashMap;
import java.util.Map;

/*
 *  question:根据一棵树的中序遍历与后序遍历构造二叉树。
 **/
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *  answer1:
 * */
class Solution {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map=new HashMap<Integer,Integer>();

    public TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) return null;
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        post_idx--;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        post_idx = postorder.length - 1;
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }
}