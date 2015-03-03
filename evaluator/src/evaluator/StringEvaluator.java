package evaluator;

import java.util.Scanner;

/**
 * StringEvaluator.java<br>
 * Feb 26, 2015
 * 
 * @author Tim Miller
 */
public class StringEvaluator
{
	/**
	 * The scanner
	 */
	static Scanner	scan	= new Scanner(System.in);

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
			System.out.println("Please enter a string: ");
			final String input = StringEvaluator.scan.nextLine();
			try
			{
				if (input.length() > 20)
				{
					throw new StringTooLongException();
				}
				else
				{
					System.out.println("That string is just right!");
				}
			}
			catch (final StringTooLongException e)
			{
				System.out.println("That string is too long!");
			}
			System.out.println("Try again? (Y,N)");
			final String again = StringEvaluator.scan.nextLine();
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
