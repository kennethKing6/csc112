package shapes;

import java.text.DecimalFormat;

/**
 * Class representing a circle object
 * Circle.java<br>
 * Feb 5, 2015<br>
 *
 * @author Tim Miller
 */
public class Circle extends Shape
{
	/**
	 * Formatter for the decimal format
	 */
	private static DecimalFormat	form	= new DecimalFormat("0.##");

	/**
	 * The radius of a circle
	 */
	private final double			radius;

	/**
	 * @param rad
	 *            the radius of the circle
	 */
	public Circle(double rad)
	{
		this.radius = rad;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Shape#computeArea()
	 */
	@Override
	public double computeArea()
	{
		return Math.PI * Math.pow(this.radius, 2);
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Shape#computePerimeter()
	 */
	@Override
	public double computePerimeter()
	{
		return Math.PI * 2 * this.radius;
	}

	/**
	 * @return the radius
	 */
	public double getRadius()
	{
		return this.radius;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Circle: radius is " + Circle.form.format(this.radius)
				+ ", area is " + Circle.form.format(this.computeArea())
				+ ", circumference  is "
				+ Circle.form.format(this.computePerimeter());
	}
}
