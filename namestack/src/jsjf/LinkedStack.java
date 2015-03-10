package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/**
 * Represents a linked implementation of a stack.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedStack<T> implements StackADT<T>
{
	private int				count;
	private LinearNode<T>	top;

	/**
	 * Creates an empty stack.
	 */
	public LinkedStack()
	{
		this.count = 0;
		this.top = null;
	}

	/**
	 * Returns true if this stack is empty and false otherwise.
	 * 
	 * @return true if stack is empty
	 */
	@Override
	public boolean isEmpty()
	{
		try
		{
			return (this.top.getElement() == null) || (this.count == 0);
		}
		catch (NullPointerException e)
		{
			return true;
		}
	}

	/**
	 * Returns a reference to the element at the top of this stack.
	 * The element is not removed from the stack.
	 * 
	 * @return element on top of stack
	 * @throws EmptyCollectionException
	 *             if the stack is empty
	 */
	@Override
	public T peek() throws EmptyCollectionException
	{
		return this.top.getElement();
	}

	/**
	 * Removes the element at the top of this stack and returns a
	 * reference to it.
	 * 
	 * @return element from top of stack
	 * @throws EmptyCollectionException
	 *             if the stack is empty
	 */
	@Override
	public T pop() throws EmptyCollectionException
	{
		if (this.isEmpty())
		{
			throw new EmptyCollectionException("stack");
		}

		final T result = this.top.getElement();
		this.top = this.top.getNext();
		this.count--;

		return result;
	}

	/**
	 * Adds the specified element to the top of this stack.
	 * 
	 * @param element
	 *            element to be pushed on stack
	 */
	@Override
	public void push(T element)
	{
		final LinearNode<T> temp = new LinearNode<T>(element);

		temp.setNext(this.top);
		this.top = temp;
		this.count++;
	}

	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return number of elements in the stack
	 */
	@Override
	public int size()
	{
		return this.count;
	}

	/**
	 * Returns a string representation of this stack.
	 * 
	 * @return string representation of the stack
	 */
	@Override
	public String toString()
	{
		String result = "";
		LinearNode<T> temp = new LinearNode<T>();
		temp = this.top;
		T element = temp.getElement();
		for (int index = this.count; index > 0; index--)
		{
			element = temp.getElement();
			result += "[" + this.count + "]" + element.toString() + "\n";
			temp = temp.getNext();
		}
		return result;
	}
}
