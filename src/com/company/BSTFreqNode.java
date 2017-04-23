package com.company;

/**
 * Created by tau on 23/04/17.
 */
public class BSTFreqNode {
    Integer key;
    String elem;

    BSTFreqNode parent;
    BSTFreqNode left;
    BSTFreqNode right;

    public BSTFreqNode(Integer k, String e) {
        key = k;
        elem = e;
    }

    public void getInorder() {
        getInorder(this);
    }


    public void getOrder() { getOrder(this);}



    public void getInorder(BSTFreqNode node) {
        if (node==null) return;
        getInorder(node.left);
        System.out.println("("+node.key+" , "+node.elem+")");
        getInorder(node.right);
    }
    public void getOrder(BSTFreqNode node) {
        if (node == null) return;
        getOrder(node.right);
        System.out.println("(" + node.key + " , " + node.elem + ")");
        getOrder(node.left);
    }
}
