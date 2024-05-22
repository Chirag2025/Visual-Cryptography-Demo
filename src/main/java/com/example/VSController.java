package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.ImageUploadService;

@Controller
public class VSController {

	@Autowired
	ImageUploadService imageUploadService;
	
	
	@GetMapping({"/","home"})
	public String home() {
		return "home";
	}
	
	@ResponseBody
	@PostMapping("uploadAndEncryptImg")
	public String uploadImg(@RequestParam(name = "file", required = true) MultipartFile file) {
		String response = "";
		try
		{
			response = imageUploadService.uploadAndEncryptImg(file);
			System.out.println("### response ["+response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return response;
	}
	
	@ResponseBody
	@PostMapping("decryptImg")
	public String decryptImg() {
		String response = "";
		try 
		{
			response = imageUploadService.decryptImg();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return response;
	}
	
}
