package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsLine {

    static class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }

    static class Solution {

        public int maxPoints(Point[] points) {

            int res = 0;
            if(points == null || points.length == 0) return res;
            for(int i=0;i<points.length-1;i++){
                Map<String,Integer> cache = new HashMap<>();
                int overlap = 0;
                int tempCount = 0;
                int tempMax = 0;
                for(int j=i+1;j<points.length;j++){
                    if(equal(points[i],points[j])){
                        overlap++;
                        continue;
                    }

                    String slope = getSlope(points[i],points[j]);
                    if(cache.containsKey(slope)){
                        tempCount = cache.get(slope);
                    }else{
                        tempCount = 0;
                    }
                    cache.put(slope,++tempCount);
                    tempMax = Math.max(tempMax,tempCount);
                }
                res = Math.max(res,tempMax+overlap);
            }
            return res+1;
        }

        private boolean equal(Point p,Point q){
            return p.x==q.x && p.y == q.y;
        }

        private String getSlope(Point p,Point q){
            int xx = p.x - q.x;
            int yy = p.y - q.y;

            int gcd = getGCD(yy,xx);
            return String.valueOf(xx/gcd)+"-"+String.valueOf(yy/gcd);
        }

        private int getGCD(int x,int y){
            if(y==0) return x;
            return getGCD(y,x%y);
        }
    }

    public static void main(String[]args){
        Solution solution = new Solution();
        Point p = new Point(1,2);
        Point q  = new Point(2,3);
        Point k = new Point(3,4);
        int number = solution.maxPoints(new Point[]{p,q,k});
        System.out.println(number);
    }
}
