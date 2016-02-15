package com.leetcode.hard;
import java.util.*;
public class WordLadder {
	public static void main(String[] args){
		String b = "hit";
		String e = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		System.out.println(ladderLength(b, e, wordList));
	}
	
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
         if(beginWord.equals(endWord)){
        	 return 1;
         }
         Set<String> visited = new HashSet<>();
         Queue<String> queue = new LinkedList<>();
         queue.offer(beginWord);
         wordList.remove(beginWord);
         
         int level = 2;
         while(!queue.isEmpty()){
        	 int size = queue.size();
        	 
        	 for(int i = 0; i < size; i ++){
        		 String cur = queue.poll();
        		 for(int index = 0; index < cur.length(); index ++){
        			 char[] curArr = cur.toCharArray();
        			 for(char c = 'a' ; c <= 'z'; c ++){
        				 curArr[index] = c;
        				 String tmp = new String(curArr);
        				 if(tmp.equals(endWord)){
        					 return level;
        				 }
        				 if(wordList.contains(tmp) && !visited.contains(tmp)){
        					 visited.add(tmp);
        					 queue.offer(tmp);
        				 }
        			 }
        		 }
        	 }
        	 level ++;
         }
         return 0;
    }
}
