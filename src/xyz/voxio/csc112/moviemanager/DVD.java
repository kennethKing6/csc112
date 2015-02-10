package xyz.voxio.csc112.moviemanager;

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
	 * Is it a blu-ray disk (seriously, who uses blu-ray? Do I want the same
	 * film for way
	 * more money? No thank you.
	 */
	private final boolean	bluray;

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
			final double cost, final boolean bluRay)
	{
		this.title = title;
		this.director = director;
		this.year = year;
		this.cost = cost;
		this.bluray = bluRay;
	}

	/**
	 * Standard constructor for a DVD, using string which are parsed to values
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
	 * @throws NumberFormatException
	 *             if the year or cost aren't valid
	 */
	public DVD(final String title, final String director, final String year,
			final String cost, final String bluRay)
			throws NumberFormatException
	{
		this(title, director, Integer.parseInt(year), Double.parseDouble(cost),
				Boolean.parseBoolean(bluRay));
	}

	/**
	 * @return the bluRay
	 */
	public boolean bluray()
	{
		return this.bluray;
	}

	/**
	 * @return the cost
	 */
	public double cost()
	{
		return this.cost;
	}

	/**
	 * @return the director
	 */
	public String director()
	{
		return this.director;
	}

	/**
	 * @return the year
	 */
	public int getYear()
	{
		return this.year;
	}

	/**
	 * @return the title
	 */
	public String title()
	{
		return this.title;
	}

	/**
	 * @return a string representation of the object, formatted for use in the
	 *         'list' command
	 */
	public String toListString()
	{
		String string = "";
		string += this.title + "\t";
		string += this.director + "\t\t";
		string += this.year + "\t";
		string += NumberFormat.getCurrencyInstance().format(this.cost) + "\t";
		final String br = this.bluray ? "true" : "false";
		string += br + "\n";
		return string;
	}

	/**
	 * Returns a string representation of the object
	 */
	@Override
	public String toString()
	{
		final NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String description = "";
		description += this.title + "\n" + this.director + "\n" + this.year
				+ "\n" + fmt.format(this.cost) + "\n" + this.bluray;
		return description;
	}
}
