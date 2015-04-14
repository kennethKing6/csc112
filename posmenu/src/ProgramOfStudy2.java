import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Scanner;

import jsjf.ArrayOrderedList;

public class ProgramOfStudy2 implements Iterable<Course2>, Serializable
{
	/**
	 *
	 */
	private static final long				serialVersionUID	= 6351403329122962471L;
	private final ArrayOrderedList<Course2>	list				= new ArrayOrderedList<Course2>();

	/**
	 * Constructs an initially empty Program of Study.
	 */
	public ProgramOfStudy2()
	{

	}

	/**
	 * Adds the specified course to the end of the course list.
	 *
	 * @param course
	 *            the course to add
	 */
	public void addCourse(Course2 course)
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
	public Course2 find(String prefix, int number)
	{
		for (final Course2 course : this.list)
		{
			if (prefix.equals(course.getPrefix())
					&& (number == course.getNumber())) { return course; }
		}

		return null;
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
	public Iterator<Course2> iterator()
	{
		return this.list.iterator();
	}

	/**
	 * Loads a serialized Program of Study from the specified file.
	 *
	 * @param fileName
	 *            the file from which the POS is read
	 * @return the loaded Program of Study
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ProgramOfStudy2 load(String fileName) throws IOException,
			ClassNotFoundException
	{
		/*
		 * FileInputStream fis = new FileInputStream(fileName);
		 * ObjectInputStream ois = new ObjectInputStream(fis);
		 * ProgramOfStudy pos = (ProgramOfStudy) ois.readObject();
		 * ois.close();
		 */
		final ProgramOfStudy2 pos = new ProgramOfStudy2();
		final Scanner fileScan = new Scanner(new File(fileName));
		Scanner stringScan;

		String record = "";
		String prefix = "";
		int number = 0;
		String courseName = "";
		String grade = "";

		while (fileScan.hasNext())
		{
			record = fileScan.nextLine();
			stringScan = new Scanner(record);
			stringScan.useDelimiter("  ");
			prefix = stringScan.next();
			number = stringScan.nextInt();
			courseName = stringScan.next();
			grade = stringScan.next();
			pos.addCourse(new Course2(prefix, number, courseName, grade));
			stringScan.close();

		}
		System.out.println("\nFile " + fileName + " is loaded\n");
		fileScan.close();
		return pos;
	}

	public void removeCourse(Course2 course)
	{
		if (course != null)
		{
			this.list.remove(course);
		}
	}

	/**
	 * Adds the specified course after the target course. Does nothing if
	 * either course is null or if the target is not found.
	 *
	 * @param target
	 *            the course after which the new course will be added
	 * @param newCourse
	 *            the course to add
	 */
	/*
	 * public void addCourseAfter(Course2 target, Course2 newCourse)
	 * {
	 * if (target == null || newCourse == null)
	 * return;
	 * int targetIndex = list.indexOf(target);
	 * if (targetIndex != -1)
	 * list.add(targetIndex + 1, newCourse);
	 * }
	 */
	/**
	 * Replaces the specified target course with the new course. Does nothing if
	 * either course is null or if the target is not found.
	 *
	 * @param target
	 *            the course to be replaced
	 * @param newCourse
	 *            the new course to add
	 */
	public void replace(Course2 target, Course2 newCourse)
	{
		if ((target == null) || (newCourse == null)) { return; }
		this.list.remove(target);
		System.out.println(target + "has been removed \n");

		this.list.add(newCourse);
		System.out.println(newCourse + "has been added \n");

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
		/*
		 * FileOutputStream fos = new FileOutputStream(fileName);
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * oos.writeObject(this);
		 * oos.flush();
		 * oos.close();
		 */
		final FileWriter fw = new FileWriter(fileName);
		final BufferedWriter bw = new BufferedWriter(fw);
		final PrintWriter pw = new PrintWriter(bw);

		for (final Course2 course : this.list)
		{
			pw.println(course);
		}

		pw.flush();
		pw.close();
	}

	/**
	 * Creates and returns a string representation of this Program of Study.
	 *
	 * @return a string representation of the Program of Study
	 */
	public String toString()
	{
		String result = "";
		for (final Course2 course : this.list)
		{
			result += course + "\n";
		}
		return result;
	}
}
