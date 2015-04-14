package jsjf;

import java.util.Iterator;

/**
 * ListADT defines the interface to a general list collection. Specific
 * types of lists will extend this interface to complete the
 * set of necessary operations.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface ListADT<T> extends Iterable<T>
{
	/**
	 * Returns true if this list contains the specified target element.
	 *
	 * @param target
	 *            the target that is being sought in the list
	 * @return true if the list contains this element
	 */
	public boolean contains(T target);

	/**
	 * Returns a reference to the first element in this list.
	 *
	 * @return a reference to the first element in this list
	 */
	public T first();

	/**
	 * Returns true if this list contains no elements.
	 *
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty();

	/**
	 * Returns an iterator for the elements in this list.
	 *
	 * @return an iterator over the elements in this list
	 */
	@Override
	public Iterator<T> iterator();

	/**
	 * Returns a reference to the last element in this list.
	 *
	 * @return a reference to the last element in this list
	 */
	public T last();

	/**
	 * Removes and returns the specified element from this list.
	 *
	 * @param element
	 *            the element to be removed from the list
	 */
	public T remove(T element);

	/**
	 * Removes and returns the first element from this list.
	 *
	 * @return the first element from this list
	 */
	public T removeFirst();

	/**
	 * Removes and returns the last element from this list.
	 *
	 * @return the last element from this list
	 */
	public T removeLast();

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the integer representation of number of elements in this list
	 */
	public int size();

	/**
	 * Returns a string representation of this list.
	 *
	 * @return a string representation of this list
	 */
	@Override
	public String toString();
}
