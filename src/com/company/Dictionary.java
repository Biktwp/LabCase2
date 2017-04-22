package com.company;

/**
 * Created by tau on 25/03/17.
 */
public class Dictionary {

    DNode header;
    DNode trailer;
    int size;

    public Dictionary() {
        header = new DNode(null);
        trailer = new DNode(null);
        header.next = trailer;
        trailer.prev= header;
    }

    public void addFirst(Elem elem) {//This method add the word and its frequency in the first position in the list
        DNode newNode = new DNode(elem);
        newNode.next = header.next;
        newNode.prev= header;
        header.next.prev= newNode;
        header.next = newNode;
        size++;
    }
    public void addLast(Elem elem) {//This methods add the word and its frequency in the last position in the list
        DNode newNode = new DNode(elem);
        newNode.next = trailer;
        newNode.prev= trailer.prev;
        trailer.prev.next = newNode;
        trailer.prev= newNode;
        size++;
    }


    public boolean isEmpty() {
        return (header.next == trailer);
    }


    public Elem getAt(int index) {//This method is to obtain the word and its frequency in a specific position
        int i = 0;
        Elem result=null;
        for (DNode nodeIt = header.next; nodeIt != trailer && result==null; nodeIt = nodeIt.next) {
            if (i == index) result=nodeIt.elem;
            ++i;
        }
        if (result==null) System.out.println("DList: Get out of bounds");
        return result;
    }

    public String  toString() {//This method is to print all the list
        String result = null;
        for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
            if (result == null) {
                result = "Word: "+nodeIt.elem.word +". Frequency: "+ nodeIt.elem.frequency +"\n";
            } else {
                result +="Word: "+nodeIt.elem.word +". Frequency: " + nodeIt.elem.frequency+"\n";
            }
        }
        return result == null ? "empty" : result;
    }

    public void add(SQueue queue){//this method introduces all the words in the list
        for(int i = 0;i < queue.getSize();i++){
            add(queue.getAt(i));
        }
    }

    public void add(String word){// This method add the frequency and sort the list in alphabetical order
        DNode aux = header.next;
        boolean re = false;
        int fr=1;
        Elem elem = new Elem(word,fr);//This is the word and its frequency to introduce in the Dictionary
        if (isEmpty()) addFirst(elem);
        else {//If the word is not in the dictionary this is introduced with its frequency
            while (aux != trailer && !re) {
                if (aux.elem.word.equals(word)) {re = true;aux.elem.frequency++;}
                    aux = aux.next;
            }
            if (!re)addFirst(elem);
        }
        boolean foundChange = true;
        while(foundChange) {//Sorts in a ascending alphabetical order
            foundChange = false;
            for(DNode nodeIt=header.next; nodeIt!=trailer.prev; nodeIt=nodeIt.next) {
                if (nodeIt.elem.word.compareTo(nodeIt.next.elem.word)>0) {
                    foundChange=true;
                    Elem aux1=nodeIt.elem;
                    nodeIt.elem=nodeIt.next.elem;
                    nodeIt.next.elem=aux1;
                }
            }
        }
    }



    public Dictionary getTop(int n){//This method is to print a list with n numbers of words and in ascending frequency number
        Dictionary newDictionary = new Dictionary();
        boolean foundChange = true;
        while(foundChange) {// Here the Dictionary is sort in ascending frequency number
            foundChange = false;
            for(DNode nodeIt=header.next; nodeIt!=trailer.prev; nodeIt=nodeIt.next) {
                if (nodeIt.elem.frequency - nodeIt.next.elem.frequency<0) {
                    foundChange=true;
                    Elem aux1=nodeIt.elem;
                    nodeIt.elem=nodeIt.next.elem;
                    nodeIt.next.elem=aux1;
                }
            }
        }
        for(int i = 0; i < n;i++){//Here the words are introduced in the new list
            newDictionary.addLast(getAt(i));
        }
        System.out.println(newDictionary.toString());//Here the new list are printed
        return newDictionary;
    }

    public Dictionary getLow(int n){//This method is to print a list with n numbers of words and in descending frequency number
        Dictionary newDictionary = new Dictionary();//here a new list is created
        boolean foundChange = true;
        while(foundChange) {// Here the Dictionary is sort in descending frequency number
            foundChange = false;
            for(DNode nodeIt=header.next; nodeIt!=trailer.prev; nodeIt=nodeIt.next) {
                if (nodeIt.elem.frequency - nodeIt.next.elem.frequency>0) {
                    foundChange=true;
                    Elem aux1=nodeIt.elem;
                    nodeIt.elem=nodeIt.next.elem;
                    nodeIt.next.elem=aux1;
                }
            }
        }
        for(int i = 0; i < n;i++){//Here the words are introduced in the new list
            newDictionary.addLast(getAt(i));
        }
        System.out.println(newDictionary.toString());//Here the new list are printed
        return newDictionary;
    }
}
