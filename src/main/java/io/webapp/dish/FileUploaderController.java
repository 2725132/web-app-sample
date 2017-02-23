package io.webapp.dish;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

@CrossOrigin(origins = "*")
@Controller
public class FileUploaderController {

	
		@Autowired
		MultipartResolver resolver;
	
		@Autowired
		DishService service;
	
		@PostMapping(value="/upload") 
		public String uploadTest(@RequestParam(name="file") MultipartFile file) throws IOException{
			System.out.println("File Uploaded " + file.getContentType() + "  " + file.getSize() + "  " + file);
			byte[] img = file.getBytes();
			
			Dish d = new Dish(img, "água", "1 real", "bebida" );
			List<Dish> dishes = new ArrayList<Dish>();
			dishes.add(d);
			service.addDish(dishes);
			return "arquivo uploadeado";
		}
}
