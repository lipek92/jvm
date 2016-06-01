package com.lipek.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Externalizer {

	static String FILE_NAME = "externalized.object";
	
	public void serialize(List<LoginExt> logins) {
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

	public List<LoginExt> deserialize() {
		List<LoginExt> logins = null;
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(FILE_NAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(fileIn);
			logins = (List<LoginExt>) in.readObject();  
			in.close();  
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return logins;
	}
	
	public long testSerialization(List<LoginExt> logins) {
		long t1 = System.currentTimeMillis();
		serialize(logins);
		long processingTime = System.currentTimeMillis() - t1;
		return processingTime;
	}
	
	public long testDeserialization(List<LoginExt> logins) {
		long t1 = System.currentTimeMillis();
		deserialize();
		long processingTime = System.currentTimeMillis() - t1;
		return processingTime;
	}

}
