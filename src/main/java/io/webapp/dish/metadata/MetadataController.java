package io.webapp.dish.metadata;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/meta/")
public class MetadataController {
	
	private MetadataService service;

	@RequestMapping(value="/{className}/methods")
	public List<Method> getMethods(@PathVariable String className){
		service = new MetadataService(className);
		return service.getMethods();
	}
	

}
