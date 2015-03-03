package upc;

/**
 * InvalidUPCException.java<br>
 * Feb 26, 2015
 * 
 * @author Tim Miller
 */
public class InvalidUPCException extends Exception
{
	private static final long	serialVersionUID	= 7516079767840956119L;

	/**
	 * @param message
	 *            a message to be handled by the exception
	 */
	public InvalidUPCException(String message)
	{
		super(message);
	}
}
