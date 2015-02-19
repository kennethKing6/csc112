package firm;

/**
 * Class for an employee who is paid an hourly wage
 *
 * @author Tim Miller - Feb 12, 2015
 */
public class Hourly extends Employee
{

	private int				hoursWorked;

	private final double	overtimeRate;
	private int				overtimeWorked;

	/**
	 * @param eName
	 *            employee name
	 * @param eAddress
	 *            employee address
	 * @param ePhone
	 *            employee phone number
	 * @param socSecNumber
	 *            employee ss number
	 * @param rate
	 *            employee hourly pay rate
	 */
	public Hourly(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate)
	{
		this(eName, eAddress, ePhone, socSecNumber, rate, rate * 1.5);
	}

	/**
	 * @param eName
	 *            employee name
	 * @param eAddress
	 *            employee address
	 * @param ePhone
	 *            employee phone number
	 * @param socSecNumber
	 *            employee ss number
	 * @param rate
	 *            employee hourly pay rate
	 * @param overtimeRate
	 *            hourly overtime pay rate
	 */
	public Hourly(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate, double overtimeRate)
	{
		super(eName, eAddress, ePhone, socSecNumber, rate);
		this.overtimeRate = overtimeRate;
		this.overtimeWorked = 0;
		this.hoursWorked = 0;
	}

	/**
	 * @param moreHours
	 *            the hours worked
	 */
	public void addHours(int moreHours)
	{
		this.hoursWorked += moreHours;
	}

	/**
	 * @param hours
	 *            the overtime worked
	 */
	public void addOvertime(int hours)
	{
		this.overtimeWorked += hours;
	}

	/*
	 * (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.Employee#pay()
	 */
	@Override
	public double pay()
	{
		final double payment = (this.payRate * this.hoursWorked)
				+ (this.overtimeRate * this.overtimeWorked);
		this.hoursWorked = 0;
		this.overtimeWorked = 0;
		return payment;
	}

	/*
	 * (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.Employee#toString()
	 */
	@Override
	public String toString()
	{
		String result = super.toString();

		result += "\nCurrent hours: " + this.hoursWorked;

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see xyz.voxio.csc112.firm.Employee#vacation()
	 */
	@Override
	public int vacation()
	{
		return 1;
	}
}
