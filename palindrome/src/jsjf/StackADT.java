package jsjf;

/**
 * Defines the interface to a stack collection.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface StackADT<T>
{
	/**
	 * Returns true if this stack contains no elements.
	 *
	 * @return true if the stack is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns without removing the top element of this stack.
	 *
	 * @return the element on top of the stack
	 */
	public T peek();

	/**
	 * Removes and returns the top element from this stack.
	 *
	 * @return the element removed from the stack
	 */
	public T pop();

	/**
	 * Adds the specified element to the top of this stack.
	 *
	 * @param element
	 *            element to be pushed onto the stack
	 */
	public void push(T element);

	/**
	 * Returns the number of elements in this stack.
	 *
	 * @return the number of elements in the stack
	 */
	public int size();

	/**
	 * Returns a string representation of this stack.
	 *
	 * @return a string representation of the stack
	 */
	@Override
	public String toString();
}
