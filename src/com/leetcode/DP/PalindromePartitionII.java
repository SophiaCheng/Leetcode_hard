package com.leetcode.DP;

public class PalindromePartitionII {
	public static void main(String[] args){
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(minCut(s));
	}
	
	 public static  int minCut(String s) {
         if(s == null || s.length() == 0){
	  	return 0;
	 }
	 int[] min = new int[s.length()];
	 min[0] = 0;
	 for(int i = 1; i < s.length(); i ++){
	     if(isPalindrome(s, 0, i)){
		 min[i] = 0;
		 continue;
	     } else{
		 int curMin = Integer.MAX_VALUE;
	 	 for(int j = 0; j < i ; j ++){
		     if(curMin > min[j] && isPalindrome(s, j + 1, i)){
			   curMin = min[j];
		     }
		 }
		 min[i] = curMin + 1;
	     }
 	 }
	 return min[s.length() - 1];
    }
    private static boolean isPalindrome(String s, int left, int right){
	while(left < right){
	    if(s.charAt(left) == s.charAt(right)){
		left ++;
		right --;
	    } else{
		return false;
	    }
	   
	}
        return true;
    }
}
