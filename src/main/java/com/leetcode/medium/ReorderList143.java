package com.leetcode.medium;

public class ReorderList143 {

    /**
     * Definition for singly-linked list.*/
     static public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    static class Solution {
        public void reorderList(ListNode head) {
            if(head == null) return;
            ListNode p = head;
            int count = 0;
            while(p!=null){
                p=p.next;
                count++;
            }

            ListNode[] points = new ListNode[count];
            p = head;
            count = 0;
            while(p!=null){
                points[count++] = p;
                p=p.next;
            }

            int i = 0, j = count-1;
            while(i < j) {
                points[i].next = points[j];
                points[j--].next = points[++i];
            }
            points[i].next = null;
        }
    }

    public static void main(String[]args){
         Solution solution = new Solution();

         ListNode head = new ListNode(1);
         ListNode p = head;
         for(int i=2;i<11;i++){
             p.next = new ListNode(i);
             p = p.next;
         }

         solution.reorderList(head);
         p = head;
         while(p != null){
             System.out.println(p.val);
             p=p.next;
         }
    }
}
