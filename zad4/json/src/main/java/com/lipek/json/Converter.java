package com.lipek.json;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {
	
	ObjectMapper mapper = new ObjectMapper();

	public String toJson (Object o){
		Class<?> type = null;
		
		Field[] fields = o.getClass().getDeclaredFields();
		
		StringBuilder jsonResult = new StringBuilder("{");
		try {
			for (Field field : fields){	
				field.setAccessible(true);
				type = field.getType();
	
				if (type.isArray()){
					jsonResult.append(parseArray(field, o)).append(",");
				} else if (type.equals(String.class)){
	
						if (field.get(o) == null){
							jsonResult.append("\"").append(field.getName()).append("\":").append(field.get(o)).append(",");
						} else {
							jsonResult.append("\"").append(field.getName()).append("\":\"").append(field.get(o)).append("\",");
						}
	
				} else {
						jsonResult.append("\"").append(field.getName()).append("\":").append(field.get(o)).append(",");
				}
	
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		jsonResult.replace(jsonResult.length()-1, jsonResult.length(), "}");
		
		return jsonResult.toString();
	}

	private String parseArray(Field field, Object o) {
		StringBuilder parseResult = new StringBuilder("\"").append(field.getName()).append("\":");
		
		Class cType = field.getType().getComponentType();
	    Object array = null;
		try {
			array = field.get(o);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	    
	    if (array != null){
			parseResult.append("[");
		    for(int i = 0; i<Array.getLength(array); i++){
				if (cType.equals(String.class)){
					parseResult.append("\"").append(Array.get(array, i)).append("\",");
				} else {
					parseResult.append(Array.get(array, i)).append(",");
			    }
		    }
		    if (Array.getLength(array) != 0){
		    	parseResult.delete(parseResult.length()-1, parseResult.length());
		    }
			parseResult.append("]");
	    } else {
	    	parseResult.append(array);
	    }

		return parseResult.toString();
	}
	
	public String toJackson (Object o){
		try {
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
