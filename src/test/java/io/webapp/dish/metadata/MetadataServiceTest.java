package io.webapp.dish.metadata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MetadataServiceTest {
	
	@Test
	public void GetMethodsTest(){
		MetadataService service = new MetadataService();
		service.getAll();
		
	}
}
