package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars1 {
	
	
	static List <Vehicle> vList=CarsList.getVehicles();
	public static void main(String[] args) {
		
		//1
		getListOfVehicles();
		//2
		getCarAndMileageAsMap().forEach((x,y)->System.out.println(x+","+y));
		//3
		getListOfVehicles("Sedan").forEach((x,y)->System.out.println(x+","+y));
		//4
		System.out.println("avg car price: "+avgCarPrice());
		//5
		System.out.println(checkIfAllFuelTypesMatches("Gasolene"));
		//6
		System.out.println(filterVehicleWithTorqueMoreThan(200));
		//7
		updateFuelCapacityOfAVehicle("Camry", 15);

	}
	
//1)print all the vehicles
	public static void getListOfVehicles(){
		vList.stream().forEach(System.out::println);
	}
	
//2)return the list of car and its mileage as map
	 public static Map<String, Integer> getCarAndMileageAsMap(){
	        return vList.stream().collect(Collectors.toMap(l->l.getCarName(),m->m.getFuelCapacity()));

	    }
//3) return the list of car of a kind
	 public static Map<String, List<Vehicle>> getListOfVehicles(String type){
		return vList.stream().collect(Collectors.groupingBy(l->l.getCarType()));
	 }
		
//4) avg price value of the a car
		
		public static Double avgCarPrice(){
	        return vList.stream().collect(Collectors.averagingDouble(l->l.getPrice()));

	    }
//5) all matches of fuel type 
		
		public static boolean checkIfAllFuelTypesMatches(String type) {
			return vList.stream().allMatch(l->l.getFuelType().equals(type));
		}
//6) get all the vehicles with torque >200
		public static Map<String, Integer> filterVehicleWithTorqueMoreThan(int torque) {
		return vList.stream().filter(l->l.getTorque()>torque).collect(Collectors.toMap(l->l.getCarName(), m->m.getTorque()));
		}
//7) operation on the fuel capacity
		public static void updateFuelCapacityOfAVehicle(String name, int capacity) {
		vList.stream()
		.filter(l->l.getCarName().equals(name))
		.map(l->{l.setFuelCapacity(capacity);
		     return l;})
		.forEach(System.out::println);
		
		
		}

}
