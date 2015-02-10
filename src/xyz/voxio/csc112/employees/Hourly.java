package xyz.voxio.csc112.employees;

// ********************************************************************
// Hourly.java Author: Lewis/Loftus
//
// Represents an employee that gets paid by the hour.
// ********************************************************************

public class Hourly extends Employee
{
	public static double timeAndHalf(double time)
	{
		return time * 1.5;
	}

	private int				hoursWorked;
	private final double	overtimeRate;

	private int				overtimeWorked;

	public Hourly(String string, String string2, String string3,
			String string4, double rate)
	{
		this(string, string2, string3, string4, rate, Hourly.timeAndHalf(rate));
	}

	// -----------------------------------------------------------------
	// Constructor: Sets up this hourly employee using the specified
	// information.
	// -----------------------------------------------------------------
	public Hourly(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate, double overtimeRate)
	{
		super(eName, eAddress, ePhone, socSecNumber, rate);
		this.overtimeRate = overtimeRate;
		this.overtimeWorked = 0;
		this.hoursWorked = 0;
	}

	// -----------------------------------------------------------------
	// Adds the specified number of hours to this employee's
	// accumulated hours.
	// -----------------------------------------------------------------
	public void addHours(int moreHours)
	{
		this.hoursWorked += moreHours;
	}

	public void addOvertime(int hours)
	{
		this.overtimeWorked += hours;
	}

	// -----------------------------------------------------------------
	// Computes and returns the pay for this hourly employee.
	// -----------------------------------------------------------------
	@Override
	public double pay()
	{
		final double payment = this.payRate * this.hoursWorked
				+ this.overtimeRate * this.overtimeWorked;
		this.hoursWorked = 0;
		this.overtimeWorked = 0;
		return payment;
	}

	// -----------------------------------------------------------------
	// Returns information about this hourly employee as a string.
	// -----------------------------------------------------------------
	@Override
	public String toString()
	{
		String result = super.toString();

		result += "\nCurrent hours: " + this.hoursWorked;

		return result;
	}
}
