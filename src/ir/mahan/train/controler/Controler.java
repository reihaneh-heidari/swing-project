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
		psl.addPerson(person);
	}
	
	public void saveToFile(File file) throws IOException
	{
		psl.saveToFile(file);
	}
	
	public Person[] loadFromFile(File file) throws IOException, ClassNotFoundException
	{
		return psl.loadFromFile(file);
	}
}
