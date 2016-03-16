package com.lipek.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args )
    {
    	String jacksonString = null;
    	String myJsonString = null;
    	
    	ObjectMapper mapper = new ObjectMapper();
    	Converter converter = new Converter();
    	
    	SimpleObject simpleObject = new SimpleObject();
    	simpleObject.publicInt = 10;
    	
    	try {
    		jacksonString = mapper.writeValueAsString(simpleObject);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	myJsonString = converter.toJson(simpleObject);
    	
    	System.out.println(jacksonString);
    	System.out.println(myJsonString);
    }
}
