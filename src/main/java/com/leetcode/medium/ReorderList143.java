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



        public void reorderList2(ListNode head) {
            if(head==null) return;
            ListNode fast = head, slow = head;
            while(slow!=null && slow.next!=null){
                slow = slow.next.next;
                if(slow!=null){
                    fast = fast.next;
                }
            }
            ListNode pre = null;
            ListNode p = fast.next;
            ListNode post = p==null ? null : p.next;
            while(post!=null){
                p.next = pre;
                pre = p;
                p=post;
                post = post.next;
            }
            if(p!=null)
                p.next = pre;

            fast.next = p;
            ListNode  guard = fast;
            ListNode h1 = head;
            ListNode h2 = head.next;
            ListNode mid1 = guard.next;
            ListNode mid2 = mid1 == null ? null : mid1.next;
            do{
                h1.next = mid1;
                if(mid1 !=null){
                    mid1.next = h2;
                }
                h1 = h2;
                h2 = h2 == null ? null : h2.next;
                mid1 = mid2;
                mid2 = mid2==null ? null : mid2.next;
            }while(h1!=guard && h1!=null);

            if(h1 != null)
                h1.next = mid1;
        }

        public void reorderList3(ListNode head) {
            if(head==null) return;
            ListNode fast = head, slow = head;
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                if(fast!=null){
                    slow = slow.next;
                }
            }
            ListNode pre = null;
            ListNode p = slow.next;
            ListNode post = p==null ? null : p.next;
            while(post!=null){
                p.next = pre;
                pre = p;
                p=post;
                post = post.next;
            }
            if(p!=null)
                p.next = pre;

            slow.next = null;
            ListNode h1 = head;
            ListNode h2 = head.next;
            ListNode m = p;
            while(h1!=null && m!=null) {
                h1.next = m;
                m = m.next;
                h1 = h1.next;
                h1.next = h2;
                h2 = h2 == null? null : h2.next;
                h1 = h1.next;
            }

        }
    }

    public static void main(String[]args){
         Solution solution = new Solution();

         ListNode head = new ListNode(1);
         ListNode p = head;
         for(int i=2;i<10;i++){
             p.next = new ListNode(i);
             p = p.next;
         }

         solution.reorderList3(head);
         p = head;
         while(p != null){
             System.out.println(p.val);
             p=p.next;
         }
    }
}
