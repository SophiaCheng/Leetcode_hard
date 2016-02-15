package com.leetcode.hard;
import java.util.*;

public class LongestTwoDistinct {
	public static void main(String[] args){
		String s = "aac";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s == null || s.length() == 0){
			return 0;
		}
		if(s.length() <= 2){
			return s.length();
		}
		Map<Character, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int head = 0;
		int tail = 0;
		 
		while(tail < s.length()){
			if(map.size() <= 2){
				char c = s.charAt(tail);
				map.put(c, tail);
				tail ++;
			}
			if(map.size() > 2){
				int leftMost = s.length();
				for(int i : map.values()){
					leftMost = Math.min(i, leftMost);
				}
				char c = s.charAt(leftMost);
				map.remove(c);
				head = leftMost + 1;
			}
			max = Math.max(max, tail - head);
		}
		return max;
		
////////////////////////////////////////////////////////////////////////////////
//		if(s == null || s.length() == 0){
//			return 0;
//		}
//		if(s.length() <= 2){
//			return s.length();
//		}
//        int head = 0;
//        int tail = 0;
//        int count = 0;
//        int res = Integer.MIN_VALUE;
//        Map<Character, Integer> map = new HashMap<>();
//        while(head < s.length() && tail < s.length()){
//        	char c = s.charAt(tail);
//        	if(!map.containsKey(c) && count <= 1){
//        		map.put(c, 1);
//        		tail ++;
//        		count ++;
//        	} else if(map.containsKey(c)){
//        		map.put(c, map.get(c) + 1);
//        		tail ++;
//        	} else{
//        		res = Math.max(res, tail - head);
//        		while(head < tail && map.containsKey(s.charAt(head))){
//        			if(map.get(s.charAt(head)) == 1){
//        				map.remove(s.charAt(head));
//        				count --;
//        				head ++;
//        				break;
//        			} 
//        			map.put(s.charAt(head), map.get(s.charAt(head)) - 1);
//        			head ++;
//        		}
//        	}
//        }
//        return Math.max(res, tail - head);
    }
}
