package xyz.voxio.csc112.caesar;

import java.util.Scanner;

// ********************************************************************
// SecretTest.java Java Foundations
//
// Demonstrates the use of a formal interface.
// ********************************************************************

public class SecretTest
{
	// -----------------------------------------------------------------
	// Creates a Secret object and exercises its encryption.
	// -----------------------------------------------------------------
	public static void main(String[] args)
	{
		final Scanner scan = new Scanner(System.in);
		System.out.println("Enter some text please");
		final Secret hush = new Secret(scan.nextLine());

		System.out.println(hush);

		hush.encrypt();
		System.out.println(hush);

		hush.decrypt();
		System.out.println(hush);
		scan.close();
	}
}
