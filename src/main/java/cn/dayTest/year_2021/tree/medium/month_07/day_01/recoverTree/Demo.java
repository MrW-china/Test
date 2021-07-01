package cn.dayTest.year_2021.tree.medium.month_07.day_01.recoverTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 *   question: 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *   step1: 二叉搜索树交换其中两个节点之后，该树的中序遍历结果会发生改变，即交换的节点i会出现int[i]>int[i+1]的情况。
 *   step2: 符合step1条件的节点数目记为n，当n=1时交换int[i]与int[i+1],当n=2时，交换int[i1]与int[i2+1]。
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *   answer1: 显式中序遍历(递归)
 *   step: 将排序错误的节点值保存在数组之中，之后再去遍历二叉树来更正节点值。
 *
 * */
class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //step1: 中序遍历题目给定的树，将值存入集合之中
        inorder(root, list);
        //step2: 遍历集合，找出排序异常的数值
        int[] twoSwapped = findTwoSwapped(list);
        //step3: 交换异常数值
        recover(root, 2, twoSwapped[0], twoSwapped[1]);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public int[] findTwoSwapped(List<Integer> list) {
        int n = list.size() - 1;
        int x = -1, y = -1;
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i + 1)) {
                y = list.get(i + 1);
                if (x == -1) {
                    x = list.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }
}

/*
 *   answer2: 隐式中序遍历(迭代)
 *   step: 在中序遍历过程中便找出排列错误的节点。
 *
 * */
class Solution2 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}

/*
 *  answer: morris中序遍历
 *
 * */
class Solution3 {
    public void recoverTree(TreeNode root) {
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null;
        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // predecessor.right = root; 左子树已经访问完成,需要断开链接。
                else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    predecessor.right = null;
                    root = root.right;
                }
            }
            else {
                if (pred !=null && root.val<pred.val){
                    y=root;
                    if (x == null) {
                        x=pred;
                    }
                }
                pred =root;
                root=root.right;
            }
        }
        swap(x,y);
    }
    public void swap(TreeNode x ,TreeNode y){
        int tmp =x.val;
        x.val=y.val;
        y.val=tmp;
    }
}








