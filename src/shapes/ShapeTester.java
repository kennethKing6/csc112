package shapes;

// ******************************************************************************
// ShapeTester.java Java Foundations
//
// Solution to Programming Project 8.6
// ******************************************************************************

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShapeTester
{
	// ---------------------------------------------------------------------------
	// Read the dimensions of various 3-D shapes from an input file, then
	// displays pertinent information about each shape.
	// ---------------------------------------------------------------------------
	public static void main(String[] args) throws IOException
	{
		final Scanner scan = new Scanner(new File("shapes.dat"));
		double width, length, height, side, radius;

		// Read the data from the input file
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
