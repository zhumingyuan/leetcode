package com.leetcode.medium;

public class QuickSortList {

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

    static class Partion{
        ListNode small = new ListNode(-1);
        ListNode equal = new ListNode(-1);
        ListNode large = new ListNode(-1);
    }

    public ListNode sortList(ListNode head) {

        return quickSort(head);
    }

    private ListNode quickSort(ListNode head){
        if(head == null) return head;
        Partion p = partion(head);

        ListNode nh= new ListNode(-1),tmp=null;
        if(p.small != null){
            nh.next = quickSort(p.small);
        }

        tmp = nh;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = p.equal;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = quickSort(p.large);
        return nh.next;
    }

    private Partion partion(ListNode head) {

        Partion p = new Partion();
        int key = head.val;
        ListNode next;
        while(head != null) {
            next = head.next;
            if(head.val<key){
                head.next = p.small.next;
                p.small.next = head;
            }else if(head.val > key){
                head.next = p.large.next;
                p.large.next = head;
            }else{
                head.next = p.equal.next;
                p.equal.next = head;
            }
            head = next;
        }
        p.small = p.small.next;
        p.large = p.large.next;
        p.equal = p.equal.next;
        return p;
    }

    public static void main(String[]args){
        QuickSortList quickSortList = new QuickSortList();

        ListNode head = new ListNode(0);
        for(int i=1;i<4;i++){
            ListNode node = new ListNode(i);
            node.next = head.next;
            head.next = node;
        }

        ListNode nh = head;
        nh = quickSortList.sortList(head);

        while(nh != null){
            System.out.println(nh.val);
            nh = nh.next;
        }
    }
}
