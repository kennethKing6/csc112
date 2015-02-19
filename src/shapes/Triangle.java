package shapes;

import java.text.DecimalFormat;

/**
 * Class representing a triangle object
 * Triangle.java<br>
 * Feb 19, 2015
 * 
 * @author Tim Miller
 */
public class Triangle extends Shape
{
	/**
	 * The decimal formatter (I should move this to Shape but I won't)
	 */
	protected static DecimalFormat	form	= new DecimalFormat("0.##");
	/**
	 * The side
	 */
	protected double				side;

	/**
	 * @param sid
	 *            the side length
	 */
	public Triangle(double sid)
	{
		this.side = sid;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Shape#computeArea()
	 */
	@Override
	public double computeArea()
	{
		return (this.side * this.getHeight()) / 2;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Shape#computePerimeter()
	 */
	@Override
	public double computePerimeter()
	{
		return this.side * 3;
	}

	/**
	 * @return the height
	 */
	public double getHeight()
	{
		return Math.sqrt(Math.pow(this.side, 2) - Math.pow(this.side / 2, 2));
	}

	/**
	 * @return the side length
	 */
	public double getSide()
	{
		return this.side;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Triangle: side length is " + Triangle.form.format(this.side)
				+ "\nperimeter is "
				+ Triangle.form.format(this.computePerimeter()) + ", area is "
				+ Triangle.form.format(this.computeArea());
	}
}
