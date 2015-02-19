package moviemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * DVDCollection.java<br>
 * Feb 5, 2015<br>
 *
 * @author Tim Miller
 */
public class DVDCollection implements Collection<DVD>
{
	private DVD[]	collection;
	private int		count;
	private double	totalCost;

	/**
	 * Default constructor
	 */
	public DVDCollection()
	{
		this.collection = new DVD[1];
		this.count = 0;
		this.totalCost = 0.0;
	}

	@Override
	public boolean add(final DVD dvd)
	{
		try
		{
			if (this.count == this.collection.length)
			{
				this.increaseSize();
			}
			this.collection[this.count] = dvd;
			this.totalCost += dvd.cost();
			this.count++;
			return true;
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param title
	 *            the title
	 * @param director
	 *            the director
	 * @param year
	 *            the year
	 * @param cost
	 *            the cost
	 * @param bluRay
	 *            whether or not the disc is bluray
	 */
	public void add(final String title, final String director, final int year,
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

	@Override
	public boolean addAll(final Collection<? extends DVD> c)
	{
		try
		{
			for (final DVD d : c)
			{
				this.add(d);
			}
			return true;
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param targetTitle
	 *            the title to search for
	 * @return the DVD
	 */
	public DVD binarySearch(final String targetTitle)
	{
		int min = 0;
		int max = this.count;
		int mid = 0;
		boolean found = false;

		while (!found && (min <= max))
		{
			mid = (min + max) / 2;
			if (this.collection[mid].title().compareTo(targetTitle) == 0)
			{
				found = true;
			}
			else
				if (this.collection[mid].title().compareTo(targetTitle) > 0)
				{
					max = mid - 1;
				}
				else
				{
					min = mid + 1;
				}
		}

		if (found)
		{
			return this.collection[mid];
		}
		else
		{
			return null;
		}
	}

	@Override
	public void clear()
	{
		this.collection = new DVD[1];
	}

	@Override
	public boolean contains(final Object o)
	{
		return false;
	}

	@Override
	public boolean containsAll(final Collection<?> c)
	{
		return false;
	}

	/**
	 * @return the size of the collection
	 */
	public int currentSize()
	{
		return this.collection.length;
	}

	/**
	 * @param title
	 *            the title of the dvd
	 * @return the dvd
	 */
	public DVD getDVD(final String title)
	{
		for (final DVD d : this.collection)
		{
			try
			{
				if (d.title().equalsIgnoreCase(title))
				{
					return d;
				}
			}
			catch (final NullPointerException e)
			{
				return null;
			}
		}
		return null;
	}

	/**
	 * Increase the array size
	 */
	private void increaseSize()
	{
		final DVD[] temp = new DVD[this.collection.length * 2];

		for (int dvd = 0; dvd < this.collection.length; dvd++)
		{
			temp[dvd] = this.collection[dvd];
		}

		this.collection = temp;
	}

	@Override
	public boolean isEmpty()
	{
		if (this.collection.length > 1)
		{
			return false;
		}
		else
			if (this.collection[0] == null)
			{
				return false;
			}
			else
			{
				return true;
			}
	}

	@Override
	public Iterator<DVD> iterator()
	{
		return Arrays.asList(this.collection).iterator();
	}

	@Override
	public boolean remove(final Object o)
	{
		try
		{
			for (int count = 0; count < this.collection.length; count++)
			{
				if (this.collection[count] == o)
				{
					this.collection[count] = null;
				}
			}
			return true;
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeAll(final Collection<?> c)
	{
		try
		{
			for (final Object obj : c)
			{
				for (int count = 0; count < this.collection.length; count++)
				{
					if (this.collection[count] == obj)
					{
						this.collection[count] = null;
					}
				}
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean retainAll(final Collection<?> c)
	{
		return false;		// Lol, who even uses this
	}

	public void scannerReadFile(final File file)
	{
		try
		{
			Scanner fileScan, recordScan;

			String title, director, record;
			double cost;
			int year;
			boolean bluRay;

			this.count = 0;
			this.totalCost = 0.0;

			fileScan = new Scanner(file);

			while (fileScan.hasNext())
			{
				if (this.collection.length == 0)
				{
					this.collection = new DVD[1];
				}
				if (this.count >= this.collection.length)
				{
					this.increaseSize();
				}

				record = fileScan.nextLine();
				recordScan = new Scanner(record);
				recordScan.useDelimiter("/");

				title = recordScan.next();
				director = recordScan.next();
				year = recordScan.nextInt();
				cost = recordScan.nextDouble();
				bluRay = recordScan.nextBoolean();
				this.collection[this.count] = new DVD(title, director, year,
						cost, bluRay);
				this.totalCost += cost;
				this.count++;

			}
			fileScan.close();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Sort by the director
	 */
	public void selectionSortByDirector()
	{
		int min;

		DVD temp;

		for (int index = 0; index < (this.count - 1); index++)
		{
			min = index;

			for (int scan = index + 1; scan < this.count; scan++)
			{
				if (this.collection[scan].director().compareTo(
						this.collection[min].director()) < 0)
				{
					min = scan;
				}
			}

			temp = this.collection[min];
			this.collection[min] = this.collection[index];
			this.collection[index] = temp;
		}
	}

	/**
	 * Sort by title
	 */
	public void selectionSortByTitle()
	{
		int min;

		DVD temp;

		for (int index = 0; index < (this.count - 1); index++)
		{
			min = index;

			for (int scan = index + 1; scan < this.count; scan++)
			{
				if (this.collection[scan].title().compareTo(
						this.collection[min].title()) < 0)
				{
					min = scan;
				}
			}

			temp = this.collection[min];
			this.collection[min] = this.collection[index];
			this.collection[index] = temp;
		}
	}

	@Override
	public int size()
	{
		return this.collection.length;
	}

	/**
	 * @param title
	 *            The title
	 * @return whether or not the task was completed successfully
	 */
	public boolean subDVD(final String title)
	{
		int j = 0;
		int i;

		final DVD[] temp = new DVD[this.currentSize()];

		for (i = 0; i < this.count; i++)
		{
			if (title.equalsIgnoreCase(this.collection[i].title()))
			{
				this.totalCost -= this.collection[i].cost();
			}
			else
			{
				temp[j] = this.collection[i];
				j++;
			}
		}

		if (i != j)
		{
			this.count--;
			this.collection = temp;
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public Object[] toArray()
	{
		final Object[] dest = new Object[this.collection.length];
		System.arraycopy(this.collection, 0, dest, 0, this.collection.length);
		return dest;
	}

	@Override
	public <T> T[] toArray(final T[] a)
	{
		System.arraycopy(this.collection, 0, a, 0, this.collection.length);
		return a;
	}

	public String toListString()
	{
		String string = "Title\tDirector\tYear\tCost\tBluray\n===================================================\n";
		loop: for (final DVD d : this.collection)
		{
			try
			{
				string += d.toListString();
			}
			catch (final NullPointerException e)
			{
				break loop;
			}
		}
		return string;
	}

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

	/**
	 * @param title
	 *            the title
	 * @param director
	 *            the director
	 * @param year
	 *            the year
	 * @param cost
	 *            the cost
	 * @param bluRay
	 *            whether or not it's a bluray
	 * @throws Exception
	 *             if something happened
	 */
	public void updDVD(final String title, final String director,
			final int year, final double cost, final boolean bluRay)
					throws Exception
	{
		int i;
		int flag = 0;
		final DVD[] temp = new DVD[this.currentSize()];

		for (i = 0; i < this.count; i++)
		{
			if (title.equalsIgnoreCase(this.collection[i].title()))
			{
				temp[i] = new DVD(title, director, year, cost, bluRay);
				this.totalCost -= this.collection[i].cost();
				this.totalCost += cost;
				flag = 1;
			}
			else
			{
				temp[i] = this.collection[i];
			}
		}
		if (flag == 1)
		{
			throw new Exception("DVD not found");
		}
		else this.collection = temp;
	}

	/**
	 * @param title
	 *            the title
	 * @param director
	 *            the director
	 * @param year
	 *            the year
	 * @param cost
	 *            the cost
	 * @param bluRay
	 *            whether or not it's a bluray
	 * @throws Exception
	 *             if something happened
	 */
	public void updDVD(final String title, final String director,
			final String year, final String cost, final String bluRay)
					throws Exception
	{
		this.updDVD(title, director, Integer.parseInt(year),
				Double.parseDouble(cost), Boolean.parseBoolean(bluRay));
	}

	/**
	 * @param file
	 *            the file to write to
	 */
	public void writeToFile(final File file)
	{
		try
		{
			final FileWriter fw = new FileWriter(file, false);

			final BufferedWriter bw = new BufferedWriter(fw);

			String s;

			for (int i = 0; i < this.count; i++)
			{
				s = "";
				s += this.collection[i].title() + "/";
				s += this.collection[i].director() + "/";
				s += this.collection[i].getYear() + "/";
				s += this.collection[i].cost() + "/";
				s += this.collection[i].bluray() + "\r\n";
				bw.write(s);
			}

			bw.flush();
			bw.close();
		}

		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}
}
