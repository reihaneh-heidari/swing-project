package ir.mahan.train.view;

import ir.mahan.train.view.Components.Table_Panel;
import java.io.Serializable;
import java.util.List;

public class UserTablePanel extends Table_Panel implements Serializable 
{
	private static final long serialVersionUID = 2518186825062290108L;	
	private  UserTableModel userTableModel;
			
	public UserTablePanel()
	{	
		super("Users", new UserTableModel());
		userTableModel = (UserTableModel) this.getTableModel();
	}
	
	public void setDataSource(List<User> users)
	{
		userTableModel.setDataSource(users);	
	}
}
