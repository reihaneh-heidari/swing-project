package ir.mahan.train.controler;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
	
	public void addUser(User user) 
	{
		psl.addPerson(convertUserToPerson(user));
	}
	
	public List<User> getUsers()
	{
		return convertPersonsToUsers(psl.getPeople());
	}
	
	
	public void saveToFile(File file) throws IOException
	{
		psl.saveToFile(file);
	}
	
	public void loadFromFile(File file) throws IOException, ClassNotFoundException
	{		
		psl.loadFromFile(file);
	}
	
	private Person convertUserToPerson(User user)
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
	
	private User convertPersonToUser(Person person)
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
	
	private List<User> convertPersonsToUsers(List<Person> persons)
	{
		List<User> users = new LinkedList<>();
		for (int i = 0; i < persons.size(); i++)
		{
			users.add(convertPersonToUser(persons.get(i)));
		}
		return users;
	}
}

