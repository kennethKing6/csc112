package jsjf.exceptions;

/**
 * ElementNotFoundException represents the situation in which a target element
 * is not present in a collection
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ElementNotFoundException extends RuntimeException
{
	/**
	 *
	 */
	private static final long	serialVersionUID	= 8065745841566141595L;

	/**
	 * Sets up this exception with an appropriate message.
	 */
	public ElementNotFoundException(String collection)
	{
		super("The target element is not in this " + collection);
	}
}
