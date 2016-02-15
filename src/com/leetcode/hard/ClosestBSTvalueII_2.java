package com.leetcode.hard;
import java.util.*;
import com.leetcode.TreeNode.*;
public class ClosestBSTvalueII_2 {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> pre = new Stack<Integer>();
        Stack<Integer> suc = new Stack<Integer>();
        List<Integer> list = new ArrayList<>();
        inOrder(pre, root, target, true);
        inOrder(suc, root, target, false);
        // pre refers to the ele in ascending order
        // suc refers to the ele in descending order
        
        while(k > 0){
        	if(pre.isEmpty()){
        		list.add(suc.pop());
        	} else if(suc.isEmpty()){
        		list.add(pre.pop());
        	} else if((target -  pre.peek()) < (suc.peek() - target)){
        		list.add(pre.pop());
        	} else{
        		list.add(suc.pop());
        	}
        	k --;
        }
        return list;
    }
	
	private static void inOrder(Stack<Integer> stack, TreeNode root, double target, boolean isPre){
		if(root == null){
			return ;
		}
		
		inOrder(stack, (isPre ? root.left : root.right), target, isPre);
		
		if((isPre && root.val > target) || (!isPre && root.val <= target)){
			return;
		}
		
		stack.push(root.val);
		inOrder(stack, (isPre? root.right : root.left), target, isPre);
	}
}
