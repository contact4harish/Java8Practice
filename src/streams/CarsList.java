package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarsList {
	
	
	 static List<Vehicle> cList=new ArrayList<>();
	
	public static List<Vehicle> getVehicles(){
		
		//public Vehicle(String carName, String carType, String fuelType, int fuelCapacity, int torque, int bhp,int price) {
		Vehicle camry=new Vehicle("Camry", "Sedan", "Gasolene", 14, 182, 202, 28000);
		Vehicle cherokee=new Vehicle("Cherokee", "4X4", "Gasolene", 16, 240, 271, 34000);
		Vehicle accord=new Vehicle("Accord", "Sedan", "Gasolene", 13, 180, 205, 29000);
		Vehicle mustang=new Vehicle("Mustang", "Sport", "Gasolene", 16, 420, 470, 53000);
		//1) add objs from array to list
		//cList=Arrays.asList(camry, cherokee, accord, mustang);
		cList.add(cherokee);
		cList.add(mustang);
		cList.add(accord);
		cList.add(camry);
		
		return cList;
		
	} 

}
