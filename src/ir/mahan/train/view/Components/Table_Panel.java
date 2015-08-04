package ir.mahan.train.view.Components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Table_Panel extends JComponent implements Serializable 
{
	
	private static final long serialVersionUID = -5960460667675305498L;
	private JPanel panel;
	private JTable table;	
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
		table.setPreferredSize(this.dim);
	}
	
	public Table_Panel( String panelCaption, AbstractTableModel tableModel )
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createTitledBorder(panelCaption));
		this.add(panel);
		
		table = new JTable(tableModel);
		panel.add(new JScrollPane(table), BorderLayout.CENTER);				
	}
		
	public AbstractTableModel getTableModel()
	{
		return (AbstractTableModel)table.getModel();
	}
	
	public void refresh()
	{
		AbstractTableModel tm;
		tm = (AbstractTableModel)table.getModel();
		tm.fireTableDataChanged();
	}
}
