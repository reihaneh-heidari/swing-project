package ir.mahan.train.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Label_TextField_Panel extends JComponent
{
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	private Dimension componentDim;
	
	public void setComponentDimension(Dimension dim) 
	{
		if (dim == null)
			this.componentDim = new Dimension(260, 22);
		else
			this.componentDim = dim;
		setComponentSize();
	}
	
	public Dimension getComponentDimension() 
	{
		return componentDim;
	}
	
	public Label_TextField_Panel(String LabelCaption)
	{	
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panel);
				
		label = new JLabel();
		label.setText(LabelCaption);
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		
		setComponentDimension(null);		
	}
		
	private void setComponentSize()
	{
		Dimension dim;
		panel.setSize(this.componentDim); 
		dim = new Dimension(this.componentDim.width - label.getPreferredSize().width , this.componentDim.height);
		textField.setPreferredSize(dim);
	}
	
	public String GetEnteredText()
	{
		return textField.getText();
	}

	@Override
	public void setEnabled(boolean arg0) 
	{
		textField.setEditable(arg0);
	}

	

	
	
}
