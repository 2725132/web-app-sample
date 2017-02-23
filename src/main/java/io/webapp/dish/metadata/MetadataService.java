package io.webapp.dish.metadata;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetadataService extends AbstractMetadataService {

	public MetadataService(){
		super();
	}
	
	@Autowired
	private DirectoryReader directoryReader;
	
	public List<String> getMethods(String className) throws ClassNotFoundException{
		String fullClassName = directoryReader.getFullName(className);
		Method[] methods = Class.forName(fullClassName).getMethods();
		List<Method> methodsTransformed = Arrays.asList(methods);
		List<String> methodsName = new ArrayList<String>();
		methodsTransformed.forEach(name -> methodsName.add(name.getName()));
		
		return methodsName;
	}
	
	public List<String> getAttributes(String className) throws ClassNotFoundException {
		String fullClassName = directoryReader.getFullName(className);
		Field[] fields = Class.forName(fullClassName).getDeclaredFields();
		List<Field> fieldsTransformed = Arrays.asList(fields);
		List<String> fieldsName = new ArrayList<String>();
		fieldsTransformed.forEach(name -> fieldsName.add(name.getName()));
		
		return fieldsName;
	}

	public List<String> getClasses() {
		return directoryReader.getClasses();

	}
	

	
}
