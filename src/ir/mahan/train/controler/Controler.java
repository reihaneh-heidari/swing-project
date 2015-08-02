package ir.mahan.train.controler;

import java.io.File;
import java.io.IOException;

import ir.mahan.train.model.Person;
import ir.mahan.train.model.Person_SaveAndLoad;
import ir.mahan.train.view.User;

public class Controler 
{
	Person_SaveAndLoad psl;

	public Controler()
	{
		psl = new Person_SaveAndLoad();
	}
	
	public void addPerson(User user) 
	{
		psl.addPerson(convertUserToPerson(user));
	}
	
	public void saveToFile(File file) throws IOException
	{
		psl.saveToFile(file);
	}
	
	public Person[] loadFromFile(File file) throws IOException, ClassNotFoundException
	{
		return psl.loadFromFile(file);
	}
	
	public Person convertUserToPerson(User user)
	{
		Person person = new Person();
		person.setName(user.getName());
		person.setFamily(user.getFamily());
		person.setAge(user.getAge());
		person.setCategory(user.getCategory());
		person.setCities(user.getCities());
		person.setFavoritSport(user.getFavoritSport());
		person.setGender(user.getGender());
		person.setIsEmployee(user.getIsEmployee());
		person.setSalary(user.getSalary());
		return person;
	}
	
	public User convertUserToPerson(Person person)
	{
		User user = new User();
		user.setName(person.getName());
		user.setFamily(person.getFamily());
		user.setAge(person.getAge());
		user.setCategory(person.getCategory());
		user.setCities(person.getCities());
		user.setFavoritSport(person.getFavoritSport());
		user.setGender(person.getGender());
		user.setIsEmployee(person.getIsEmployee());
		user.setSalary(person.getSalary());
		return user;
	}
}

