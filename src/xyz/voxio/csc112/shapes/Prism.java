package xyz.voxio.csc112.shapes;

// ******************************************************************************
// Prism.java Java Foundations
//
// Solution to Programming Project 8.6
// ******************************************************************************

public class Prism extends Rectangle
{
	private final double	height;
	
	// ---------------------------------------------------------------------------
	// Sets up the prism by entering its width, height and length.
	// ---------------------------------------------------------------------------
	public Prism(double wid, double len, double hei)
	{
		super(wid, len);
		this.height = hei;
	}
	
	// ---------------------------------------------------------------------------
	// Returns the calculated value of the surface area.
	// ---------------------------------------------------------------------------
	@Override
	public double computeArea()
	{
		return (2 * super.computeArea()) + (2 * this.width * this.height)
				+ (2 * this.length * this.height);
	}
	
	// ---------------------------------------------------------------------------
	// Returns the calculated value of the volume.
	// ---------------------------------------------------------------------------
	public double computeVolume()
	{
		return super.computeArea() * this.height;
	}
	
	// ---------------------------------------------------------------------------
	// Returns the double value of the length.
	// ---------------------------------------------------------------------------
	public double getHeight()
	{
		return this.height;
	}
	
	// ---------------------------------------------------------------------------
	// Returns pertinent information about the prism.
	// ---------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return "Prism: width is " + Rectangle.form.format(this.width)
				+ ", length is " + Rectangle.form.format(this.length)
				+ ", height is " + Rectangle.form.format(this.height)
				+ "\nperimeter of base is "
				+ Rectangle.form.format(this.computePerimeter()) + ", area is "
				+ Rectangle.form.format(this.computeArea()) + "\nvolume is "
				+ Rectangle.form.format(this.computeVolume()) + "\n";
	}
}
