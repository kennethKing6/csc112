package xyz.voxio.csc112.shapes;
import java.text.DecimalFormat;


public class Sphere extends Circle
{

	private final double radius;

	public Sphere(double radius)
    {
		super(radius);
		this.radius = radius;
    }

	@Override
    public double computeArea()
    {
	    return (4/3)*Math.PI * Math.pow(radius,3);
    }
	
	protected static DecimalFormat form = new DecimalFormat("0.##");

	@Override
    public double computePerimeter()
    {
		return 4 * Math.PI * Math.pow(radius, 2);
    }

	public double getRadius()
    {
	    return radius;
    }
	
	public String toString()
	{
		return "Sphere: radius is " + form.format(radius) + ", surface area is " + form.format(computePerimeter()) + ", volume is " + form.format(computeArea());
	}
}
