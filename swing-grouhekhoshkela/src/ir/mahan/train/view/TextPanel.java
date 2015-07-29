package ir.mahan.train.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel 
{
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
		this.setPreferredSize(this.dim);		 				
	}
	
	public TextPanel()
	{
		textArea = new JTextArea();
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Text Area"));		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void SetText(String txt)
	{
		this.textArea.setText(this.textArea.getText() + "\n" + txt);
	}		
	
	
}
