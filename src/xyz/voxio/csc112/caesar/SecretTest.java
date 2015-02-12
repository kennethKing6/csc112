package xyz.voxio.csc112.caesar;

import java.util.Scanner;


/**
 * Test class for Secret.class
 * @author Tim Miller - Feb 12, 2015
 * 
 */
public class SecretTest
{
	public static void main(String[] args)
	{
		//Take in input, generate secret
		final Scanner scan = new Scanner(System.in);
		System.out.println("Enter some text please");
		final Secret hush = new Secret(scan.nextLine());

		//Print out the original text
		System.out.println(hush);

		//Print out the encrypted text
		hush.encrypt();
		System.out.println(hush);

		//Print the original text
		hush.decrypt();
		System.out.println(hush);
		scan.close();
	}
}
