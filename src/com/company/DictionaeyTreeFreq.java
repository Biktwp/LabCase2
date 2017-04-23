package com.company;

/**
 * Created by tau on 22/04/17.
 */
public class DictionaeyTreeFreq {

    BSTFreqNode root;

    public void save(Dictionary newDictionary){
        DNode aux = newDictionary.header.next;

        while (aux != newDictionary.trailer){
            BSTFreqNode newNode = new BSTFreqNode(aux.elem.frequency, aux.elem.word);
            if (root == null) root = newNode;
            else add(aux.elem.frequency, aux.elem.word,root);
            aux = aux.next;
        }
    }

    public void add(Integer key,String elem, BSTFreqNode node) {
        BSTFreqNode nod = root;
        //Integer key = newNode.key;
        BSTFreqNode newNode = new BSTFreqNode(key,elem);
        if (key.compareTo(node.key) == 0) {node.elem+=","+newNode.elem;return;}

        if (key.compareTo(node.key) < 0) {
            if (node.left == null) {
                node.left = newNode;
                newNode.parent = node;
            } else {
                node = node.left;
                add(key,elem, node);
            }
        } else {
            if (node.right == null) {
                node.right = newNode;
                newNode.parent = node;
            } else {
                node = node.right;
                add(key,elem, node);
            }
        }
    }
    public void getInorder() {
        if (root != null)
            root.getInorder();
    }
}
