package com.leetcode.hard;
import java.util.*;
public class StrobogrammaticNumber {
	public static void main(String[] args){
		String num = "169";
		System.out.println(isStrobogrammatic(num));
	}
	
	public static boolean isStrobogrammatic(String num) {
        StringBuilder rev =  new StringBuilder(num);
        rev = rev.reverse();
        Map<Character, Character> map = new HashMap<>();
        map.put('1','1');
        map.put('0','0');
        map.put('9','6');
        map.put('0','0');
        map.put('8','8');
        map.put('6','9');
        for(int i = 0; i < rev.length(); i ++){
        	if(!map.containsKey(rev.charAt(i))){
        		return false;
        	}else{
        		rev.setCharAt(i, map.get(rev.charAt(i)));
        	}
        }
        if(num.equals(new String(rev))){
        	return true;
        }else{
        	return false;
        }
    }
}
