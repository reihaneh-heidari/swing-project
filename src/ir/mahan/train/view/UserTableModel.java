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
		switch (columnIndex) 
		{
			case 0:
				return user.getID();
			case 1:
				return user.getName();
			case 2:
				return user.getFamily();
			case 3:
				return user.getCategory();
			case 4:
				return user.getGender();
			case 5:
				return user.getFavoritSport();
			case 6:
				return user.getStringCities();
			case 7:
				return user.getAge();
			case 8:
				return user.getSalary();
			default:
				return null;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) 
	{
		return columnName[columnIndex];
	}

}
