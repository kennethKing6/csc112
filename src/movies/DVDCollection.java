package movies;

// ********************************************************************
// DVDCollection.java Author: Lewis/Loftus
//
// Represents a collection of DVD movies.
// ********************************************************************

import java.text.NumberFormat;

public class DVDCollection
{
	private DVD[]	collection;

	private int		count;

	private double	totalCost;

	// -----------------------------------------------------------------
	// Constructor: Creates an initially empty collection.
	// -----------------------------------------------------------------
	public DVDCollection()
	{
		this.collection = new DVD[100];
		this.count = 0;
		this.totalCost = 0.0;
	}

	// -----------------------------------------------------------------
	// Adds a DVD to the collection, increasing the size of the
	// collection array if necessary.
	// -----------------------------------------------------------------
	public void addDVD(final String title, final String director,
			final int year,
			final double cost, final boolean bluRay)
	{
		if (this.count == this.collection.length)
		{
			this.increaseSize();
		}

		this.collection[this.count] = new DVD(title, director, year, cost,
				bluRay);
		this.totalCost += cost;
		this.count++;
	}
	
	public void subDVD(String title)
	{
		// j will count the number of CD's in the newly sized collection
	      int j = 0;
	      // i will count the current number of CD's
	      int i;
	      // create a temporary array of CD objects 
	      // which will become the newly sized collection
	      DVD [] temp = new DVD[collection.length];
	       
	      for(i=0; i<count; i++)
	      {
	         // look for a match
	         if(title.compareTo(collection[i].getTitle()) != 0)
	         {
	            // if there is no match, copy from the old to the new
	            temp[j] = collection[i];
	            j++;
	         }
	         else
	         {  
	            // if there is a match, do not copy from the old to the new
	            // but update the total value
	            totalCost -= collection[i].getCost();
	         }
	      }
	     
	      // check to see if there was a match and a deletion from the collection
	      if (i != j) 
	      {
	          count--;
	          System.out.println("\nCD deleted\n");
	          collection = temp;
	      }
	      else
	          System.out.println("\nCD not found\n");
	}

	// -----------------------------------------------------------------
	// Returns a report describing the DVD collection.
	// -----------------------------------------------------------------
	@Override
	public String toString()
	{
		final NumberFormat fmt = NumberFormat.getCurrencyInstance();

		String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		report += "My DVD Collection\n\n";

		report += "Number of DVDs: " + this.count + "\n";
		report += "Total cost: " + fmt.format(this.totalCost) + "\n";
		report += "Average cost: " + fmt.format(this.totalCost / this.count);

		report += "\n\nDVD List:\n\n";

		for (int dvd = 0; dvd < this.count; dvd++)
		{
			report += this.collection[dvd].toString() + "\n";
		}

		return report;
	}

	// -----------------------------------------------------------------
	// Increases the capacity of the collection by creating a
	// larger array and copying the existing collection into it.
	// -----------------------------------------------------------------
	private void increaseSize()
	{
		final DVD[] temp = new DVD[this.collection.length * 2];

		for (int dvd = 0; dvd < this.collection.length; dvd++)
		{
			temp[dvd] = this.collection[dvd];
		}

		this.collection = temp;
	}
}
