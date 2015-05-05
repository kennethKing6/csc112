/**
 * Generic binary tree, storing data of a parametric type in each node
 *
 * @author Richard Specioso
 * @param <E>
 */
public class BinaryTree<E extends Comparable<E>>
{
	private TreeNode<E>	root;	// children; can be null

	/**
	 * Constructor for the tree. Sets the root of the tree to null.
	 * By default the tree is empty.
	 */
	public BinaryTree()
	{
		this.root = null;
	}

	public void clearTree()
	{
		this.root = null;
	}

	/**
	 * Displays the object in the tree in order. This method calls
	 * displayInOrder passing it the root which is the starting point.
	 */
	public void displayInOrder()
	{
		this.displayInOrder(this.root);
	}

	/**
	 * Displays the object in the tree in order. This is a private method
	 * which is called by the public method called displayInOrder. This
	 * method uses recursion to display all of the values in the tree.
	 * The base case for the recursion is when the node passed in is null.
	 *
	 * @param node
	 */
	private void displayInOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			this.displayInOrder(node.left);
			System.out.println(node.value);
			this.displayInOrder(node.right);
		}
	}

	/**
	 * Displays the object in the tree Post order. This method calls
	 * displayPostOrder passing it the root which is the starting point.
	 */
	public void displayPostOrder()
	{
		this.displayPostOrder(this.root);
	}

	/**
	 * Displays the object in the tree post order. This is a private method
	 * which is called by the public method called displayPostOrder. This
	 * method uses recursion to display all of the values in the tree.
	 * The base case for the recursion is when the node passed in is null.
	 *
	 * @param node
	 */
	private void displayPostOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			this.displayPostOrder(node.left);
			this.displayPostOrder(node.right);
			System.out.println(node.value);
		}

	}

	/**
	 * Displays the object in the tree Pre order. This method calls
	 * displayPreOrder passing it the root which is the starting point.
	 */
	public void displayPreOrder()
	{
		this.displayPreOrder(this.root);
	}

	/**
	 * Displays the object in the tree in preorder. This is a private method
	 * which is called by the public method called displayPreOrder. This
	 * method uses recursion to display all of the values in the tree.
	 * The base case for the recursion is when the node passed in is null.
	 *
	 * @param node
	 */
	private void displayPreOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			System.out.println(node.value);
			this.displayPreOrder(node.left);
			this.displayPreOrder(node.right);
		}
	}

	private E getMin(TreeNode<E> node)
	{
		if (node.left == null)
		{
			return node.value;
		}
		else
		{
			return this.getMin(node.left);
		}
	}

	/**
	 * This method determines the height of the tree.
	 *
	 * @return the height of the tree
	 */
	public int height()
	{
		return this.heightOfBinaryTree(this.root);
	}

	/**
	 * Helper function to find the height of the tree using recursion.
	 *
	 * @param node
	 *            - the starting point for the recursive calls.
	 * @return the height of each sub tree back to the root of the tree.
	 */
	private int heightOfBinaryTree(TreeNode<E> node)
	{
		if (node == null)
		{
			return -1;
		}
		else
		{
			return 1 + Math.max(this.heightOfBinaryTree(node.left),
					this.heightOfBinaryTree(node.right));
		}
	}

	/**
	 * The insert method will check method the new node is a child of the node passed in.
	 * If it is not a child of the current node then it will check if it belong on the left
	 * or the right side of the current node. It will use recursion to determine where the
	 * new node will be located.
	 *
	 * @param node1
	 *            this is the node to check if the new node needs to be child of
	 * @param obj
	 *            the object for which the new node will be created for
	 * @return the current node so the tree can be recreated
	 */
	private TreeNode<E> insert(TreeNode<E> node1, E obj)
	{
		if (node1 == null)
		{
			node1 = new TreeNode<E>(obj);
		}
		else if (obj.compareTo(node1.value) < 0)
		{
			node1.left = this.insert(node1.left, obj);
		}
		else
		{
			node1.right = this.insert(node1.right, obj);
		}
		return node1;
	}

	/**
	 * This is the insert mode called from outside the class to add a node
	 * to the tree. The object that needs to be added is passed in. This method
	 * will call the private insert method providing it the root as the starting
	 * point to determine where the new node needs to be added to.
	 *
	 * @param obj
	 */
	public void insertNode(E obj)
	{
		this.root = this.insert(this.root, obj);
	}

	public Boolean isEmpty()
	{
		if (this.root == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * This method determines how many levels the tree has.
	 *
	 * @return the number of levels in the tree.
	 */
	public int levels()
	{
		return 0;
	}

	/**
	 * This method determines the number of leaves the tree has.
	 *
	 * @return the number of leaves in the tree.
	 */
	public int numLeaf()
	{
		return this.numLeaf(this.root);
	}

	/**
	 * This is a helper method to count the number of leaves in a tree.
	 * This method uses recursion to count the leaves but traversing the
	 * sub trees starting at the root.
	 *
	 * @param node
	 * @return
	 */
	private int numLeaf(TreeNode<E> node)
	{
		if (node == null) { return 0; }
		if ((node.left == null) && (node.right == null))
		{
			return 1;
		}
		else
		{
			return this.numLeaf(node.left) + this.numLeaf(node.right);
		}
	}

	/**
	 * This method will remove an object form the tree. It calls
	 * deleteNode passing it the object to look for and the root
	 * which is the starting point.
	 *
	 * @param obj
	 *            the object to remove from the list.
	 */
	public void remove(E obj)
	{
		this.root = this.remove(this.root, obj);
	}

	/**
	 * This method will remove a node from the tree that contains an
	 * object that matches the obj parameter. The node parameter is the
	 * current node the method is checking and allows the method to use
	 * recursion to attempt to find the object in the tree.
	 *
	 * @param obj
	 *            the object used to determine which node to remove from the tree
	 * @param node
	 *            the starting point for this instance of the recursive calls
	 * @return the node as the recursion ends to rebuild the tree without the deleted node
	 */
	private TreeNode<E> remove(TreeNode<E> node, E obj)
	{

		if (node == null)
		{
			node = node;
		}
		else if (obj.compareTo(node.value) < 0)
		{
			node.left = this.remove(node.left, obj);
		}
		else if (obj.compareTo(node.value) > 0)
		{
			node.right = this.remove(node.right, obj);
		}
		else
			// this is the node to remove
		{
			if ((node.left == null) && (node.right == null))
			{
				node = null;
			}
			else if (node.right == null)
			{
				node = node.left;
			}
			else if (node.left == null)
			{
				node = node.right;
			}
			else
				// both children; replace with minimum value from right subtree
			{
				final E min = this.getMin(node.right);            // find the min value on the right
				node.right = this.remove(node.right, min); // remove the min node and make it the new right
				node.value = min;                      // replace value in node to remove with min value.
				// note the node is not really removed, just replaced
				// node with min value is removed.
			}

		}
		return node;
	}

	public boolean search(E obj)
	{
		boolean result;

		if (this.root == null)
		{
			result = false;
		}
		else
		{
			result = this.searchNode(this.root, obj);
		}

		return result;

	}

	/**
	 * This method searches the tree for a specific obj. If the object
	 * is in the tree it will return true otherwise false.
	 *
	 * @param node
	 *            the node in the tree to compare to.
	 * @param obj
	 *            the object to search the tree for
	 * @return true if the object is in the tree, false otherwise
	 */

	private boolean searchNode(TreeNode<E> node, E obj)
	{
		boolean result;

		if (node == null)
		{
			result = false;
		}
		else if (obj.compareTo(node.value) == 0)
		{
			result = true;
		}
		else if (obj.compareTo(node.value) < 0)
		{
			result = this.searchNode(node.left, obj);
		}
		else
		{
			result = this.searchNode(node.right, obj);
		}

		return result;
	}

	/**
	 * This method determines how many nodes the tree has.
	 *
	 * @return the number of levels in the tree.
	 */
	public int size()
	{
		return this.sizeOfBinaryTree(this.root);
	}

	/**
	 * A helper function to count the number of nodes in the tree.
	 * This method uses recursion to determine the number of nodes
	 * in the tree by traversing the sub-trees of the root.
	 *
	 * @param node
	 * @return
	 */
	private int sizeOfBinaryTree(TreeNode<E> node)
	{
		if (node == null)
		{
			return 0;
		}
		else
		{
			return 1 + this.sizeOfBinaryTree(node.left)
					+ this.sizeOfBinaryTree(node.right);
		}
	}

	/**
	 * Provide the items in the tree as one big formatted string. Calls
	 * the helper function by providing the root as the starting point.
	 *
	 * @return the string with all the data in the tree.
	 */
	@Override
	public String toString()
	{
		String ret = "";

		ret = this.toStringHelper(this.root);

		return ret;
	}

	/**
	 * This method helps the toString method to create the string of
	 * all the object stored in the tree. This method uses recursion
	 * to traverse the tree to create the string of all the data in the
	 * tree. Each call to this method creates part of the complete
	 * string.
	 *
	 * @param node
	 *            The current node to build the string with.
	 * @return part of the complete string of all the data in the tree.
	 */
	public String toStringHelper(TreeNode<E> node)
	{
		String ret = "";
		if (node.right != null)
		{
			ret += this.toStringHelper(node.right);
		}

		ret += node.value + "\n";

		if (node.left != null)
		{
			ret += this.toStringHelper(node.left);
		}

		return ret;
	}
}
