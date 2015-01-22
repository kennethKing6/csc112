package movies;

// ********************************************************************
// DVD.java Author: Lewis/Loftus
//
// Represents a DVD video disc.
// ********************************************************************

import java.text.NumberFormat;

public class DVD
{
	private final boolean	bluRay;

	private final double	cost;

	private final String	title, director;

	private final int		year;

	// -----------------------------------------------------------------
	// Creates a new DVD with the specified information.
	// -----------------------------------------------------------------
	public DVD(final String title, final String director, final int year,
			final double cost,
			final boolean bluRay)
	{
		this.title = title;
		this.director = director;
		this.year = year;
		this.cost = cost;
		this.bluRay = bluRay;
	}

	// -----------------------------------------------------------------
	// Returns a string description of this DVD.
	// -----------------------------------------------------------------
	@Override
	public String toString()
	{
		final NumberFormat fmt = NumberFormat.getCurrencyInstance();

		String description;

		description = fmt.format(this.cost) + "\t" + this.year + "\t";
		description += this.title + "\t" + this.director;

		if (this.bluRay)
		{
			description += "\t" + "Blu-Ray";
		}

		return description;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public double getCost()
	{
		return cost;
	}
}
