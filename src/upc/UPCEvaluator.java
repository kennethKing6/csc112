package upc;

import java.util.Scanner;

/**
 * UPCEvaluator.java<br>
 * Feb 26, 2015
 * 
 * @author Tim Miller
 */
public class UPCEvaluator
{
	/**
	 * Your friendly neighborhood scanner
	 */
	static Scanner	scan	= new Scanner(System.in);

	/**
	 * This function evaluates a UPC. It returns a 0 if the code is valid, a 1
	 * if the code doesn't begin with a U, P, or C, a 2 if the code is longer
	 * than 2 characters, and a 3 if the code is longer than 2 characters AND it
	 * doesn't begin with a U, P, or C
	 *
	 * @param code
	 *            the code to be evaluated
	 * @return an integer value from 0 to 3
	 */
	public static int evaluate(String code)
	{
		boolean length = false;
		boolean first = false;
		code = code.toUpperCase();
		if (code.length() > 2)
		{
			length = true;
		}
		char firstc = code.charAt(0);
		if ((firstc != 'U') && (firstc != 'P')
					&& (firstc != 'C'))
			{
				first = true;
			}
		if (length || first)
		{
			if (length && first)
			{
				return 3;
			}
			else
				if (length)
				{
					return 2;
				}
				else
				{
					return 1;
				}
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Main method
	 *
	 * @param args
	 *            args
	 */
	public static void main(String... args)
	{
		boolean quit = false;
		do
		{
			System.out.println("Please enter a UPC code: ");
			final String input = UPCEvaluator.scan.nextLine();
			try
			{
				final int code = UPCEvaluator.evaluate(input);
				if (code != 0)
				{
					String msg = "";
					switch (code)
					{
						case 1:
							msg += "Code doesn't begin with a U, P, or C!";
							break;
						case 2:
							msg += "Code is longer than 2 characters";
							break;
						case 3:
							msg += "Code neither begins with a U, P, or C and is longer than 2 characters";
							break;
					}
					throw new InvalidUPCException(msg);
				}
			}
			catch (final InvalidUPCException e)
			{
				System.out.println(e.getMessage());
			}
			System.out.println("Try again? (Y,N)");
			final String again = UPCEvaluator.scan.nextLine();
			if (again.equalsIgnoreCase("n"))
			{
				quit = true;
			}
			else
				if (!again.equalsIgnoreCase("y"))
				{
					System.out
							.println("That's not a Y or an N!  I'll assume you want to quit");
					quit = true;
				}
		}
		while (!quit);
	}
}
