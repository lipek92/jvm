package com.lipek.json;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

public class Converter {

	public String toJson (Object o) throws IllegalArgumentException, IllegalAccessException{
		String jsonResult = null;
		Class<?> type = null;
		
		Field[] fields = o.getClass().getDeclaredFields();
		
		jsonResult = "{";
		
		for (Field field : fields){	
			field.setAccessible(true);
			type = field.getType();

			if (type.equals(Collection.class)){
				continue;
			} else if (type.isArray()){
				jsonResult += parseArray(field, o) + ",";
			} else if (type.equals(String.class)){
				if (field.get(o) == null){
					jsonResult += "\""+field.getName()+"\":"+field.get(o)+",";
				} else {
					jsonResult += "\""+field.getName()+"\":\""+field.get(o)+"\",";
				}
			} else {
				jsonResult += "\""+field.getName()+"\":"+field.get(o)+",";
			}

		}
		
		jsonResult = jsonResult.substring(0, jsonResult.length()-1);
		jsonResult += "}";
		
		return jsonResult;
	}

	private String parseArray(Field field, Object obj) throws IllegalArgumentException, IllegalAccessException {
		String parseResult = "\""+field.getName()+"\":";
		
		Class cType = field.getType().getComponentType();
	    Object array = field.get(obj);
	    
	    if (array != null){
			parseResult += "[";
		    for(int i = 0; i<Array.getLength(array); i++){
				if (cType.equals(String.class)){
					parseResult += "\""+Array.get(array, i)+"\",";
				} else {
					parseResult += Array.get(array, i)+",";
			    }
		    }
		    if (Array.getLength(array) != 0){
			    parseResult = parseResult.substring(0, parseResult.length()-1);
		    }
			parseResult += "]";
	    } else {
	    	parseResult += null;
	    }

		return parseResult;
	}
}
