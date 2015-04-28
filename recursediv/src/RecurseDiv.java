import java.util.Scanner;

/**
 * RecurseDiv.java<br>
 * Apr 21, 2015
 * 
 * @author Tim Miller
 */
public class RecurseDiv
{
	public static void main(String[] args)
	{
		boolean running = true;
		final Scanner scan = new Scanner(System.in);
		do
		{
			System.out.println("Please enter a dividend");
			final int x = scan.nextInt();
			System.out.println("Please enter a divisor");
			final int y = scan.nextInt();
			try
			{
				System.out.println(RecurseDiv.recursediv(x, y));
			}
			catch (final Exception e)
			{
				System.out
				.println("An error occurred, please see stacktrace for details");
				e.printStackTrace();
			}
			System.out
			.println("Would you like to go again ('q' to  quit, else continue)");
			scan.nextLine();
			running = !scan.nextLine().equalsIgnoreCase("q");
		}
		while (running);
		scan.close();
		System.out.println("Goodbye!");
	}

	public static int recursediv(int a, int b)
	{
		if(a > b)
		{
			return 1 + recursediv(a-b,b);
		}
		else return 0;
	}
}
