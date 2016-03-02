package com.lipek.jvm;

public class App 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException
    {
		MyService s0, s1, s2;
		s0 = new MyImpl();
		System.out.println("CL s0: " + s0.getClass().getClassLoader());

		s1 = MyFactory.newInstance();
		System.out.println("CL s1: " + s1.getClass().getClassLoader());

		while (true) {
			s2 = MyFactory.newInstance();
			System.out.println("0. " + s0.message());
			System.out.println("1. " + s1.message());
			System.out.println("2. " + s2.message());
			System.out.println("====================================");

			Thread.sleep(5000);
		}
		

    }
}

