package data;


public class Car extends Vehicle{
	private String registrationNo;
	private int driverAge;
	public Car(String registrationNo, int driverAge)
	{
		super(registrationNo, driverAge);
		this.registrationNo = registrationNo;
		this.driverAge = driverAge;
	}
	public String getRegNo() {
		return registrationNo;
	}

	public int getAge() {
		return driverAge;
	}
}
