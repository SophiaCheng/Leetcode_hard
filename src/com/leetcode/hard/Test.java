package com.leetcode.hard;
import java.util.*;

public class Test {
	public static void main(String[] args){
//		String s1 = "abc";
//		String s2 = "abcd";
		String[] s = {"abc", "abcd","acd", "abcdf"};
		
		System.out.println(longestCommonPrefix(s));
	}
	 public static String longestCommonPrefix(String[] strs) {
         if(strs == null || strs.length == 0){
		return null;
	 }
        Arrays.sort(strs);
	 String res = strs[0];
	 int i = 1;
	 while(i < strs.length){
	   if(strs[i].startsWith(res)){
		i ++;
	   } else{
	       if(res == ""){
		    return res;
	       }
	       res = res.substring(0, res.length() - 1);
		
	   }
	 }
	 	return res;

    }
}
