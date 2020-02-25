package data;

public class ParkingLot {
	private int slotNumber;
	private Vehicle vehicle;
	ParkingLot(int slotNo, Vehicle c){
		this.slotNumber = slotNo;
		this.vehicle = c;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
}
