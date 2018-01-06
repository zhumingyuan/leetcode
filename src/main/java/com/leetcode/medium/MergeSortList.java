package com.leetcode.medium;


public class MergeSortList {


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

    public ListNode sortList(ListNode head){
        return mergeSort(head);
    }


    private ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null
                && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left,right);
    }

    private ListNode merge(ListNode left,ListNode right) {
        ListNode pre = new ListNode(0);
        ListNode rear = pre;
        while(left!=null && right!=null){
            if(left.val<right.val){
                rear.next = left;
                rear = rear.next;
                left = left.next;
            }else{
                rear.next = right;
                rear = rear.next;
                right = right.next;
            }
        }
        if(left!=null){
            rear.next = left;
        }
        if(right!=null){
            rear.next = right;
        }

        return pre.next;
    }

    public static void main(String[]args){
        MergeSortList mergeSortList = new MergeSortList();

        ListNode head = new ListNode(0);

        for(int i=1;i<10;i++){
            ListNode node = new ListNode(i);
            node.next = head.next;
            head.next = node;
        }

        ListNode nh = head;
        //ListNode nh = mergeSortList.mergeSort(head);

        while(nh != null){
            System.out.println(nh.val);
            nh = nh.next;
        }
    }
}
