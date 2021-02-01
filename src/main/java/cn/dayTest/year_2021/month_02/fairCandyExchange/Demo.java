package cn.dayTest.year_2021.month_02.fairCandyExchange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main (String[] args) {

    }
}


class Solution {
    public int[] fairCandySwap (int[] a, int[] b) {
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        int[] result=new int[2];
        if ((sumA-sumB)%2!=0) return result;
        int delta=(sumA-sumB)/2;
        Set<Integer> set =new HashSet<>();
        for (int i :a){
            set.add(i);
        }
        for (int i :b){
            if (set.contains(delta+i)){
                result[0]=delta+i;
                result[1]=i;
                break;
            }
        }
        return result;
    }
}