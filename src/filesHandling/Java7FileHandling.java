package filesHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Java7FileHandling {

	public static void main(String[] args) throws IOException, NullPointerException{
		// TODO Auto-generated method stub
//1) Read the file using FileInputStream
		FileInputStream fis=new FileInputStream("basicFile.txt");
		int data=0;
		while((data=fis.read())!=-1) {
			System.out.print((char)data);
		}
		fis.close();
	
	
//2) Write to the file using FileOutputStream
	     FileOutputStream fos=new FileOutputStream("basicFile2.txt");
	     fos.write("This is file Output Stream; ".getBytes());

	     
//3) Read the file using BufferedReader
	     
	     BufferedReader br=new BufferedReader(new FileReader("basicFile.txt"));
	     String stData=null;
	     while((stData=br.readLine())!=null) {
	    	 System.out.println(stData); 
	     }
	     br.close();
//4) Write to the file using BufferedWriter
	     
	     BufferedWriter bw=new BufferedWriter(new FileWriter("basicFile2.txt"));
	     bw.write("This is the second line written by BufferedWriter");
	     bw.close();
	     

//5) get all the words in the file to a map
	
	     Map<String, Integer> map=new HashMap<String, Integer>();
	    BufferedReader wordReader=new BufferedReader(new FileReader("basicFile.txt"));
	     //get the words as string, put the string in array string, get the word using forEach loop, add to map key if map is not null 
	     String words=null;
	     while((words=wordReader.readLine())!=null){
	    	String[] wordArray=words.split(" ");
	    	for(String word:wordArray) {
	    	
	    		if(map==null||map.isEmpty()) {
	    		   
	    			map.put(word, 1);
	    			
	    		}
	    		else {
	    			map.put(word, map.get(word)+1);
	    		}
	    	}
	     }
	     wordReader.close();
	     System.out.println(map);




}

}
