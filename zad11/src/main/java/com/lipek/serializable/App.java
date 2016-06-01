package com.lipek.serializable;

import java.util.ArrayList;
import java.util.List;


public class App 
{
	private static int numberOfTests = 10;
	private static int numberOfLogins = 10000;
	
	public static List<Login> logins = new ArrayList<Login>();
	public static List<LoginExt> loginsExt = new ArrayList<LoginExt>();
	public static List<BaseSerial> serializatos = new ArrayList<BaseSerial>();
	
    public static void main( String[] args )
    {
    	for (int i=0; i<numberOfLogins; i++){
            Login login = new Login();
            LoginExt loginExt = new LoginExt(login.getUsername(), login.getPassword());
            logins.add(login);
            loginsExt.add(loginExt);
    	}
    	
    	serializatos.add(new Serializer());
    	serializatos.add(new Jackson());
    	serializatos.add(new GsonConverter());

        testSerialization();
        testExternalizer();
        
    }
    
	static public void testSerialization(){
		for (BaseSerial serializer : serializatos){
			int processingTime = 0;
			for (int i = 0; i<numberOfTests; i++){
				processingTime += serializer.testSerialization(logins);
				processingTime += serializer.testDeserialization(logins);
			}
			float avg = processingTime / numberOfTests;
			System.out.println(serializer.getClass().toString() + " procesing time: " + processingTime);
		}
	}
	
	static public void testExternalizer(){
		Externalizer externalizer = new Externalizer(); 
		int processingTime = 0;
		for (int i = 0; i<numberOfTests; i++){
			processingTime += externalizer.testSerialization(loginsExt);
			processingTime += externalizer.testDeserialization(loginsExt);
		}
		float avg = processingTime / numberOfTests;
		System.out.println(externalizer.getClass().toString() + " procesing time: " + processingTime);
	}
	
}
