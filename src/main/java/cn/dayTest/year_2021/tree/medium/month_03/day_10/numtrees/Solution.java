package cn.dayTest.year_2021.tree.medium.month_03.day_10.numtrees;

public class Solution {
    public static void main (String[] args) {
        numTrees(4);
    }


    /*    public static int numTrees (int n) {
            if (n <= 1) return 1;
            int i = n;
            int sum =0;
            for (int j = 0; j < n; j++) {
                int a =numTrees(j);
                int b=numTrees(n-j-1);
                sum+= numTrees(j) * numTrees(n - j - 1);
            }
            return sum;
        }*/
    public static int numTrees (int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                num[i] += num[j] * num[i - j - 1];
            }
        }
        return num[n];
    }
}
