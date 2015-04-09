
import java.awt.EventQueue;

import javax.swing.JFrame;

public class AppWindow
{

	private JFrame	frame;
	private ProgramOfStudy	pos;

	/**
	 * Create the application.
	 * @param pos 
	 */
	public AppWindow(ProgramOfStudy pos)
	{
		this.pos = pos;
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				AppWindow.this.initialize();

			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		this.frame = new JFrame();
		frame.setResizable(false);
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
