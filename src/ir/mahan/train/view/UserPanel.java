package ir.mahan.train.view;

import ir.mahan.train.view.EnumDefinitions.Category;
import ir.mahan.train.view.EnumDefinitions.FavoritSport;
import ir.mahan.train.view.EnumDefinitions.Gender;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UserPanel extends JPanel implements ActionListener
{
	private IStringListener iStringListener;
	private FormEvent user;
	private Label_TextField_Panel name_Component;
	private Label_TextField_Panel family_Component;
	private Label_ComboBox_Panel  categori_Component;
	private Label_ComboBox_Panel  gender_Component;
	private Panel_of_CheckBoxs    city_Component;
	private Panel_of_RadioButtons age_Component;
	private JList_Panel favoritSport_Component;
	private JCheckBox    isEmployee_Checkbox;
	private Label_TextField_Panel salary_Component;
	private JButton submit_Button;
	private Dimension dimention;
	private Dimension fieldDimension;
	private Dimension listDimension;
	TablePanel tablePanel;
	
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
		name_Component = new  Label_TextField_Panel("Name:");
		name_Component.setComponentDimension(fieldDimension);
		
		family_Component = new Label_TextField_Panel("Family:");
		family_Component.setComponentDimension(fieldDimension);
		
		categori_Component = new Label_ComboBox_Panel("Category:", EnumDefinitions.Category.values());
		categori_Component.setComponentDimension(fieldDimension);
		
		gender_Component =new Label_ComboBox_Panel("Gender:", EnumDefinitions.Gender.values());
		gender_Component.setComponentDimension(fieldDimension);
		
		city_Component = new Panel_of_CheckBoxs("City", getStringList(EnumDefinitions.City.values()));
		city_Component.setComponentDimension(fieldDimension);
		
		age_Component = new Panel_of_RadioButtons("Age", getStringList(EnumDefinitions.Age.values()));
		age_Component.setComponentDimension(fieldDimension);
		
		favoritSport_Component =new JList_Panel("Favorit Sport:", EnumDefinitions.FavoritSport.values());
		favoritSport_Component.setComponentDimension(listDimension);
	
		isEmployee_Checkbox = new JCheckBox("Is Employee");
		isEmployee_Checkbox.addActionListener(this);
		
		salary_Component = new Label_TextField_Panel("salary:");
		salary_Component.setComponentDimension(fieldDimension);
		salary_Component.setEnabled(false);
		
		submit_Button = new JButton();
		submit_Button.setText("Submit");
		submit_Button.addActionListener(this);
	}

	private void addAllComponents()
	{
		setBorder(BorderFactory.createTitledBorder("User Informations"));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(name_Component);
		this.add(family_Component);
		this.add(categori_Component);
		this.add(gender_Component);
		this.add(city_Component);
		this.add(age_Component);
		this.add(favoritSport_Component);
		this.add(isEmployee_Checkbox);
		this.add(salary_Component);
		this.add(submit_Button);
		//setLayout(new GridBagLayout());
		//layoutcomponent();
	}
	
	private	String[] getStringList(Object[] objectList)
	{
		String[] stringList = new String[objectList.length];
		for (int i = 0; i < objectList.length; i++) 
		{			
			stringList[i] = objectList[i].toString();
		}
		return stringList;
	}
	
	private Boolean userIsValid() 
	{
		Boolean _userIsValid = true;
		
		if ( name_Component.GetEnteredText().isEmpty() )
		{
			JOptionPane.showMessageDialog(this, "Please Enter Name");
			_userIsValid = false;
		}
		
		if ( family_Component.GetEnteredText().isEmpty() )
		{
			JOptionPane.showMessageDialog(this, "Please Enter Family");
			_userIsValid = false;
		}
		
		if ( isEmployee_Checkbox.isSelected() && salary_Component.GetEnteredText().isEmpty() )
		{
			JOptionPane.showMessageDialog(this, "Please Enter Salary");
			_userIsValid = false;
		}
		
		return _userIsValid;
	}
	
	private void setUserSpecifications() 
	{		
		this.user = new FormEvent();
		this.user.setName(name_Component.GetEnteredText());
		this.user.setFamily(family_Component.GetEnteredText());
		this.user.setCategory((Category)categori_Component.GetSelectedItem());
		this.user.setGender((Gender)gender_Component.GetSelectedItem());		
		this.user.setCities(city_Component.GetSelectedItems());
		this.user.setAge(age_Component.GetSelectedItem());		
		this.user.setFavoritSport((FavoritSport)favoritSport_Component.GetSelectedItem());
		this.user.setIsEmployee(isEmployee_Checkbox.isSelected());
		if (salary_Component.GetEnteredText().isEmpty() == false)
			this.user.setSalary(Integer.parseInt(salary_Component.GetEnteredText()));
	}
	
	public void setIStringListener (IStringListener isl)
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
			salary_Component.setEnabled(isEmployee_Checkbox.isSelected());		 		
		}
	}
	
	public void layoutcomponent(){
//		GridBagConstraints gc = new GridBagConstraints();
//		gc.weightx=1;
//		gc.weighty=0.1;
//		
//		gc.gridx=0;
//		gc.gridy=0;
//		gc.fill=GridBagConstraints.NONE;
//		gc.anchor=GridBagConstraints.LINE_START;
//		add(userName,gc);
////		gc.gridx=1;
////		gc.anchor=GridBagConstraints.LINE_START;
////		gc.fill=GridBagConstraints.HORIZONTAL;
////		add(txtUser,gc);
//		gc.weightx=1;
//		gc.weighty=0.1;
//		gc.gridy=1;
//		gc.gridx=0;
//		gc.anchor=GridBagConstraints.LINE_END;
//	//	add(lblFamily,gc);
//		gc.gridx++;
//		gc.anchor=GridBagConstraints.LINE_START;
//		gc.fill=GridBagConstraints.HORIZONTAL;
//		//add(txtFamily,gc);
//		gc.weightx=1;
//		gc.weighty=2;
//		gc.gridy++;
//		gc.gridx=1;
//		gc.anchor=GridBagConstraints.FIRST_LINE_START;
//		add(myButton,gc);
//		
	};		
}
