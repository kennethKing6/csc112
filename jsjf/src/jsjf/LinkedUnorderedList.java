package jsjf;

import jsjf.Exceptions.*;

/**
 * LinkedUnorderedList represents a singly linked implementation of an 
 * unordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedUnorderedList<T> extends LinkedList<T> 
         implements UnorderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public LinkedUnorderedList()
    {
        super();
    }

    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the list
	 */
    public void addToFront(T element)
    {
        // To be completed as a Programming Project
        LinearNode<T> newNode  = new LinearNode<T>(element);
      
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
		else 
		{
            newNode.setNext(head);
            head = newNode;
		}
      
        count++;
		modCount++;
    }

	@Override
	public void addToRear(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAfter(T element, T target) {
		// TODO Auto-generated method stub
		
	}
}
	/**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the list
	 */