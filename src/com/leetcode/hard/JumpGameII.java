package com.leetcode.hard;

 

public class JumpGameII {
	public static void main(String[] args){
		int[] array = {3,2,1,0,4};
		System.out.println(jump(array));
	}
	
	public static int jump(int[] nums) {
		 // curIndex 记录到当前位置时，它可以到达的最远距离
		 // lastIndex 记录上一次可以到达的最远距离，如果现在能到达的最远距离和原来一样，证明此处为0， 不能到达尾端
		int curIndex = 0;
		int njump = 0;
		int i = 0;
		while(curIndex < nums.length - 1){//注意此处的termination条件
			int lastIndex = curIndex;
			while(i <= lastIndex){
				curIndex = Math.max(curIndex, i + nums[i]);
				i ++;
			}
			njump ++;
			if(curIndex == lastIndex){
				return -1;
			}
		}
		return njump;
//		 if(nums == null || nums.length == 0 || nums.length == 1){
//		     return 0;
//	        }
//	        int[] path = new int[nums.length];
//	        path[nums.length - 1] = 0;
//	        for(int i = nums.length - 2; i >= 0 ; i --){
//	           int curMin = Integer.MAX_VALUE;
//		    if(i + nums[i] >= nums.length - 1){
//		       path[i] = 1;
//	           } else if(nums[i] == 0){
//		       path[i] = -1;
//	           } else {
//		       for(int j = nums[i]; j >= 1; j --){
//		          if(path[i + j] != -1){
//		              curMin = Math.min(curMin, path[i + j]);
//	                 }
//	             }
//		      path[i] = curMin == Integer.MAX_VALUE ? -1 : curMin + 1;
//	           }
//	        }
//	       return path[0];
    }
}
