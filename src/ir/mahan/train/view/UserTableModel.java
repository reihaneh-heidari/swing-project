package ir.mahan.train.view;

import java.io.Serializable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel implements Serializable  
{

	private static final long serialVersionUID = -2549820329926351603L;
	
	private List<User> users;
	private String[] columnName = {"ID", "Name", "Family", "Category", "Gender", "FavoritSport", "Cities", "Age", "Salary"};
	
	public void setDataSource(List<User> _users) 
	{
		this.users = _users;
	}
	
	@Override
	public int getColumnCount() 
	{

		return columnName.length;
	}

	@Override
	public int getRowCount() 
	{
		return users.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		User user = users.get(rowIndex);
		Object userCell = new Object();
		switch (columnIndex) 
		{
			case 0:
				userCell = user.getID();
			case 1:
				userCell = user.getName();
			case 2:
				userCell = user.getFamily();
			case 3:
				userCell = user.getCategory();
			case 4:
				userCell = user.getGender();
			case 5:
				userCell = user.getFavoritSport();
			case 6:
				userCell = user.getStringCities();
			case 7:
				userCell = user.getAge();
			case 8:
				userCell = user.getSalary();
		}
		return userCell;		
	}
	
	@Override
	public String getColumnName(int columnIndex) 
	{
		return columnName[columnIndex];
	}

}
