package com.leetcode.DP;

public class PaintHouse {
	//此题需要保存红、绿、蓝各自的最小值
	public int minCost(int[][] costs) {
		int red = 0;
		int blue = 0;
		int green = 0;
        for(int i = 0; i < costs.length; i ++){
        	int preRed = red;
        	int preBlue = blue;
        	int preGreen = green;
        	red = costs[i][0] + Math.min(preBlue, preGreen);
        	blue = costs[i][1] + Math.min(preRed, preGreen);
        	green = costs[i][2] + Math.min(preRed, preBlue);
        }
        return Math.min(red, Math.min(blue, green));
    }
}
