package xyz.voxio.csc112.firm;

/**
 * Class for an employee of a firm
 * @author Tim Miller - Feb 12, 2015
 */
/**
 * 
 * @author Tim Miller - Feb 12, 2015
 */
public class Employee extends StaffMember
{
	protected double	payRate;
	protected String	socialSecurityNumber;

	/**
	 * Default constructor
	 * @param eName employee name
	 * @param eAddress employee address
	 * @param ePhone employee phone number
	 * @param socSecNumber employee ss number
	 * @param rate empoloyee payrate
	 */
	public Employee(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate)
	{
		super(eName, eAddress, ePhone);

		this.socialSecurityNumber = socSecNumber;
		this.payRate = rate;
	}

	/* (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.StaffMember#pay()
	 */
	@Override
	public double pay()
	{
		return this.payRate;
	}

	/* (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.StaffMember#toString()
	 */
	@Override
	public String toString()
	{
		String result = super.toString();

		result += "\nSocial Security Number: " + this.socialSecurityNumber;

		return result;
	}

	/* (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.StaffMember#vacation()
	 */
	@Override
	public int vacation()
	{
		return 2;
	}
}
