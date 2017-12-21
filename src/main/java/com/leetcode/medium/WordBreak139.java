package com.leetcode.medium;

import java.util.*;

public class WordBreak139 {

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Queue<Integer> queue =new LinkedList<>();
            queue.add(-1);
            Node tree = buildTree(wordDict);
            Set<Integer> set = new HashSet<>();
            while(!queue.isEmpty()){
                int index = queue.poll();
                Set<Integer> points = getEndChar(tree,s,index+1);
                points.removeAll(set);
                queue.addAll(points);
                set.addAll(points);
                if(queue.contains(s.length()-1)){
                    return true;
                }
            }
            return false;
        }

        Set<Integer> getEndChar(Node tree,String s,int start){
            Set<Integer> set = new HashSet<>();
            Node tmp = tree.chrildren[s.charAt(start)-'a'];
            while(tmp != null&&start<s.length()){
                if(tmp.end){
                    set.add(start);
                    if(start == s.length()-1){
                        return set;
                    }
                }
                start++;
                if(start<s.length())
                    tmp = tmp.chrildren[s.charAt(start)-'a'];
            }
            return set;
        }

        private Node buildTree(List<String> wordDict){
            Node root = new Node(' ');
            Node tmp = root;
            for(String word:wordDict){
                tmp = root;
                for(char c : word.toCharArray()){
                    if(tmp.chrildren[c-'a']==null){
                        tmp.chrildren[c-'a'] = new Node(c);
                    }
                    tmp = tmp.chrildren[c-'a'];
                }
                tmp.setEnd();
            }
            return root;
        }

        static class Node {
            char c;
            boolean end = false;
            Node[] chrildren = new Node[26];
            Node (char c){
                this.c = c;
            }

            void setEnd(){
                end = true;
            }
        }
    }
}
