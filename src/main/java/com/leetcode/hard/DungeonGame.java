package com.leetcode.hard;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null) return 0;
        int row = dungeon.length;
        int width = dungeon[0].length;
        int [][] dp = new int[row][width];
        for(int i=row-1;i>=0;i--){
            for(int j=width-1;j>=0;j--) {
                if(i==row-1&&j==width-1){
                    dp[i][j] = Math.max(1,1-dungeon[i][j]);
                }else if(i==row-1){
                    dp[i][j] = Math.max(1,dp[i][j+1]-dungeon[i][j]);
                }else if(j==width-1){
                    dp[i][j] = Math.max(1,dp[i+1][j]-dungeon[i][j]);
                }else{
                    dp[i][j] = Math.min(
                            Math.max(1,dp[i][j+1]-dungeon[i][j]),
                            Math.max(1,dp[i+1][j]-dungeon[i][j])
                        );
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[]args){
        DungeonGame dungeonGame = new DungeonGame();
        //[[1,-4,5,-99],[2,-2,-2,-1]]
        int[][] game = new int[][]{{1,-4,5,-99},{2,-2,-2,-1}};
        dungeonGame.calculateMinimumHP(game);
    }
}
