import java.util.Scanner;

import jsjf.LinkedStack;
import jsjf.exceptions.EmptyCollectionException;

/**
 * NameStack.java<br>
 * Mar 10, 2015
 * @author Tim Miller
 */
public class NameStack
{
	/**
	 * The number of names to be used
	 */
	public static final int QUANT = 6;
	
	/**
	 * The entry point of the program
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		String again;
		do
		{
			System.out.println("Creating new stack");
			LinkedStack<String> nameStack = new LinkedStack<String>();
			if(nameStack.isEmpty())
				System.out.println("The stack is empty");
			else
				System.out.println("The stack is not empty");
			try
			{
				System.out.println("Peeking...");
			}
			catch(EmptyCollectionException e)
			{
				System.out.println(e.getMessage());
			}
			System.out.println("Please enter " + QUANT + " full names");
			for(int count = 0;count<QUANT;count++)
			{
				System.out.print("Name " + (count+1) + ": ");
				nameStack.push(new Scanner(System.in).nextLine());
			}
			System.out.println("The size of the stack is " + nameStack.size());
			if(nameStack.isEmpty())
				System.out.println("The stack is empty");
			else
				System.out.println("The stack is not empty");
			System.out.println(nameStack.toString());
			System.out.println("The top entry of the stack is " + nameStack.peek());
			for(int count = 0;count<3;count++)
				System.out.println(nameStack.pop());
			System.out.println("Size = " + nameStack.size());
			System.out.println(nameStack.toString());
			System.out.println("Would you like to run the tests again? (Enter 'Y' to continue, or enter anything else to quit)");
			again = new Scanner(System.in).nextLine();
		}
		while(again.equalsIgnoreCase("Y"));
	}
}
