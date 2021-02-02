package cn.dayTest.year_2021.tree.simple.month_02.day_02.printUp;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main (String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        Queue<Integer> queue1=new LinkedList<>();

        queue1.offer(1);
        queue=queue1;
        queue1=null;
        System.out.println(queue);
        queue1.offer(2);
        System.out.println(queue1);
    }
}
