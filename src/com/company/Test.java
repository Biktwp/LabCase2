package com.company;
import java.io.File;
import  java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Test {

	public static String[] reader(File f) throws IOException{
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line, text = " ";//these variables is to store all the lines and the test respectively
		String [] aux;//This variable is to store all the words
		while ((line = br.readLine()) != null) {//Here we introduce all the lines in the test variable
			text += line;
		}
		text = text.replaceAll("[^a-zA-Z]"," ");//Here we replace all the character by spaces
		text = text.toLowerCase();
		fr.close();
		br.close();
		aux = text.split(" ");//Here we introduce the words in the array
		return aux;
	}
	public static void main(String[] args) {
		File f = new File("/home/tau/UNI/EDA/LabCase1.txt");//The directory of the file
		SQueue queue = new SQueue();
		DictionaryTree bstree = new DictionaryTree();
		try {
			queue.addWords(reader(f));//We adding the words in the queue
            /*System.out.println("hol"+reader(f).length);
            for(int i=0;i<queue.getSize();i++){
                System.out.println(queue.getAt(i));
            }*/
			bstree.add(queue);
			//bstree.getInorder();
			//bstree.show('c');
			//bstree.getLevelorder();
			System.out.println(bstree.search("by"));
		} catch (IOException e) {//if it is an error make the e.printStackTrace
			e.printStackTrace();
		}

	}

}