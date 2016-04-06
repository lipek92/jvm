package com.lipek.sdf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App 
{
	private static final String DATE_FORMAT = "yyyy.MM.dd";
	private static final String DATE = "1992.08.01";
	
	private static ExecutorService executorServiceUnSafe = Executors.newFixedThreadPool(10);
	private static ExecutorService executorServiceSafe = Executors.newFixedThreadPool(10);
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	private static ArrayList<Date> unSafeResults = new ArrayList<>();
	private static ArrayList<Date> safeResults = new ArrayList<>();
	
    public static void main( String[] args )
    {
    	for (int i=0; i<20; i++)
    	{
    		try {
    			unSafe();
				safe();
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	
    	System.out.println("UNSAFE\n");
    	printResult(unSafeResults);
    	System.out.println("\nSAFE\n");
    	printResult(safeResults);
    }
    
    public static void unSafe() throws ParseException
    {
		executorServiceUnSafe.submit(new Runnable() {
		    public void run() {
		        try {
		        	unSafeResults.add(sdf.parse(DATE));
				} catch (ParseException e) {
					e.printStackTrace();
				}
		    }
		});
    }
    
    public static void safe() throws ParseException
    {
		executorServiceSafe.submit(new Runnable() {
		    public void run() {
		        try {
		        	safeResults.add(formatter.get().parse(DATE));
				} catch (ParseException e) {
					e.printStackTrace();
				}
		    }
		});
    }
    
    private static void printResult(ArrayList<Date> result){
    	for (int i = 0; i<result.size(); i++){
    		System.out.println(result.get(i));
    	}
    }
    
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat(DATE_FORMAT);
        }
    };
    
}
