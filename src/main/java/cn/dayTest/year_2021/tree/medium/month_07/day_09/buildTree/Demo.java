package cn.dayTest.year_2021.tree.medium.month_07.day_09.buildTree;

import java.util.HashMap;
import java.util.Map;

/*
 *  question: 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 **/
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *  answer1: 递归
 *  step1: 后序遍历的顺序是先遍历左子树，再遍历右子树，最后遍历根节点。
 *  step2: 后序遍历的最后一个节点是根节点，可以利用已知根节点信息在中序遍历数组中找到根节点所在下标，然后将中序遍历分成左右子树两部分，
 *    知道左右子树的数量之后，同样可以在后序遍历中找出左子树和右子树的数据。
 *  step3: inorder：中序遍历；  postorder：后序遍历  找到根节点后，中序遍历可以更清晰的将左右子树区分出来
 *  step4:
 **/
class Solution {
    int post_idx;
    int[] postorder;
    int[] inorder;
    // 建立哈希表来存储中序队列(元素，小标)键值对的哈希表。
    Map<Integer, Integer> idx_map=new HashMap<Integer,Integer>();
    // 递归函数
    public TreeNode helper(int in_left, int in_right) {
        // 左边界大于有边界，说明遍历结束
        if (in_left > in_right) return null;
        // 从后序遍历数组中最后一位是该节点的根节点,该递归首先会遍历根节点的右子树，所以根节点位置依次减一即可
        int root_val = postorder[post_idx];
        // 定义跟节点
        TreeNode root = new TreeNode(root_val);
        // 找出该节点的位置2
        int index = idx_map.get(root_val);
        // 节点下标减一
        post_idx--;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        post_idx = postorder.length - 1;
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }
}