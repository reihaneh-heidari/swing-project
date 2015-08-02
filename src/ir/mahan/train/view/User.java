package ir.mahan.train.view;

import ir.mahan.train.model.EnumDefinitions.Age;
import ir.mahan.train.model.EnumDefinitions.Category;
import ir.mahan.train.model.EnumDefinitions.City;
import ir.mahan.train.model.EnumDefinitions.FavoritSport;
import ir.mahan.train.model.EnumDefinitions.Gender;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private static final long serialVersionUID = -1093239392376997810L;
	
	private String 	 name;
	private String 	 family;	
	private Category category;
	private Gender 	 gender;
	private FavoritSport favoritSport;
	private Boolean   isEmployee;
	private int 	 salary;
	private City[]	 cities;
	private Age 	 age;

	//*** not in person class ***//
	private int ID;
	static int count;
	
	//*** not in person class ***//
	public User()
	{
		this.ID = count++;
	}

	//*** not in person class ***//
	public int getID() 
	{
		return ID;
	}

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

	//*** not in person class ***//
	public void setCities(ArrayList<String> _citieStrings) 
	{		
		cities = new City[_citieStrings.size()];
		for (int i = 0; i < _citieStrings.size(); i++) 
		{
			this.cities[i] = City.valueOf(_citieStrings.get(i).toString());			 
		}
	}
		
	public City[] getCities()
	{
		return cities;
	}
	
	//*** not in person class ***//
	public String getStringCities()
	{
		String _cities = "";
		
    	for (int i = 0; i < cities.length; i++) 
    	{
    		_cities = _cities + cities[i].toString() + ',';
    	}
    	
    	if (_cities.lastIndexOf(',') > 0)
    		_cities = _cities.substring(0, _cities.lastIndexOf(','));
    	return _cities;
	}
	
	public void setAge(Age _age) 
	{
		this.age = _age;
	}
	
	public Age getAge() 
	{
		return age;
	}

	//*** not in person class ***//
	@Override
	public String toString() 
	{
		String resultString = "";
		resultString = name + "::" + family + "::" + category.toString() + "::" + gender.toString() + "::" + getStringCities() + "::" + age.toString() + "::" + 
				favoritSport.toString();
		if (isEmployee) 
			resultString = resultString + "::" + salary; 
    	return  resultString;
	}
	
}
