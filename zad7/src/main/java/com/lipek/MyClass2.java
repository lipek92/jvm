package com.lipek;

public class MyClass2 {
	
	public static int doSomething(String time){
		System.out.println("Parameter: "+time);
		int ms = Integer.parseInt(time);
		System.out.println("Method from MyClass2");
		try {
			Thread.sleep(ms*2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ms;
	}

}
