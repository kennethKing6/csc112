package xyz.voxio.csc112.shapes;
import java.text.DecimalFormat;


/**
 * Cylinder.java<br>
 * Feb 5, 2015<br>
 * 
 * @author Tim Miller
 * 
 */
public class Cylinder extends Circle
{

	/**
	 * @param radius the radius
	 * @param height the height
	 */
	public Cylinder(double radius, double height)
    {
		super(radius);
		this.radius = radius;
		this.height = height;
    }
	
	private final double radius;
	private final double height;

	@Override
    public double computeArea()
    {
		return Math.PI * Math.pow(radius, 2) * height;
    }
	
	protected static DecimalFormat form = new DecimalFormat("0.##");

	/**
	 * It's actually the surface area
	 * @return the surface area
	 */
	@Override
    public double computePerimeter()
    {
	    return (2 * Math.PI * Math.pow(radius, 2)) + 2 * Math.PI * radius * height ;
    }

	public double getHeight()
    {
	    return height;
    }

	public double getRadius()
    {
	    return radius;
    }
	
	public String toString()
	{
		return "Cylinder: radius is " + form.format(radius) + ", height is " + form.format(height) + ", surface area is " + form.format(computePerimeter()) + ", volume is " + form.format(computeArea());
	}
}
