package xyz.voxio.csc112.firm;

// ********************************************************************
// Firm.java Author: Lewis/Loftus
//
// Demonstrates polymorphism via inheritance.
// ********************************************************************

// +vacation()
public class Firm
{
	// -----------------------------------------------------------------
	// Creates a staff of employees for a firm and pays them.
	// -----------------------------------------------------------------
	public static void main(String[] args)
	{
		final Staff personnel = new Staff();

		personnel.payday();
	}
}
