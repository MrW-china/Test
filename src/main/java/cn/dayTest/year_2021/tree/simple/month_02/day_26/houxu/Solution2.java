package cn.dayTest.year_2021.tree.simple.month_02.day_26.houxu;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list=new LinkedList<>();
        LinkedList<Node> nodeLinkedList=new LinkedList<>();
        if (root==null) return list;
        nodeLinkedList.add(root);
        while(!nodeLinkedList.isEmpty()){
            Node node = nodeLinkedList.pollLast();
            list.addFirst(node.val);
            for (Node child:node.children){
                nodeLinkedList.add(child);
            }
        }

        return list;
    }

}
