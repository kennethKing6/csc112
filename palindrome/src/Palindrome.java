import java.util.Scanner;

import jsjf.LinkedStack;
import jsjf.StackADT;


/**
 * Palindrome.java<br>
 * Mar 31, 2015
 * @author Tim Miller
 */
public class Palindrome
{
	public static void main(String... args)
	{
		Scanner scan = new Scanner(System.in);
		String again = null;
		do
		{
			System.out.print("Please enter a string: ");
			String string = scan.nextLine();
			StackADT<Character> stack = new LinkedStack<Character>();
			for(Character c:string.toCharArray())
			{
				stack.push(c);
			}
			String newString = "";
			while(!stack.isEmpty())
			{
				newString += stack.pop();
			}
			if(string.equalsIgnoreCase(newString))
				System.out.println("The string is a palindrome");
			else
				System.out.println("The string is not a palindrome");
			System.out.println("Enter 'Y' to go again, enter another character to quit");
			again = scan.nextLine();
		}
		while(again.equalsIgnoreCase("Y"));
		scan.close();
	}
}
