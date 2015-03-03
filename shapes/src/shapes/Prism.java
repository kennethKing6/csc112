package shapes;

/**
 * Class representing a prism object
 * Prism.java<br>
 * Feb 19, 2015
 *
 * @author Tim Miller
 */
public class Prism extends Rectangle
{
	/**
	 * The height
	 */
	private final double	height;

	/**
	 * Default constructor for a prism object
	 *
	 * @param wid
	 *            the width
	 * @param len
	 *            the length
	 * @param hei
	 *            the height
	 */
	public Prism(double wid, double len, double hei)
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
		return (2 * super.computeArea()) + (2 * this.width * this.height)
				+ (2 * this.length * this.height);
	}

	/**
	 * @return the volume
	 */
	public double computeVolume()
	{
		return super.computeArea() * this.height;
	}

	/**
	 * @return the height
	 */
	public double getHeight()
	{
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * @see shapes.Rectangle#toString()
	 */
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
