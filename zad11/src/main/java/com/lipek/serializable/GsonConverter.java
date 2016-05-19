package com.lipek.serializable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonConverter extends BaseSerial {
	
	static String FILE_NAME = "gson.json";

	@Override
	public void serialize(List<Login> logins) {
		
		try(Writer writer = new OutputStreamWriter(new FileOutputStream(FILE_NAME) , "UTF-8")){
            Gson gson = new GsonBuilder().create();
            gson.toJson(logins, writer);
        } catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Login> deserialize() {

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(  
				     new FileReader(FILE_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  

		Gson gson = new Gson();
	    List<Login> logins = gson.fromJson(reader, List.class);
	    
	    return logins;
	}



}
