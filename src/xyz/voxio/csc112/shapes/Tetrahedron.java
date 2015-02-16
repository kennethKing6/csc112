package xyz.voxio.csc112.shapes;

// ******************************************************************************
// Tetrahedron.java Java Foundations
//
// Solution to Programming Project 8.6
// ******************************************************************************

public class Tetrahedron extends Triangle
{
	private final double	height;

	// ---------------------------------------------------------------------------
	// Sets up the pyramid by entering its base side length and height.
	// ---------------------------------------------------------------------------
	public Tetrahedron(double sid, double hei)
	{
		super(sid);
		this.height = hei;
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of the surface area.
	// ---------------------------------------------------------------------------
	@Override
	public double computeArea()
	{
		return (3 * this.faceArea()) + super.computeArea();
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of the volume.
	// ---------------------------------------------------------------------------
	public double computeVolume()
	{
		return (super.computeArea() * this.height) / 3;
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of a face area.
	// ---------------------------------------------------------------------------
	public double faceArea()
	{
		return (this.faceHeight() * this.side) / 2;
	}

	// ---------------------------------------------------------------------------
	// Returns the calculated value of a face height.
	// ---------------------------------------------------------------------------
	public double faceHeight()
	{
		return Math.sqrt(Math.pow(this.height, 2)
				+ Math.pow(this.getHeight() / 2, 2));
	}

	// ---------------------------------------------------------------------------
	// Returns the double value of the height.
	// ---------------------------------------------------------------------------
	public double getPyramidHeight()
	{
		return this.height;
	}

	// ---------------------------------------------------------------------------
	// Returns pertinent information about the pyramid.
	// ---------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return "Triangle Pyramid: Height is "
				+ Triangle.form.format(this.height) + "\nperimeter of base is "
				+ Triangle.form.format(this.computePerimeter()) + ", area is "
				+ Triangle.form.format(this.computeArea()) + "\nvolume is "
				+ Triangle.form.format(this.computeVolume()) + "\n";
	}
}
