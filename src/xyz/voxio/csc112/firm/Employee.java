package xyz.voxio.csc112.firm;

// ********************************************************************
// Employee.java Author: Lewis/Loftus
//
// Represents a general paid employee.
// ********************************************************************

// +vacation()
public class Employee extends StaffMember
{
	protected double	payRate;
	protected String	socialSecurityNumber;

	// -----------------------------------------------------------------
	// Constructor: Sets up this employee with the specified
	// information.
	// -----------------------------------------------------------------
	public Employee(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate)
	{
		super(eName, eAddress, ePhone);

		this.socialSecurityNumber = socSecNumber;
		this.payRate = rate;
	}

	// -----------------------------------------------------------------
	// Returns the pay rate for this employee.
	// -----------------------------------------------------------------
	@Override
	public double pay()
	{
		return this.payRate;
	}

	// -----------------------------------------------------------------
	// Returns information about an employee as a string.
	// -----------------------------------------------------------------
	@Override
	public String toString()
	{
		String result = super.toString();

		result += "\nSocial Security Number: " + this.socialSecurityNumber;

		return result;
	}

	@Override
	public int vacation()
	{
		return 2;
	}
}
