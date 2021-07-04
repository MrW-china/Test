package cn.dayTest.year_2021.tree.simple.month_07.day_02.isSameTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *   question: 相同的树
 *   给你两棵二叉树的根节点p和q，编写一个函数来检验这两棵树是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *  answer1: 递归(深度优先搜索)
 *  step: 遍历得到两个树的值的集合，之后对集合进行对比
 * */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
        }
    }
}

/*
 *   answer2: 广度优先搜索
 *   step: 利用栈来进行,这里使用Queue(先进先出)而非Deque(先进后出)。
 * */
class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> deque1 = new LinkedList<>();
        Queue<TreeNode> deque2 = new LinkedList<>();
        deque1.offer(p);
        deque2.offer(q);
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            TreeNode p1 = deque1.poll();
            TreeNode q1 = deque2.poll();
            if (p1.val != q1.val) return false;
            TreeNode pleft = p1.left;
            TreeNode pright = p1.right;
            TreeNode qleft = q1.left;
            TreeNode qright = q1.right;
            if (pleft == null ^ qleft == null) {
                return false;
            }
            if (pright == null ^ qright == null) {
                return false;
            }
            if (pleft != null) {
                deque1.offer(pleft);
                deque2.offer(qleft);
            }
            if (qright != null) {
                deque1.offer(pright);
                deque2.offer(qright);
            }
        }
        return deque1.isEmpty() && deque2.isEmpty();
    }
}