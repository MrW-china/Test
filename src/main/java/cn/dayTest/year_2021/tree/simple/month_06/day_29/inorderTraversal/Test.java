package cn.dayTest.year_2021.tree.simple.month_06.day_29.inorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode treeNode = null;
        while (root!=null){
            if (root.left!=null){
                treeNode=root.left;
                while (treeNode.right!=null && treeNode.right!=root){
                    treeNode=treeNode.right;
                }
                if (treeNode.right==null){
                    treeNode.right=root;
                    root=root.left;
                }
                else {
                    list.add(root.val);
                    treeNode.right=null;
                    root=root.right;
                }

            }
            else {
                list.add(root.val);
                root=root.right;
            }
        }
        return list;
    }
}
