package cn.dayTest.year_2021.tree.simple.month_01.day_29.symmetricTree;


public class Demo {
    public static void main (String[] args) {
        System.out.println(false||false);
    }
}

class Solution{
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return  digui(left,right);
    }

    boolean digui(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }else if (left==null||right==null){
            return false;
        }else if (left.val!=right.val){
            return false;
        }else {
            return digui(left.left, right.right) && digui(left.right, right.left);
        }
    }
}

class Solution2{
    public boolean isSymmetric(TreeNode root) {
        return false;
    }
}