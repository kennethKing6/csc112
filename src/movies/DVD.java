package movies;

import java.text.NumberFormat;

/**
 * DVD.java<br>
 * Jan 23, 2015<br>
 *
 * @author Tim Miller
 */
public class DVD
{
	/**
	 * Is it a blu-ray disk (seriously, who uses blu-ray? The same film for way
	 * more money,? No thank you.
	 */
	private final boolean	bluRay;

	/**
	 * The retail cost
	 */
	private final double	cost;
	
	/**
	 * The director of the file
	 */
	private final String	director;

	/**
	 * The title of the filme
	 */
	private final String	title;

	/**
	 * The publication year
	 */
	private final int		year;

	/**
	 * Standard constructor for a DVD
	 *
	 * @param title
	 *            the title
	 * @param director
	 *            the director
	 * @param year
	 *            the year
	 * @param cost
	 *            the cost
	 * @param bluRay
	 *            whether or not it is a blu ray
	 */
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

	/**
	 * @return the cost
	 */
	public double getCost()
	{
		return this.cost;
	}

	/**
	 * @return the director
	 */
	public String getDirector()
	{
		return this.director;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * @return the year
	 */
	public int getYear()
	{
		return this.year;
	}
	
	/**
	 * @return the bluRay
	 */
	public boolean isBluRay()
	{
		return this.bluRay;
	}
	
	/**
	 * Returns a string representation of the object
	 */
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
}
