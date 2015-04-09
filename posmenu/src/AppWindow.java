import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class AppWindow
{

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

	private JFrame			frame;

	private ProgramOfStudy	pos;

	/**
	 * Create the application.
	 */
	public AppWindow()
	{
		this.initialize();
	}

	protected void find()
	{

	}

	protected void guiAbout()
	{

	}

	protected void guiLoad()
	{

	}

	protected void guiQuit()
	{
		logger.log(Level.INFO, "Shutting down!");
		System.exit(0);
	}

	protected void guiSave()
	{
		
	}

	public static Logger logger = Logger.getLogger(AppWindow.class.getCanonicalName());
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		this.pos = new ProgramOfStudy();

		this.frame = new JFrame();
		this.frame.setResizable(false);
		this.frame.setBounds(100, 100, 277, 171);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		final JButton btnList = new JButton("List");
		btnList.setBounds(12, 33, 117, 25);
		this.frame.getContentPane().add(btnList);

		final JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(12, 70, 117, 25);
		this.frame.getContentPane().add(btnAdd);

		final JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(12, 107, 117, 25);
		this.frame.getContentPane().add(btnRemove);

		final JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(141, 107, 117, 25);
		this.frame.getContentPane().add(btnUpdate);

		final JButton btnFind = new JButton("Find");
		btnFind.setBounds(141, 70, 117, 25);
		this.frame.getContentPane().add(btnFind);

		final JButton btnSize = new JButton("Size");
		btnSize.setBounds(141, 33, 117, 25);
		this.frame.getContentPane().add(btnSize);

		final JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 269, 21);
		this.frame.getContentPane().add(menuBar);

		final JMenu mnPosmenu = new JMenu("POSMenu");
		menuBar.add(mnPosmenu);

		final JMenuItem mntmAbout = new JMenuItem("About");
		mnPosmenu.add(mntmAbout);

		final JSeparator separator_1 = new JSeparator();
		mnPosmenu.add(separator_1);

		final JMenuItem mntmSave = new JMenuItem("Save");
		mnPosmenu.add(mntmSave);

		final JMenuItem mntmLoad = new JMenuItem("Load");
		mnPosmenu.add(mntmLoad);

		final JSeparator separator = new JSeparator();
		mnPosmenu.add(separator);

		final JMenuItem mntmQuit = new JMenuItem("Quit");
		mnPosmenu.add(mntmQuit);
	}

	protected void guiList()
	{

	}

	protected void guiRemove()
	{

	}

	protected void guiSize()
	{

	}

	protected void guiUpdate()
	{

	}

}
