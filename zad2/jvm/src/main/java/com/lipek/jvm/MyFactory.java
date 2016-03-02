package com.lipek.jvm;


public class MyFactory {

	public static MyService newInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		ClassLoader myCL = new MyClassLoader();
		
		return (MyService) myCL.loadClass("com.lipek.jvm.MyImpl").newInstance();
	}
}