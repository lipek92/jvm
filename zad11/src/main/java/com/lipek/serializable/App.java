package com.lipek.serializable;

import java.util.ArrayList;
import java.util.List;


public class App 
{
	private static int numberOfTests = 10;
	private static int numberOfLogins = 1000;
	
	public static List<Login> logins = new ArrayList<Login>();
	public static List<BaseSerial> serializatos = new ArrayList<BaseSerial>();
	
    public static void main( String[] args )
    {
    	for (int i=0; i<numberOfLogins; i++){
            Login login = new Login();
            logins.add(login);		
    	}
    	
    	serializatos.add(new Serializer());
    	serializatos.add(new Jackson());
    	serializatos.add(new GsonConverter());
    	serializatos.add(new Externalizer());
    
    	System.out.println("SERIALIZATION");
        testSerialization();
        System.out.println("DESERIALIZATION");
        testDeserialization();
        
    }
    
	static public void testSerialization(){
		for (BaseSerial serializer : serializatos){
			int processingTime = 0;
			for (int i = 0; i<numberOfTests; i++){
				processingTime += serializer.testSerialization(logins);
			}
			float avg = processingTime / numberOfTests;
			System.out.println(serializer.getClass().toString() + " procesing time: " + processingTime);
			
		}
	}
	
	static public void testDeserialization(){
		for (BaseSerial serializer : serializatos){
			int processingTime = 0;
			for (int i = 0; i<numberOfTests; i++){
				processingTime += serializer.testDeserialization(logins);
			}
			float avg = processingTime / numberOfTests;
			System.out.println(serializer.getClass().toString() + " procesing time: " + processingTime);
			
		}
	}
}
