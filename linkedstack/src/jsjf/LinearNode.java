package jsjf;

/**
 * Represents a node in a linked list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinearNode<T>
{
	private T				element;
	private LinearNode<T>	next;

	/**
	 * Creates an empty node.
	 */
	public LinearNode()
	{
		this.next = null;
		this.element = null;
	}

	/**
	 * Creates a node storing the specified element.
	 * 
	 * @param elem
	 *            element to be stored
	 */
	public LinearNode(T elem)
	{
		this.next = null;
		this.element = elem;
	}

	/**
	 * Returns the element stored in this node.
	 * 
	 * @return element stored at the node
	 */
	public T getElement()
	{
		return this.element;
	}

	/**
	 * Returns the node that follows this one.
	 * 
	 * @return reference to next node
	 */
	public LinearNode<T> getNext()
	{
		return this.next;
	}

	/**
	 * Sets the element stored in this node.
	 * 
	 * @param elem
	 *            element to be stored at this node
	 */
	public void setElement(T elem)
	{
		this.element = elem;
	}

	/**
	 * Sets the node that follows this one.
	 * 
	 * @param node
	 *            node to follow this one
	 */
	public void setNext(LinearNode<T> node)
	{
		this.next = node;
	}
}
