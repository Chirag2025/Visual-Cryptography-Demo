package com.example.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.util.DecryptImage;
import com.example.util.EncryptImage;
import com.example.util.FilePath;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

	
	
	@Autowired
	FilePath filePath;
	@Override
	public String uploadAndEncryptImg(MultipartFile file) throws Exception {
		String response = "";
		
		String resourcePath = filePath.getResourcePath();
		
		resourcePath = resourcePath.substring(0,resourcePath.indexOf("erdr.png"));
	
		resourcePath = resourcePath+"static\\images";
		
		response = file.getOriginalFilename();
				
		Path fileNameAndPath = Paths.get(resourcePath, file.getOriginalFilename());        
        
		Files.write(fileNameAndPath, file.getBytes());
        
        EncryptImage img = new EncryptImage(response, resourcePath);
        
		return response;
	}

	@Override
	public String decryptImg() throws Exception {
		String response = "";
		
		String resourcePath = filePath.getResourcePath();
		
		resourcePath = resourcePath.substring(0,resourcePath.indexOf("erdr.png"));
		
		resourcePath = resourcePath+"static\\images";
		
		DecryptImage decryptImage = new DecryptImage(resourcePath);
		
		return response;
	}

}
