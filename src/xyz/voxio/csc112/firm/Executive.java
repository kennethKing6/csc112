package xyz.voxio.csc112.firm;

// ********************************************************************
// Executive.java Author: Lewis/Loftus
//
// Represents an executive staff member, who can earn a bonus.
// ********************************************************************

// +vacation()
public class Executive extends Employee
{
	private double	bonus;

	// -----------------------------------------------------------------
	// Constructor: Sets up this executive with the specified
	// information.
	// -----------------------------------------------------------------
	public Executive(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate)
	{
		super(eName, eAddress, ePhone, socSecNumber, rate);

		this.bonus = 0;  // bonus has yet to be awarded
	}

	// -----------------------------------------------------------------
	// Awards the specified bonus to this executive.
	// -----------------------------------------------------------------
	public void awardBonus(double execBonus)
	{
		this.bonus = execBonus;
	}

	// -----------------------------------------------------------------
	// Computes and returns the pay for an executive, which is the
	// regular employee payment plus a one-time bonus.
	// -----------------------------------------------------------------
	@Override
	public double pay()
	{
		final double payment = super.pay() + this.bonus;

		this.bonus = 0;

		return payment;
	}

	@Override
	public int vacation()
	{
		return 3;
	}
}
