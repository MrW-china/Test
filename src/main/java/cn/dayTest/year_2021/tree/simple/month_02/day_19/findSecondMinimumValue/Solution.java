package cn.dayTest.year_2021.tree.simple.month_02.day_19.findSecondMinimumValue;

public class Solution {
    int min;
    int two = -1;

    public int findSecondMinimumValue (TreeNode root) {
        min = root.val;
        digui(root.left);
        digui(root.right);
        return two;
    }

    public void digui (TreeNode treeNode) {
        if (treeNode == null) return;
        int num = treeNode.val;
        if (two == -1) {
            if (min>num){
                two =min;
                min=num;
            }
            if (min<num){
                two=num;
            }
        }else{
            if (num<min){
                two =min;
                min=num;
            }
            if (num>min&&num<two){
                two=num;
            }
        }
        digui(treeNode.left);
        digui(treeNode.right);
    }
}
