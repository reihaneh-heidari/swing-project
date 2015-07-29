package ir.mahan.train.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class JList_Panel extends JComponent
{
	private JPanel panel;
	private JList<Object[]> list;
	private Dimension componentDim;
	
	public void setComponentDimension(Dimension dim) 
	{
		if (dim == null)
			this.componentDim = new Dimension(260, 70);
		else
			this.componentDim   = dim;
		setComponentSize();
	}
	
	public Dimension getComponentDimension() 
	{
		return componentDim;
	}
	
	public JList_Panel(String panelCaption, Object[] objectList )
	{	
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createTitledBorder(panelCaption));
		this.add(panel);
						 
		list = new JList(objectList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		
		panel.add(list);		
		setComponentDimension(null);		
	}
		
	private void setComponentSize()
	{
		panel.setSize(this.componentDim); 
		list.setPreferredSize(this.componentDim);
	}
	
	public Object GetSelectedItem()
	{
		return list.getSelectedValue();
	}			
}
