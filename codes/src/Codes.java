import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Codes demonstrates the use of queues to encrypt and decrypt messages.
 *
 * @author Java Foundations
 * @version 4.0
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
			final Queue<Integer> encodingQueue = new LinkedList<Integer>();
			final Queue<Integer> decodingQueue = new LinkedList<Integer>();
			// load key queues
			for (final int element : key)
			{
				encodingQueue.add(element);
				decodingQueue.add(element);
			}
			
			// encode message
			for (int index = 0; index < message.length(); index++)
			{
				keyValue = encodingQueue.remove();
				encoded += (char) (message.charAt(index) + keyValue);
				encodingQueue.add(keyValue);
			}
			System.out.println("Encoded Message:\n" + encoded + "\n");
			
			// decode message
			for (int index = 0; index < encoded.length(); index++)
			{
				keyValue = decodingQueue.remove();
				decoded += (char) (encoded.charAt(index) - keyValue);
				decodingQueue.add(keyValue);
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
