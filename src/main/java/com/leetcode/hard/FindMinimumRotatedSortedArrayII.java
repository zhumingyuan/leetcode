package com.leetcode.hard;

public class FindMinimumRotatedSortedArrayII {

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
            }else if(nums[mid]<nums[end]){
                return findMinHelper(nums, start + 1, mid);
            }else{
                return Math.min(findMinHelper(nums,start,mid-1),
                        findMinHelper(nums,mid+1,end));
            }
        }

        private int findMinHelper2(int[]nums,int start,int end){
            int mid;
            while(start < end){
                if(nums[start]<nums[end]){
                    return nums[start];
                }else if(nums[start]==nums[end]){
                    start++;
                }else{
                    mid = (start+end)/2;
                    if(nums[mid]>nums[start]){
                        start = mid+1;
                    }else if(nums[mid]<nums[start]){
                        start++;
                        end = mid;
                    }else{
                        start++;
                    }
                }
            }
            return nums[start];
        }
    }
}
