package com.lipek;

public class MyClass {
	
	public static int doSomething(String time){
		int ms = Integer.parseInt(time);
		System.out.println("Method from MyClass");
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ms;
	}

}
