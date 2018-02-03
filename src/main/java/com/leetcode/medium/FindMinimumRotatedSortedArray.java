package com.leetcode.medium;

public class FindMinimumRotatedSortedArray {

    class Solution {
        public int findMin(int[] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }
            return findMinHelper(nums,0,nums.length-1);
        }

        private int findMinHelper(int[]nums,int start,int end){
            if(start>=end) return nums[start];
            if(nums[start]<nums[end]) return nums[start];
            int mid = (start+end)/2;
            if(nums[mid]>nums[start]){
                return findMinHelper(nums,mid+1,end);
            }else {
                return findMinHelper(nums, start + 1, mid);
            }
        }

        private int findMinHelper2(int[]nums,int start,int end){
            int mid;
            while(start < end){
                if(nums[start]<nums[end]) return nums[start];
                mid = (start+end)/2;
                if(nums[mid]<nums[start]){
                    start++;
                    end = mid;
                }else{
                    start = mid+1;
                }
            }
            return nums[start];
        }
    }
}
