package lambda;

import java.util.ArrayList;
import java.util.List;

public class Calculations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	/*
	 * 1) basic lambda
	 * 
	 * usage: used for functional interfaces. 
	 * The methods in the functional interface can implemented in a shortest form of a method.
	 * The functional interfaces can be created by ourselves or by java itself
	 * 
	 * */

	List<String> li =new ArrayList<>();
	li.add("apple");
	li.forEach((x)->System.out.println(x));
		

     //2) prime numbers using lambda    
		
	PrimeNumberInterface ref = 	(number)->{
			Boolean flag=false;
			for(int i =2; i<=number/2; i++) {
				if(number%i==0) {
					flag=true;
					break;
				}
			}
			
				if(!flag) {
					System.out.println("it is a prime number");
				}
				
				else {
					System.out.println("it is not a prime number");
				}	
			return flag;
				
		};
		
		
		
		System.out.println(ref.isPrime(50));
		
		
		
		//3) Add Multiply Divide numbers
		 ArithematicInterface<Integer, Integer> add=(x,y)->{
			 return x+y;
		 };
		 ArithematicInterface<Integer, Integer> sub=(x,y)->{
			 return x-y;
		 };
		 ArithematicInterface<Double, Double> div=(x,y)->{
			 return x/y;
		 };
		 ArithematicInterface<Double, Double> percentage=(x,y)->{
			 return x*y/100;
		 };
		 ArithematicInterface<Double, Double> mult=(x,y)->{
			 return x*y;
		 };
		 
		 System.out.println(add.calc(5, 6));
		 System.out.println(sub.calc(5, 6));
		 System.out.println(div.calc(5.0, 6.0));
		 System.out.println(percentage.calc(5.0, 6.0));
			}
	
	     
	 
	 


}
