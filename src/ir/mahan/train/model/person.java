package ir.mahan.train.model;

import ir.mahan.train.view.EnumDefinitions.Category;
import ir.mahan.train.view.EnumDefinitions.FavoritSport;
import ir.mahan.train.view.EnumDefinitions.Gender;

import java.io.Serializable;
import java.util.ArrayList;

public class person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7471407281725251567L;

	private String 	 name;
	private String 	 family;
	private Category category;
	private Gender 	 gender;
	private ArrayList<String>	 cities;
	private String 	 age;
	private FavoritSport favoritSport;
	private Boolean   isEmployee;
	private int 	 salary;
	
	public person (String 	 name,String 	 family,Category category,Gender 	 gender
			,ArrayList<String>	 cities ,String 	 age,FavoritSport favoritSport
			,int 	 salary)
	{
	this.name = name;
	this.family = family;
	this.category = category;
	this.gender = gender;
	this.cities = cities;
	this.age = age;
	this.favoritSport = favoritSport;
	this.salary = salary;
	}
}
