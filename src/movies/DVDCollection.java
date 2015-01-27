package movies;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class DVDCollection implements Collection<DVD>
{
	private DVD[]	collection;

	private int		count;

	private double	totalCost;

	/**
	 * Standard constructor for a simple collection of DVD's
	 */
	public DVDCollection()
	{
		this.collection = new DVD[100];
		this.count = 0;
		this.totalCost = 0.0;
	}

	@Override
	public boolean add(final DVD e)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addAll(final Collection<? extends DVD> c)
	{
		throw new UnsupportedOperationException();
	}

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

	@Override
	public void clear()
	{
		for(DVD d:collection)
		{
			d.getDirector();
			d = null;
		}
	}
	
	public int collectionLength()
	{
		return this.collection.length;
	}
	
	@Override
	public boolean contains(final Object o)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(final Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean isEmpty()
	{
		return false;
	}
	
	@Override
	public Iterator<DVD> iterator()
	{
		return Arrays.asList(collection).iterator();
	}
	
	@Override
	public boolean remove(final Object o)
	{
		if (o instanceof String)
		{
			final String s = (String) o;
			return this.subDVD(s);
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean removeAll(final Collection<?> c)
	{
		for(Object o:c)
		{
			if(o instanceof String)
			{
				String s = (String) o;
				return this.subDVD(s);
			}
			else if (o instanceof DVD)
			{
				DVD d = (DVD) o;
				return this.remove(d);
			}
			else return false;
		}
		return false;
	}
	
	@Override
	public boolean retainAll(final Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int size()
	{
		return collection.length;
	}
	
	public boolean subDVD(final String title)
	{
		try
		{
			int j = 0;
			int i;
			final DVD[] temp = new DVD[this.collection.length];

			for (i = 0; i < this.count; i++)
			{
				if (title.compareTo(this.collection[i].getTitle()) != 0)
				{
					temp[j] = this.collection[i];
					j++;
				}
				else
				{
					this.totalCost -= this.collection[i].getCost();
				}
			}

			if (i != j)
			{
				this.count--;
				System.out.println("\nCD deleted\n");
				this.collection = temp;
			}
			else
			{
				System.out.println("\nCD not found\n");
				return false;
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
	public DVD[] toArray()
	{
		final DVD[] dest = new DVD[100];
		System.arraycopy(this.collection, 0, dest, 0, this.collection.length);
		return dest;
	}
	
	@Override
	public <T> T[] toArray(final T[] a)
	{
		throw new UnsupportedOperationException();
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
	
	public double totalValue()
	{
		return this.totalCost;
	}
	
	public void updDVD(final String title, final String director,
			final int year, final double value, final boolean bluray)
	{
		int i;
		int flag = 0;
		final DVD[] temp = new DVD[this.collection.length];

		for (i = 0; i < this.count; i++)
		{
			if (title.compareTo(this.collection[i].getTitle()) != 0)
			{
				temp[i] = this.collection[i];
			}
			else
			{
				temp[i] = new DVD(title, director, year, value, bluray);
				this.totalCost -= this.collection[i].getCost();
				this.totalCost += value;
				flag = 1;
			}
		}

		if (flag == 1)
		{
			System.out.println("\nCollection Updated\n");
			this.collection = temp;
		}
		else
		{
			System.out.println("\nCD not found\n");
		}
	}
	
	protected void increaseSize()
	{
		final DVD[] temp = new DVD[this.collection.length * 2];

		for (int dvd = 0; dvd < this.collection.length; dvd++)
		{
			temp[dvd] = this.collection[dvd];
		}

		this.collection = temp;
	}
}
