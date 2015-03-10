

import java.util.Scanner;

import jsjf.ArrayStack;

/**
 * Reverse.java<br>
 * Mar 5, 2015
 * @author Tim Miller
 */
public class Reverse
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String again = null;
		do
		{
			System.out.println("Please enter a string");
			String input = scan.nextLine();
			String reversedString = "";
			char[] ca = input.toCharArray();
			ArrayStack<Character> stack = new ArrayStack<Character>();
			for(char c:ca)
			{
				stack.push(c);
			}
			while(!stack.isEmpty())
			{
				reversedString+=stack.pop();
			}
			System.out.println(reversedString);
			System.out.println("Enter 'Y' to do another, press any other key to exit");
			again = scan.nextLine();
		}
		while(again.equalsIgnoreCase("Y"));
		System.out.println("Goodbye");
		scan.close();
	}
}
