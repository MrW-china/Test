package cn.dayTest.year_2021.sort.month_04.day_29.sortByBits;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByBits {
    public static void main (String[] args) {
        int i=3;
        System.out.println(i>>1+(i&1));
    }
}

class Solution {
    public int[] sortByBits (int[] arr) {
        //最大数10000，最小0
        int[] bit = new int[10001];
        /*将数组中的数赋值到list集合之中，
        且将二进制中‘1’的个数保存到相应位置的bit数组之中
        */
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare (Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                }
                return x - y;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    //计算数二进制中有几个'1';
    public int get (int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }
}

class Solution2 {
    public int[] sortByBits (int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }
        int[] bit = new int[10001];
        for (int i = 1; i <= 10000; i++) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare (Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                }
                return x - y;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}


