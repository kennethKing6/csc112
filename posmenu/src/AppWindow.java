import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import static java.util.logging.Level.*;

public class AppWindow
{

	public static Logger		logger	= Logger.getLogger(AppWindow.class
												.getCanonicalName());

	public static final File	POS_DAT	= new File("pos.dat");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					final AppWindow window = new AppWindow();
					window.frame.setVisible(true);
				}
				catch (final Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	static
	{
	    FileHandler fh;  

	    try {  

	        fh = new FileHandler("./logfile.log");  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}

	private JFrame			frame;

	private ProgramOfStudy	pos;

	/**
	 * Create the application.
	 */
	public AppWindow()
	{
		this.initialize();
	}
	
	protected void guiAdd()
	{
		logger.log(Level.INFO, "Adding");
		try
		{
			Course c = new Course(getClassPrefix(), getClassNum(), getClassTitle());
			pos.addCourse(c);
			JOptionPane.showMessageDialog(null, "The course was added successfully", "", JOptionPane.PLAIN_MESSAGE);
		}
		catch (Exception e)
		{
			logger.log(Level.INFO, e.getMessage());
			JOptionPane.showMessageDialog(null, "The course was not added successfully\nPlease see the log for more details", "", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public static String getClassPrefix()
	{
		return JOptionPane.showInputDialog(null, "Please enter the class prefix", "", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static int getClassNum()
	{
		return Integer.valueOf(JOptionPane.showInputDialog(null, "Please enter the class number","", JOptionPane.PLAIN_MESSAGE));
	}
		
	public static String getClassTitle()
	{
		return JOptionPane.showInputDialog(null, "Please enter the class title", "", JOptionPane.PLAIN_MESSAGE);
	}

	protected void guiError(String task, Throwable e)
	{
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "An error has occurred and the task " + task + " could not be completed", "Error", JOptionPane.WARNING_MESSAGE);
	}

	protected void guiFind()
	{
		// TODO
	}

	protected void guiList()
	{
		// TODO
	}

	protected void guiLoad()
	{
		// TODO
	}
	
	public ProgramOfStudy getProgram()
	{
		return pos;
	}

	protected void guiQuit()
	{
		AppWindow.logger.log(Level.INFO, "Shutting down!");
		System.exit(0);
	}

	protected void guiRemove()
	{
		// TODO
	}

	protected void guiSave()
	{
		AppWindow.logger.log(Level.INFO, "Saving");
		try
		{
			this.pos.save(AppWindow.POS_DAT.getAbsolutePath());
		}
		catch (final IOException e)
		{
			this.guiError("'save'", e);
		}
		catch (Exception e)
		{
			this.guiError("'save'", e);
		}
	}

	protected void guiSize()
	{
		logger.log(INFO, "size");
		JOptionPane.showMessageDialog(null, "The Program of Study size is " + pos.getSize(),"Size", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void guiUpdate()
	{
		logger.log(Level.INFO, "Updating");
		//TODO
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		this.pos = new ProgramOfStudy();

		this.frame = new JFrame();
		this.frame.setTitle("Program of Study 2015");
		this.frame.setResizable(false);
		this.frame.setBounds(100, 100, 277, 171);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		final JButton btnList = new JButton("List");
		btnList.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiList();
			}
		});
		btnList.setBounds(12, 33, 117, 25);
		this.frame.getContentPane().add(btnList);

		final JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiAdd();
			}
		});
		btnAdd.setBounds(12, 70, 117, 25);
		this.frame.getContentPane().add(btnAdd);

		final JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiRemove();
			}
		});
		btnRemove.setBounds(12, 107, 117, 25);
		this.frame.getContentPane().add(btnRemove);

		final JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiUpdate();
			}
		});
		btnUpdate.setBounds(141, 107, 117, 25);
		this.frame.getContentPane().add(btnUpdate);

		final JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiFind();
			}
		});
		btnFind.setBounds(141, 70, 117, 25);
		this.frame.getContentPane().add(btnFind);

		final JButton btnSize = new JButton("Size");
		btnSize.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiSize();
			}
		});
		btnSize.setBounds(141, 33, 117, 25);
		this.frame.getContentPane().add(btnSize);

		final JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 269, 21);
		this.frame.getContentPane().add(menuBar);

		final JMenu mnPosmenu = new JMenu("POSMenu");
		menuBar.add(mnPosmenu);

		final JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiSave();
			}
		});
		mnPosmenu.add(mntmSave);

		final JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiLoad();
			}
		});
		mnPosmenu.add(mntmLoad);

		final JSeparator separator = new JSeparator();
		mnPosmenu.add(separator);

		final JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AppWindow.this.guiQuit();
			}
		});
		mnPosmenu.add(mntmQuit);

	}
}
