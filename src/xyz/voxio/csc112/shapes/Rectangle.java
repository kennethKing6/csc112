package xyz.voxio.csc112.shapes;

// ******************************************************************************
// Rectangle.java Java Foundations
//
// Solution to Programming Project 8.6
// ******************************************************************************

import java.text.DecimalFormat;

public class Rectangle extends Shape
{
	protected static DecimalFormat	form	= new DecimalFormat("0.##");
	protected double				length;
	protected double				width;
	
	// ---------------------------------------------------------------------------
	// Sets up the rectangle by entering its width and length.
	// ---------------------------------------------------------------------------
	public Rectangle(double wid, double len)
	{
		this.width = wid;
		this.length = len;
	}
	
	// ---------------------------------------------------------------------------
	// Returns the calculated value of the area.
	// ---------------------------------------------------------------------------
	@Override
	public double computeArea()
	{
		return this.length * this.width;
	}
	
	// ---------------------------------------------------------------------------
	// Returns the calculated value of the perimeter.
	// ---------------------------------------------------------------------------
	@Override
	public double computePerimeter()
	{
		return 2 * (this.length + this.width);
	}
	
	// ---------------------------------------------------------------------------
	// Returns the double value of the length.
	// ---------------------------------------------------------------------------
	public double getLength()
	{
		return this.length;
	}
	
	// ---------------------------------------------------------------------------
	// Returns the double value of the width.
	// ---------------------------------------------------------------------------
	public double getWidth()
	{
		return this.width;
	}
	
	// ---------------------------------------------------------------------------
	// Returns pertinent information about the rectangle.
	// ---------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return "Rectangle: width is " + Rectangle.form.format(this.width)
				+ ", length is " + Rectangle.form.format(this.length)
				+ "\nperimeter is "
				+ Rectangle.form.format(this.computePerimeter()) + ", area is "
				+ Rectangle.form.format(this.computeArea());
	}
}
