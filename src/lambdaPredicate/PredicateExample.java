package lambdaPredicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//note: Predicate uses 
		String[] fruits= {"apple", "mango", "banana","pineapple", "sts"};
		List<String> li=Arrays.asList(fruits);		
		
		//1) size validation of a string using predicate

        Predicate<String> size=t->t.length()>2;
        System.out.println(size.test("apple"));

       //2) check if the String is polyndrome or not
		Predicate<String> polyndrome = t -> {
			char[] c = t.toCharArray();
			String rev = "";
			for (int i = c.length - 1; i >= 0; i--) {
				rev += c[i];
			}
			return t.equalsIgnoreCase(rev);

		};

		System.out.println(polyndrome.test("sts"));
		
		//3) combination of 2 conditions
		li.stream().filter(polyndrome.and(size)).forEach(System.out::println);
		
		
		//4) get the values starting with a specific letter
		
		Predicate<String> startingLetterCheck=t->t.charAt(0)=='a';
		li.stream().filter(startingLetterCheck).forEach(System.out::println);
		
		//5) get the word with repeated chars
		Predicate<String> repeatedChars=t->{
			char[] c=t.toCharArray();
			Set s=new HashSet();
			for(char ch:c) {
				s.add(ch);
			}
			
			return s.size()==t.length()?false:true;
			
		};
		li.stream().filter(repeatedChars).forEach(System.out::println);
		//6 Map (filter normally) VS PREDICATE
				Map<Integer, String> transport=new HashMap<>();
				transport.put(1, "Aeroplance");
				transport.put(2, "Cruse");
				transport.put(3, "Car");
				transport.put(4, "Trailer");
				
				for(Map.Entry<Integer, String> entry:transport.entrySet()) {
				Boolean greaterSize=entry.getValue().length()>5?true:false;
				if(greaterSize)
					System.out.println(entry.getValue());
				}
		//with streams, predicate and lamda		
		transport.entrySet().stream().filter(x->x.getValue().length()>5).forEach(x->System.out.println(x.getValue()));		
		
		
		
}
}