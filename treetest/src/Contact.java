/**
 * Contact represents a phone contact.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Contact implements Comparable<Contact>
{
	private final String	firstName, lastName, phone;

	/**
	 * Sets up this contact with the specified information.
	 *
	 * @param first
	 *            a string representation of a first name
	 * @param last
	 *            a string representation of a last name
	 * @param telephone
	 *            a string representation of a phone number
	 */
	public Contact(String first, String last, String telephone)
	{
		this.firstName = first;
		this.lastName = last;
		this.phone = telephone;
	}

	/**
	 * Uses both last and first names to determine lexical ordering.
	 *
	 * @param other
	 *            the contact to be compared to this contact
	 * @return the integer result of the comparison
	 */
	@Override
	public int compareTo(Contact other)
	{
		int result;

		if (this.lastName.equals(other.lastName))
		{
			result = this.firstName.compareTo(other.firstName);
		}
		else
		{
			result = this.lastName.compareTo(other.lastName);
		}

		return result;
	}

	/**
	 * Returns a description of this contact as a string.
	 *
	 * @return a string representation of this contact
	 */
	@Override
	public String toString()
	{
		return this.lastName + ", " + this.firstName + "\t" + this.phone;
	}
}
