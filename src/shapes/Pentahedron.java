package shapes;

// ******************************************************************************
// Pentahedron.java Java Foundations
//
// Solution to Programming Project 8.6
// ******************************************************************************

public class Pentahedron extends Rectangle
{
	private final double	height;

	// ---------------------------------------------------------------------------
	// Sets up the pyramid by entering its width, height and length.
	// ---------------------------------------------------------------------------
	public Pentahedron(double wid, double len, double hei)
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
		return (2 * this.lengthFaceArea()) + (2 * this.widthFaceArea())
				+ super.computeArea();
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of the volume.
	// ---------------------------------------------------------------------------
	public double computeVolume()
	{
		return (super.computeArea() * this.height) / 3;
	}

	// ---------------------------------------------------------------------------
	// Returns the double value of the height.
	// ---------------------------------------------------------------------------
	public double getHeight()
	{
		return this.height;
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of the long face area.
	// ---------------------------------------------------------------------------
	public double lengthFaceArea()
	{
		return (this.lengthFaceHeight() * this.length) / 2;
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of the long face height.
	// ---------------------------------------------------------------------------
	public double lengthFaceHeight()
	{
		return Math
				.sqrt(Math.pow(this.height, 2) + Math.pow(this.width / 2, 2));
	}

	// ---------------------------------------------------------------------------
	// Returns pertinent information about the pyramid.
	// ---------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return "Square Pyramid: width is " + Rectangle.form.format(this.width)
				+ ", length is " + Rectangle.form.format(this.length)
				+ ", height is " + Rectangle.form.format(this.height)
				+ "\nperimeter of base is "
				+ Rectangle.form.format(this.computePerimeter()) + ", area is "
				+ Rectangle.form.format(this.computeArea()) + "\nvolume is "
				+ Rectangle.form.format(this.computeVolume()) + "\n";
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of the wide face area.
	// ---------------------------------------------------------------------------
	public double widthFaceArea()
	{
		return (this.widthFaceHeight() * this.width) / 2;
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of the wide face height.
	// ---------------------------------------------------------------------------
	public double widthFaceHeight()
	{
		return Math.sqrt(Math.pow(this.height, 2)
				+ Math.pow(this.length / 2, 2));
	}
}
