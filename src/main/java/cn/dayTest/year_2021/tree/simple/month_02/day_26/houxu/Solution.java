package cn.dayTest.year_2021.tree.simple.month_02.day_26.houxu;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root==null) return list;
        for (Node node:root.children){
            postorder(node);
        }
        list.add(root.val);
        return list;
    }
}
