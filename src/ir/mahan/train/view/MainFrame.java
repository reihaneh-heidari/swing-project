package ir.mahan.train.view;

import ir.mahan.train.controler.Controler;
import ir.mahan.train.utility.Utility;
import ir.mahan.train.view.Components.TextArea_Panel;

//import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.io.IOException;
import java.io.Serializable;

public class MainFrame extends JFrame implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu File;
//	private JMenu windowBar;
//	private JMenu showMenu;
//	private JMenuItem prefsItem;
//	private JMenuItem showFormItem;
//	private JCheckBoxMenuItem showFormCheckBoxItem;	
	
	private JSplitPane splitPane;
	private IUserListener iStringListener;
	private UserPanel userPanel;
	private JTabbedPane tabbedPane;
	private TextArea_Panel textPanel;
	private UserTablePanel tablePanel;
	private Controler controler;
	
	int formWidth = 800;
	int formHeight = 600;

	public MainFrame(String title) 
	{
		super(title);
		controler = new Controler();
		setFrameView();
		setMenu();
		addPanels();
	}
		
	private void setFrameView() 
	{						
		this.setSize(new Dimension(formWidth , formHeight));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JMenuItem createExportDataMenuItem()
	{	
		JMenuItem exportDataMenuItem;
		exportDataMenuItem = new JMenuItem("Export Data");
		exportDataMenuItem.addActionListener(new ActionListener()
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {	
	        	JFileChooser fileChooser = new JFileChooser();
	    		fileChooser.setAcceptAllFileFilterUsed(true);
	    		if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
	            {
	    			try 
	    			{
						controler.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        }
	    });
		exportDataMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));		
		return exportDataMenuItem;
	}
	
	public JMenuItem createImportDataMenuItem()
	{	
		JMenuItem ImportDataMenuItem;
		ImportDataMenuItem = new JMenuItem("Import Data");
		ImportDataMenuItem.addActionListener(new ActionListener()
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {	       
	        	JFileChooser fileChooser = new JFileChooser();
	    		fileChooser.setAcceptAllFileFilterUsed(true);	    		
	            if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)
	            {
	            	try 
	    			{
						controler.loadFromFile(fileChooser.getSelectedFile());
					} catch (Exception e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        }
	    });
		ImportDataMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I , ActionEvent.CTRL_MASK));
		return ImportDataMenuItem;
	}
	
	private void setMenu()
	{
		File = new JMenu("File");		
		Utility.formComponent = MainFrame.this;
		File.add(createExportDataMenuItem());
		File.add(createImportDataMenuItem());
		File.addSeparator();
		File.add(Utility.createExitMenuItem());
		File.setMnemonic(KeyEvent.VK_F);

//		showMenu = new JMenu("SHOW");
//		showFormItem = new JMenuItem("Person Form");
//		showMenu.add(showFormItem);
//		showFormCheckBoxItem = new JCheckBoxMenuItem("Show the form");
//		showFormCheckBoxItem.setSelected(true);
//		showMenu.add(showFormCheckBoxItem);
//		
//		prefsItem = new JMenuItem("Preferences");
//		prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
//		
//		windowBar = new JMenu("windowBar");
//		windowBar.add(showMenu);
//		windowBar.add(prefsItem);
		
		menuBar = new JMenuBar();
		menuBar.add(File);
//		menuBar.add(windowBar);				
		this.setJMenuBar(menuBar);		
	}
	
	private void addPanels() 
	{	
		int leftPanelWidth = (formWidth / 2) - 90;
		int rightPanelWidth = (formWidth - leftPanelWidth);
		int insideRightPanelWidth = (rightPanelWidth - 55);
						
		this.textPanel = new TextArea_Panel("Defined Users");
		this.textPanel.setDimension(new Dimension(insideRightPanelWidth , formHeight));
		this.textPanel.setSize();
		
		this.tablePanel = new UserTablePanel();
		this.tablePanel.setDimension(new Dimension(insideRightPanelWidth , formHeight));
		this.tablePanel.setSize();		
		
		this.iStringListener = new IUserListener() 
		{			
			@Override
			public void stringEmmited(User input) 
			{			
				textPanel.addText(input.toString());
				controler.addUser(input);	
				tablePanel.setDataSource(controler.getUsers());		
				tablePanel.refresh();				
			}
		};								
		
		this.userPanel = new UserPanel();
		this.userPanel.setIStringListener(this.iStringListener);
		this.userPanel.setDimensions(new Dimension(leftPanelWidth, formHeight));
		this.userPanel.setSize();
		
		tabbedPane = new JTabbedPane();
		tabbedPane.add("User Text", textPanel);
		tabbedPane.add("User Table", tablePanel);
		tabbedPane.setSize(new Dimension(rightPanelWidth , formHeight));
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT , userPanel ,tabbedPane);
		splitPane.setDividerLocation(leftPanelWidth);
		this.add(splitPane);
	}		
}
