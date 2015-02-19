package shapes;

import java.text.DecimalFormat;

/**
 * Class for a 3d sphere object
 * Sphere.java<br>
 * Feb 19, 2015
 *
 * @author Tim Miller
 */
public class Sphere extends Circle
{

	/**
	 * Decimal formatter
	 */
	protected static DecimalFormat	form	= new DecimalFormat("0.##");

	/**
	 * The radius
	 */
	private final double			radius;

	/**
	 * Default constructor for sphere
	 *
	 * @param radius
	 *            the radius
	 */
	public Sphere(double radius)
	{
		super(radius);
		this.radius = radius;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Circle#computeArea()
	 */
	@Override
	public double computeArea()
	{
		return (4 / 3) * Math.PI * Math.pow(this.radius, 3);
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Circle#computePerimeter()
	 */
	@Override
	public double computePerimeter()
	{
		return 4 * Math.PI * Math.pow(this.radius, 2);
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
		return "Sphere: radius is " + Sphere.form.format(this.radius)
				+ ", surface area is "
				+ Sphere.form.format(this.computePerimeter()) + ", volume is "
				+ Sphere.form.format(this.computeArea());
	}
}
