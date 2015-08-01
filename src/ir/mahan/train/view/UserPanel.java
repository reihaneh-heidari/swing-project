package ir.mahan.train.view;

import ir.mahan.train.model.EnumDefinitions;
import ir.mahan.train.model.EnumDefinitions.Age;
import ir.mahan.train.model.EnumDefinitions.Category;
import ir.mahan.train.model.EnumDefinitions.FavoritSport;
import ir.mahan.train.model.EnumDefinitions.Gender;
import ir.mahan.train.view.Components.Label_TextField_Panel;
import ir.mahan.train.view.Components.List_Panel;
import ir.mahan.train.view.Components.Label_ComboBox_Panel;
import ir.mahan.train.view.Components.Panel_of_CheckBoxs;
import ir.mahan.train.view.Components.Panel_of_RadioButtons;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UserPanel extends JPanel implements ActionListener, Serializable
{
	private static final long serialVersionUID = -9073008833754623425L;
	private IUserListener iStringListener;
	private User user;
	private Label_TextField_Panel name_txtComponent;
	private Label_TextField_Panel family_txtComponent;
	private Label_ComboBox_Panel  categori_cmbComponent;
	private Label_ComboBox_Panel  gender_cmbComponent;
	private Panel_of_CheckBoxs    city_chkComponent;
	private Panel_of_RadioButtons age_rbComponent;
	private List_Panel favoritSport_lstComponent;
	private JCheckBox    isEmployee_Checkbox;
	private Label_TextField_Panel salary_txtComponent;
	private JButton submit_Button;
	private Dimension dimention;
	private Dimension fieldDimension;
	private Dimension listDimension;
	
	public void setDimensions(Dimension _dim) 
	{
		this.dimention = _dim;
		this.fieldDimension = new Dimension(_dim.width - 35 , 22); 
		this.listDimension = new Dimension(_dim.width - 40 , 70);
	}
	
	public Dimension getDimension() 
	{
		return dimention;
	}
	
	public void setSize()
	{
		this.setPreferredSize(this.dimention);		 				
	}
	
	public UserPanel()
	{
		defineAllComponents();
		addAllComponents();		
	}
	
	private void defineAllComponents()
	{		
		name_txtComponent = new  Label_TextField_Panel("Name:");
		name_txtComponent.setComponentDimension(fieldDimension);
		
		family_txtComponent = new Label_TextField_Panel("Family:");
		family_txtComponent.setComponentDimension(fieldDimension);
		
		categori_cmbComponent = new Label_ComboBox_Panel("Category:", EnumDefinitions.Category.values());
		categori_cmbComponent.setComponentDimension(fieldDimension);
		
		gender_cmbComponent =new Label_ComboBox_Panel("Gender:", EnumDefinitions.Gender.values());
		gender_cmbComponent.setComponentDimension(fieldDimension);
		
		city_chkComponent = new Panel_of_CheckBoxs("City", EnumDefinitions.City.values());
		city_chkComponent.setComponentDimension(fieldDimension);
		
		age_rbComponent = new Panel_of_RadioButtons("Age", EnumDefinitions.Age.values());
		age_rbComponent.setComponentDimension(fieldDimension);
		
		favoritSport_lstComponent =new List_Panel("Favorit Sport", EnumDefinitions.FavoritSport.values());
		favoritSport_lstComponent.setComponentDimension(listDimension);
	
		isEmployee_Checkbox = new JCheckBox("Is Employee");
		isEmployee_Checkbox.addActionListener(this);
		
		salary_txtComponent = new Label_TextField_Panel("salary:");
		salary_txtComponent.setComponentDimension(fieldDimension);
		salary_txtComponent.setEnabled(false);
		
		submit_Button = new JButton();
		submit_Button.setText("Submit");
		submit_Button.addActionListener(this);
	}

	private void addAllComponents()
	{
		setBorder(BorderFactory.createTitledBorder("User Informations"));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(name_txtComponent);
		this.add(family_txtComponent);
		this.add(categori_cmbComponent);
		this.add(gender_cmbComponent);
		this.add(city_chkComponent);
		this.add(age_rbComponent);
		this.add(favoritSport_lstComponent);
		this.add(isEmployee_Checkbox);
		this.add(salary_txtComponent);
		this.add(submit_Button);
	}
	
	private Boolean userIsValid() 
	{
		Boolean _userIsValid = true;
		
		if ( name_txtComponent.GetEnteredText().isEmpty() )
		{
			JOptionPane.showMessageDialog(this, "Please Enter Name");
			_userIsValid = false;
		}
		
		if ( family_txtComponent.GetEnteredText().isEmpty() )
		{
			JOptionPane.showMessageDialog(this, "Please Enter Family");
			_userIsValid = false;
		}
		
		if ( isEmployee_Checkbox.isSelected() && salary_txtComponent.GetEnteredText().isEmpty() )
		{
			JOptionPane.showMessageDialog(this, "Please Enter Salary");
			_userIsValid = false;
		}
		
		return _userIsValid;
	}
	
	private void setUserSpecifications() 
	{		
		this.user = new User();
		this.user.setName(name_txtComponent.GetEnteredText());
		this.user.setFamily(family_txtComponent.GetEnteredText());
		this.user.setCategory((Category)categori_cmbComponent.GetSelectedItem());
		this.user.setGender((Gender)gender_cmbComponent.GetSelectedItem());
		this.user.setCities(city_chkComponent.GetSelectedItems());
		this.user.setAge(Age.valueOf(age_rbComponent.GetSelectedItem()));		
		this.user.setFavoritSport((FavoritSport)favoritSport_lstComponent.GetSelectedItem());
		this.user.setIsEmployee(isEmployee_Checkbox.isSelected());
		if (salary_txtComponent.GetEnteredText().isEmpty() == false)
			this.user.setSalary(Integer.parseInt(salary_txtComponent.GetEnteredText()));
	}
	
	public void setIStringListener (IUserListener isl)
	{
		this.iStringListener = isl;
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource().equals(submit_Button))
		{
			if ( userIsValid() == true )
			{
				setUserSpecifications();
				this.iStringListener.stringEmmited(this.user);
			}
			
		}
		
		if (event.getSource().equals(isEmployee_Checkbox))
		{
			salary_txtComponent.setEnabled(isEmployee_Checkbox.isSelected());		 		
		}
	}
		
}

// in addAllComponents: 
// 		setLayout(new GridBagLayout());
//		call layoutcomponent();
//public void layoutcomponent()
//{
//	GridBagConstraints gc = new GridBagConstraints();
//	gc.weightx=1;
//	gc.weighty=0.1;
//	
//	gc.gridx=0;
//	gc.gridy=0;
//	gc.fill=GridBagConstraints.NONE;
//	gc.anchor=GridBagConstraints.LINE_START;
//	add(userName,gc);
////	gc.gridx=1;
////	gc.anchor=GridBagConstraints.LINE_START;
////	gc.fill=GridBagConstraints.HORIZONTAL;
////	add(txtUser,gc);
//	gc.weightx=1;
//	gc.weighty=0.1;
//	gc.gridy=1;
//	gc.gridx=0;
//	gc.anchor=GridBagConstraints.LINE_END;
////	add(lblFamily,gc);
//	gc.gridx++;
//	gc.anchor=GridBagConstraints.LINE_START;
//	gc.fill=GridBagConstraints.HORIZONTAL;
//	//add(txtFamily,gc);
//	gc.weightx=1;
//	gc.weighty=2;
//	gc.gridy++;
//	gc.gridx=1;
//	gc.anchor=GridBagConstraints.FIRST_LINE_START;
//	add(myButton,gc);
//	
//};		
