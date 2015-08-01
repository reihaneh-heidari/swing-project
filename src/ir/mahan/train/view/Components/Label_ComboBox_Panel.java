package ir.mahan.train.view.Components;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Label_ComboBox_Panel extends JComponent implements Serializable
{
	private static final long serialVersionUID = -5188607549317499315L;
	private JPanel panel;
	private JLabel label;
	private JComboBox<Object> comboBox;
	private Dimension componentDim;
	
	public void setComponentDimension(Dimension dim) 
	{
		if (dim == null)
			this.componentDim = new Dimension(260, 22);
		else
			this.componentDim = dim;
		setComponentSize();
	}
	
	private void setComponentSize()
	{
		Dimension dim;
		panel.setSize(this.componentDim); 
		dim = new Dimension(this.componentDim.width - label.getPreferredSize().width , this.componentDim.height);
		comboBox.setPreferredSize(dim);
	}
	
	public Dimension getComponentDimension() 
	{
		return componentDim;
	}
	
	public Label_ComboBox_Panel(String LabelCaption, Object listData[])
	{	
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel);
				
		label = new JLabel();
		label.setText(LabelCaption);
		panel.add(label);
				 
		comboBox = new JComboBox<>(listData);
		panel.add(comboBox);
		
		setComponentDimension(null);		
	}
		
	public Object GetSelectedItem()
	{
		return comboBox.getSelectedItem();
	}			
}
