package ir.mahan.train.view;

import ir.mahan.train.controler.Controler;
import ir.mahan.train.model.Person_FileFilter;
import ir.mahan.train.utility.Utility;
import ir.mahan.train.view.Components.Table_Panel;
import ir.mahan.train.view.Components.TextArea_Panel;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MainFrame extends JFrame implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu File;
	private JMenu windowBar;
	private JMenu showMenu;
	private JMenuItem prefsItem;
	private JMenuItem showFormItem;
	private JCheckBoxMenuItem showFormCheckBoxItem;
	
	private JSplitPane splitPane;
	private IUserListener iStringListener;
	private UserPanel userPanel;
	private JTabbedPane tabbedPane;
	private TextArea_Panel textPanel;
	private List<User> dataSource;
	private Table_Panel tablePanel;
	private Controler controler;
	
	int formWidth = 800;
	int formHeight = 600;

	public MainFrame(String title) 
	{
		super(title);
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
	
	private void setMenu()
	{
		File = new JMenu("File");		
		Utility.formComponent = MainFrame.this;
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.addChoosableFileFilter(new Person_FileFilter());
		Utility.fileChooser = fc;
		File.add(Utility.createExportDataMenuItem());
		File.add(Utility.createImportDataMenuItem());
		File.addSeparator();
		File.add(Utility.createExitMenuItem());
		File.setMnemonic(KeyEvent.VK_F);

		showMenu = new JMenu("SHOW");
		showFormItem = new JMenuItem("Person Form");
		showMenu.add(showFormItem);
		showFormCheckBoxItem = new JCheckBoxMenuItem("Show the form");
		showFormCheckBoxItem.setSelected(true);
		showMenu.add(showFormCheckBoxItem);
		
		prefsItem = new JMenuItem("Preferences");
		prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
		
		windowBar = new JMenu("windowBar");
		windowBar.add(showMenu);
		windowBar.add(prefsItem);
		
		menuBar = new JMenuBar();
		menuBar.add(File);
		menuBar.add(windowBar);				
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
		
		dataSource = new LinkedList<User>();
		UserTableModel userTableModel;
		userTableModel = new UserTableModel();
		userTableModel.setDataSource(dataSource);		
		this.tablePanel = new Table_Panel("Users", userTableModel);
		this.tablePanel.setDimension(new Dimension(insideRightPanelWidth , formHeight));
		this.tablePanel.setSize();
		
		controler = new Controler();
		
		this.iStringListener = new IUserListener() 
		{			
			@Override
			public void stringEmmited(User input) 
			{			
				textPanel.addText(input.toString());
				dataSource.add(input);
				tablePanel.refresh();
				controler.addPerson(input);
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
