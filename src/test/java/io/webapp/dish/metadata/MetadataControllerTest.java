package io.webapp.dish.metadata;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetadataControllerTest {
	
	@Autowired
	MetadataController testController;
	
	
	@Test
	public void getMethodsTest(){
		//List<Method> methods = testController.getMethods("io.webapp.dish.Dish");
		//Wmethods.forEach(method -> System.out.println(method));
	}
}
