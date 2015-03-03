package jsjf;

import java.util.Arrays;

import jsjf.exceptions.EmptyCollectionException;

/**
 * An array implementation of a stack in which the bottom of the
 * stack is fixed at index 0.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayStack<T> implements StackADT<T>
{
	private final static int	DEFAULT_CAPACITY	= 100;

	private T[]					stack;
	private int					top;

	/**
	 * Creates an empty stack using the default capacity.
	 */
	public ArrayStack()
	{
		this(ArrayStack.DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty stack using the specified capacity.
	 * 
	 * @param initialCapacity
	 *            the initial size of the array
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity)
	{
		this.top = 0;
		this.stack = (T[]) (new Object[initialCapacity]);
	}

	/**
	 * Creates a new array to store the contents of this stack with
	 * twice the capacity of the old one.
	 */
	private void expandCapacity()
	{
		this.stack = Arrays.copyOf(this.stack, this.stack.length * 2);
	}

	/**
	 * Returns true if this stack is empty and false otherwise.
	 * 
	 * @return true if this stack is empty
	 */
	@Override
	public boolean isEmpty()
	{
		for (final T t : this.stack)
		{
			if (t != null)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns a reference to the element at the top of this stack.
	 * The element is not removed from the stack.
	 * 
	 * @return element on top of stack
	 * @throws EmptyCollectionException
	 *             if stack is empty
	 */
	@Override
	public T peek() throws EmptyCollectionException
	{
		if (this.isEmpty())
		{
			throw new EmptyCollectionException("stack");
		}

		return this.stack[this.top - 1];
	}

	/**
	 * Removes the element at the top of this stack and returns a
	 * reference to it.
	 * 
	 * @return element removed from top of stack
	 * @throws EmptyCollectionException
	 *             if stack is empty
	 */
	@Override
	public T pop() throws EmptyCollectionException
	{
		if (this.isEmpty())
		{
			throw new EmptyCollectionException("stack");
		}

		this.top--;
		final T result = this.stack[this.top];
		this.stack[this.top] = null;

		return result;
	}

	/**
	 * Adds the specified element to the top of this stack, expanding
	 * the capacity of the array if necessary.
	 * 
	 * @param element
	 *            generic element to be pushed onto stack
	 */
	@Override
	public void push(T element)
	{
		if (this.size() == this.stack.length)
		{
			this.expandCapacity();
		}

		this.stack[this.top] = element;
		this.top++;
	}

	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in the stack
	 */
	@Override
	public int size()
	{
		int size = 0;
		for (final T t : this.stack)
		{
			if (t != null)
			{
				size++;
			}
		}
		return size;
	}

	/**
	 * Returns a string representation of this stack.
	 * 
	 * @return a string representation of the stack
	 */
	@Override
	public String toString()
	{
		String string = "stack=[";
		int index = 0;
		for (final T t : this.stack)
		{
			index++;
			string += t.toString();
			if (index < (this.stack.length - 1))
			{
				string += ", ";
			}
		}
		string += "]";
		return string;
	}
}
