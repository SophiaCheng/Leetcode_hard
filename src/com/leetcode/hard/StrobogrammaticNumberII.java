package com.leetcode.hard;
import java.util.*;
public class StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0){
        	return list;
        }
        char[] res = new char[n];
        dfs(list, res, 0, n - 1);
        return list;
    }
	private static void dfs(List<String> list, char[] res, int left, int right){
		if(left > right){
			list.add(new String(res));
			return;
		}
		if(left == right){
			res[left] = '0';
			list.add(new String(res));
			res[left] = '1';
			list.add(new String(res));
			res[left] = '8';
			list.add(new String(res));
			return;
		}
		if(left != 0){
			res[left] = '0';
			res[right] = '0';
			dfs(list, res, left + 1, right - 1);
		}
		
		res[left] = '1';
		res[right] = '1';
		dfs(list, res, left + 1, right - 1);
		res[left] = '6';
		res[right] = '9';
		dfs(list, res, left + 1, right - 1);
		res[left] = '9';
		res[right] = '6';
		dfs(list, res, left + 1, right - 1);
		res[left] = '8';
		res[right] = '8';
		dfs(list, res, left + 1, right - 1);
	}
}
