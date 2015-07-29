package ir.mahan.train.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class dataBase {
	
	private List<person> people;
	
	public dataBase () {
		people = new LinkedList<person>();
				
	}

	public void add() {
		
	}
	
	public void saveToFile(File file)throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		person[] persons = people.toArray(new person[people.size()]);
		oos.writeObject(persons);
		oos.close();
	}
	public void loadFromFile(File file)throws IOException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			person[] persons = (person[]) ois.readObject();
			people.clear();
			people.addAll(Arrays.asList(persons));
		} catch (Exception e) {
			e.printStackTrace();
		}
		people.toArray(new person[people.size()]);
		ois.close();
	}
}
