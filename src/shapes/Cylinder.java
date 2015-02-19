package shapes;

import java.text.DecimalFormat;

/**
 * Cylinder.java<br>
 * Feb 5, 2015<br>
 *
 * @author Tim Miller
 */
public class Cylinder extends Circle
{

	protected static DecimalFormat	form	= new DecimalFormat("0.##");

	private final double			height;
	private final double			radius;

	/**
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

	public double getHeight()
	{
		return this.height;
	}

	@Override
	public double getRadius()
	{
		return this.radius;
	}

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
