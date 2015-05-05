// Author & Date: Tim Miller 5/5/2015
// Program Name: TreeTest.java
// Description: Test the functionality of a BinaryTree

import java.util.Scanner;

public class TreeTest
{
	// Static variables, objects, etc
	static Scanner	scan	= new Scanner(System.in);

	// Enter all the fields of a Contact object
	public static Contact enterFullContact()
	{
		System.out.print("First name: ");
		final String firstName = TreeTest.scan.nextLine();
		System.out.print("Last name: ");
		final String lastName = TreeTest.scan.nextLine();
		System.out.print("Phone number: ");
		final String phone = TreeTest.scan.nextLine();
		return new Contact(firstName, lastName, phone);
	}

	// Enter only the fields necessary for searching
	public static Contact enterPartialContact()
	{
		System.out.print("First name: ");
		final String firstName = TreeTest.scan.nextLine();
		System.out.print("Last name: ");
		final String lastName = TreeTest.scan.nextLine();
		return new Contact(firstName, lastName, "");
	}

	public static void main(String[] args)
	{
		// local variables, objects, etc
		final BinaryTree<Contact> myTree = new BinaryTree<Contact>();
		boolean goAgain;

		// Go again loop
		do
		{
			// Clear tree from previous run
			final BinaryTree<Contact> tree = new BinaryTree<Contact>();

			// Show that it is empty
			if (myTree.isEmpty())
			{
				System.out.println("The tree is currently empty");
			}
			else
			{
				System.out.println("The tree is not currently empty");
			}

			// seed the tree with 7 contacts and insert them
			final Contact[] friends = new Contact[7];

			friends[0] = new Contact("John", "Smith", "610-555-7384");
			friends[1] = new Contact("Sarah", "Barnes", "215-555-3827");
			friends[2] = new Contact("Mark", "Riley", "733-555-2969");
			friends[3] = new Contact("Laura", "Getz", "663-555-3984");
			friends[4] = new Contact("Larry", "Smith", "464-555-3489");
			friends[5] = new Contact("Frank", "Phelps", "322-555-2284");
			friends[6] = new Contact("Marsha", "Grant", "243-555-2837");

			// insert each Contact into the tree
			for (final Contact friend : friends)
			{
				tree.insertNode(friend);
			}

			// Add at least 1 additional contact
			System.out
					.print("How many contacts do you wish to add to the tree? ");
			final int additions = TreeTest.scan.nextInt();
			TreeTest.scan.nextLine();

			for (int i = 1; i <= additions; i++)
			{
				System.out.println("\nEnter #" + i + ": ");
				tree.insertNode(TreeTest.enterPartialContact());
			}

			// Traverse tree using 3 methods
			System.out.println("\nInOrder Transversal");
			tree.displayInOrder();
			System.out.println("\nPreOrder Transversal");
			tree.displayPreOrder();
			;
			System.out.println("\nPostOrder Transversal");
			tree.displayPostOrder();
			System.out.println("\nUsing toString");
			System.out.println(tree.toString());

			// show that the tree is not empty
			if (myTree.isEmpty())
			{
				System.out.println("The tree is empty");
			}
			else
			{
				System.out.println("The tree is not empty");
			}

			// Show the height of the tree, size of the tree and the # of leaves
			System.out.println("Tree height is " + tree.height());
			System.out.println("Size of tree is " + tree.size());
			System.out.println("The number of leaves is " + tree.numLeaf());

			// Search the tree for a node
			System.out.println("\nFind which node in the tree? ");
			final Contact find = TreeTest.enterPartialContact();
			// Search the tree if the friend is present or not present (true or false)
			System.out.println(find + " is in this tree is "
					+ tree.search(find));

			// Delete a node from the tree
			System.out.println("\nDelete which node in the tree? ");
			final Contact delete = TreeTest.enterPartialContact();
			// remove the friend from the tree
			tree.remove(delete);
			;
			System.out
					.println(delete
							+ " has been processed, check to see if it has been removed.");
			System.out.println("\nInOrder Transversal");
			tree.displayInOrder();

			// Go Again?
			System.out.println("\nGo Again (y/n)? ");
			goAgain = TreeTest.scan.nextLine().equalsIgnoreCase("y");
		}
		while (goAgain);
		TreeTest.scan.close();
	}
}

/**************************
 * SAMPLE OUTPUT *****************************
 **********************************************************************/
