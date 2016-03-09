package com.lipek.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class App 
{
	private static final long NUMBER_OF_TESTS = 102;
	private static final long NUMBER_OF_INVOKES = 100000;
	private static simpleObject simpleObject = new simpleObject();
	private static int tempInt;
	private static String tempString;
	private static int sampleInt = 12345;
	private static String sampleString = "xxxxx";
	private static Field tempField;
	private static Method tempMethod;
	private static long startTime;
	private static long endTime;
	
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
		
        deleteOutsiders();
        	
        printList(simpleReadTestResults, reflectionSimpleReadTestResults, "Typ prosty, odczyt");
        printList(simpleWriteTestResults, reflectionSimpleWriteTestResults, "Typ prosty, zapis");
        printList(referenceReadTestResults, reflectionReferenceReadTestResults, "Typ referencyjny, odczyt");
        printList(referenceWriteTestResults, reflectionReferenceWriteTestResults, "Typ referencyjny, zapis");
        printList(invokeMethodResults, reflectionInvokeMethodResults, "Metoda, zapis");
        
        printList(simpleReadTestResults, simpleWriteTestResults, referenceReadTestResults, referenceWriteTestResults, invokeMethodResults, "Bezpośrednio");
        printList(reflectionSimpleReadTestResults, reflectionSimpleWriteTestResults, reflectionReferenceReadTestResults, reflectionReferenceWriteTestResults, reflectionInvokeMethodResults, "Przez Refleksje");
		
        System.out.println("\n");
        
		System.out.println("WYWOŁANIA BEZPOŚREDNIE\nŚredni czas testu ODCZYTU dla typu PROSTEGO: " + average(simpleReadTestResults) + " ns");
		System.out.println("Średni czas testu ZAPISU dla typu PROSTEGO: " + average(simpleWriteTestResults) + " ns");
		System.out.println("Średni czas testu ODCZYTU dla typu REFERENCYJNEGO: " + average(referenceReadTestResults) + " ns");
		System.out.println("Średni czas testu ZAPISU dla typu REFERENCYJNEGO: " + average(referenceWriteTestResults) + " ns");
		System.out.println("Średni czas testu WYWOŁANIA METODY: " + average(invokeMethodResults) + " ns");
		
		System.out.println("WYWOŁANIA PRZEZ REFLEKSJE\nŚredni czas testu ODCZYTU dla typu PROSTEGO: " + average(reflectionSimpleReadTestResults) + " ns");
		System.out.println("Średni czas testu ZAPISU dla typu PROSTEGO: " + average(reflectionSimpleWriteTestResults) + " ns");
		System.out.println("Średni czas testu ODCZYTU dla typu REFERENCYJNEGO: " + average(reflectionReferenceReadTestResults) + " ns");
		System.out.println("Średni czas testu ZAPISU dla typu REFERENCYJNEGO: " + average(reflectionReferenceWriteTestResults) + " ns");
		System.out.println("Średni czas testu WYWOŁANIA METODY: " + average(reflectionInvokeMethodResults) + " ns");
    }
    
	private static void deleteOutsiders()
	{
		simpleReadTestResults.remove(simpleReadTestResults.indexOf(Collections.max(simpleReadTestResults)));
		simpleWriteTestResults.remove(simpleWriteTestResults.indexOf(Collections.max(simpleWriteTestResults)));
		referenceReadTestResults.remove(referenceReadTestResults.indexOf(Collections.max(referenceReadTestResults)));
		referenceWriteTestResults.remove(referenceWriteTestResults.indexOf(Collections.max(referenceWriteTestResults)));
		invokeMethodResults.remove(invokeMethodResults.indexOf(Collections.max(invokeMethodResults)));
		reflectionSimpleReadTestResults.remove(reflectionSimpleReadTestResults.indexOf(Collections.max(reflectionSimpleReadTestResults)));
		reflectionSimpleWriteTestResults.remove(reflectionSimpleWriteTestResults.indexOf(Collections.max(reflectionSimpleWriteTestResults)));
		reflectionReferenceReadTestResults.remove(reflectionReferenceReadTestResults.indexOf(Collections.max(reflectionReferenceReadTestResults)));
		reflectionReferenceWriteTestResults.remove(reflectionReferenceWriteTestResults.indexOf(Collections.max(reflectionReferenceWriteTestResults)));
		reflectionInvokeMethodResults.remove(reflectionInvokeMethodResults.indexOf(Collections.max(reflectionInvokeMethodResults)));
		
		simpleReadTestResults.remove(simpleReadTestResults.indexOf(Collections.min(simpleReadTestResults)));
		simpleWriteTestResults.remove(simpleWriteTestResults.indexOf(Collections.min(simpleWriteTestResults)));
		referenceReadTestResults.remove(referenceReadTestResults.indexOf(Collections.min(referenceReadTestResults)));
		referenceWriteTestResults.remove(referenceWriteTestResults.indexOf(Collections.min(referenceWriteTestResults)));
		invokeMethodResults.remove(invokeMethodResults.indexOf(Collections.min(invokeMethodResults)));
		reflectionSimpleReadTestResults.remove(reflectionSimpleReadTestResults.indexOf(Collections.min(reflectionSimpleReadTestResults)));
		reflectionSimpleWriteTestResults.remove(reflectionSimpleWriteTestResults.indexOf(Collections.min(reflectionSimpleWriteTestResults)));
		reflectionReferenceReadTestResults.remove(reflectionReferenceReadTestResults.indexOf(Collections.min(reflectionReferenceReadTestResults)));
		reflectionReferenceWriteTestResults.remove(reflectionReferenceWriteTestResults.indexOf(Collections.min(reflectionReferenceWriteTestResults)));
		reflectionInvokeMethodResults.remove(reflectionInvokeMethodResults.indexOf(Collections.min(reflectionInvokeMethodResults)));	
	}
    
    private static long average(ArrayList<Long> list)
    {
		long sum = 0;
        
        for(int i=0; i < list.size() ; i++)
                sum = sum + list.get(i);
       
        long average = sum / list.size();
       
        return average;
    }
    
    private static void printList(ArrayList<Long> firstList, ArrayList<Long> secondList, String name)
    {
		System.out.println(name);
		System.out.println("NumerTestu, Normalnie , Refleksja");
        
        for(int i=0; i < firstList.size(); i++)
            System.out.println(i+1 + "," + firstList.get(i) + "," + secondList.get(i));
    }
    
    private static void printList(ArrayList<Long> firstList, ArrayList<Long> secondList, ArrayList<Long> thirdList, ArrayList<Long> fourthList, ArrayList<Long> fifthList, String name)
    {
		System.out.println(name);
		System.out.println("NumerTestu, ProstyOdczyt, ProstyZapis, ReferencjaOdczyt, ReferencjaZapis, MetodaZapis");
        
        for(int i=0; i < firstList.size(); i++)
            System.out.println(i+1 + "," + firstList.get(i) + "," + secondList.get(i) + "," + thirdList.get(i) + "," + fourthList.get(i) + "," + fifthList.get(i));
    }
    
	private static void simpleReadTest() {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			tempInt = simpleObject.simpleInt;
		}
		endTime = System.nanoTime();
		simpleReadTestResults.add(endTime - startTime);
	}

	private static void simpleWriteTest() {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			simpleObject.simpleInt = sampleInt;
		}
		endTime = System.nanoTime();
		simpleWriteTestResults.add(endTime - startTime);
	}

	private static void referenceReadTest() {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			tempString = simpleObject.simpleString;
		}
		endTime = System.nanoTime();
		referenceReadTestResults.add(endTime - startTime);	
	}

	private static void referenceWriteTest() {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			simpleObject.simpleString = sampleString;
		}
		endTime = System.nanoTime();
		referenceWriteTestResults.add(endTime - startTime);
	}

	private static void invokeMethod() {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			simpleObject.setSimpleInt(123);
		}
		endTime = System.nanoTime();
		invokeMethodResults.add(endTime - startTime);
	}

	private static void reflectionSimpleReadTest(Class objectClass, Object objectInstance) {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempField = objectClass.getDeclaredField("simpleInt");
				tempInt = (int) tempField.get(objectInstance);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		endTime = System.nanoTime();
		reflectionSimpleReadTestResults.add(endTime - startTime);
	}

	private static void reflectionSimpleWriteTest(Class objectClass, Object objectInstance) {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempField = objectClass.getDeclaredField("simpleInt");
				tempField.set(objectInstance, 123);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		endTime = System.nanoTime();
		reflectionSimpleWriteTestResults.add(endTime - startTime);
	}

	private static void reflectionReferenceReadTest(Class objectClass, Object objectInstance) {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempField = objectClass.getDeclaredField("simpleString");
				tempString = (String) tempField.get(objectInstance);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		endTime = System.nanoTime();
		reflectionReferenceReadTestResults.add(endTime - startTime);
	}

	private static void reflectionReferenceWriteTest(Class objectClass, Object objectInstance) {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempField = objectClass.getDeclaredField("simpleString");
				tempField.set(objectInstance, "123");
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		endTime = System.nanoTime();
		reflectionReferenceWriteTestResults.add(endTime - startTime);
	}

	private static void reflectionInvokeMethod(Class objectClass, Object objectInstance) {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			try {
				tempMethod = objectClass.getDeclaredMethod("setSimpleInt", int.class);
				tempMethod.invoke(objectInstance, 123);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}			
		}
		endTime = System.nanoTime();
		reflectionInvokeMethodResults.add(endTime - startTime);
	}
}
