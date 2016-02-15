package com.leetcode.hard;
import java.util.*;

public class MinimumWindowSubstring {
	public static void main(String[] args){
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}
	public static String minWindow(String s, String t) {
		// base: to record element in t
         Map<Character, Integer> map = new HashMap<>();
        // window: to record count of char which belongs to t up to now in s
        Map<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < t.length(); i ++){
        	if(!map.containsKey(t.charAt(i))){
        		map.put(t.charAt(i),1);
        		window.put(t.charAt(i),0);
        	} else {
        		map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
        	}
        }
        
        int start = 0;
        int count = 0;
        
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        
        for(int end = 0; end < s.length(); end ++){
        	char c = s.charAt(end);
        	if(map.containsKey(c)){
        		if(window.get(c) < map.get(c)){
        			count ++;
        		}
        		window.put(c, window.get(c) + 1);
        	}
        	
        	if(count >= t.length()){
        		while(!map.containsKey(s.charAt(start)) ||
            			window.get(s.charAt(start)) > map.get(s.charAt(start))){
            		 if(window.containsKey(s.charAt(start))){
            			 window.put(s.charAt(start), window.get(s.charAt(start)) - 1);
            		 }
            		 start ++;
            	}
            	
            	if(end - start + 1 < minLength){
            		minStart = start;
            		minLength = end - start + 1;
            	}
            	
            	count --;
            	window.put(s.charAt(start), window.get(s.charAt(start)) - 1);
            	start ++;
        	}
        }
        if(minLength == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart+minLength);
    }
}