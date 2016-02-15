package com.leetcode.hard;

public class BestMeetingPoint {
	public static void main(String[] args){
		int[][] grid = {{1,0,0,0,1},
						{0,0,1,0,0},
						{0,0,1,0,0}};
		minTotalDistance(grid);
	}
	public  static int minTotalDistance(int[][] grid) {
        int[] col_sum = new int[grid[0].length];
        int[] row_sum = new int[grid.length];
        for(int i = 0; i < grid.length; i ++){
        	for(int j = 0; j < grid[0].length; j ++){
        		col_sum[j] += grid[i][j];
        		row_sum[i] += grid[i][j];
        	}
        }
        return minDistance(col_sum) + minDistance(row_sum);
    }
	private static int minDistance(int[] array){
		int i = -1;
		int j = array.length;
		int left = 0;
		int right = 0;
		int distance = 0;
		while(i != j){
			if(left < right){
				distance += left;
				left += array[++ i];
			} else{
				distance += right;
				right += array[-- j];
			}
		}
		return distance;
	}
}
