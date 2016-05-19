package com.lipek.serializable;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson extends BaseSerial {
	
	static String FILE_NAME = "jackson.json";
	
	@Override
	public void serialize(List<Login> logins) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File(FILE_NAME), logins);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Login> deserialize() {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			List<Login> login = mapper.readValue(new File(FILE_NAME), List.class);
			return login;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
