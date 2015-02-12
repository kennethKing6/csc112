package xyz.voxio.csc112.firm;

/**
 * Abstract class for a staffmember at a firm
 * @author Tim Miller - Feb 12, 2015
 * 
 */
abstract public class StaffMember
{
	protected String	address;
	protected String	name;
	protected String	phone;

	/**
	 * Default constructor for a staff member
	 * @param eName their name
	 * @param eAddress their address
	 * @param ePhone their phone number
	 */
	public StaffMember(String eName, String eAddress, String ePhone)
	{
		this.name = eName;
		this.address = eAddress;
		this.phone = ePhone;
	}

	/**
	 * @return the amount the staffmember is to be payed
	 */
	public abstract double pay();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String result = "Name: " + this.name + "\n";

		result += "Address: " + this.address + "\n";
		result += "Phone: " + this.phone;

		return result;
	}

	/**
	 * @return the number of vacation weeks the staffmember gets
	 */
	public abstract int vacation();
}
