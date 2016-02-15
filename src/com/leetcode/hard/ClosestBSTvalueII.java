package com.leetcode.hard;
import java.util.*;
import com.leetcode.TreeNode.*;
public class ClosestBSTvalueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        inOrder(root, target, k, queue);
        while(!queue.isEmpty()){
        	list.add(queue.poll());
        }
        return list;
    }
	
	private static void inOrder(TreeNode root, double target, int k, Queue<Integer> queue){
		if(root == null){
			return;
		}
		inOrder(root.left, target, k, queue);
		if(queue.size() < k){
			queue.offer(root.val);
		} else{
			double diff1 = Math.abs(target - root.val);
			double diff2 = Math.abs(queue.peek() - target);
			if(diff1 < diff2){
				queue.poll();
				queue.offer(root.val);
			}
		}
		inOrder(root.right, target, k ,queue);
	}
}
