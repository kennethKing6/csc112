package jsjf;

import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.NonComparableElementException;

/**
 * ArrayOrderedList represents an array implementation of an ordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements
OrderedListADT<T>
{
	/**
	 * Creates an empty list using the default capacity.
	 */
	public ArrayOrderedList()
	{
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 *
	 * @param initialCapacity
	 *            the initial size of the list
	 */
	public ArrayOrderedList(int initialCapacity)
	{
		super(initialCapacity);
	}

	/**
	 * Adds the specified Comparable element to this list, keeping
	 * the elements in sorted order.
	 *
	 * @param element
	 *            the element to be added to the list
	 */
	@Override
	public void add(T element)
	{
		if (!(element instanceof Comparable)) { throw new NonComparableElementException(
				"OrderedList"); }

		@SuppressWarnings("unchecked")
		final Comparable<T> comparableElement = (Comparable<T>) element;

		if (this.size() == this.list.length)
		{
			this.expandCapacity();
		}

		int scan = 0;

		// find the insertion location
		while ((scan < this.rear)
				&& (comparableElement.compareTo(this.list[scan]) > 0))
		{
			scan++;
		}

		// shift existing elements up one
		for (int shift = this.rear; shift > scan; shift--)
		{
			this.list[shift] = this.list[shift - 1];
		}

		// insert element
		this.list[scan] = element;
		this.rear++;
		this.modCount++;
	}

	@Override
	public T remove(T element)
	{
		T result;
		final int index = this.find(element);

		if (index == ArrayList.NOT_FOUND) { throw new ElementNotFoundException(
				"ArrayList"); }

		result = this.list[index];
		this.rear--;

		// shift the appropriate elements
		for (int scan = index; scan < this.rear; scan++)
		{
			this.list[scan] = this.list[scan + 1];
		}

		this.list[this.rear] = null;
		this.modCount++;

		return result;
	}
}
