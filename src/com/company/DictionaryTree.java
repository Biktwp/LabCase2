package com.company;


public class DictionaryTree {

	BSTNode root;



	public void getInorder() {//This method is to order and print ADT in alphabetical order.
		if (root != null)
			root.getInorder();
	}

	public void getOrder(){//This method is to order and print BST Z-A
		if (root != null)root.getOrder();
	}
	
	
	public void add(SQueue queue) {// This method recive a queue and stores the words.
		int fr = 1;
		for (int k = 0; k < queue.getSize(); k++) {
			BSTNode newNode = new BSTNode(queue.getAt(k), fr);
			if (root == null){
				root = newNode;
			}
				add(newNode, root);
		}
	}

	public void add(BSTNode newNode, BSTNode node) {//This method store the word and its frequency in the BST
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

	public void show (char c){/*Here we print the BST depends of a character if the character is a,
		The BST is printed in alphabetical order*/
		if (c == 'a')getInorder();
		else getOrder();
	}


	public Integer search(String key) { //Here we print the frequency of the word.
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
	//Here we reuse the methods getTop and getLow from the ADT Dictionary.
	public void getTop(int n, Dictionary newDictionary){
		newDictionary.getTop(n);
	}
	public void getLow(int n, Dictionary newDictionary){
		newDictionary.getLow(n);
	}

}