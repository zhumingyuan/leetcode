package com.leetcode.medium;

public class InsertionSortList {

    /**
     * Definition for singly-linked list.
     **/
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode ph = new ListNode(0);
            ListNode p = ph;
            ListNode cur = head,next;

            while(cur!=null) {

                while (p.next != null && p.next.val < cur.val) {
                    p = p.next;
                }
                next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = next;
                p = ph;
            }
            return ph.next;

        }
    }


    public static void main(String[]args){
        Solution solution = new Solution();
        ListNode node = new ListNode(3);
        ListNode n2 = new ListNode(1);
        node.next = n2;
        ListNode h = solution.insertionSortList(node);
        while(h!=null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}
