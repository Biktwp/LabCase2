package com.company;


public class DictionaryTree /*implements IBSTree*/ {

	BSTNode root;



	public void getInorder() {
		if (root != null)
			root.getInorder();
	}

	public void getOrder(){
		if (root != null)root.getOrder();
	}
	
	
	public void add(SQueue queue) {
		int fr = 1;
		for (int k = 0; k < queue.getSize(); k++) {
			BSTNode newNode = new BSTNode(queue.getAt(k), fr);
			if (root == null){
				root = newNode;
			}
				add(newNode, root);
		}
	}

	public void add(BSTNode newNode, BSTNode node) {
		String key = newNode.key;
		if (key.compareTo(node.key) == 0) {node.elem++;return;}

		if (key.compareTo(node.key) < 0) {
			if (node.left == null) {
				node.left = newNode;
				newNode.parent = node;
			} else
				add(newNode, node.left);
		} else {
			if (node.right == null) {
				node.right = newNode;
				newNode.parent = node;
			} else
				add(newNode, node.right);
		}
	}

	public void show (char c){
		if (c == 'a')getInorder();
		else getOrder();
	}


	public Integer search(String key) {
		return search(root, key);
	}

	public Integer search(BSTNode node, String key) {
		if (node == null)
			return null;
		else if (key.compareTo(node.key) < 0)
			return search(node.left, key);
		else if (key.compareTo(node.key) > 0)
			return search(node.right, key);
		else
			return node.elem;
	}

	public void getTop(int n, Dictionary newDictionary){
		newDictionary.getTop(n);
	}
	public void getLow(int n, Dictionary newDictionary){
		newDictionary.getLow(n);
	}

}