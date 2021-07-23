package cn.dayTest.year_2021.tree.medium.month_07.day_21.connect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
*  question: 填充每个节点的下一个右侧节点指针
* */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
*  answer1: 自己想的迭代
* */
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        ArrayList<Node> list=new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()){
            int size = list.size();
            for (int i=1;i<size;i++){
                list.get(i-1).next=list.get(i);
            }
            list.get(size-1).next=null;
            for (int i=0;i<size;i++){
                Node node = list.get(0);
                if (node.left!=null) list.add(node.left);
                if (node.right!=null) list.add(node.right);
                list.remove(0);
            }
        }
        return root;
    }
}

/*
*  answer2: 标准迭代
* */
class Solution2{
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            for (int i=0;i<size;i++){
                Node poll = queue.poll();
                if (i<size-1){
                    poll.next=queue.peek();
                }
                if (poll.left!=null) queue.offer(poll.left);
                if (poll.right!=null) queue.offer(poll.right);
            }
        }
        return root;
    }
}

/*
*  answer3: 
* */


