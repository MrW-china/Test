package cn.dayTest.year_2021.tree.simple.month_02.day_04.findTarget;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main (String[] args) {

    }
}


class Solution{
    Map<Integer,Integer> map;
    public boolean findTarget(TreeNode root, int k) {
        map=new HashMap<>();
        add(root);
        Set<Integer> set = map.keySet();
        for (int i:set){
            if((k-i)==i){
                if(map.get(i)>1) return true;
                continue;
            }
            if (map.containsKey(k-i)) return true;
        }
        return false;
    }
    public void add(TreeNode root){
        if (root!=null){ map.put(root.val,map.getOrDefault(root.val, 0) + 1);
            add(root.left);
            add(root.right);
        }
    }
}