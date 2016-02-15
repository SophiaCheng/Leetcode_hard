package com.leetcode.hard;
import java.util.*;
public class WordLadderII_1 {
	public static void main(String[] args){
		String begin = "hot";
		String end = "dog";
		Set<String> wordList = new HashSet<>();
		wordList.add("cog");
		wordList.add("dog");
		wordList.add("tot");
		wordList.add("hog");
		wordList.add("hop");
		wordList.add("pot");
		wordList.add("dot");
		System.out.println(findLadders(begin, end, wordList));
	}
	
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
       List<List<String>> list = new ArrayList<>();
       Map<String, Integer> ladder = new HashMap<>();
       Map<String, List<String>> path = new HashMap<>();
       Queue<String> queue = new LinkedList<>();
       wordList.add(endWord);
       for(String word : wordList){
    	   ladder.put(word, Integer.MAX_VALUE);
       }
       ladder.put(beginWord, 0);
       queue.offer(beginWord);
       int min = Integer.MAX_VALUE; 
       while(!queue.isEmpty()){
    	   String cur = queue.poll();
    	   int step = ladder.get(cur) + 1;
    	   if(step > min){
    		   break;
    	   }
    	   for(int i = 0; i < cur.length(); i ++){
    		   StringBuilder sb = new StringBuilder(cur);
    		   for(char c = 'a'; c <= 'z'; c ++){
    			   sb.setCharAt(i, c);
    			   String new_word = sb.toString();
    			   if(ladder.containsKey(new_word)){
    				   if(step > ladder.get(new_word)){
    					   continue;
    				   }else if(step < ladder.get(new_word)){
    					   ladder.put(new_word, step);
    					   queue.offer(new_word);
    				   }
    				   
    				   if(path.containsKey(new_word)){
    					   path.get(new_word).add(cur);
    				   } else{
    					   List<String> sublist = new ArrayList<>();
    					   sublist.add(cur);
    					   path.put(new_word, sublist);
    				   }
    				   
    				   if(new_word.equals(endWord)){
    					   min = step;
    				   }
    			   }
    		   }
    	   }
       }
       
       List<String> sublist = new ArrayList<>();
       getPath(list, sublist, path, endWord, beginWord);
       return list;
    }
	
	private static void getPath(List<List<String>> list , List<String> sublist, Map<String, List<String>> path, String end, String begin){
		if(end.equals(begin)){
			sublist.add(0,begin);
			list.add(new ArrayList<String>(sublist));
			sublist.remove(0);
			return;
		}
		
		sublist.add(0, end);
		if(path.get(end) != null){
			for(String s : path.get(end)){
				getPath(list, sublist, path, s, begin);
			
			}
			sublist.remove(0); 
		}
		
	}
}
