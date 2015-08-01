package ir.mahan.train.view;


import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {

	private List<FormEvent> db;
	private String[] colName = {"ID","Name","Family","City","Gender","Age","FavoritSport","Salary"};
	
	
	public void setData(List<FormEvent> db) {
		this.db = db;
	}
	
	
	@Override
	public int getColumnCount() {

		return colName.length;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		FormEvent person = db.get(row);
		switch (col) {
		case 0:
			return person.getID();
		case 1:
			return person.getName();
		case 2:
			return person.getCities();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return colName[column];
	}

}
