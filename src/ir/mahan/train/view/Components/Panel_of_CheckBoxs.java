package ir.mahan.train.view.Components;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel_of_CheckBoxs extends JComponent implements Serializable
{
	private static final long serialVersionUID = -9220962382998617890L;
	private JPanel panel;
	private JCheckBox[] checkBoxs;
	private Dimension componentDim;
	
	public void setComponentDimension(Dimension dim) 
	{
		if (dim == null)
			this.componentDim = new Dimension(300, 22);
		else
			this.componentDim = dim;
		setComponentSize();
	}
	
	private void setComponentSize()
	{
		panel.setSize(this.componentDim); 				
	}
	
	public Dimension getComponentDimension() 
	{
		return componentDim;
	}
	
	public Panel_of_CheckBoxs(String panelCaption, Object[] checkBoxCaptions)
	{	
		this.setLayout(new GridBagLayout());
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder(panelCaption));
		this.add(panel);
		
		checkBoxs = new JCheckBox[checkBoxCaptions.length];
		for (int i = 0; i < checkBoxCaptions.length; i++) 
		{
			checkBoxs[i] = new JCheckBox(checkBoxCaptions[i].toString()) ;
			panel.add(checkBoxs[i]);
		}
		
		setComponentDimension(null);		
	}
		
	
	public ArrayList<String> GetSelectedItems()
	{
		ArrayList<String> resultObjects = new ArrayList<String>();
		for (int i = 0; i < checkBoxs.length; i++) 
		{
			if ( checkBoxs[i].isSelected() == true )
			{
				resultObjects.add(checkBoxs[i].getText());				
			}			
		}
		return resultObjects;
	}	
}
