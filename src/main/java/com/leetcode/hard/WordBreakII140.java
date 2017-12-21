package com.leetcode.hard;

import java.util.*;

public class WordBreakII140 {

    class Solution {
        Map<Integer,List<String>> cache = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        Node tree ;
        public List<String> wordBreak(String s, List<String> wordDict) {
            tree = buildTree(wordDict);
            List<Integer> path = new ArrayList<>();
            path.add(0);
            dfs(s,path);
            return res;
        }

        void dfs(String s, List<Integer> path){
            int point = path.get(path.size()-1);
            if(cache.containsKey(point)) {
                List<String> pathList = cache.get(point);
                String sb = "";
                for(int i= path.size()-1;i>0;i--){
                    sb = s.substring(path.get(i-1),path.get(i))+sb;
                    if(i != 1){
                        sb = " "+sb;
                    }
                    if(!cache.containsKey(path.get(i-1))){
                        cache.put(path.get(i-1),new ArrayList<String>());
                    }

                    for(String paths:pathList)
                        cache.get(path.get(i-1)).add(sb+paths);
                }
                for(String paths:pathList)
                    res.add(sb+paths);
            }
            if(point == s.length()) {
                String sb = "";
                for(int i= path.size()-1;i>0;i--){
                    sb = s.substring(path.get(i-1),path.get(i))+sb;
                    if(i != 1){
                        sb = " "+sb;
                    }
                    if(!cache.containsKey(path.get(i-1))){
                        cache.put(path.get(i-1),new ArrayList<String>());
                    }
                    cache.get(path.get(i-1)).add(sb);
                }
                res.add(sb);
                return;
            }
            if(set.contains(point)){
                return;
            }
            set.add(point);
            Set<Integer> nextPoints = getEndChar(tree,s,point);
            for(int np : nextPoints)
            {
                path.add(np+1);
                dfs(s,path);
                path.remove(path.size()-1);
            }
        }

        Set<Integer> getEndChar(Node tree, String s, int start){
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

        class Node {
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
