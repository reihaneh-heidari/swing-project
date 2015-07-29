
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import ir.mahan.train.view.FormEvent;


public class userdata
{
	public static void main(String[] args) {
		FormEvent myuser = new FormEvent();
		FileInputStream streamIn = null;
		ObjectInputStream objectinputstream = null;
		 try {
		        streamIn = new FileInputStream("C:\\Users\\reihaneh.heidari\\Desktop\\java\\test.ser");
		        objectinputstream = new ObjectInputStream(streamIn);
		        FormEvent readCase = (FormEvent) objectinputstream.readObject();
		        System.out.println(readCase.getName());

		    } catch (Exception e) {

		        e.printStackTrace();
		 }finally {
		        if(objectinputstream != null){
		            try {
						objectinputstream .close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         } 
		 }
//		myuser.setName("reihaneh");
//		ObjectOutputStream oos = null;
//		FileOutputStream fout = null;
//		try{
//		         fout = new FileOutputStream("C:\\Users\\reihaneh.heidari\\Desktop\\java\\test.ser", true);
//		         oos = new ObjectOutputStream(fout);
//		        oos.writeObject(myuser);
//		} catch (Exception ex) {
//		        ex.printStackTrace();
//		}finally {
//		        if(oos  != null){
//		            try {
//						oos.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		         } 
//		}
}
	
}
