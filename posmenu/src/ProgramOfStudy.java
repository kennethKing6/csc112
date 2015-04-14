import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

import jsjf.ArrayOrderedList;

/**
 * Represents a Program of Study, a list of courses taken and planned, for an
 * individual student.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ProgramOfStudy implements Iterable<Course>, Serializable
{
	private static final long	serialVersionUID	= -2392190997001038578L;

	/**
	 * Loads a serialized Program of Study from the specified file.
	 *
	 * @param fileName
	 *            the file from which the POS is read
	 * @return the loaded Program of Study
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ProgramOfStudy load(String fileName) throws IOException,
			ClassNotFoundException
	{
		final FileInputStream fis = new FileInputStream(fileName);
		final ObjectInputStream ois = new ObjectInputStream(fis);
		final ProgramOfStudy pos = (ProgramOfStudy) ois.readObject();
		ois.close();

		return pos;
	}

	private final ArrayOrderedList<Course>	list;

	/**
	 * Constructs an initially empty Program of Study.
	 */
	public ProgramOfStudy()
	{
		this.list = new ArrayOrderedList<Course>();
	}

	/**
	 * Adds the specified course to the end of the course list.
	 *
	 * @param course
	 *            the course to add
	 */
	public void addCourse(Course course)
	{
		if (course != null)
		{
			this.list.add(course);
		}
	}

	/**
	 * Finds and returns the course matching the specified prefix and number.
	 *
	 * @param prefix
	 *            the prefix of the target course
	 * @param number
	 *            the number of the target course
	 * @return the course, or null if not found
	 */
	public Course find(String prefix, int number)
	{
		for (final Course course : this.list)
		{
			if (prefix.equals(course.getPrefix())
					&& (number == course.getNumber())) { return course; }
		}

		return null;
	}

	public ArrayOrderedList<Course> getList()
	{
		return this.list;
	}

	public int getSize()
	{
		return this.list.size();
	}

	/**
	 * Returns an iterator for this Program of Study.
	 *
	 * @return an iterator for the Program of Study
	 */
	@Override
	public Iterator<Course> iterator()
	{
		return this.list.iterator();
	}

	/**
	 * Replaces the specified target course with the new course. Does nothing if
	 * either course is null or if the target is not found.
	 *
	 * @param target
	 *            the course to be replaced
	 * @param newCourse
	 *            the new course to add
	 */
	public void replace(Course target, Course newCourse)
	{
		this.list.remove(target);
		this.list.add(newCourse);
	}

	/**
	 * Saves a serialized version of this Program of Study to the specified
	 * file name.
	 *
	 * @param fileName
	 *            the file name under which the POS will be stored
	 * @throws IOException
	 */
	public void save(String fileName) throws IOException
	{
		final FileOutputStream fos = new FileOutputStream(fileName);
		final ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.flush();
		oos.close();
	}

	/**
	 * Creates and returns a string representation of this Program of Study.
	 *
	 * @return a string representation of the Program of Study
	 */
	@Override
	public String toString()
	{
		String result = "";
		int count = 1;
		for (final Course course : this.list)
		{
			result += "" + count + ". " + course + "\n";
			count++;
		}

		return result;
	}

}
