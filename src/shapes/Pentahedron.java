package shapes;

/**
 * Class representing a pentahedron object
 * Pentahedron.java<br>
 * Feb 19, 2015
 * 
 * @author Tim Miller
 */
public class Pentahedron extends Rectangle
{
	/**
	 * The height
	 */
	private final double	height;

	/**
	 * Default constructor for a pentahedron object
	 *
	 * @param wid
	 *            the width
	 * @param len
	 *            the length
	 * @param hei
	 *            the height
	 */
	public Pentahedron(double wid, double len, double hei)
	{
		super(wid, len);
		this.height = hei;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Rectangle#computeArea()
	 */
	@Override
	public double computeArea()
	{
		return (2 * this.lengthFaceArea()) + (2 * this.widthFaceArea())
				+ super.computeArea();
	}

	/**
	 * @return the volume of the figure
	 */
	public double computeVolume()
	{
		return (super.computeArea() * this.height) / 3;
	}

	/**
	 * @return the height of the figure
	 */
	public double getHeight()
	{
		return this.height;
	}

	/**
	 * @return the length face area
	 */
	public double lengthFaceArea()
	{
		return (this.lengthFaceHeight() * this.length) / 2;
	}

	/**
	 * @return the length face height
	 */
	public double lengthFaceHeight()
	{
		return Math
				.sqrt(Math.pow(this.height, 2) + Math.pow(this.width / 2, 2));
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Rectangle#toString()
	 */
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

	/**
	 * @return the wide face area
	 */
	public double widthFaceArea()
	{
		return (this.widthFaceHeight() * this.width) / 2;
	}

	/**
	 * @return the wide face height
	 */
	public double widthFaceHeight()
	{
		return Math.sqrt(Math.pow(this.height, 2)
				+ Math.pow(this.length / 2, 2));
	}
}
