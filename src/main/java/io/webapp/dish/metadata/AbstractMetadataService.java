package io.webapp.dish.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


public abstract class AbstractMetadataService {
	
	private Class clazz;
	

	public AbstractMetadataService(String className){
		className = "io.webapp.dish." + className; 
		try {
			clazz = (Class) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Field> getFields(String className){
		Field[]fields = clazz.getFields();
		return Arrays.asList(fields);
	}
	
	public List<Method> getMethods(){
		Method[] methods = clazz.getMethods();
		return Arrays.asList(methods);
	}
	
	public List<Annotation> getAnnotations(){
		Annotation[] annotations = clazz.getAnnotations();
		return Arrays.asList(annotations);
	}
}
