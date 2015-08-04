package ir.mahan.train.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class Person_SaveAndLoad {

	private List<Person> people;
	
	public Person_SaveAndLoad () 
	{
		people = new LinkedList<Person>();				
	}

	public void addPerson(Person p)
	{
		people.add(p);		
	}

	public List<Person> getPeople() 
	{
		return people;
	}

	public void saveToFile(File file)throws IOException 
	{
		Person_FileFilter pf = new Person_FileFilter();
		if (pf.accept(file))
		{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);	
			oos.writeObject(people);
			oos.close();
			fos.close();
		}
	}

	public void loadFromFile(File file) throws IOException, ClassNotFoundException 
	{	
		people.clear();
		Person_FileFilter pff = new Person_FileFilter();
		if (pff.accept(file))
		{	
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (ois.readObject() != null)
	        {
	        	addPerson((Person) ois.readObject());
	        }
			ois.close();			
			fis.close();
		}			
	}
}
 