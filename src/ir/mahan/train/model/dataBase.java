package ir.mahan.train.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class dataBase {

	private List<Person> people;
	
	public dataBase () 
	{
		people = new LinkedList<Person>();
				
	}

	public void addPerson(Person p)
	{
		people.add(p);
		
	}
	
	public void saveToFile(File file)throws IOException 
	{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Person[] persons = people.toArray(new Person[people.size()]);
		oos.writeObject(persons);
		oos.close();
	}

}
