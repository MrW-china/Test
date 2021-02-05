package cn.dayTest.year_2021.tree.simple.month_02.day_05.sumOfLeftLeaves;

public class Demo {

}

class Solution {
    public int sumOfLeftLeaves (TreeNode root) {
        if (root==null) return 0;
        int sum=0;
        if (root.left!=null&&root.left.left==null&&root.left.right==null){
            sum=root.left.val;
        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+sum;
    }
}