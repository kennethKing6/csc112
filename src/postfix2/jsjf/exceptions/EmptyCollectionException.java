package postfix2.jsjf.exceptions;

/**
 * Represents the situation in which a collection is empty.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class EmptyCollectionException extends RuntimeException
{
	private static final long	serialVersionUID	= 5999223261098271041L;

	/**
	 * Sets up this exception with an appropriate message.
	 * 
	 * @param collection
	 *            the name of the collection
	 */
	public EmptyCollectionException(String collection)
	{
		super("The " + collection + " is empty.");
	}
}
