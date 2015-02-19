package shapes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * The UML diagram for the program is located in uml_diagram.bmp, and the
 * program logic is located in logic.md
 * Application class for the shapes package.
 * Program logic is located in "logic.txt"
 * ShapeTester.java<br>
 * Feb 19, 2015
 *
 * @author Tim Miller
 */
public class ShapeTester
{
	/**
	 * Main method for the application
	 *
	 * @param args
	 *            args
	 * @throws IOException
	 *             if the file io dies
	 * @throws URISyntaxException if the file io dies
	 */
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		final Scanner scan = new Scanner(new File(ShapeTester.class.getResource("shapes.dat").toURI()));
		double width, length, height, side, radius;

		while (scan.hasNext())
		{
			final String shapeType = scan.next();

			if (shapeType.equalsIgnoreCase("prism"))
			{
				width = scan.nextDouble();
				length = scan.nextDouble();
				height = scan.nextDouble();
				System.out.println(new Prism(width, length, height));
			}
			else
				if (shapeType.equalsIgnoreCase("pentahedron"))
				{
					width = scan.nextDouble();
					length = scan.nextDouble();
					height = scan.nextDouble();
					System.out.println(new Pentahedron(width, length, height));
				}
				else
					if (shapeType.equalsIgnoreCase("tetrahedron"))
					{
						side = scan.nextDouble();
						height = scan.nextDouble();
						System.out.println(new Tetrahedron(side, height));
					}
					else
						if (shapeType.equalsIgnoreCase("sphere"))
						{
							radius = scan.nextDouble();
							System.out.println(new Sphere(radius));
						}
						else
							if (shapeType.equalsIgnoreCase("cylinder"))
							{
								radius = scan.nextDouble();
								height = scan.nextDouble();
								System.out
								.println(new Cylinder(radius, height));
							}
		}
		scan.close();
	}
}
