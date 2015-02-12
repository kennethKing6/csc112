package xyz.voxio.csc112.firm;

/**
 * A class for a volunteer staff member
 * @author Tim Miller - Feb 12, 2015
 */
public class Volunteer extends StaffMember
{
	/**
	 * @param eName the name
	 * @param eAddress the address
	 * @param ePhone the phone
	 */
	public Volunteer(String eName, String eAddress, String ePhone)
	{
		super(eName, eAddress, ePhone);
	}

	/* (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.StaffMember#pay()
	 */
	@Override
	public double pay()
	{
		return 0.0;
	}

	/* (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.StaffMember#vacation()
	 */
	@Override
	public int vacation()
	{
		return 0;
	}
}
