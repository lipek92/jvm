package com.lipek.json;

import java.lang.reflect.Field;

public class Converter {

	public String toJson (Object o){
		String jsonResult = null;
		
		Field[] fields = o.getClass().getDeclaredFields();
		
		for (Field field : fields){
			System.out.println(field.getName());
			System.out.println(field.getType().getSimpleName());
		}
		
		return jsonResult;
	}
}
