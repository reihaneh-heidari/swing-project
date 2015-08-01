package ir.mahan.train.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePanel extends JPanel {
	
	
	private JTable persontable;
	private PersonTableModel personTableModel;
private Dimension dim;
	
	public void setDimension(Dimension _dim) 
	{
		this.dim = _dim;
	}
	public void setSize()
	{
		this.setPreferredSize(this.dim);		 				
	}
	

	public TablePanel(){
		
		setLayout(new BorderLayout());
		personTableModel = new PersonTableModel();
		persontable = new JTable(personTableModel);
		add(new JScrollPane(persontable),BorderLayout.CENTER);
		Dimension dim = new Dimension();
		dim.height = 250;
		
		
	}
	
	public void setData(List<FormEvent> db){
		personTableModel.setData(db);
	}
	
	public void refresh(){
		personTableModel.fireTableDataChanged();
	}
}
