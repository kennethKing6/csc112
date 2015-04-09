import java.io.Serializable;

/**
 * Represents a course that might be taken by a student.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Course implements Serializable
{
	private static final long	serialVersionUID	= -3414076556011163077L;

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
	public Course(String prefix, int number, String title)
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
	public Course(String prefix, int number, String title, String grade)
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + number;
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof Course)) { return false; }
		Course other = (Course) obj;
		if (grade == null)
		{
			if (other.grade != null) { return false; }
		}
		else if (!grade.equals(other.grade)) { return false; }
		if (number != other.number) { return false; }
		if (prefix == null)
		{
			if (other.prefix != null) { return false; }
		}
		else if (!prefix.equals(other.prefix)) { return false; }
		if (title == null)
		{
			if (other.title != null) { return false; }
		}
		else if (!title.equals(other.title)) { return false; }
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
	@Override
	public String toString()
	{
		String result = this.prefix + "  " + this.number + "  " + this.title;
		if (!this.grade.equals(""))
		{
			result += "  " + this.grade + "  ";
		}
		else
		{
			result += "  " + "N/A";
		}
		return result;
	}
}
