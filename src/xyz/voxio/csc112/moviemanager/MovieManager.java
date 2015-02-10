package xyz.voxio.csc112.moviemanager;

import java.awt.Desktop;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import xyz.voxio.csc112.moviemanager.Task.TaskRunnable;

/**
 * MovieManager.java<br>
 * Feb 5, 2015<br>
 *
 * @author Tim Miller
 *
 */
public final class MovieManager
{
	/**
	 * The default endline for the system
	 */
	public static final String	END_LINE	= System
			.getProperty("line.separator");

	/**
	 * The file to write and read to and from
	 */
	public static final File	FILE	 = new File("dvds.txt");

	/**
	 * The prompt
	 */
	public static final String	PROMPT	 = ">>";
	
	/**
	 * The scanner
	 */
	public static final Scanner	scan	 = new Scanner(System.in);

	private static MovieManager	instance;
	
	static
	{
		MovieManager.scan.useDelimiter("\n");
	}

	/**
	 * @return the instance of the class
	 */
	public static MovieManager instance()
	{
		if (MovieManager.instance == null)
		{
			MovieManager.instance = new MovieManager();
			return MovieManager.instance;
		}
		return MovieManager.instance;
	}

	public static void main(final String[] args)
	{
		MovieManager.instance = new MovieManager();
		MovieManager.instance().initialize();
		MovieManager.instance().start();
	}
	
