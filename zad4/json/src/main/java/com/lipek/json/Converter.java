package com.lipek.json;

import java.lang.reflect.Field;
import java.util.Collection;

public class Converter {

	public String toJson (Object o) throws IllegalArgumentException, IllegalAccessException{
		String jsonResult = null;
		Class<?> type = null;
		
		Field[] fields = o.getClass().getDeclaredFields();
		
		int counter = 0;
		jsonResult = "{";
		
		for (Field field : fields){
			counter++;
			
			type = field.getType();

			if (type.equals(Collection.class) || type.isArray()){
				continue;
			} else if (type.equals(String.class)){
				jsonResult += "\""+field.getName()+"\":\""+field.get(o)+"\",";
			} else {
				jsonResult += "\""+field.getName()+"\":"+field.get(o)+",";
			}

		}
		
		jsonResult = jsonResult.substring(0, jsonResult.length()-1);
		jsonResult += "}";
		
		return jsonResult;
	}
}
