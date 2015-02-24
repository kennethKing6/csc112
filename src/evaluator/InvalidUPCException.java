package evaluator;

public class InvalidUPCException extends Exception
{
	private static final long	serialVersionUID	= -8150110507055694777L;
	public final String			upc;

	public InvalidUPCException(String upc)
	{
		this.upc = upc;
	}
}
