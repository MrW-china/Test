package cn.dayTest.year_2021.tree.simple.month_02.day_25.qianxu;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list=new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root==null) return list;
        list.add(root.val);
        for (Node child:root.children){
            preorder(child);
        }
        return list;
    }
}
