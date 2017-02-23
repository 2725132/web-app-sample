package io.webapp.dish.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.stereotype.Component;

@Component
public class DirectoryReader {

	
	private List<String> allClasses;
	
	@PostConstruct
	public void init(){
		getAllClassesName();
	}
	
	public String getFullName(String className) throws ClassNotFoundException{
		for (String name : allClasses){
			if(name.endsWith(className)) return name;
		}
		throw new ClassNotFoundException();
	}
	
	public List<String> getClasses(){
		return allClasses;
	}

	private void getAllClassesName(){
		Reflections reflections = new Reflections("io.webapp", new SubTypesScanner(false));
		Set<String> classes = reflections.getAllTypes();
		this.allClasses	= new ArrayList<String>(classes);
		Collections.sort(this.allClasses);
	}
	
}