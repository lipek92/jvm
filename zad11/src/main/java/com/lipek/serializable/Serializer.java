package com.lipek.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializer extends BaseSerial {
	
	static String FILE_NAME = "serialized.object";

	@Override
	public void serialize(List<Login> logins) {
    	ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			out.writeObject(logins);
	    	out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Login> deserialize() {
    	try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
			List<Login> result = (List<Login>) in.readObject();
			in.close();
			return result;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
