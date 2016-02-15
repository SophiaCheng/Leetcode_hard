package com.leetcode.hard;

public class StrobogrammaticNumberIII {
	public static void main(String[] args){
		String low = "1";
		String high = "1";
		System.out.println(strobogrammaticInRange(low, high));
	}
	static char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
	static int count = 0;

	public static int strobogrammaticInRange(String low, String high) {
	    for(int len = low.length(); len <= high.length(); len++) {
	        dfs(low, high, new char[len], 0, len - 1);
	    }
	    return count;
	}

	public static  void dfs(String low, String high, char[] c, int left, int right) {
	    if(left > right) {
	        String s = new String(c);
	        if((s.length() == low.length() && s.compareTo(low) < 0) || 
	           (s.length() == high.length() && s.compareTo(high) > 0)) return;
	        count++; 
	        return;
	    }

	    for(char[] p : pairs) {
	        c[left] = p[0]; 
	        c[right] = p[1];
	        if(c.length != 1 && c[0] == '0') continue;
	        if(left < right || left == right && p[0] == p[1]) dfs(low, high, c, left + 1, right - 1);
	    }
	}
}
