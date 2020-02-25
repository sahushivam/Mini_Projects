package main;

import data.Car;
import data.Commands;
import data.Vehicle;
import data.constants.CommandInputMap;
import exception.ParkingException;

public class ProcessorImpl {
	Impl parkingLot = null;
	public boolean validate(String inputString) {
		// TODO Auto-generated method stub
		boolean valid = true;
		try
		{
			String[] inputs = inputString.split(" ");
			int params = CommandInputMap.getCommandsParameterMap().get(inputs[0]);
			switch (inputs.length)
			{
				case 1:
					if (params != 0) // e.g status -> inputs = 1
						valid = false;
					break;
				case 2:
					if (params != 1) // create_parking_lot 6 -> inputs = 2
						valid = false;
					break;
				case 3:
					if (params != 2) // park KA-01-P-333 White -> inputs = 3
						valid = false;
					break;
				default:
					valid = false;
			}
		}
		catch (Exception e)
		{
			valid = false;
		}
		return valid;
	}

	public void execute(String line) throws ParkingException {
		// TODO Auto-generated method stub
		String[] commandLine = line.split(" ");
		String command = commandLine[0];
		String regNo;
		int age;
		int parkingres;
		int num;
		switch(Commands.getCommand(command)){
		case CREATE:
			int count= Integer.parseInt(commandLine[1]);
			if(parkingLot==null)
			{
				parkingLot = new Impl(count);
				System.out.println("Created a parking of "+count+" slots");
			}
			else
			{
				throw new ParkingException("Parking already exists");
			}
			break;
		case LEAVE:
			num = Integer.parseInt(commandLine[1]);
			Vehicle c = parkingLot.leaveCar(num-1);
			System.out.println("Slot number "+num+" vacated, the car with vehicle registration number \""
					+ c.getRegistrationNo()+ "\" left the space, the driver of the car was of age "
					+ c.getDriverAge());
			break;
		case PARK:
			regNo = commandLine[1];
			age = Integer.valueOf(commandLine[3]);
			parkingres =parkingLot.parkCar(new Car(regNo, age));
			if(parkingres != -1){
				System.out.println("Car with vehicle registration number \""+ regNo +"\" has been parked at slot number"
						+ " " + parkingres);
			}
			else
				System.out.println("Sorry, parking lot is full");
			break;
		case REG_NUMBERS:
			age = Integer.valueOf(commandLine[1]);
			parkingLot.getRegNumberForAge(age);
			break;
		case SLOT_AGE:
			age = Integer.valueOf(commandLine[1]);
			parkingLot.getSlotNumberForAge(age);
			break;
		case SLOT_REG:
			regNo = commandLine[1];
			parkingres = parkingLot.getSlotNumberForReqNumber(regNo);
			if(parkingres != -1){
				System.out.println(parkingres);
			}
			else
				System.out.println("Car with given registration Number is not at Parking");
			break;
		default:
			System.out.println("Command Not found");
		}
	}
}
