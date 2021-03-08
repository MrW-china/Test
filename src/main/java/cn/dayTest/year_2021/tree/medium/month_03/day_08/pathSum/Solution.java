package cn.dayTest.year_2021.tree.medium.month_03.day_08.pathSum;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> lists =new LinkedList<>();
    LinkedList<Integer> list =new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return lists;
    }

    public void dfs(TreeNode root ,int sum ){
        if (root==null) return;
        int val = root.val;
        list.add(val);
        if (sum-val==0&&root.left==null&&root.right==null){
            lists.add(new LinkedList<>(list));
        }
        dfs(root.left,sum-val);
        dfs(root.right,sum-val);
        list.removeLast();
    }
}
