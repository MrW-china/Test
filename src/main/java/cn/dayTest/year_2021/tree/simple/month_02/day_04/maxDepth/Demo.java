package cn.dayTest.year_2021.tree.simple.month_02.day_04.maxDepth;

import java.util.LinkedList;
import java.util.Queue;

public class Demo {
    public static void main (String[] args) {

    }
}

class Solution {
    public int maxDepth (TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class Solution2 {
    public int maxDepth (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (; length > 0; length--) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);

            }
            i++;
        }
        return i;
    }
}