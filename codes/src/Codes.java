import java.util.Scanner;

import jsjf.LinkedQueue;
import jsjf.QueueADT;

/**
 * Codes.java<br>
 * Mar 25, 2015
 * @author Tim Miller
 */
public class Codes
{
	/**
	 * Encode and decode a message using a key of values stored in
	 * a queue.
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String again;
		do
		{
			int[] key;
			int keysize;
			Integer keyValue;
			String encoded = "", decoded = "", message = "";
			
			System.out.println("Please enter a message: ");
			message = scan.nextLine();
			System.out.println("Please enter the length of the key");
			keysize = scan.nextInt();
			key = new int[keysize];
			for (int index = 0; index < keysize; index++)
			{
				System.out.println("Please enter key index " + (index + 1)
						+ ": ");
				key[index] = scan.nextInt();
			}
			System.out.println("\nOriginal Message: \n" + message + "\n");
			final QueueADT<Integer> encodingQueue = new LinkedQueue<Integer>();
			final QueueADT<Integer> decodingQueue = new LinkedQueue<Integer>();
			// load key queues
			for (final int element : key)
			{
				encodingQueue.enqueue(element);
				decodingQueue.enqueue(element);
			}
			
			// encode message
			for (int index = 0; index < message.length(); index++)
			{
				keyValue = encodingQueue.dequeue();
				encoded += (char) (message.charAt(index) + keyValue);
				encodingQueue.enqueue(keyValue);
			}
			System.out.println("Encoded Message:\n" + encoded + "\n");
			
			// decode message
			for (int index = 0; index < encoded.length(); index++)
			{
				keyValue = decodingQueue.dequeue();
				decoded += (char) (encoded.charAt(index) - keyValue);
				decodingQueue.enqueue(keyValue);
			}
			System.out.println("Decoded Message:\n" + decoded);
			
			scan = new Scanner(System.in);
			System.out
					.println("Go again? (Enter 'Y' to run again, enter any other character to exit)");
			again = scan.nextLine();
		}
		while (again.equalsIgnoreCase("Y"));
		scan.close();
	}
}
