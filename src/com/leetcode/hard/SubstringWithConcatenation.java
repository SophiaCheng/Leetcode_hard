package com.leetcode.hard;
import java.util.*;


public class SubstringWithConcatenation {
	public static void main(String[] args){
		String s= "barfoothefoobarman";
		
	}
	public static List<Integer> findSubstring(String s, String[] words) {
		 List<Integer> list = new ArrayList<>();
		 if(words.length == 0 || s.length() < words.length * words[0].length()){
			 return list;
		 }
		 Map<String, Integer> map = new HashMap<>();
		 for(String word : words){
			 if(!map.containsKey(word)){
				 map.put(word, 1);
			 } else{
				 map.put(word, map.get(word) + 1);
			 }
		 }
		 
		 Map<String, Integer> curMap = new HashMap<>();
		 int sLen = s.length();
		 int n = words.length;
		 int len = words[0].length();
		 int count = 0;
		 for(int i = 0; i < len; i ++){
			 count = 0;
			 for(int l = i, r = i; r + len <= sLen; r += len){
				 String next = s.substring(r, r + len);
				 if(map.containsKey(next)){
					 if(!curMap.containsKey(next)){
						 curMap.put(next, 1);
					 } else{
						 curMap.put(next, curMap.get(next) + 1);
					 }
					 
					 if(curMap.get(next) <= map.get(next)){
						 count ++;
					 } else{
						 while(curMap.get(next) > map.get(next)){
							 String tmp = s.substring(l, l + len);
							 curMap.put(tmp,curMap.get(tmp) - 1);
							 l += len;
							 if(curMap.get(tmp) < map.get(tmp)){
								 count --;
							 }
						 }
					 }
					 
					 if(count == n){
						 list.add(l);
						 String tmp = s.substring(l, l + len);
						 curMap.put(tmp, curMap.get(tmp) - 1);
						 l += len;
						 count --;
					 }
				 } else{
					 l = r + len;
					 curMap.clear();
					 count = 0;
				 }
			 }
			 curMap.clear();
		 }
		 return list;
	}
}
