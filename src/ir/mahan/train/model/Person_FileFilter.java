package ir.mahan.train.model;

import ir.mahan.train.utility.Utility;
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Person_FileFilter extends FileFilter 
{

	@Override
	public boolean accept(File file) 
	{
		if (file.isDirectory())
		{
			return false;
		}

		String name = file.getName();
		String extension = Utility.getFileExtension(name);
		
		if (extension == null)
		{
			return false;
		}
		
		if (extension.equalsIgnoreCase("Per"))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
