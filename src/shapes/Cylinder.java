package shapes;

import java.text.DecimalFormat;

/**
 * Class representing a cylinder object
 * Cylinder.java<br>
 * Feb 5, 2015<br>
 *
 * @author Tim Miller
 */
public class Cylinder extends Circle
{

	/**
	 * Formatter for the decimal format
	 */
	private static DecimalFormat	form	= new DecimalFormat("0.##");

	/**
	 * The height
	 */
	private final double			height;
	/**
	 * The radius
	 */
	private final double			radius;

	/**
	 * The default constructor for the cylinder
	 *
	 * @param radius
	 *            the radius
	 * @param height
	 *            the height
	 */
	public Cylinder(double radius, double height)
	{
		super(radius);
		this.radius = radius;
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Circle#computeArea()
	 */
	@Override
	public double computeArea()
	{
		return Math.PI * Math.pow(this.radius, 2) * this.height;
	}

	/**
	 * It's actually the surface area
	 *
	 * @return the surface area
	 */
	@Override
	public double computePerimeter()
	{
		return (2 * Math.PI * Math.pow(this.radius, 2))
				+ (2 * Math.PI * this.radius * this.height);
	}

	/**
	 * @return the height of the figure
	 */
	public double getHeight()
	{
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Circle#getRadius()
	 */
	@Override
	public double getRadius()
	{
		return this.radius;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Circle#toString()
	 */
	@Override
	public String toString()
	{
		return "Cylinder: radius is " + Cylinder.form.format(this.radius)
				+ ", height is " + Cylinder.form.format(this.height)
				+ ", surface area is "
				+ Cylinder.form.format(this.computePerimeter())
				+ ", volume is " + Cylinder.form.format(this.computeArea());
	}
}
