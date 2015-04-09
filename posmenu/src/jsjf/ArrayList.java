package jsjf;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

/**
 * ArrayList represents an array implementation of a list. The front of
 * the list is kept at array index 0. This class will be extended
 * to create a specific kind of list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public abstract class ArrayList<T> implements ListADT<T>, Iterable<T>
{
	/**
	 * ArrayListIterator iterator over the elements of an ArrayList.
	 */
	private class ArrayListIterator implements Iterator<T>
	{
		int	current;
		int	iteratorModCount;

		/**
		 * Sets up this iterator using the specified modCount.
		 *
		 * @param modCount
		 *            the current modification count for the ArrayList
		 */
		public ArrayListIterator()
		{
			this.iteratorModCount = ArrayList.this.modCount;
			this.current = 0;
		}

		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return true if this iterator has at least one more element to deliver
		 *         in the iteration
		 * @throws ConcurrentModificationException
		 *             if the collection has changed
		 *             while the iterator is in use
		 */
		@Override
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (this.iteratorModCount != ArrayList.this.modCount) { throw new ConcurrentModificationException(); }

			return (this.current < ArrayList.this.rear);
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException
		 *             if an element not found exception occurs
		 * @throws ConcurrentModificationException
		 *             if the collection has changed
		 */
		@Override
		public T next() throws ConcurrentModificationException
		{
			if (!this.hasNext()) { throw new NoSuchElementException(); }

			this.current++;

			return ArrayList.this.list[this.current - 1];
		}

		/**
		 * The remove operation is not supported in this collection.
		 *
		 * @throws UnsupportedOperationException
		 *             if the remove method is called
		 */
		@Override
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

	}

	private final static int	DEFAULT_CAPACITY	= 3;

	public final static int		NOT_FOUND			= -1;
	protected T[]				list;
	protected int				modCount;

	protected int				rear;

	/**
	 * Creates an empty list using the default capacity.
	 */
	public ArrayList()
	{
		this(ArrayList.DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty list using the specified capacity.
	 *
	 * @param initialCapacity
	 *            the integer value of the size of the array list
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity)
	{
		this.rear = 0;
		this.list = (T[]) (new Object[initialCapacity]);
		this.modCount = 0;
	}

	/**
	 * Returns true if this list contains the specified element.
	 *
	 * @param target
	 *            the target element
	 * @return true if the target is in the list, false otherwise
	 */
	@Override
	public boolean contains(T target)
	{
		return (this.find(target) != ArrayList.NOT_FOUND);
	}

	/**
	 * Creates a new array to store the contents of this list with
	 * twice the capacity of the old one. Called by descendant classes
	 * that add elements to the list.
	 */
	protected void expandCapacity()
	{
		// To be completed as a Programming Project
		@SuppressWarnings("unchecked")
		final T[] temp = (T[]) (new Object[2 * this.size()]);
		for (int i = 0; i < this.list.length; i++)
		{
			temp[i] = this.list[i];
		}

		this.list = temp;
		System.out.println("Capacity Expanded\n");
	}

	/**
	 * Returns the array index of the specified element, or the
	 * constant NOT_FOUND if it is not found.
	 *
	 * @param target
	 *            the target element
	 * @return the index of the target element, or the
	 *         NOT_FOUND constant
	 */
	public int find(T target)
	{
		int scan = 0;
		int result = ArrayList.NOT_FOUND;

		if (!this.isEmpty())
		{
			while ((result == ArrayList.NOT_FOUND) && (scan < this.rear))
			{
				if (target.equals(this.list[scan]))
				{
					result = scan;
				}
				else
				{
					scan++;
				}
			}
		}

		return result;
	}

	/**
	 * Returns a reference to the element at the front of this list.
	 * The element is not removed from the list. Throws an
	 * EmptyCollectionException if the list is empty.
	 *
	 * @return a reference to the first element in the list
	 * @throws EmptyCollectionException
	 *             if the list is empty
	 */
	@Override
	public T first() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		if (this.size() == 0) { throw new EmptyCollectionException("ArrayList"); }

		final T result = this.list[0];
		return result;
	}

	/**
	 * Returns true if this list is empty and false otherwise.
	 *
	 * @return true if the list is empty, false otherwise
	 */
	@Override
	public boolean isEmpty()
	{
		// To be completed as a Programming Project
		if (this.rear == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Returns an iterator for the elements currently in this list.
	 * 
	 * @return an iterator for the elements in the list
	 */
	@Override
	public Iterator<T> iterator()
	{
		return new ArrayListIterator();
	}

	/**
	 * Returns a reference to the element at the rear of this list.
	 * The element is not removed from the list. Throws an
	 * EmptyCollectionException if the list is empty.
	 *
	 * @return a reference to the last element of this list
	 * @throws EmptyCollectionException
	 *             if the list is empty
	 */
	@Override
	public T last() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		if (this.size() == 0) { throw new EmptyCollectionException("ArrayList"); }

		final T result = this.list[this.rear - 1];
		return result;
	}

	/**
	 * Removes and returns the specified element.
	 *
	 * @param element
	 *            the element to be removed and returned from the list
	 * @return the removed elememt
	 * @throws ElementNotFoundException
	 *             if the element is not in the list
	 */
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

	/**
	 * Removes and returns the first element in this list.
	 *
	 * @return the first element in the list
	 * @throws EmptyCollectionException
	 *             if the element is not in the list
	 */
	@Override
	public T removeFirst() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		if (this.size() == 0) { throw new ElementNotFoundException("ArrayList"); }

		// place list[0] into result
		final T result = this.list[0];

		// shift the appropriate elements
		for (int scan = 0; scan < (this.rear - 1); scan++)
		{
			this.list[scan] = this.list[scan + 1];
		}

		this.rear--;
		this.list[this.rear] = null;
		this.modCount++;

		return result;
	}

	/**
	 * Removes and returns the last element in this list.
	 *
	 * @return the last element in the list
	 * @throws EmptyCollectionException
	 *             if the element is not in the list
	 */
	@Override
	public T removeLast() throws EmptyCollectionException
	{
		// To be completed as a Programming Project
		if (this.list.length == 0) { throw new ElementNotFoundException(
				"ArrayList"); }

		// Place last item in result
		final T result = this.list[this.rear];

		// get rid of the last one
		this.rear--;
		this.list[this.rear] = null;
		this.modCount++;

		return result;
	}

	/**
	 * Returns the number of elements currently in this list.
	 *
	 * @return the number of elements in the list
	 */
	@Override
	public int size()
	{
		// To be completed as a Programming Project
		return this.rear;
	}

	/**
	 * Returns a string representation of this list.
	 * 
	 * @return the string representation of the list
	 */
	@Override
	public String toString()
	{
		// To be completed as a Programming Project
		String result;
		result = "";
		for (int i = 0; i < this.size(); i++)
		{
			result += "[" + (i + 1) + "]  " + this.list[i].toString() + "\n";
		}
		return result;
	}
}
