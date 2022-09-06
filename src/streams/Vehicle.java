package streams;

public class Vehicle {

	private String carName;
	private String carType;
	private String fuelType;
	private int fuelCapacity;
	private int torque;
	private int bhp;
	private int price;
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getFuelCapacity() {
		return fuelCapacity;
	}
	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	public int getTorque() {
		return torque;
	}
	public void setTorque(int torque) {
		this.torque = torque;
	}
	public int getBhp() {
		return bhp;
	}
	public void setBhp(int bhp) {
		this.bhp = bhp;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	@Override
	public String toString() {
		return "Specifications [carName=" + carName + ", carType=" + carType + ", fuelType=" + fuelType
				+ ", fuelCapacity=" + fuelCapacity + ", torque=" + torque + ", bhp=" + bhp + ", price=" + price + "]";
	}
	public Vehicle(String carName, String carType, String fuelType, int fuelCapacity, int torque, int bhp,
			int price) {
		super();
		this.carName = carName;
		this.carType = carType;
		this.fuelType = fuelType;
		this.fuelCapacity = fuelCapacity;
		this.torque = torque;
		this.bhp = bhp;
		this.price = price;
	}
	
}
