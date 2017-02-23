package io.webapp.dish.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;


public abstract class AbstractMetadataService {

	public AbstractMetadataService(){
	}
	
	public List<Field> getFields(String className){
		Field[]fields = null;
		return Arrays.asList(fields);
	}
	

	
	public List<Annotation> getAnnotations(){
		Annotation[] annotations = null;
		return Arrays.asList(annotations);
	}
}
