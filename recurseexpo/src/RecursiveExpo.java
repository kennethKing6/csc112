import java.util.Scanner;

public class RecursiveExpo
{
	private static int exp(int num, int pow)
	{
		if(pow==0)
		{
			return 1;
		}
		else
		{
			return num * exp(num, pow-1);
		}
	}

	public static void main(String[] args)
	{
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		do
		{
			System.out
					.println("Please enter two values, x and y respectively, to calculate x ^ y");
			System.out.print("x: ");
			final int x = scan.nextInt();
			scan.nextLine();
			System.out.print("y: ");
			final int y = scan.nextInt();
			scan.nextLine();
			final int z = RecursiveExpo.exp(x, y);
			System.out.println("" + x + " ^ " + y + " = " + z);
			System.out.println("Enter 'q' to quit, enter anything else to go again");
			System.out.print("> ");
			String response = scan.nextLine();
			running = !response.equalsIgnoreCase("q");
			scan = new Scanner(System.in);
		}
		while (running);
		System.out.println("Goodbye");
		scan.close();
	}
}
