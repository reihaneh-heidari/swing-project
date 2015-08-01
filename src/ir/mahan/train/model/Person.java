package ir.mahan.train.model;

import ir.mahan.train.model.EnumDefinitions.Age;
import ir.mahan.train.model.EnumDefinitions.Category;
import ir.mahan.train.model.EnumDefinitions.City;
import ir.mahan.train.model.EnumDefinitions.FavoritSport;
import ir.mahan.train.model.EnumDefinitions.Gender;
import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 2442234401322632835L;
	
	private String 	 name;
	private String 	 family;	
	private Category category;
	private Gender 	 gender;
	private FavoritSport favoritSport;
	private Boolean   isEmployee;
	private int 	 salary;
	private City[]	 cities;
	private Age 	 age;
	
	public void setName(String _name) 
	{
		this.name = _name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setFamily(String _family) 
	{
		this.family = _family;
	}

	public String getFamily() 
	{
		return family;
	}
	
	public void setCategory(Category _category) 
	{
		this.category = _category;
	}
	
	public Category getCategory() 
	{
		return category;
	}

	public void setGender(Gender _gender) 
	{
		this.gender = _gender;
	}
	
	public Gender getGender() 
	{
		return gender;
	}

	public void setFavoritSport(FavoritSport _favoritSport) 
	{
		this.favoritSport = _favoritSport;
	}
	
	public FavoritSport getFavoritSport() 
	{
		return favoritSport;
	}

	public void setIsEmployee(Boolean _isEmployee) 
	{
		this.isEmployee = _isEmployee;
	}

	public Boolean getIsEmployee() 
	{
		return isEmployee;
	}
	
	public void setSalary(int _salary) 
	{
		this.salary = _salary;
	}
	
	public int getSalary() 
	{
		return salary;
	}
	
	public void setCities(City[] _cities) 
	{
		this.cities = _cities;
	}
	
	public City[] getCities()
	{
		return cities;
	}
	
	public void setAge(Age _age) 
	{
		this.age = _age;
	}
	
	public Age getAge() 
	{
		return age;
	}

	
}
