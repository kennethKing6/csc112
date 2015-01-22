package movies;

// ********************************************************************
// Movies.java Author: Lewis/Loftus
//
// Demonstrates the use of an array of objects.
//
// http://studenthome.sunyocc.edu/~pagelj/csc111/c8.html
// ********************************************************************

public class Movies
{
	// -----------------------------------------------------------------
	// Creates a DVDCollection object and adds some DVDs to it. Prints
	// reports on the status of the collection.
	// -----------------------------------------------------------------
	public static void main(final String[] args)
	{
		final DVDCollection movies = new DVDCollection();

		movies.addDVD("The Godfather", "Francis Ford Coppala", 1972, 24.95,
				true);
		movies.addDVD("District 9", "Neill Blomkamp", 2009, 19.95, false);
		movies.addDVD("Iron Man", "Jon Favreau", 2008, 15.95, false);
		movies.addDVD("All About Eve", "Joseph Mankiewicz", 1950, 17.50, false);
		movies.addDVD("The Matrix", "Andy & Lana Wachowski", 1999, 19.95, true);
		movies.addDVD("Pulp Fiction", "Quentin Tarantine", 1997, 3.50, true);
		movies.addDVD("VHS", "Some dood", 2007, 3.50, false);
		movies.addDVD("Carver", "Some other dood", 2008, 3.50, false);

		System.out.println(movies);

		movies.addDVD("Iron Man 2", "Jon Favreau", 2010, 22.99, false);
		movies.addDVD("Casablanca", "Michael Curtiz", 1942, 19.95, false);

		System.out.println(movies);
		
		movies.subDVD("Pulp Fiction");
		
		System.out.println(movies);
	}
}
