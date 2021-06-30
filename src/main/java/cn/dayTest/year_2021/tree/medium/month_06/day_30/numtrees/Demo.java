package cn.dayTest.year_2021.tree.medium.month_06.day_30.numtrees;

public class Demo {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.numTrees(3);
    }
}

/*
 *  question: 给你一个整数n，求恰由n个节点组成且节点值从1到n互不相同的二叉搜索树有多少种？返回满足题意的二叉搜索树的种数。(1<=n<=19)
 *  step1: 二叉搜索树根节点大于所有左子树的值，小于所有右子树的值，左右子树也是二叉搜索树。
 *  answer1: 动态规划
 *
 *
 * */
class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        // 根节点左子树有一个或没有值时，该子树只有一种排列
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }

        return nums[n];
    }
}
/*
*   answer2: 数学方式
* */
class Solution2{
    public int numTrees(int n){
        long c=1;
        for (int i=0;i<n;i++){
            c=c*2*(2*i+1)/(i+2);
        }
        return 0;
    }
}



