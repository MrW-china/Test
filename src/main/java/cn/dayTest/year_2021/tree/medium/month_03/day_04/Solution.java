package cn.dayTest.year_2021.tree.medium.month_03.day_04;


public class Solution {
    public boolean isSubStructure (TreeNode A, TreeNode B) {
        //终结条件，题目上指出了空树不是任意树的子结构
        if (A==null||B==null){
            return false;
        }

        return dfs(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    public boolean dfs (TreeNode p, TreeNode q) {
        //q遍历完成，没有触发不符合子结构的判断语句，便是成功
        if (q==null){
            return true;
        }
        //q存在值，而p为空说明p不包含所有q的结构
        if (p==null){
            return false;
        }
        //值不同，返回失败
        if (p.val!=q.val){
            return false;
        }
        //结点值相同，继续访问左右子树
        return dfs(p.left,q.left)&&dfs(p.right,q.right);
    }
}
