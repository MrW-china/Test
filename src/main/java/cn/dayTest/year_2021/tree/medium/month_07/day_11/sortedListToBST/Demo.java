package cn.dayTest.year_2021.tree.medium.month_07.day_11.sortedListToBST;

import java.util.ArrayList;
import java.util.List;

/*
 *   question: 有序链表转换二叉搜索树
 *   step: 要求高度平衡
 * */
public class Demo {
    public static void main(String[] args) {

    }
}

/*
 *   answer1: 将链表转化为集合或数组，在进行递归处理
 * */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return dfs(list, 0, list.size() - 1);
    }

    public TreeNode dfs(List<Integer> list, int left, int right) {
        if (left > right) return null;
        int idx = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(idx));
        root.left = dfs(list, left, idx - 1);
        root.right = dfs(list, idx + 1, right);
        return root;
    }
}

/*
 *   answer2: 分治
 * */
class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {

        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode solw = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            solw = solw.next;
        }
        return solw;
    }
}

/*
 *   answer3: 分治法加中中序遍历
 * */
class Solution3 {
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(globalHead);
        return buildTree(0,length-1);
    }

    public int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            listNode = listNode.next;
            length++;
        }
        return length;
    }

    public TreeNode buildTree(int left, int right) {
        if (left>right) return null;
        int mid = (left+right+1)/2;
        TreeNode root =new TreeNode();
        root.left=buildTree(left,mid-1);
        root.val=globalHead.val;
        globalHead=globalHead.next;
        root.right=buildTree(mid+1,right);
        return root;
    }
}










