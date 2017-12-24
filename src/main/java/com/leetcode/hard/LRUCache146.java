package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

    static class Node{
        int key;
        int val;
        Node pre;
        Node post;

        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }


    static class LRUCache {

        Node head,tail;
        int size;
        int capacity;
        Map<Integer,Node> map;


        public LRUCache(int capacity) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.capacity = capacity;
            this.map = new HashMap<Integer, Node>();
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            Node temp = map.get(key);
            remove(temp);
            add(temp);
            return temp.val;
        }

        public void put(int key, int value) {

            Node temp;
            if(map.containsKey(key)){
                temp = map.get(key);
                remove(temp);
                map.remove(key);
                size--;
            }

            if(size == capacity){
                Node h = head;
                remove(h);
                map.remove(h.key);
                size--;
            }

            temp = new Node(key,value);
            add(temp);
            map.put(key,temp);
            size++;
        }

        private void add(Node n){
            if(head == null && tail == null) {
                head = n;
                tail = n;
            }else {
                tail.post = n;
                n.pre = tail;
                tail = n;
            }
        }

        private void remove(Node n){
            if(n==head && n==tail){
                head = null;
                tail = null;
            }else if(n == head) {
                head = head.post;
                head.pre = null;
            } else if(n == tail) {
                tail = tail.pre;
                tail.post = null;
            }else{
                n.pre.post = n.post;
                n.post.pre = n.pre;
            }
            n.pre = null;
            n.post = null;
        }
    }

    public static void main(String[]args){
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        cache.get(2);
        cache.put(3, 2);
        System.out.println(cache.get(2));       // returns 1
        System.out.println(cache.get(3));       // returns -1 (not found)
    }
}
