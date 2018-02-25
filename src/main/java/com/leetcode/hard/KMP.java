package com.leetcode.hard;

public class KMP {

    private void next(char[] ptr,int []next) {

        int len = ptr.length;
        next[0] = -1;
        int k;
        for(int i=1;i<len;i++){

            k = next[i-1];
            while(k>-1 && ptr[i]!=ptr[k+1]){
                k = next[k];
            }
            if(ptr[i]==ptr[k+1]) {
                k ++;
            }
            next[i] = k;
        }
    }

    public int kmp(String str,String ptr){
        int [] next = new int[ptr.length()];
        next(ptr.toCharArray(),next);
        int k = -1;
        for(int i=0;i<str.length();i++){
            while(k>-1 && ptr.charAt(k+1)!=str.charAt(i)){
                k = next[k];
            }
            if(ptr.charAt(k+1) == str.charAt(i)){
                k++;
            }
            if(k==ptr.length()-1){
                return i-ptr.length()+1;
            }
        }
        return -1;
    }

    public static void main(String[]args) {
        String str = "bacbababadababacambabacaddababacasdsd";
        String ptr = "ababaca";
        KMP kmp = new KMP();
        System.out.println(kmp.kmp(str,ptr));
    }
}
