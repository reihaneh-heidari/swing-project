package ir.mahan.train.view.Components;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Panel_of_RadioButtons extends JComponent implements Serializable
{
	private static final long serialVersionUID = 1791831098602195374L;
	private JPanel panel;
	private JRadioButton[] radioButtons;
	private Dimension componentdim;
	
	public void setComponentDimension(Dimension dim) 
	{
		if (dim == null)
			this.componentdim = new Dimension(300, 22);
		else
			this.componentdim = dim;
		setComponentSize();
	}
	
	private void setComponentSize()
	{
		panel.setSize(this.componentdim); 				
	}
	
	public Dimension getComponentDimension() 
	{
		return componentdim;
	}
	
	public Panel_of_RadioButtons(String panelCaption, Object[] raidioButtonCaptions)
	{	
		this.setLayout(new GridBagLayout());
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder(panelCaption));
		this.add(panel);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		radioButtons = new JRadioButton[raidioButtonCaptions.length];
		for (int i = 0; i < raidioButtonCaptions.length; i++) 
		{
			radioButtons[i] = new JRadioButton(raidioButtonCaptions[i].toString()) ;
			buttonGroup.add(radioButtons[i]);
			panel.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);
		
		setComponentDimension(null);		
	}
			
	public String GetSelectedItem()
	{
		String string = "";
		for (int i = 0; i < radioButtons.length; i++) 
		{
			if ( radioButtons[i].isSelected() == true )
			{
				string = radioButtons[i].getText();
			}
		}
		return string;
	}	
}