	public static void openWebpage(final String string)
	{
		try
		{
			MovieManager.openWebpage(new URL(string));
		}
		catch (final MalformedURLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void openWebpage(final URI uri)
	{
		final Desktop desktop = Desktop.isDesktopSupported() ? Desktop
		        .getDesktop() : null;
		if ((desktop != null) && desktop.isSupported(Desktop.Action.BROWSE))
		{
			try
			{
				desktop.browse(uri);
			}
			catch (final Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void openWebpage(final URL url)
	{
		try
		{
			MovieManager.openWebpage(url.toURI());
		}
		catch (final URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String stripNewline(String string)
	{
		if (string.endsWith("\n") || string.endsWith("\r"))
		{
			string = string.substring(0, string.length() - 1);
			return MovieManager.stripNewline(string);
		}
		else
		{
			return string;
		}
	}
	
	public DVDCollection	col	    = new DVDCollection();

	private final Set<Task>	taskSet	= new HashSet<Task>();
	
	/**
	 * @param i exit code
	 */
	protected void exit(final int i)
	{
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	/**
	 * @return the input
	 */
	private String getInput(final String prompt, final Scanner scan,
	        final boolean newLine)
	{
		if (newLine)
		{
			System.out.println(prompt);
		}
		else
		{
			System.out.print(prompt);
		}
		String str = scan.next();
		if (str.contains("/"))
		{
			System.out.println("Sorry, input cannot contain \"/\"");
			return this.getInput(prompt, scan, newLine);
		}
		str = MovieManager.stripNewline(str);
		return str;
	}

	/**
	 * Initialize the array
	 */
	private void initialize()
	{
		this.taskSet.add(new Task("menu", "Displays the available commands",
				new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{
				for (final Task t : MovieManager.this.taskSet)
				{
					System.out.println(t.name() + "\t\t\t"
							+ t.desc());
				}
			}
		}));
		this.taskSet.add(new Task("quit", "Quits the application",
				new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{
				MovieManager.this.exit(0);
			}
		}));
		this.taskSet.add(new Task("help", "Displays a simple help text",
				new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{
				System.out
				.println("Use 'menu' for a list of tasks, or 'quit' to quit, or 'help' to see this text again!");
			}
		}));
		this.taskSet.add(new Task("exit", "Alias for quit", new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{

				MovieManager.this.exit(0);
			}
		}));
		this.taskSet.add(new Task("add", "Add a DVD", new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{
				final String title = MovieManager.this.getInput("title: ",
				        MovieManager.scan, false);
				final String dir = MovieManager.this.getInput("director: ",
				        MovieManager.scan, false);
				final String year = MovieManager.this.getInput("year: ",
						MovieManager.scan, false);
				final String cost = MovieManager.this.getInput("cost: ",
				        MovieManager.scan, false);
				final String bluray = MovieManager.this.getInput("bluray: ",
				        MovieManager.scan, false);
				DVD dvd = null;
				try
				{
					dvd = new DVD(title, dir, year, cost, bluray);
				}
				catch (final NumberFormatException e)
				{
					e.printStackTrace();
					System.out.println("DVD was not added successfully");
					return;
				}
				MovieManager.this.col.add(dvd);
				System.out.println("DVD added successfully");
			}
		}));
		this.taskSet.add(new Task("delete", "Deletes a DVD", new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{
				final String title = MovieManager.this
				        .getInput(
				                "Please enter the title of the DVD you'd like to delete: ",
				                MovieManager.scan, false);
				final boolean val = MovieManager.this.col.subDVD(title);
				final String output = val ? "DVD " + title
				        + " was deleted successfully" : "DVD not found";
				System.out.println(output);
			}
		}));
		this.taskSet.add(new Task("display", "Display a DVD",
				new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{
				final String title = MovieManager.this.getInput(
				                "title: ", MovieManager.scan, false);
				final DVD dvd = MovieManager.this.col.getDVD(title);
				if (dvd == null)
				{
					System.out.println("DVD not found");
					return;
				}
				else
				{
					System.out.println(dvd.toString());
				}
			}
		}));
		this.taskSet.add(new Task("list", "Display a list of the DVD's",
				new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{
				System.out.println(MovieManager.this.col
						.toListString());
			}
		}));
		this.taskSet.add(new Task("repo",
		        "Open the source repo in the web browser", new TaskRunnable()
		        {
			        @Override
			        public void run(final String... args)
			        {
				        MovieManager
				                .openWebpage("https://github.com/Commador/MovieManager");
			        }
		        }));
		this.taskSet.add(new Task("write",
		        "Write the current data to a file (dvds.txt)",
		        new TaskRunnable()
		        {
			        @Override
			        public void run(final String... args)
			        {
				        try
				        {
					        MovieManager.this.col
					                .writeToFile(MovieManager.FILE);
				        }
				        catch (final Exception e)
				        {
					        e.printStackTrace();
					        System.out
					                .println("Sorry, an error occurred, the data was not written successfully");
					        return;
				        }
				        System.out.println("Data written successfully");
			        }
		        }));
		this.taskSet.add(new Task("issues",
		        "Open the issue tracker in the web browser", new TaskRunnable()
		        {
			        @Override
			        public void run(final String... args)
			        {
				        MovieManager
				                .openWebpage("https://github.com/Commador/MovieManager/issues");
			        }
		        }));
		this.taskSet.add(new Task("read",
		        "Read the data from a file (dvds.txt)", new TaskRunnable()
		        {
			        @Override
			        public void run(final String... args)
			        {
				        try
				        {
					        MovieManager.this.col
					                .scannerReadFile(MovieManager.FILE);
				        }
				        catch (final Exception e)
				        {
					        e.printStackTrace();
					        System.out
					                .println("Sorry, an error occurred, the data was not read successfully");
					        return;
				        }
				        System.out
				                .println("Data read successfully\nUse list to see the data");
			        }
		        }));
		this.taskSet.add(new Task("sortdirector",
		        "Sort the list by the director", new TaskRunnable()
		        {
			        @Override
			        public void run(final String... args)
			        {
				        try
				        {
					        MovieManager.this.col.selectionSortByDirector();
				        }
				        catch (final Exception e)
				        {
					        e.printStackTrace();
					        System.out
					                .println("Sorry, an error occurred, sort was unsuccessful");
				        }
			        }
		        }));
		this.taskSet.add(new Task("sorttitle", "Sort the list by the title",
		        new TaskRunnable()
		        {
			        @Override
			        public void run(final String... args)
			        {
				        try
				        {
					        MovieManager.this.col.selectionSortByTitle();
				        }
				        catch (final Exception e)
				        {
					        e.printStackTrace();
					        System.out
					                .println("Sorry, an error occurred, sort was unsuccessful");
				        }
			        }
		        }));
		this.taskSet.add(new Task("update", "Update a DVD", new TaskRunnable()
		{
			@Override
			public void run(final String... args)
			{
				final String title = MovieManager.this.getInput("title: ",
				        MovieManager.scan, false);
				final String dir = MovieManager.this.getInput("director: ",
				        MovieManager.scan, false);
				final String year = MovieManager.this.getInput("year: ",
				        MovieManager.scan, false);
				final String cost = MovieManager.this.getInput("cost: ",
				        MovieManager.scan, false);
				final String bluray = MovieManager.this.getInput("bluray: ",
				        MovieManager.scan, false);
				try
				{
					MovieManager.this.col
					        .updDVD(title, dir, year, cost, bluray);
				}
				catch (final Exception e)
				{
					e.printStackTrace();
					System.out
					        .println("DVD was not updated successfully");
					return;
				}
				System.out.println("DVD updated successfully");
			}
		}));
	}
	
	/**
	 * @param name the name of the task
	 * @param args the args for the task
	 */
	private void runTask(final String name, final String... args)
	{
		boolean found = false;
		for (final Task t : this.taskSet)
		{
			if (t.name().equalsIgnoreCase(name))
			{
				t.run(args);
				found = true;
			}
		}
		if (!found)
		{
			System.out.println("The command " + name
			        + " could not be found");
		}
	}

	/**
	 * Start the program
	 */
	private void start()
	{
		this.runTask("help");
		while (true)
		{
			System.out.print(MovieManager.PROMPT);
			String input = MovieManager.scan.next();
			input = input.split(" ")[0];
			input = MovieManager.stripNewline(input);
			this.runTask(input);
		}
	}
}
