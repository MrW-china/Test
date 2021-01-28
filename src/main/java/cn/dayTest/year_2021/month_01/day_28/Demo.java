package cn.dayTest.year_2021.month_01.day_28;

import java.util.Arrays;

public class Demo {
    public static void main (String[] args) {

    }
}
class Solution{
    public int pivotIndex(int[] nums) {
        int sum=0;
        int length=nums.length;
//        for (int i = 0; i < length; i++) {
//            sum+=nums[i];
//        }
        for (int i:nums){
            sum+=i;
        }
        int before=0;
        for (int i = 0; i < length; i++) {
            if (sum-nums[i]==before*2) return i;
            before+=nums[i];
        }
        return -1;
    }
}