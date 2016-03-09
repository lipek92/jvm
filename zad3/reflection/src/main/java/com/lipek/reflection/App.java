package com.lipek.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class App 
{
	private static final long NUMBER_OF_TESTS = 10;
	private static final long NUMBER_OF_INVOKES = 10000;
	private static simpleObject simpleObject = new simpleObject();
	private static int tempInt;
	private static String tempString;
	private static Field tempField;
	private static Method tempMethod;
	
	private static ArrayList<Long> simpleReadTestResults = new ArrayList<>();
	private static ArrayList<Long> simpleWriteTestResults = new ArrayList<>();
	private static ArrayList<Long> referenceReadTestResults = new ArrayList<>();
	private static ArrayList<Long> referenceWriteTestResults = new ArrayList<>();
	private static ArrayList<Long> invokeMethodResults = new ArrayList<>();
	
	private static ArrayList<Long> reflectionSimpleReadTestResults = new ArrayList<>();
	private static ArrayList<Long> reflectionSimpleWriteTestResults = new ArrayList<>();
	private static ArrayList<Long> reflectionReferenceReadTestResults = new ArrayList<>();
	private static ArrayList<Long> reflectionReferenceWriteTestResults = new ArrayList<>();
	private static ArrayList<Long> reflectionInvokeMethodResults = new ArrayList<>();

    public static void main( String[] args )
    {
    	Class objectClass;
    	Object objectInstance;
    	
		try {
			objectClass = Class.forName("com.lipek.reflection.simpleObject");
			objectInstance = objectClass.newInstance();
			
	    	for	(int i = 0; i < NUMBER_OF_TESTS; i++){
	    		
	        	simpleReadTest();		
	        	simpleWriteTest();
	        	referenceReadTest();
	        	referenceWriteTest();
	        	invokeMethod();
	        	
	        	reflectionSimpleReadTest(objectClass, objectInstance);
	        	reflectionSimpleWriteTest(objectClass, objectInstance);
	        	reflectionReferenceReadTest(objectClass, objectInstance);
	        	reflectionReferenceWriteTest(objectClass, objectInstance);
	        	reflectionInvokeMethod(objectClass, objectInstance);   
	        	
	    	}	
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		

		average(invokeMethodResults);
        average(reflectionInvokeMethodResults);
		
    	
    }
    
    private static void average(ArrayList<Long> list)
    {
		long sum = 0;
        
        for(int i=0; i < list.size() ; i++)
                sum = sum + list.get(i);
       
        double average = sum / list.size();
       
        System.out.println("Average value of array elements is : " + average);
    }
    
	private static void simpleReadTest() {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			tempInt = simpleObject.simpleInt;
		}
		long resultTime = System.nanoTime() - startTime;
		simpleReadTestResults.add(resultTime);
	}

	private static void simpleWriteTest() {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			simpleObject.simpleInt = 123;
		}
		long resultTime = System.nanoTime() - startTime;
		simpleWriteTestResults.add(resultTime);
	}

	private static void referenceReadTest() {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			tempString = simpleObject.simpleString;
		}
		long resultTime = System.nanoTime() - startTime;
		referenceReadTestResults.add(resultTime);	
	}

	private static void referenceWriteTest() {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			simpleObject.simpleString = "123";
		}
		long resultTime = System.nanoTime() - startTime;
		referenceWriteTestResults.add(resultTime);
	}

	private static void invokeMethod() {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			simpleObject.setSimpleInt(123);
		}
		long resultTime = System.nanoTime() - startTime;
		invokeMethodResults.add(resultTime);
	}

	private static void reflectionSimpleReadTest(Class objectClass, Object objectInstance) {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempField = objectClass.getDeclaredField("simpleInt");
				tempInt = (int) tempField.get(objectInstance);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		long resultTime = System.nanoTime() - startTime;
		reflectionSimpleReadTestResults.add(resultTime);
	}

	private static void reflectionSimpleWriteTest(Class objectClass, Object objectInstance) {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempField = objectClass.getDeclaredField("simpleInt");
				tempField.set(objectInstance, 123);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		long resultTime = System.nanoTime() - startTime;
		reflectionSimpleWriteTestResults.add(resultTime);
	}

	private static void reflectionReferenceReadTest(Class objectClass, Object objectInstance) {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempField = objectClass.getDeclaredField("simpleString");
				tempString = (String) tempField.get(objectInstance);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		long resultTime = System.nanoTime() - startTime;
		reflectionReferenceReadTestResults.add(resultTime);
	}

	private static void reflectionReferenceWriteTest(Class objectClass, Object objectInstance) {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempField = objectClass.getDeclaredField("simpleString");
				tempField.set(objectInstance, "123");
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		long resultTime = System.nanoTime() - startTime;
		reflectionReferenceWriteTestResults.add(resultTime);
	}

	private static void reflectionInvokeMethod(Class objectClass, Object objectInstance) {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempMethod = objectClass.getDeclaredMethod("setSimpleInt", int.class);
				tempMethod.invoke(objectInstance, 123);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}			
		}
		long resultTime = System.nanoTime() - startTime;
		reflectionInvokeMethodResults.add(resultTime);
	}
}
