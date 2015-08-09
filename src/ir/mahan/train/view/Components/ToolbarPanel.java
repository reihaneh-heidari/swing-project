package ir.mahan.train.view.Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import ir.mahan.train.utility.Utility;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;



public class ToolbarPanel extends JToolBar implements ActionListener {

	JButton saveBTN ;
	JButton loadBTN ;
	private ToolbarActionLisener toolbalLisener;
	
	public ToolbarPanel(){
		setBorder(BorderFactory.createEtchedBorder());
		setFloatable(false);
		
		saveBTN = new JButton();
		saveBTN.setIcon(Utility.createIcon("/Images/save16.gif"));
		saveBTN.setToolTipText("Save to DataBase");
		
		loadBTN = new JButton();
		loadBTN.setIcon(Utility.createIcon("/Images/Refresh16.gif"));
		loadBTN.setToolTipText("Refresh Data");
		saveBTN.addActionListener(this);
		
		add(saveBTN);
		addSeparator();
		add(loadBTN);
	}
	
	public void settoolbalLisener(ToolbarActionLisener lisener) {
		this.toolbalLisener = lisener;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JButton clicked = (JButton)e.getSource();
		if(clicked == saveBTN){
			if(this.toolbalLisener != null){
				try {
					toolbalLisener.saveEventOccured();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else
		{
			if(this.toolbalLisener != null){
				toolbalLisener.rereshEventOccured();
			}
		}
	}
	
}
