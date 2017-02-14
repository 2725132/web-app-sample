package io.webapp.dish.metadata;

import java.lang.reflect.Method;
import java.util.List;

public class MetadataService extends AbstractMetadataService {

	public MetadataService(String className){
		super(className);
	}
	
	public List<Method> getMethods(){
		return getMethods();
	}

	
}
