package io.webapp.dish.metadata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetadataServiceTest {
	
	@Autowired
	private MetadataService testService;
	
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void GetMethodsTest() throws ClassNotFoundException{
		List<String> methods = testService.getMethods("Dish");
		assertNotNull(methods);
		assertEquals(methods.isEmpty(), false);
		assertTrue(methods.size() > 1);
		
		exception.expect(ClassNotFoundException.class);
		testService.getMethods("BissoClass");
	}
	
	@Test
	public void GetAttributesTest() throws ClassNotFoundException{
		List<String> attributes = testService.getAttributes("Dish");
		assertNotNull(attributes);
		assertEquals(attributes.isEmpty(), false);
		assertTrue(attributes.size() >= 4);
		
		exception.expect(ClassNotFoundException.class);
		testService.getAttributes("BissoClass");
	}
	
	@Test
	public void GetClassesTest(){
		List<String> classesWithinSystem = testService.getClasses();
		assertNotNull(classesWithinSystem);
		assertEquals(classesWithinSystem.isEmpty(), false);

	}
}
