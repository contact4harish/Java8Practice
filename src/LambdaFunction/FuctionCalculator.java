package LambdaFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FuctionCalculator {

	public static void main(String[] args) {
		//1) use the functional interface Fuction
        Function<String, Integer> len=t->t.length();
        Function<Integer, Integer> sq=l->l*l;
        System.out.println(len.andThen(sq).apply("Apple"));
        System.out.println(sq.apply(len.apply("Microsoft")));    
        //2) find the area of 
        Area<Double, Double, Double> square=(t, r)->t*t;
        Area<Double, Double, Double> circle=(t, r)->3.14*t*t;
        Area<Double, Double, Double> rectangle=(t, r)->t*r;
        Area<Double, Double, Double> triangle=(t, r)->t*r/2;
        System.out.println(square.calc(3.3, 0.0));
        System.out.println(circle.calc(3.3, 0.0));
        System.out.println(rectangle.calc(3.3, 4.0));
        System.out.println(triangle.calc(3.3, 4.0));
        //3) Arraylist and function
        List<String> li=new ArrayList<>();
        li.add("laptop");
        li.add("desktop");
        li.add("ipad");
        li.add("iphone");
        li.add("lil");
        //java.util.stream.Collectors.toMap(Function<? super Boolean, ? extends Object> keyMapper, Function<? super Boolean, ? extends Object> valueMapper)
       System.out.println(li.stream().filter(t->t.charAt(0)=='i').collect(Collectors.toList()));
       System.out.println(li.stream().map(l->getReverseOfAString2(l)).collect(Collectors.toList()));
       li.stream().filter(l->checkIfItIsPolyndrome(l)).forEach(System.out::println);
       System.out.println(li.stream().filter(l->checkIfItHasDuplicate(l)).collect(Collectors.toList()));
       
        
	}
	
	public static String getReverseOfAString1(String str) {
		char[] s=str.toCharArray();
		char temp=0;
		int i=0;
		int j=str.length()-1;
		while( i<str.length()/2){
			
				temp=s[j];
				s[j]=s[i];
				s[i]=temp;
				
			i++;
			j--;
		}
		
		return String.valueOf(s);
		
	}
	public static String getReverseOfAString2(String str) {
	StringBuilder sb=new StringBuilder(str);
	
		return sb.reverse().toString();
		
	}
	public static boolean checkIfItIsPolyndrome(String str) {
		StringBuilder sb=new StringBuilder(str);
		return sb.reverse().toString().equals(str)?true:false;
			
			
		}
	public static boolean checkIfItHasDuplicate(String l) {
  	   int size=l.length();
 	   //Stream.of(l.toCharArray()).flatMap(t->new String(t).chars().mapToObj(a->(char) a)).collect(Collectors.toSet()).forEach(System.out::println);
 	   int setSize=Stream.of(l.toCharArray()).flatMap(t->new String(t).chars().mapToObj(a->(char) a)).collect(Collectors.toSet()).size();
 	   return size==setSize?false:true;
    }
		
		
		
	

}
