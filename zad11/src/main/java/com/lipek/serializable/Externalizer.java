package com.lipek.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Externalizer extends BaseSerial {

	static String FILE_NAME = "externalized.object";
	
	@Override
	public void serialize(List<Login> logins) {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(FILE_NAME);
		} catch (FileNotFoundException e4) {
			e4.printStackTrace();
		}  
		ObjectOutputStream outStream;
		try {
			outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(logins);
			outStream.close();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

	@Override
	public List<Login> deserialize() {
		List<Login> logins = null;
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(FILE_NAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(fileIn);
			logins = (List<Login>) in.readObject();  
			in.close();  
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return logins;
	}

}
