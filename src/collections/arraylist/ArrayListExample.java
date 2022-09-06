package collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListExample {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		//1)add element into list
		list.add("String");
        list.add("Integer");
        
        //2)get the elements from the list or type of iterations -1
        list.forEach(System.out::println);
        
        //List internally uses iterable class (which has iterator / foreach /spliterator)
        
        //3) type of iterations -2
        for(String st:list) {
        System.out.println(st);
        }
        
        //4) type of iterations -3
        Iterator<String> itr =list.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        
        //4) add another list to a list
    	List<String> list2=new ArrayList<>();
    	list2.add("Double");
        list2.add("Generic");
        
        list.addAll(list2);
        
        //5) basic sort
        Collections.sort(list);
           //sort in descending order
        
        
        //6) advanced sort
        //create class / pojo - use compareTo method in the comparator class 
        
        //7) reverse of a list -1
        ListIterator<String> itr3 =list.listIterator();
        
        //8) duplicates in arraylist
        
        List<Integer> list3=new ArrayList<>();
    	list3.add(1);
        list3.add(2);
        list3.add(2);
        list3.add(5);
        
        //9) All 1's to left
        
        Integer[] num= {1,0,0,1,0,0,1,1,1,0,1};
        List<Integer> arr = Arrays.asList(num);
        System.out.println(arr+"  ::arr");
        int i=0;
        int j=arr.size()-1;
        while(i<=arr.size()/2) {
        
      if ((arr.get(i)==1 ) && (arr.get(j)==1)) {
          i++;
      
        }
      else if((arr.get(i)==0 ) && (arr.get(j)==0)) {
    	  j--;
      }
      else {
    	Integer temp=  arr.get(i);
    	arr.set(i, arr.get(j));
    	arr.set(j, temp);
    	i++;
    	j--;
      }
          
	}
        System.out.println(arr+"  ::arranged arr");  
	}
	
	
	
     
}
