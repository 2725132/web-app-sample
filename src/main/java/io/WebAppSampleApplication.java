package io;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;



@SpringBootApplication

public class WebAppSampleApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(WebAppSampleApplication.class, args);
	}
}
