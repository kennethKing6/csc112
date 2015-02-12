package xyz.voxio.csc112.firm;

// ********************************************************************
// StaffMember.java Author: Lewis/Loftus
//
// Represents a generic staff member.
// ********************************************************************

abstract public class StaffMember
{
	protected String	address;
	protected String	name;
	protected String	phone;

	// -----------------------------------------------------------------
	// Constructor: Sets up this staff member using the specified
	// information.
	// -----------------------------------------------------------------
	public StaffMember(String eName, String eAddress, String ePhone)
	{
		this.name = eName;
		this.address = eAddress;
		this.phone = ePhone;
	}

	/**
	 * @return the number of vacation weeks the staffmember gets
	 */
	public abstract int vacation();

	// -----------------------------------------------------------------
	// Derived classes must define the pay method for each type of
	// employee.
	// -----------------------------------------------------------------
	public abstract double pay();

	// -----------------------------------------------------------------
	// Returns a string including the basic employee information.
	// -----------------------------------------------------------------
	@Override
	public String toString()
	{
		String result = "Name: " + this.name + "\n";

		result += "Address: " + this.address + "\n";
		result += "Phone: " + this.phone;

		return result;
	}
}
