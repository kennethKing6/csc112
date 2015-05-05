/**
 * This is the node of in a tree. It holds a value and two references to its
 * left and right child nodes.
 *
 * @author Richard Specioso
 * @param <T>
 */
public class TreeNode<T extends Comparable<T>>
{
	TreeNode<T>	left;
	TreeNode<T>	right;
	T			value;

	TreeNode(T obj)
	{
		this.left = null;
		this.right = null;
		this.value = obj;
	}

	public int compareTo(TreeNode<T> other)
	{
		return (this.value.compareTo(other.value));
	}
}
