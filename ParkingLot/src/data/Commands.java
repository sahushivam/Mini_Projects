package data;
import data.constants.*;
public enum Commands {
	CREATE,PARK,LEAVE,STATUS, REG_NUMBERS, SLOT_REG, SLOT_AGE, COMMAND_NOT_FOUND;
	
	public static Commands getCommand(String comm){
		if(Constants.CREATE.equals(comm))
			return CREATE;
		else if(Constants.PARK.equals(comm))
			return PARK;
		else if(Constants.LEAVE.equals(comm))
			return LEAVE;
		else if(Constants.REG_NUMBERS.equals(comm))
			return REG_NUMBERS;
		else if(Constants.SLOT_AGE.equals(comm))
			return SLOT_AGE;
		else if(Constants.SLOT_REG.equals(comm))
			return SLOT_REG;
		else
			return COMMAND_NOT_FOUND;
	}
}
