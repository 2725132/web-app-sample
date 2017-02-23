package io.webapp.dish.metadata;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
@Log4j
@RestController
@RequestMapping(value="/meta")
public class MetadataController {
	
	@Autowired
	private MetadataService service;

	@RequestMapping(value="/{className}/methods")
	public List<String> getMethods(@PathVariable String className) throws ClassNotFoundException{
		log.info("calling getMethods with parameter " + className + ", inside "  + this.getClass().getName());
		return service.getMethods(className);
	}
	
	@RequestMapping(value="/{className}/attr")
	public List<String> getAttributes(@PathVariable String className) throws ClassNotFoundException{
		log.info("calling getAttributes with parameter " + className + ", inside "  + this.getClass().getName());
		return service.getAttributes(className);
	}
	
	@RequestMapping(value="/class")
	public List<String> getClasses() throws ClassNotFoundException{
		log.info("calling getClasses inside " + this.getClass().getName());
		return service.getClasses();
	}

}
