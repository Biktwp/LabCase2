package com.company;


public class DictionaryTree /*implements IBSTree*/ {

	BSTNode root;

	public void getPreorder() {
		if (root != null)
			root.getPreorder();
	}

	public void getInorder() {
		if (root != null)
			root.getInorder();
	}

	public void getPostorder() {
		if (root != null)
			root.getPostorder();
	}

	public void getLevelorder() {
		if (root != null)
			root.getLevelorder();
	}
	public void getOrder(){
		if (root != null)root.getOrder();
	}

	public int getSize() {
		if (root == null)
			return 0;
		return root.getSize();
	}

	public int getHeight() {
		if (root == null)
			return 0;
		return root.getHeight();
	}

	public int getDepth() {
		if (root == null)
			return 0;
		return root.getDepth();
	}
	public void goOver(){
		if (root != null)root.goOver();
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

	public void remove(String key) {
		if (root == null) {
			System.out.println("Cannot remove: The tree is empty");
			return;
		}
		if (key.equals(root.key)) {
			if (root.left == null && root.right == null)
				root = null;
			else if (root.left == null || root.left == null) {
				if (root.left == null)
					root = root.right;
				if (root.right == null)
					root = root.left;
				root.parent = null;
			} else {
				remove(key, root);
			}
		} else
			remove(key, root);
	}

	public boolean remove(String key, BSTNode node) {
		if (node == null) {
			System.out.println("Cannot remove: The key doesn't exist");
			return false;
		}
		if (key.compareTo(node.key) < 0)
			return remove(key, node.left);

		if (key.compareTo(node.key) > 0)
			return remove(key, node.right);
		//Here, it means that key.compareTo(node.Key)==0
		//That is, we already have found it: node is the node to remove.

		//First case: the node is a leaf.
		if (node.left == null && node.right == null) {
			BSTNode parent = node.parent;
			//we must break the references between the node and its parent. First, we must detect if the
			//node is the left or right child of its parent.
			if (parent.left == node)
				parent.left = null;//node has to be the left child of its parent
			else
				parent.right = null; //node is the rightChild
			node.parent = null; //is is not necessary, because Java has automatic garbage collection
			return true;
		}

		//Second case is one the node only has a child: left or right
		if (node.left == null || node.right == null) {
			//its only child is its right child
			BSTNode grandChild = null;
			if (node.left == null)
				grandChild = node.right;
			else
				grandChild = node.left;

			BSTNode grandParent = node.parent;
			if (grandParent.left == node)
				grandParent.left = grandChild;
			else
				grandParent.right = grandChild;
			//the grand child must point its grand parent.
			grandChild.parent = grandParent;
			return true;
		}

		//Third case: node has two childs.
		//We can replace its value by the maximum value in its left child or
		//by the minimum value in its right child
		BSTNode sucesorNode = findMin(node.right);
		node.elem = sucesorNode.elem;
		node.key = sucesorNode.key;
		remove(sucesorNode.key, node.right);
		return true;
		//Finally, we must remove the sucesor Node
	}

	public BSTNode findMin(BSTNode node) {
		if (node != null)
			while (node.left != null)
				node = node.left;
		return node;
	}

	public BSTNode findRecMin(BSTNode node) {
		if (node == null)
			return null;
		else if (node.left == null)
			return node;
		return findRecMin(node.left);
	}

	public BSTNode findMax(BSTNode node) {
		if (node != null)
			while (node.right != null)
				node = node.right;
		return node;
	}

	public BSTNode findRecMax(BSTNode node) {
		if (node == null)
			return null;
		else if (node.right == null)
			return node;
		return findRecMax(node.right);
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

	public Integer findIt(String key) {
		BSTNode searchNode = root;
		while (searchNode != null) {
			String keyVisit = searchNode.key;
			if (key.equals(keyVisit))
				return searchNode.elem;
			else if (key.compareTo(keyVisit) <0 )
				searchNode = searchNode.left;
			else if (key.compareTo(keyVisit)>0)
				searchNode = searchNode.right;
		}
		System.out.println(key + " does not exist");
		return null;
	}

	public DictionaryTree getTop(int n){
		DictionaryTree newDictionary = new DictionaryTree();
		BSTNode node = root;
		BSTNode newNode =root;

		newDictionary.getInorder();
		return newDictionary;
	}
//hola

}