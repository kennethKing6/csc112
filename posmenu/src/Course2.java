import java.io.Serializable;

/**
 * Course2.java<br>
 * Apr 14, 2015
 * 
 * @author Tim Miller
 */
public class Course2 implements Serializable, Comparable<Course2>
{
	/**
	 *
	 */
	private static final long	serialVersionUID	= 2603037426011595652L;
	private String				grade;
	private final int			number;
	private final String		prefix;
	private final String		title;

	/**
	 * Constructs the course with the specified information, with no grade
	 * established.
	 *
	 * @param prefix
	 *            the prefix of the course designation
	 * @param number
	 *            the number of the course designation
	 * @param title
	 *            the title of the course
	 */
	public Course2(String prefix, int number, String title)
	{
		this(prefix, number, title, "");
	}

	/**
	 * Constructs the course with the specified information.
	 *
	 * @param prefix
	 *            the prefix of the course designation
	 * @param number
	 *            the number of the course designation
	 * @param title
	 *            the title of the course
	 * @param grade
	 *            the grade received for the course
	 */
	public Course2(String prefix, int number, String title, String grade)
	{
		this.prefix = prefix;
		this.number = number;
		this.title = title;
		if (grade == null)
		{
			this.grade = "";
		}
		else
		{
			this.grade = grade;
		}
	}

	public int compareTo(Course2 other)
	{
		int result = this.prefix.compareTo(other.getPrefix());
		if (result == 0)
		{
			result = this.number - other.getNumber();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Course2)) return false;
		Course2 other = (Course2) obj;
		if (number != other.number) return false;
		if (prefix == null)
		{
			if (other.prefix != null) return false;
		}
		else if (!prefix.equals(other.prefix)) return false;
		return true;
	}

	/**
	 * Returns the grade for this course.
	 *
	 * @return the grade for this course
	 */
	public String getGrade()
	{
		return this.grade;
	}

	/**
	 * Returns the number of the course designation.
	 *
	 * @return the number of the course designation
	 */
	public int getNumber()
	{
		return this.number;
	}

	/**
	 * Returns the prefix of the course designation.
	 *
	 * @return the prefix of the course designation
	 */
	public String getPrefix()
	{
		return this.prefix;
	}

	/**
	 * Returns the title of this course.
	 *
	 * @return the prefix of the course
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * Sets the grade for this course to the one specified.
	 *
	 * @param grade
	 *            the new grade for the course
	 */
	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	/**
	 * Returns true if this course has been taken (if a grade has been received).
	 *
	 * @return true if this course has been taken and false otherwise
	 */
	public boolean taken()
	{
		return !this.grade.equals("");
	}

	/**
	 * Creates and returns a string representation of this course.
	 *
	 * @return a string representation of the course
	 */
	public String toString()
	{
		String result = this.prefix + "  " + this.number + "  " + this.title;
		if (!this.grade.equals(""))
		{
			result += "  " + this.grade;
		}
		else
		{
			result += "  " + "[]";
		}
		return result;
	}

}
