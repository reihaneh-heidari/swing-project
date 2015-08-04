package ir.mahan.train.utility;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Utility 
{
	public static Component formComponent;	
	
	public static String getFileExtension(String name) 
	{
		int pointIndex = name.lastIndexOf(".");
		if (pointIndex == -1)
		{
			return null;
		}
		if (pointIndex == name.length()-1)
		{
			return null;
		}
		return name.substring((pointIndex)+1 , name.length());
	}
	
	public static JMenuItem createExitMenuItem()
	{
		JMenuItem exitMenu; 
		exitMenu = new JMenuItem("Exit");
		exitMenu.addActionListener(new ActionListener()
		{
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	int action = JOptionPane.showConfirmDialog(formComponent, "Do you want to exit? " , "Confirm Exit" , JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION)
                {
                	System.exit(0);
                }
            }
        });
		exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , ActionEvent.CTRL_MASK));
		exitMenu.setMnemonic(KeyEvent.VK_X);
		return exitMenu;
	}	
}
