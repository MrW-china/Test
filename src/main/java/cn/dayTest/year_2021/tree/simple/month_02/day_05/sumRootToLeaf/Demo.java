package cn.dayTest.year_2021.tree.simple.month_02.day_05.sumRootToLeaf;

public class Demo {
    public static void main (String[] args) {

    }
}

class Solution {
    public int sumRootToLeaf (TreeNode root) {

        return digui(root, 0);
    }

    public int digui (TreeNode root, int num) {
//        if (root==null){
//            return num;
//        }else {
//            num *= 2;
//            num += root.val;
//            return digui(root.left, num) + digui(root.right, num);
//        }
        if (root == null) return num;
        num *= 2;
        num += root.val;
        if (root.left!=null&&root.right!=null){
            return digui(root.left, num) + digui(root.right, num);
        }
        return Math.max(digui(root.left, num),digui(root.right, num));
    }
}