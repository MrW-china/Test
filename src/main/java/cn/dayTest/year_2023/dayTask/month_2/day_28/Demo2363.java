package cn.dayTest.year_2023.dayTask.month_2.day_28;

import com.aliyuncs.utils.MapUtils;

import java.util.*;

public class Demo2363 {
    public static void main(String[] args) {

    }


}

class Solution {
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map=new HashMap();
        for (int i = 0; i < items1.length; i++) {
            int[] ints = items1[i];
            map.put(ints[0],ints[1]);
        }
        for (int i = 0; i < items2.length; i++) {
            int[] ints = items2[i];
            map.put(ints[0], map.getOrDefault(ints[0],0)+ints[1]);
        }
        List<List<Integer>> lists =new ArrayList<>();

        Set<Integer> integers = map.keySet();
        for (int a : integers) {
            List<Integer> list=new ArrayList<>();
            list.add(a);
            list.add(map.get(a));
            lists.add(list);
        }
        return lists;
    }
}