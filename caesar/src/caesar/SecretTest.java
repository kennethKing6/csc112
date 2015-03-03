package caesar;

import java.util.Scanner;

/**
 * Test class for Secret.class
 *
 * @author Tim Miller - Feb 12, 2015
 */
public class SecretTest
{
	public static void main(String[] args)
	{
		Scanner scan = null;
		String again = null;

		do
		{
			scan = new Scanner(System.in);
			System.out.println("Enter some text please:");
			final Secret hush = new Secret(scan.nextLine());

			System.out.println(hush);

			hush.encrypt();
			System.out.println(hush);

			hush.decrypt();
			System.out.println(hush);

			System.out
					.println("Would you like to encrypt another message? (Enter 'y' for yes, press any other key to exit");
			again = scan.nextLine();
		}
		while (again.equalsIgnoreCase("y"));
		scan.close();
	}
}
