package com.leetcode.hard;
import java.util.*;

public class ShortestPalindrome {
	public static void main(String[] args){
		String s = "abcd";
		System.out.println(shortestPalindrome(s));
	}
	public static String shortestPalindrome(String s) {
		if(s == null || s.length() == 0){
			return s;
		}
        boolean[][] vec = new boolean[s.length()][s.length()];
        vec[0][0] = true;
        for(int j = 1; j < s.length(); j ++){
        	for(int i = j; i >= 0; i --){
        		if(i == j){
        			vec[i][j] = true;
        		} else{
        			if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || vec[i + 1][j - 1])){
            			vec[i][j] = true;
            		}
        		}
        	}
        }
        for(int i = s.length() - 1; i >= 0 ; i --){
        	if(vec[0][i]){
        		StringBuilder tmp = new StringBuilder (s.substring(i + 1));
        		String res = tmp.reverse().toString() + s;
        		return res;
        	}
        }
        return s;
    }
	 
}
