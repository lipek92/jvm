package com.lipek.json;

import java.util.ArrayList;
import java.util.Collections;

public class App 
{
	private static final long NUMBER_OF_TESTS = 10;
	private static final long NUMBER_OF_INVOKES = 100000;
	private static ArrayList<Long> jacksonResults = new ArrayList<>();
	private static ArrayList<Long> myConverterResults = new ArrayList<>();
	private static long startTime;
	private static long endTime;
	private static String jacksonString = null;
	private static String myConverterString = null;
	private static Converter converter = new Converter();
	private static SimpleObject simpleObject = new SimpleObject();
	
    public static void main( String[] args )
    {
    	simpleObject.publicInt = 10;
    	simpleObject.publicBool = true;
    	simpleObject.publicString = "xaxa";    	
    	
    	for	(int i = 0; i < NUMBER_OF_TESTS; i++){
    		jacksonTest();
        	myConverterTest();	
    	}
    	
    	deleteOutsiders();

    	
    	System.out.println("jackson:     "+jacksonString);
    	System.out.println("myConverter: "+myConverterString);
    	System.out.println("\n===== ŚREDNIE CZASY =====");
    	
    	long avgJackson = average(jacksonResults);
    	long avgMyConverter = average(myConverterResults);
    	System.out.println("jackson:      "+avgJackson);
    	System.out.println("myConverter:  "+avgMyConverter);
    	System.out.println("Współczynnik: "+ (avgMyConverter*100/avgJackson) +"%");
    }
    
	private static void deleteOutsiders()
	{
		jacksonResults.remove(jacksonResults.indexOf(Collections.max(jacksonResults)));	
		jacksonResults.remove(jacksonResults.indexOf(Collections.min(jacksonResults)));
		myConverterResults.remove(myConverterResults.indexOf(Collections.max(myConverterResults)));	
		myConverterResults.remove(myConverterResults.indexOf(Collections.min(myConverterResults)));	
	}

    private static long average(ArrayList<Long> list)
    {
		long sum = 0;
        
        for(int i=0; i < list.size() ; i++)
                sum = sum + list.get(i);
       
        long average = sum / list.size();
       
        return average;
    }
	
	private static void jacksonTest() {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			jacksonString = converter.toJackson(simpleObject);
		}
		endTime = System.nanoTime();
		jacksonResults.add(endTime - startTime);	
	}
	private static void myConverterTest() {
		startTime = System.nanoTime();
		for (int i = 0; i < NUMBER_OF_INVOKES; i++)
		{
			myConverterString = converter.toJson(simpleObject);
		}
		endTime = System.nanoTime();
		myConverterResults.add(endTime - startTime);	
	}
}
