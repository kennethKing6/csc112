
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

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
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoad.setBounds(12, 123, 117, 25);
		frame.getContentPane().add(btnLoad);
		
		JButton btnList = new JButton("List");
		btnList.setBounds(12, 49, 117, 25);
		frame.getContentPane().add(btnList);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(12, 86, 117, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(12, 151, 117, 25);
		frame.getContentPane().add(btnRemove);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(141, 151, 117, 25);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(141, 12, 117, 25);
		frame.getContentPane().add(btnFind);
		
		JButton btnSize = new JButton("Size");
		btnSize.setBounds(141, 49, 117, 25);
		frame.getContentPane().add(btnSize);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(141, 188, 117, 25);
		frame.getContentPane().add(btnSave);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 129, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnPosmenu = new JMenu("POSMenu");
		menuBar.add(mnPosmenu);
		
		JSeparator separator_1 = new JSeparator();
		mnPosmenu.add(separator_1);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnPosmenu.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mnPosmenu.add(mntmLoad);
		
		JSeparator separator = new JSeparator();
		mnPosmenu.add(separator);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnPosmenu.add(mntmQuit);
	}
}
