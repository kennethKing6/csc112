package shapes;

import java.text.DecimalFormat;

/**
 * Class for a simple rectangle object
 * Rectangle.java<br>
 * Feb 19, 2015
 * 
 * @author Tim Miller
 */
public class Rectangle extends Shape
{
	/**
	 * Decimal formatter
	 */
	protected static DecimalFormat	form	= new DecimalFormat("0.##");
	/**
	 * The length
	 */
	protected double				length;
	/**
	 * The width
	 */
	protected double				width;

	/**
	 * Default constructor for a simple rectangle
	 *
	 * @param wid
	 *            the width
	 * @param len
	 *            the length
	 */
	public Rectangle(double wid, double len)
	{
		this.width = wid;
		this.length = len;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Shape#computeArea()
	 */
	@Override
	public double computeArea()
	{
		return this.length * this.width;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Shape#computePerimeter()
	 */
	@Override
	public double computePerimeter()
	{
		return 2 * (this.length + this.width);
	}

	/**
	 * @return the length
	 */
	public double getLength()
	{
		return this.length;
	}

	/**
	 * @return the width
	 */
	public double getWidth()
	{
		return this.width;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Rectangle: width is " + Rectangle.form.format(this.width)
				+ ", length is " + Rectangle.form.format(this.length)
				+ "\nperimeter is "
				+ Rectangle.form.format(this.computePerimeter()) + ", area is "
				+ Rectangle.form.format(this.computeArea());
	}
}
