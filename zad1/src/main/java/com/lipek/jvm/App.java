package com.lipek.jvm;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
    	ArrayList<String> array = new ArrayList<String>();
    	
        try {
        	while(true)
        	{
        		array.add("test");
        	}
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }
}
