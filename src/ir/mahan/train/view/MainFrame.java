package ir.mahan.train.view;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class MainFrame extends JFrame 
{
	TextPanel textPanel;
	UserPanel userPanel;
	Container pane;
	IStringListener iStringListener;
	private JMenuBar menuBar;
	private JMenu File;
	private JMenu windowBar;
	private JMenu showMenu;
	private JMenuItem exit;
	private JMenuItem exportData;
	private JMenuItem importData;
	private JMenuItem prefsItem;
	private JMenuItem showFormItem;
	JCheckBoxMenuItem showFormCheckBoxItem;
	public JFileChooser fileChooser = new JFileChooser();
	private JTabbedPane tabbedPane;
	private JSplitPane splitPane;

	public MainFrame(String title) 
	{
		super(title);
		setFrameView();
		setMenu();
		addPanels();
		this.setJMenuBar(menuBar);
	}
	
	private void setFrameView() 
	{		
		this.setSize(800, 610);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pane = new Container();
		//pane = this.getContentPane();
	}
	
	private JMenuBar setMenu()
	{
		File = new JMenu("File");
		windowBar = new JMenu("windowBar");
		
		
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new personFileFilter());
		
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	int action = JOptionPane.showConfirmDialog(MainFrame.this, "Reihaneh?" , "Confirm Exit" , JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION){
            	System.exit(0);
                }
            }
        });
		
		exportData = new JMenuItem("Export Data ...");
		exportData.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION)
                {
                }
            }
        });
		importData = new JMenuItem("Import Data ...");
		importData.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION)
                {
                }
            }
        });
		
		
		File.add(exportData);
		File.add(importData);
		File.addSeparator();
		File.add(exit);
		
	
		prefsItem = new JMenuItem("Preferences");
		showMenu = new JMenu("SHOW");
		showFormItem = new JMenuItem("Person Form");
		showFormCheckBoxItem = new JCheckBoxMenuItem("Show the form");
		showFormCheckBoxItem.setSelected(true);
		
		showMenu.add(showFormItem);
		showMenu.add(showFormCheckBoxItem);
		
		windowBar.add(showMenu);
		windowBar.add(prefsItem);
		
		menuBar = new JMenuBar();
		menuBar.add(File);
		menuBar.add(windowBar);
		
		File.setMnemonic(KeyEvent.VK_F);
		exit.setMnemonic(KeyEvent.VK_X);
		
		prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , ActionEvent.CTRL_MASK));
		importData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I , ActionEvent.CTRL_MASK));
		exportData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
		
		
		return menuBar;
		
	}
	private void addPanels() 
	{		
		
		this.textPanel = new TextPanel();
		Dimension dim = this.textPanel.getPreferredSize();
		dim.width = 480;
		this.textPanel.setDimension(dim);
		this.textPanel.setSize();
		this.iStringListener = new IStringListener() 
		{			
			@Override
			public void stringEmmited(String input) 
			{			
				textPanel.SetText(input);				
			}
		};								
		
		this.userPanel = new UserPanel();
		this.userPanel.setIStringListener(this.iStringListener);
		Dimension borderDim = this.userPanel.getPreferredSize();
		borderDim.width = 300;
		this.userPanel.setDimensions(borderDim);
		this.userPanel.setSize();
		

		
		tabbedPane = new JTabbedPane();
		tabbedPane.add("TextAria" , textPanel);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT , userPanel ,tabbedPane);
		this.add(splitPane);
		
	}		
}
