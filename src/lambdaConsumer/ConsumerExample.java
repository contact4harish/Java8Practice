package lambdaConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		
		//1) print value of a string using consumer
		Consumer<String> valToPrint=t->System.out.println(t);
		valToPrint.accept("print my name: harish");
		
		//2) print length of each element in the list
		 Consumer<String> setLength =t->System.out.println(t+"'s size::"+t.length());   
	        List<String> li=new ArrayList<>();
	        li.add("Apple");
	        li.add("Tesla");
	        li.forEach(t->setLength.accept(t));
		
	     //3) set value to the User 
	        List<Users> user=new ArrayList<Users>();
	        Users harish=new Users(1, "harish");
	        Users java=new Users(2, "java");
	      Consumer<Users> addUser=t->user.add(t);
	      addUser.accept(harish);
	      addUser.accept(java);
	      user.stream().forEach(System.out::println);

	      //4) remove user from the list of users
	      
	      Consumer<Users> removeUser=t->user.remove(t);
	      removeUser.accept(harish);
	      user.stream().forEach(System.out::println);
	      
	     //5) change the name of the user
	      
	      Consumer<Users> renameUser=t->t.setName("JAVA2");
	      user.stream().filter(t->t.getName().equalsIgnoreCase("java")).forEach(renameUser);
	      user.forEach(System.out::println);
	}


}
