package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import data.Vehicle;

public class Impl{
	private int capacity;
	private int availability;
	private HashMap<Integer,Vehicle> parkingLotMap ;
	private TreeSet<Integer> freeSlots;
	
	public Impl(int c){
		capacity =c;
		availability = c;
		parkingLotMap = new HashMap<Integer, Vehicle>();
		freeSlots = new TreeSet<Integer>();
		for(int i=0;i<capacity;i++){
			parkingLotMap.put(i, null);
			freeSlots.add(i);
		}
	}
	public int parkCar(Vehicle c){
		int nextAvail;
		if(availability == 0){
			return -1;
		}
		else{
			nextAvail = freeSlots.first();
			parkingLotMap.put(nextAvail, c);
			availability--;
			freeSlots.remove(nextAvail);
		}
		return (nextAvail+1);
	}
	public Vehicle leaveCar(int slotNum){
		availability++;
		freeSlots.add(slotNum);
		Vehicle c = parkingLotMap.get(slotNum);
		parkingLotMap.put(slotNum, null);
		return c;
	}
	
	public void getRegNumberForAge(int age){
		List<String> res = new ArrayList<String>();
		for(int i=0;i<capacity;i++){
			Vehicle r = parkingLotMap.get(i);
			if(r != null && age == r.getDriverAge()){
				res.add(r.getRegistrationNo());
			}
		}
		if(res.size()==0)
			System.out.println("");
		else
			printStringList(res);
	}
	public void getSlotNumberForAge(int age){
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<capacity;i++){
			Vehicle r = parkingLotMap.get(i);
			if(r != null && age == r.getDriverAge()){
				res.add(i+1);
			}
		}
		if(res.size()==0)
			System.out.println("");
		else
			printIntegerList(res);
	}
	
	private void printIntegerList(List<Integer> list){
		int i=0;
		for(i=0;i<list.size()-1;i++){
			System.out.print(list.get(i)+", ");
		}
		System.out.println(list.get(i));
	}
	
	private void printStringList(List<String> list){
		int i=0;
		for(i=0;i<list.size()-1;i++){
			System.out.print(list.get(i)+", ");
		}
		System.out.println(list.get(i));
	}

	public int getSlotNumberForReqNumber(String regNum){
		int res=-1;
		for(int i=0;i<capacity;i++){
			Vehicle r = parkingLotMap.get(i);
			if(r != null && regNum.equals(r.getRegistrationNo())){
				res = i+1;
			}
		}
		return res;
	}
}
