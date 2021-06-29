package cn.dayTest.year_2021.tree.simple.month_06.day_29.inorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        Solution3 solution3=new Solution3();
        List<Integer> list = solution3.inorderTraversal(root);
    }
}

// 递归
class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        this.inorderTraversal(root.left);
        list.add(root.val);
        this.inorderTraversal(root.right);
        return list;
    }
}

// 迭代
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        // 首先将父节点送入栈中，之后送入左子树，
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root); //栈里送入节点
                root = root.left;
            }
            root = stk.pop();  //栈里取出一个节点
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

// morris 中序遍历
/*
*  step1 若x无左子树，先将现节点的值加入数组，之后访问右子树。
*  step2.1 若x存在左子树，找到x左子树上最右的节点，记为predecessor，根据predecessor右子树是否为空，进行操作。
*  step2.2 若predecessor右子树为空，将其右子树指向x，然后访问x的左子树，即x=x.left。
*  step2.3 若predecessor右子树不为空，则此时其右子树指向x，说明已经遍历完x的左子树，
*   将predecessor右子树置空，将x值置入数组，之后访问x的右子树，即下x=x.right
*
* */
class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null) {
            // x存在左子树
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // predecessor右指针指向root，继续遍历root左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 左子树已经访问完成，断开连接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左节点，直接访问右节点
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}





