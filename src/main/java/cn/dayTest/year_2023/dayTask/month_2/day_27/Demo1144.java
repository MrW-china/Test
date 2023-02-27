package cn.dayTest.year_2023.dayTask.month_2.day_27;

public class Demo1144 {
    public static void main(String[] args) {
        int[] a=new int[]{2,7,10,9,8,9};
        int i = movesToMakeZigzag(a);
        System.out.println(i);
    }


    public static int movesToMakeZigzag(int[] nums) {
        int a=nums.length;
        if (nums.length==1){
            return 0;
        }
        int ji=0;
        int ou=0;
        for (int i=0;i<a;i++){
            if (nums.length==1) {
                return 0;
            }
            //偶数
            if (i%2==0){
                if (i-1>=0 && i+1< a){
                   ou+= Math.max(0,Math.max(nums[i]-nums[i-1]+1,nums[i]-nums[i+1]+1));
                }else if(i==0){
                    ou+= Math.max(0,nums[i]-nums[i+1]+1);
                }else {
                    ou+= Math.max(0,nums[i]-nums[i-1]+1);
                }
            }else {
                if (i-1>=0 && i+1< a){
                    ji+= Math.max(0,Math.max(nums[i]-nums[i-1]+1,nums[i]-nums[i+1]+1));
                }if(i+1 == nums.length){
                    ji+= Math.max(0,nums[i]-nums[i-1]+1);
                }
            }
        }
        return Math.min(ji,ou);
    }
}
