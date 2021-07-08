package cn.dayTest.year_2021.tree.medium.month_07.day_08.buildTree;

import java.util.*;

/*
 *   question: 根据一棵树的前序遍历与中序遍历构造二叉树。
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *   answer1: 递归
 *   step1: 在中序遍历中找到根节点，就可以知道该节点的左子树和右子树节点有哪些。
 *   step2: 通过确定前序以及中序的遍历边界来获取根节点以及左右节点。
 * */
class Solution {
    //
    private Map<Integer, Integer> indexMap;

    //p 前序  i 中序
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        //根节点值为前序遍历第一个值
        int preorder_root=preorder_left;
        //中序遍历中定位根节点
        int inorder_root= indexMap.get(preorder[preorder_root]);
        //建立根节点
        TreeNode root= new TreeNode(preorder[preorder_root]);
        //确定左子树节点数量
        int left_size_subtree= inorder_root-inorder_left;
        //构建左子树
        root.left=myBuildTree(preorder,inorder,preorder_left+1,preorder_left+left_size_subtree,inorder_left,inorder_root-1);
        //构建右子树
        root.right=myBuildTree(preorder,inorder,preorder_left+left_size_subtree+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        //构建哈希映射，可以快速定位根节点
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}

/*
*   answer2: 迭代
*   step1: 前序遍历中的任意两个连续节点u和v，根据前序遍历流程，u和v只可能有两种关系:
*     ① v是u的左儿子
*     ② u没有左儿子，v是u或者u的某个祖先节点的右儿子。
* */
class Solution2{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }
}



