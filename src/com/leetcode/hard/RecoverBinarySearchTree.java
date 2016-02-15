package com.leetcode.hard;
import com.leetcode.TreeNode.*;
public class RecoverBinarySearchTree {
	
	static TreeNode first = null;
	static TreeNode second = null;
	static TreeNode pre = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
	private static void inOrder(TreeNode root){
		if(root == null){
			return;
		}
		
		inOrder(root.left);
		
		if(first == null && pre.val >= root.val){
			first = pre;
		}
		
		if(first != null && pre.val >= root.val){
			second = root;
		}
	    pre = root;
	    
	    inOrder(root.right);
	}
}
