import java.util.Scanner;

/**
 * RecursiveMult.java<br>
 * Apr 16, 2015
 *
 * @author Tim Miller
 */
public class RecursiveMult
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		final String QUIT = "q";
		final Scanner scan = new Scanner(System.in);
		String pr;
		do
		{
			System.out.print("Please enter a number: ");
			final int x = Integer.parseInt(scan.nextLine());
			System.out.print("Please enter a second number: ");
			final int y = Integer.parseInt(scan.nextLine());
			System.out.println(RecursiveMult.recurseMult(x, y));
			System.out
			.print("Go again? ('q' to quit, else enter anything to go again): ");
			pr = scan.nextLine();
		}
		while (!pr.equalsIgnoreCase(QUIT));
		scan.close();
	}

	/**
	 * return the product of two given integers, found through recursive addition
	 *
	 * @param x
	 *            the multiplicand
	 * @param y
	 *            the multiplier
	 * @return the product of x and y
	 */
	public static int recurseMult(int x, int y)
	{
		// Begin the recursive multiplication algorithm, beginning the working total with 0
		return RecursiveMult.recurseMult(0, x, y, false);
	}

	/**
	 * @param workingTotal
	 *            the working total
	 * @param x
	 *            the multiplicand
	 * @param y
	 *            the multiplier
	 * @return the product of x and y
	 */
	private static int recurseMult(int workingTotal, int x, int y, boolean neg)
	{
		neg = neg || ((x < 0) ^ (y < 0));
		x = Math.abs(x);
		y = Math.abs(y);
		if (x == 0)
		{
			if (neg)
			{
				return 0 - workingTotal;
			}
			else
			{
				return workingTotal;
			}
		}
		else
		{
			workingTotal += y;
			x--;
			return RecursiveMult.recurseMult(workingTotal, x, y, neg);
		}
	}
}
