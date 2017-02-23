package io.webapp.dish.metadata;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/meta")
public class MetadataController {
	
	@Autowired
	private MetadataService service;

	@RequestMapping(value="/{className}/methods")
	public List<String> getMethods(@PathVariable String className) throws ClassNotFoundException{
		return service.getMethods(className);
	}
	
	@RequestMapping(value="/{className}/attr")
	public List<String> getAttributes(@PathVariable String className) throws ClassNotFoundException{
		return service.getAttributes(className);
	}
	
	@RequestMapping(value="/class")
	public List<String> getClasses() throws ClassNotFoundException{
		return service.getClasses();
	}

}
