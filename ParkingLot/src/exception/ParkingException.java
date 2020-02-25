package exception;

public class ParkingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ParkingException(String message, Throwable throwable)
	{
		super(message, throwable);
	}
	
	/**
	 * @param message
	 */
	public ParkingException(String message)
	{
		super(message);
	}
	/**
	 * @param throwable
	 */
	public ParkingException(Throwable throwable)
	{
		super(throwable);
	}
}
