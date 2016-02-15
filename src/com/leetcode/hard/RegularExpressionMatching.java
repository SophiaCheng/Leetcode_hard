package com.leetcode.hard;

public class RegularExpressionMatching {
	public static void main(String[] args){
		String s = "aaab";
		String p = "a***b";
		System.out.println(isMatch(s, p));
	}
	
	public static boolean isMatch(String s, String p) {
		if (!p.isEmpty() && p.charAt(0) == '*') {
	        return false;   // invalid p
	    }

	    boolean[][] f = new boolean[s.length() + 1][p.length() + 1];

	    // initialize f(0,0)
	    f[0][0] = true;

	    // f(k,0) and f(0,2k-1) where k>=1 are false by default

	    // initialize f(0,2k) where p_2k-1 = * for any k>=1
	    for (int j = 1; j < p.length(); j+=2) {
	        if (p.charAt(j) == '*') {
	            f[0][j+1] = f[0][j-1];
	        }
	    }

	    for (int i = 1; i <= s.length(); i++) {
	        for (int j = 1; j <= p.length(); j++) {
	            if (p.charAt(j - 1) != '*') {
	                f[i][j] = f[i - 1][j - 1] && isCharMatch(s.charAt(i - 1), p.charAt(j - 1));
	            } else {
	                f[i][j] = f[i][j - 2] || f[i - 1][j] && isCharMatch(s.charAt(i - 1), p.charAt(j - 2));
	            }
	        }
	    }
	    System.out.println(f[1][2]);
	    return f[s.length()][p.length()];
	}

	// no * in p
	private static boolean isCharMatch(char s, char p) {
	    return p == '.' || s == p;
	}
	
}
