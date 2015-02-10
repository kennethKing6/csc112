package xyz.voxio.csc112.shapes;
import java.text.DecimalFormat;


/**
 * Circle.java<br>
 * Feb 5, 2015<br>
 * 
 * @author Tim Miller
 * 
 */
public class Circle extends Shape
{
	/**
	 * @param rad the radius of the circle
	 */
	public Circle(double rad)
	{
		this.radius = rad;
	}
	
	private final double radius;
	
	/**
	 * @return the radius
	 */
	public double getRadius()
	{
		return radius;
	}
	
	protected static DecimalFormat form = new DecimalFormat("0.##");
	
	@Override
	public double computeArea()
	{
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public double computePerimeter()
	{
		return Math.PI * 2 * radius;
	}
	
	@Override
	public String toString()
	{
		return "Circle: radius is " + form.format(radius) + ", area is " + form.format(this.computeArea()) + ", circumference  is " + form.format(this.computePerimeter());
	}
}
