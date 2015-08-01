package ir.mahan.train.view.Components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea_Panel extends JComponent implements Serializable
{
	private static final long serialVersionUID = 5533930873060854081L;
	private JPanel panel;
	private JTextArea textArea;
	private Dimension dim;
	
	public void setDimension(Dimension _dim) 
	{
		this.dim = _dim;
	}
	
	public Dimension getDimension() 
	{
		return dim;
	}
	
	public void setSize()
	{
		panel.setSize(this.dim);	
		textArea.setPreferredSize(this.dim);
	}
	
	public TextArea_Panel(String panelCaption)
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createTitledBorder(panelCaption));
		this.add(panel);
				
		textArea = new JTextArea();		
		panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void addText(String txt)
	{
		this.textArea.setText(this.textArea.getText() + "\n" + txt);
	}		
	
	
}
