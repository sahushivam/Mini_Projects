/**
 * 
 */
package data.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sahushivam
 * used for validation
 */
public class CommandInputMap {
private static volatile Map<String, Integer> commandsParameterMap = new HashMap<String, Integer>();
	
	static
	{
		commandsParameterMap.put(Constants.CREATE, 1);
		commandsParameterMap.put(Constants.PARK, 2);
		commandsParameterMap.put(Constants.LEAVE, 1);
		commandsParameterMap.put(Constants.REG_NUMBERS, 1);
		commandsParameterMap.put(Constants.SLOT_AGE, 1);
		commandsParameterMap.put(Constants.SLOT_REG, 1);
	}
	
	public static Map<String, Integer> getCommandsParameterMap()
	{
		return commandsParameterMap;
	}

	public static void addCommand(String command, int parameterCount)
	{
		commandsParameterMap.put(command, parameterCount);
	}
}
