package xyz.voxio.csc112.firm;

/**
 * Class for executive of a firm
 * @author Tim Miller - Feb 12, 2015
 */
public class Executive extends Employee
{
	private double	bonus;

	/**
	 * @param eName exec name
	 * @param eAddress exec address
	 * @param ePhone exec phone number
	 * @param socSecNumber exec ss number
	 * @param rate exec payrate
	 */
	public Executive(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate)
	{
		super(eName, eAddress, ePhone, socSecNumber, rate);

		this.bonus = 0;  // bonus has yet to be awarded
	}

	/**
	 * @param execBonus the bonus to be awarded
	 */
	public void awardBonus(double execBonus)
	{
		this.bonus += execBonus;		//I changed = to +=
	}

	/* (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.Employee#pay()
	 */
	@Override
	public double pay()
	{
		final double payment = super.pay() + this.bonus;

		this.bonus = 0;

		return payment;
	}

	/* (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.Employee#vacation()
	 */
	@Override
	public int vacation()
	{
		return 3;
	}
}
