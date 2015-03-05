

import java.util.Scanner;

import jsjf.ArrayStack;

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
			Scanner read = new Scanner(input);
			ArrayStack<String> reverse = new ArrayStack<String>();
			while(read.hasNext())
			{
				String next = read.next();
				char[] ca = next.toCharArray();
				ArrayStack<Character> rc = new ArrayStack<Character>();
				String reversed = "";
				for(char c:ca)
				{
					rc.push(c);
				}
				while(!rc.isEmpty())
				{
					reversed += String.valueOf(rc.pop());
				}
				reverse.push(reversed);
			}
			String reversedString = "";
			while(!reverse.isEmpty())
			{
				reversedString+=(reverse.pop()+" ");
			}
			System.out.println(reversedString);
			System.out.println("Enter 'Y' to do another, press any other key to exit");
			again = scan.nextLine();
			read.close();
		}
		while(again.equalsIgnoreCase("Y"));
		System.out.println("Goodbye");
		scan.close();
	}
}
