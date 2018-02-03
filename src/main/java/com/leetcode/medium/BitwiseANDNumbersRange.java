package com.leetcode.medium;

public class BitwiseANDNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        if(m==n) return m;
        int diff = n-m-1;
        int count = 0;
        while(diff > 0){
            count++;
            diff>>=1;
        }
        return ((m>>count) << count)&n;
    }
}
