package shapes;

/**
 * Class representing a 3D tetrahedron
 * Tetrahedron.java<br>
 * Feb 19, 2015
 *
 * @author Tim Miller
 */
public class Tetrahedron extends Triangle
{
	/**
	 * The height of the tetrahedron
	 */
	private final double	height;

	/**
	 * Default constructor for a tetrahedron object.
	 *
	 * @param sid
	 *            the side length
	 * @param hei
	 *            the height
	 */
	public Tetrahedron(double sid, double hei)
	{
		super(sid);
		this.height = hei;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Triangle#computeArea()
	 */
	@Override
	public double computeArea()
	{
		return (3 * this.faceArea()) + super.computeArea();
	}

	/**
	 * @return the volume of the figure
	 */
	public double computeVolume()
	{
		return (super.computeArea() * this.height) / 3;
	}

	/**
	 * @return the area of a single face
	 */
	public double faceArea()
	{
		return (this.faceHeight() * this.side) / 2;
	}

	/**
	 * @return the height of a single face of the figure
	 */
	public double faceHeight()
	{
		return Math.sqrt(Math.pow(this.height, 2)
				+ Math.pow(this.getHeight() / 2, 2));
	}

	/**
	 * @return the height of the figure
	 */
	public double getPyramidHeight()
	{
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Triangle#toString()
	 */
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
