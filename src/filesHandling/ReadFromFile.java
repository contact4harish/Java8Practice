package filesHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadFromFile {
public static void main(String[] args) throws IOException {

	String file ="basicFile.txt";
	//1) print the value in the file
	Files.lines(Paths.get(file)).forEach(System.out::println);
	
	//2) read words and store in map with the words and their occurance -java 7
	//System.out.println(getWordsFromFilesToMap(file));
	
	//3) read words and store in map with the words and their occurance -java 8
	Map<String,Integer> map=new HashMap<>();
	Files.readAllLines(Paths.get(file)).stream().map(
		line->{ 
			
			String[] arr=line.split(" ");
			for(String word:arr) {
				if(map.get(word)!=null) {
					map.put(word, map.get(word)+1);
				}
				else {
					map.put(word, 1);
				}
			}
			return map;
					}).forEach(System.out::println);
					
	
	//4)
	//System.out.println(getWords("basicFile.txt"));
	
}
	
	public static Map<String, Integer> getWordsFromFilesToMap(String file) throws IOException {
		BufferedReader reader =new BufferedReader(new FileReader(file));
		Map<String, Integer> map=new HashMap<>();
		String data=null;
		while((data=reader.readLine())!=null) {
			String[] arrayOfWords=data.split(" ");
			for(String word:arrayOfWords) {
				if(map.get(word)!=null) {
					map.put(word, map.get(word)+1);
				}
				else {
					map.put(word, 1);
				}
				
			}
		}
		return map;
	}
	
	public static Map<String, Integer> getWords(String file) throws IOException{
		Map<String, Integer> wordCountMap = new HashMap<>();
		
		Function<String, Integer> count = (word) ->{
			if(wordCountMap.get(word) != null ) {
				wordCountMap.put(word, wordCountMap.get(word) +1);
			} else {
				wordCountMap.put(word, 1);
			}
			return wordCountMap.get(word);
		};
		
		Map<String, Integer> finalMap = Files.readAllLines(Paths.get(file)).stream()
						.map(line -> line.split(" ")) // string[] -> string stream
						.flatMap(Arrays::stream)
						.collect(Collectors.toMap(word -> word, word -> count.apply(word), (o, n)->n));
		
		
		return finalMap;
	}
	
}
