package io.webapp.dish;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploaderController {

		@RequestMapping("/upload")
		public String getUploadPage(){
			return "UploadTemplate";
		}
}
