package com.company;

public class BSTNode{
	
	String key;
	Integer elem;

	BSTNode parent;
	BSTNode left;
	BSTNode right;

	public BSTNode(String k, Integer e) {
		key = k;
		elem = e;
	}

	public void getInorder() {
		getInorder(this);
	}


	public void getOrder() { getOrder(this);}



	public void getInorder(BSTNode node) {
		if (node==null) return;
		getInorder(node.left);
		System.out.println("("+node.key+" , "+node.elem+")");
		getInorder(node.right);
	}
	public void getOrder(BSTNode node) {
		if (node == null) return;
		getOrder(node.right);
		System.out.println("(" + node.key + " , " + node.elem + ")");
		getOrder(node.left);
	}


}