package ir.mahan.train.model;

import ir.mahan.train.view.EnumDefinitions.Category;
import ir.mahan.train.view.EnumDefinitions.FavoritSport;
import ir.mahan.train.view.EnumDefinitions.Gender;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 2442234401322632835L;
	
	private String 	 name;
	private String 	 family;	
	private Category category;
	private Gender 	 gender;
	private ArrayList<String>	 cities;
	private String 	 age;
	private FavoritSport favoritSport;
	private Boolean   isEmployee;
	private int 	 salary;
	
	public void setSalary(int _salary) 
	{
		this.salary = _salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setFavoritSport(FavoritSport _favoritSport) 
	{
		this.favoritSport = _favoritSport;
	}
	
	public void setIsEmployee(Boolean _isEmployee) 
	{
		this.isEmployee = _isEmployee;
	}

	public void setName(String _name) 
	{
		this.name = _name;
	}

	public void setFamily(String _family) 
	{
		this.family = _family;
	}

	public void setCategory(Category _category) 
	{
		this.category = _category;
	}

	public String getName() {
		return name;
	}

	public void setGender(Gender _gender) 
	{
		this.gender = _gender;
	}
	
	public void setCities(ArrayList<String> _cities) 
	{
		this.cities = _cities;
	}
	
	public String getCities()
	{
		String _cities = "";
		
    	for (int i = 0; i < cities.size(); i++) 
    	{
    		_cities = _cities + cities.get(i).toString() + ',';
    	}
    	
    	if (_cities.lastIndexOf(',') > 0)
    		_cities = _cities.substring(0, _cities.lastIndexOf(','));
    	return _cities;
	}
	
	public void setAge(String _age) 
	{
		this.age = _age;
	}
	public String getFamily() {
		return family;
	}

	public Category getCategory() {
		return category;
	}

	public Gender getGender() {
		return gender;
	}

	public String getAge() {
		return age;
	}

	public FavoritSport getFavoritSport() {
		return favoritSport;
	}

	public Boolean getIsEmployee() {
		return isEmployee;
	}

}
