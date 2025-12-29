package com.telemedicine.controlles;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.telemedicine.services.ocrservices;

@Controller
public class ocr_controller {
	
	@Autowired
	private ocrservices ocrservices;
	
	 @GetMapping("/test")
	    public String index() {
	        return "test";
	    }

	    @PostMapping("/upload")
	    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) throws IOException {
	        File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
	        file.transferTo(tempFile);

	        String text = ocrservices.extractText(tempFile);
	        model.addAttribute("text", text);

	        return "test";
	    }

}
