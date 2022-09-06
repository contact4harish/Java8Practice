package lambdaSupplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExample {

	public static void main(String[] args) {
		
		//1)basic example of supplier. Takes no argument, returns a value.
		Supplier<String> name=()->"apple";
		
		System.out.println(name.get());
		
		
		//2) get constants 
		Supplier<Double> pie=()->3.14;
		Supplier<Double> speedOfLight=()->299792458.0;
		
		System.out.println("Pie value is :::"+pie.get());
		System.out.println("Speed of Light is :::"+speedOfLight.get());
		
		
		//3) write Math formulae
		Supplier<Double> math1=()->Math.sqrt(Math.log(100));
		
		System.out.println(math1.get());
		
		
		//4) Supplier and list
		List<String> li=new ArrayList<>();
		li.add("animals");
		li.add("plants");
		li.add("fruits");
		Supplier<List<String>> lenghtMoreThan=()->{
			
		return li.stream().filter(i->i.length()>6).collect(Collectors.toList());
	};
	     System.out.println(lenghtMoreThan.get());
	     
	  //5)  Map and Supplier
	     Random random=new Random();
	     Supplier<Integer> randomInteger=()->random.nextInt();
	     StringBuilder sb=new StringBuilder();
	     String atoz="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     Supplier<String> randomString=()->{int i = 0;
	     									while(i<5) 
	     									{
	     										sb.append(atoz.charAt(random.nextInt(atoz.length())));
	     										i++;
	     									}
											return sb.toString();};
	     System.out.println(randomString.get());
	     Map<Integer,Integer> member=new HashMap<>();
	     member.put(1, null);
	     member.entrySet().stream().forEach(x->x.setValue(randomInteger.get()));
	     System.out.println(member);
	    	 
	     
	     //6)  List to Map
	     
	     List<Hosting> host = new ArrayList<>();
	        host.add(new Hosting(1, "liquidweb.com", 80000));
	        host.add(new Hosting(2, "linode.com", 90000));
	        host.add(new Hosting(3, "digitalocean.com", 120000));
	        host.add(new Hosting(4, "aws.amazon.com", 200000));
	        host.add(new Hosting(5, "mkyong.com", 1));
	        host.add(new Hosting(6, "linode.com", 100000));
	        host.add(new Hosting(6, "apple.com", 100000));
	        
	        Map getHosts=host.stream().collect(Collectors.toMap(Hosting::getName, collections->collections.toString(), (a, b)->a, LinkedHashMap::new));
	        
	        System.out.println("host code 2"+host.stream().collect(Collectors.toMap(ele->ele.toString(), Function.identity())));
	        System.out.println("host code 3"+host.stream().collect(Collectors.toMap(Hosting::getName, Function.identity(), (a,b)->a)));
	        Map<Integer, List<Hosting>> getHostsMap = host.stream().collect(Collectors.groupingBy(Hosting::getId));
	        
}
	
	
	

}