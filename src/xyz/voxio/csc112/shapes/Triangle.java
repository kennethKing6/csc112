package xyz.voxio.csc112.shapes;

// ******************************************************************************
// Triangle.java Java Foundations
//
// Solution to Programming Project 8.6
// ******************************************************************************

import java.text.DecimalFormat;

public class Triangle extends Shape
{
	protected static DecimalFormat	form	= new DecimalFormat("0.##");
	protected double				side;
	
	// ---------------------------------------------------------------------------
	// Sets up the triangle by entering the length of a side.
	// ---------------------------------------------------------------------------
	public Triangle(double sid)
	{
		this.side = sid;
	}
	
	// ---------------------------------------------------------------------------
	// Returns the calculated value of the area.
	// ---------------------------------------------------------------------------
	@Override
	public double computeArea()
	{
		return (this.side * this.getHeight()) / 2;
	}
	
	// ---------------------------------------------------------------------------
	// Returns the calculated value of the perimeter.
	// ---------------------------------------------------------------------------
	@Override
	public double computePerimeter()
	{
		return this.side * 3;
	}
	
	// ---------------------------------------------------------------------------
	// Returns the double value of the height of the triangle.
	// ---------------------------------------------------------------------------
	public double getHeight()
	{
		return Math.sqrt(Math.pow(this.side, 2) - Math.pow(this.side / 2, 2));
	}
	
	// ---------------------------------------------------------------------------
	// Returns the double value of the side.
	// ---------------------------------------------------------------------------
	public double getSide()
	{
		return this.side;
	}
	
	// ---------------------------------------------------------------------------
	// Returns pertinent information about the triangle.
	// ---------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return "Triangle: side length is " + Triangle.form.format(this.side)
				+ "\nperimeter is "
				+ Triangle.form.format(this.computePerimeter()) + ", area is "
				+ Triangle.form.format(this.computeArea());
	}
}
