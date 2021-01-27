package cn.dayTest.year_2021.month_01.day_20_yes;

import java.util.Arrays;

public class Demo {
    public static void main (String[] args) {

    }
}

class Solution{
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int sum=1;
        int length=nums.length;
        if (nums[length-1]<0){
            sum=sum*nums[0]*nums[1]*nums[2];
        }else if (nums[3]<0){
            sum=sum*nums[0]*nums[length-1]*nums[length-2];
        }else {
            sum=sum*nums[length-3]*nums[length-1]*nums[length-2];
        }
        return sum;
    }
}