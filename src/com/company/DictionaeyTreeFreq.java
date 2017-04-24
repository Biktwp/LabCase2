package com.company;

/**
 * Created by tau on 22/04/17.
 */
public class DictionaeyTreeFreq {

    BSTFreqNode root;

    public void save(Dictionary newDictionary){//This method is used to introduce the frequency
        DNode aux = newDictionary.header.next;

        while (aux != newDictionary.trailer){
            BSTFreqNode newNode = new BSTFreqNode(aux.elem.frequency, aux.elem.word);
            if (root == null) root = newNode;
            else add(aux.elem.frequency, aux.elem.word,root);
            aux = aux.next;
        }
    }

    public void add(Integer key,String elem, BSTFreqNode node) {//This method is used to store the frequency and the words in the BST
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
}
