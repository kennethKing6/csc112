package xyz.voxio.csc112.shapes;

import java.text.DecimalFormat;

public class Sphere extends Circle
{

	protected static DecimalFormat	form	= new DecimalFormat("0.##");

	private final double			radius;

	public Sphere(double radius)
	{
		super(radius);
		this.radius = radius;
	}

	@Override
	public double computeArea()
	{
		return (4 / 3) * Math.PI * Math.pow(this.radius, 3);
	}

	@Override
	public double computePerimeter()
	{
		return 4 * Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public double getRadius()
	{
		return this.radius;
	}

	@Override
	public String toString()
	{
		return "Sphere: radius is " + Sphere.form.format(this.radius)
				+ ", surface area is "
				+ Sphere.form.format(this.computePerimeter()) + ", volume is "
				+ Sphere.form.format(this.computeArea());
	}
}
