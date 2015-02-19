package shapes;

/**
 * Abstract class for a 2d or 3d shape
 * Shape.java<br>
 * Feb 19, 2015
 * 
 * @author Tim Miller
 */
public abstract class Shape
{
	/**
	 * @return the area (or volume) of a figure
	 */
	abstract public double computeArea();

	/**
	 * @return the perimeter (or surface area) of a figure
	 */
	abstract public double computePerimeter();
}
