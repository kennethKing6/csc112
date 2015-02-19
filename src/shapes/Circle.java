package shapes;

import java.text.DecimalFormat;

/**
 * Circle.java<br>
 * Feb 5, 2015<br>
 *
 * @author Tim Miller
 */
public class Circle extends Shape
{
	protected static DecimalFormat	form	= new DecimalFormat("0.##");

	private final double			radius;

	/**
	 * @param rad
	 *            the radius of the circle
	 */
	public Circle(double rad)
	{
		this.radius = rad;
	}

	@Override
	public double computeArea()
	{
		return Math.PI * Math.pow(this.radius, 2);
	}

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

	@Override
	public String toString()
	{
		return "Circle: radius is " + Circle.form.format(this.radius)
				+ ", area is " + Circle.form.format(this.computeArea())
				+ ", circumference  is "
				+ Circle.form.format(this.computePerimeter());
	}
}
