package data;


public abstract class Vehicle {
	private String registrationNo	=	null;
	private int driverAge		 	=	-1;

  	public Vehicle(String registrationNo, int driverAge)
	{
		this.registrationNo = registrationNo;
		this.driverAge = driverAge;
	}
	//getter
	public String getRegistrationNo()
	{
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo)
	{
		this.registrationNo = registrationNo;
	}
	//setter
	public int getDriverAge()
	{
		return driverAge;
	}
	public void setDriverAge(int driverAge)
	{
		this.driverAge = driverAge;
	}
}
