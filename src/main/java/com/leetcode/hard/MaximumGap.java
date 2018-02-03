package com.leetcode.hard;

import java.util.Arrays;

public class MaximumGap {


    public int maximumGap(int[] nums) {

        if(nums==null) return 0;
        int len = nums.length;
        if(len ==0 || len == 1)
            return 0;
        if(len==2){
            return Math.abs(nums[0]-nums[1]);
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num:nums){
            min = Math.min(num,min);
            max = Math.max(num,max);
        }

        if(min==max) return 0;

        int everageGap = (max-min)/ (len-1) +1;

        int[] bucketMin = new int[len];
        int[] bucketMax = new int[len];

        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        Arrays.fill(bucketMax,Integer.MIN_VALUE);

        int idx = 0;
        for(int num: nums){
            idx = (num - min)/everageGap;
            bucketMin[idx] = Math.min(num,bucketMin[idx]);
            bucketMax[idx] = Math.max(num,bucketMax[idx]);
        }

        int res = Integer.MIN_VALUE;
        int lastMax = -1;
        for(int i=0;i<len;i++){
            if(bucketMin[i]==Integer.MAX_VALUE){
                continue;
            }
            if(lastMax != -1){
                res = Math.max(res,bucketMin[i] - lastMax);
            }
            lastMax = bucketMax[i];
        }

        return res;
     }

     public static void main(String[]args){
        MaximumGap maximumGap = new MaximumGap();
        int maxGap = maximumGap.maximumGap(new int[]{1,1,1,1});
        System.out.println(maxGap);
     }
}
