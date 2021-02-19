package cn.dayTest.year_2021.tree.simple.month_02.day_07.isSubtree;

public class Solution {
    public boolean isSametree(TreeNode s, TreeNode t){
        if (s==null&&t==null) {
            return true;
        }
        if (s==null||t==null){
            return false;
        }
        if (s.val!=t.val){
            return false;
        }

        return isSametree(s.left,t.left)&&isSametree(s.right,t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null){
            return false;
        }
        return isSametree(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }
}

/*
*
* class Solution {
        // 这个就是LeetCode100 题的那个函数
        public boolean isSameTree(TreeNode s,TreeNode t){
            // 同时为空 说明树一起到底，两树相同
            if (s==null && t == null){
                return true;
            }
            // 如果上面没有返回值，说明必有一个没有为空（有可能两个都不为空）
            if (s == null || t == null){
                return false;
            }
            // 如果判断到了这一步，说明两个都不为空
            // 先序遍历 自己--左 -- 右
            if (s.val != t.val){
                return false;
            }
            return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
        }
        public boolean isSubtree(TreeNode s, TreeNode t) {
            // 我s都遍历完了。你居然还没匹配上。那就返回false
            if (s==null){
                return false;
            }
            // 短路运算符，有一个为真，返回真
            return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
        }
    }*/