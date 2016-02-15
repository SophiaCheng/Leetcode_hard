package com.leetcode.hard;

public class PopulatingNextRightPointersInNodeII {
	public void connect(TreeLinkNode root) {
		  TreeLinkNode tmpNode = new TreeLinkNode(0);
		  while(root != null){
			  TreeLinkNode curNode = tmpNode;
			  while(root != null){
				  if(root.left != null){
					  curNode.next = root.left;
					  curNode = curNode.next;
				  }
				  
				  if(root.right != null){
					  curNode.next = root.right;
					  curNode = curNode.next;
				  }
				  root = root.next;
			  }
			  root = tmpNode.next;
			  tmpNode.next = null;
		  }
    }
}

  class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
        TreeLinkNode(int x) { 
        	val = x;
    	}
  }