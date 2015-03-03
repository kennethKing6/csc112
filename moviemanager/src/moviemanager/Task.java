package moviemanager;

/**
 * Task.java<br>
 * Feb 5, 2015<br>
 *
 * @author Tim Miller
 */
public class Task
{
	/**
	 * Task.java<br>
	 * Feb 5, 2015<br>
	 *
	 * @author Tim Miller
	 */
	public static abstract class TaskRunnable
	{
		public abstract void run(String... args);
	}

	/**
	 * Task.java<br>
	 * Feb 5, 2015<br>
	 *
	 * @author Tim Miller
	 */
	public class TaskThread extends Thread
	{
		public final String[]	args;

		public final Task		task;

		public TaskThread(final Task task, final String[] args)
		{
			this.args = args;
			this.task = task;

		}

		@Override
		public void run()
		{
			this.task.run.run();
		}

		@Override
		public void start()
		{
			super.start();
		}
	}

	/**
	 * The description for the task
	 */
	private final String		desc;

	/**
	 * The name of the task
	 */
	private final String		name;

	/**
	 * The runnable object for the task
	 */
	private final TaskRunnable	run;

	/**
	 * @param name
	 *            the name
	 * @param desc
	 *            the description
	 * @param run
	 *            the runnable
	 */
	public Task(final String name, final String desc, final TaskRunnable run)
	{
		this.name = name == null ? "" : name;
		this.desc = desc == null ? "" : desc;
		if (run == null)
		{
			throw new NullPointerException("Runnable for task " + this.name
					+ "was null");
		}
		this.run = run;
	}

	/**
	 * @param name
	 *            the name
	 * @param run
	 *            the runnable
	 */
	public Task(final String name, final TaskRunnable run)
	{
		this(name, "", run);
	}

	/**
	 * @return the description
	 */
	public String desc()
	{
		return this.desc;
	}

	/**
	 * @return the name
	 */
	public String name()
	{
		return this.name;
	}

	/**
	 * @param args
	 *            the args
	 */
	public void run(final String... args)
	{
		final Thread tt = new TaskThread(this, args);
		tt.start();
		try
		{
			tt.join();
		}
		catch (final InterruptedException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}
