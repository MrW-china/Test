package cn.dayTest.year_2021.tree.simple.month_02.day_04.isUnivalTree;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main (String[] args) {

    }
}


class Solution {
    public boolean isUnivalTree (TreeNode root) {
        return digui(root, root.val);
    }

    public boolean digui (TreeNode root, int i) {
        if (root == null) return true;
        if (root.val != i) return false;
        return digui(root.left, i) && digui(root.right, i);
    }
}

class Solution2 {
    List<Integer> list;

    public boolean isUnivalTree (TreeNode root) {
        list = new ArrayList<>();
        add(root);
        for (int i:list){
            if (i!=list.get(0)) return false;
        }
        return true;
    }

    public void add (TreeNode root) {
        if (root != null) {
            list.add(root.val);
            add(root.left);
            add(root.right);
        }
    }

}
