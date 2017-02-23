package io.webapp.dish.metadata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootConfiguration
public class MetadataControllerTest {
	
	RestTemplate template;
	
	@Before
	public void setUp(){
		log.info("setup...");
		template = new RestTemplate();
		
	}
	
	
	@Test
	public void GetMethodsTest() throws Exception{
		log.info("testing 'GetMethodsTest'  method" );
	    String result = template.getForObject("http://localhost:9090/meta/class", String.class);
	    log.info(result);
		
	}
	
	//@Test
	public void GetAttributesTest(){
		
	}
	
	//@Test
	public void GetClassesTest(){
		
	}
}
