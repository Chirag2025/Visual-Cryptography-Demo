package com.example.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePath {

	public String getResourcePath() {
		String path = "";
		File file = null;
		URL resource = getClass().getClassLoader().getResource("erdr.png");
		if (resource == null) {

			throw new IllegalArgumentException("file not found!");
		} else {

			try {

				file = new File(resource.toURI());
				path = file.getAbsolutePath();
				//System.out.println("#### getResourcePath " + path);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return path;

	}

	public File getFilePath() {
		File file = null;
		URL resource = getClass().getClassLoader().getResource("erdr.png");
		  if (resource == null) {
		      throw new IllegalArgumentException("file not found!");
		  } else {	      

		      try {
		    	  file = new File(resource.toURI());
		    	  System.out.println("#### Path"+file.getAbsolutePath());
					
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		 
		return file;
		  
	}
	
	 

}
