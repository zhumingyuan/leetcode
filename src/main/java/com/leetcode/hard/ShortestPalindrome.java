package com.leetcode.hard;

public class ShortestPalindrome {

    public String shortestPalindrome2(String s) {

        String s2 = revert(s);
        String tmp = s+ "#" + s2;
        int[] next = new int[tmp.length()];
        next[0] = -1;
        int k;
        for(int i=1;i<tmp.length();i++){
            k = next[i-1];
            while(k>-1&&tmp.charAt(i)!=tmp.charAt(k+1)){
                k = next[k];
            }
            if(tmp.charAt(k+1)==tmp.charAt(i)){
                k++;
            }
            next[i] = k;
        }
        return s2.substring(0,s2.length() - next[tmp.length()-1]-1)+s;
    }

    public String shortestPalindrome(String s) {
        int i=0,j = s.length()-1;
        for(;j>=0;j--){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
        }
        if(i==s.length()) {
            return s;
        }
        return new StringBuilder(s.substring(i)).reverse().toString() +
                shortestPalindrome(s.substring(0,i)) + s.substring(i);
    }


    private String revert(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[]args){
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        String res = shortestPalindrome.shortestPalindrome("aab");
        System.out.println(res);
    }
}
