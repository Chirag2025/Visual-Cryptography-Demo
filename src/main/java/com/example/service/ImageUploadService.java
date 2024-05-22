package com.example.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

	String uploadAndEncryptImg(MultipartFile file) throws Exception;

	String decryptImg() throws Exception;

}
