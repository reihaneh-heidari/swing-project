package ir.mahan.train.view;

import ir.mahan.train.model.Person_FileFilter;
import ir.mahan.train.utility.Utility;
import ir.mahan.train.view.Components.Table_Panel;
import ir.mahan.train.view.Components.TextArea_Panel;

import javax.swing.JCheckBoxMenuItem;
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

	public MainFrame(String title) 
	{
		super(title);
		setFrameView();
		setMenu();
		addPanels();
	}
	
	
	private void setFrameView() 
	{		
		this.setSize(800, 610);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void setMenu()
	{
		File = new JMenu("File");		
		Utility.formComponent = MainFrame.this;
		Utility.fileFilter = new Person_FileFilter();
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
		this.textPanel = new TextArea_Panel("Defined Users");
		Dimension dim = this.textPanel.getPreferredSize();
		this.textPanel.setDimension(dim);
		this.textPanel.setSize();
		
		UserTableModel userTableModel;
		userTableModel = new UserTableModel();
		userTableModel.setDataSource(dataSource);		
		this.tablePanel = new Table_Panel("Users", userTableModel);
		this.tablePanel.setDimension(dim);
		this.tablePanel.setSize();
		
		this.iStringListener = new IUserListener() 
		{			
			@Override
			public void stringEmmited(User input) 
			{			
				textPanel.addText(input.toString());
				dataSource.add(input);
				tablePanel.refresh();
			}
		};								
		
		this.userPanel = new UserPanel();
		this.userPanel.setIStringListener(this.iStringListener);
		Dimension borderDim = this.userPanel.getPreferredSize();
		borderDim.width = 350;
		this.userPanel.setDimensions(borderDim);
		this.userPanel.setSize();
		
		tabbedPane = new JTabbedPane();
		tabbedPane.add("User Text", textPanel);
		tabbedPane.add("User Table", tablePanel);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT , userPanel ,tabbedPane);
		this.add(splitPane);
	}		
}
