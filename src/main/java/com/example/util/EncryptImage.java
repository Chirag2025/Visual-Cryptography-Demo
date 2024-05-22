package com.example.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class EncryptImage {



	static final int BLACK = -16777216;  // Constant to represent the RGB binary value of black. In binary - 1111111 00000000 00000000 00000000
	static final int WHITE = -1;  // Constant to represent the RGB binary value of white. In binary - 1111111 1111111 1111111 1111111
	private boolean imageFlag;  // Flag used to track state of image radio button
	private boolean textFlag;  // Flag used to track state of text radio button
	
	
	//private static final String INPUT_IMAGE = "canada.png";	
	//private static final String modifyActionIMAGE = "test.png";	
	//private static final String FOLDER_PATH = "C:\\Users\\Server\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\vs2\\photos";
	//private static final String OUTPUT_PATH = "C:\\Users\\Server\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\vs2\\photos\\shares";
	
	
	
	public EncryptImage(String imageName, String folderPath) {
				
		//Comment below as by default input is image
		//imageFlag = false;
		//textFlag = false;
		
		//So when image Set imageFlag = true;
		imageFlag = true;
		textFlag = false;
		
		//So when Text
		
		//imageFlag = false;
		//textFlag = true;
		
		//Code to select file to import as the original image
		String inputImg = folderPath+File.separator+imageName;
		OriginalActionPerformed(inputImg);
		
		ModifiedActionPerformed(folderPath);
		
		EncryptAddMouseListener();
		
		
	
	}


	


	private void OriginalActionPerformed(String inputImg) {
	
		if(imageFlag == false && textFlag == false){
			System.out.println("Select image radio button");
			return;
		}
		
		else{
			
			// Allows user to choose file name and path for original image
			
			//File file = new File(INPUT_IMAGE);//Added by Amol
			File file = new File(inputImg);//Added by Amol
			
			Main.path = ImageFunctions.GetPathName(file);
			
			
			// Handles errors during file selection
			try{
				Main.file = new File(Main.path);
				Main.originalImage = ImageFunctions.Display(Main.file, "Original");
				
				
			} catch (NullPointerException e) {
				//Original_Path_Name.setText("Error opening image file");
				return;
			}

			//Update label to display selected path
			//Original_Path_Name.setText(Main.path);
			
		}
		
	}


	private void ModifiedActionPerformed(String folderPath) 
	{
		//if(imageFlag == false && Main.path == null && rdbtnText.isSelected() == false)
		if(imageFlag == false && Main.path == null)
		{
			System.out.println("Select image radio button/select an original image");
			return;
		}
		
		else{
			
			// Allow user to chose a save location and name
			//File file = new File(modifyActionIMAGE);//Added by Amol
			String modifyActionIMAGE = folderPath+File.separator+"modified.png";
			File file = new File(modifyActionIMAGE);//Added by Amol
			Main.save_path = ImageFunctions.GetPathName(file);
			
			// Catch errors during path selection
			if (Main.save_path == null) {
				//Save_Path_Name.setText("Error selecting save destination");
				return;
			}
			
			// Create a save file for key
			Main.save_key_path = Main.save_path + "_key.png";
			Main.key_file = new File(Main.save_key_path);
			
			//System.out.println("Save key: " + Main.save_key_path);
								
			// Create a save file for cipher
			Main.save_cipher_path = Main.save_path + "_cipher.png";
			Main.cipher_file = new File(Main.save_cipher_path);
			
			//System.out.println("Save cipher: " + Main.save_cipher_path);
			
			//Update save label to display selected path
			//Save_Path_Name.setText(Main.save_path + ".png");						
			
		}
		
	}
	
private void EncryptAddMouseListener() {

		
		//Read in user text input
		//String text = textArea.getText();
		
		// If user has not entered text, prompt and return
		//if(imageFlag == false && text.equals("")){
		if(imageFlag == false){
			System.out.println("Enter some text");
			return;
		}
		
		// If user has entered text, obtain image of textbox and store as original image
		/*
		if(imageFlag == false && textFlag == true){
			
			//System.out.println("converting textbox to image"); // Print debugging statement
			
			// Convert text input box into an image
			BufferedImage text_image = new BufferedImage(textArea.getWidth(), textArea.getHeight(), BufferedImage.TYPE_BYTE_BINARY );
			Graphics2D graphic = text_image.createGraphics();
			textArea.printAll(graphic);
			graphic.dispose();
			
			//ImageFunctions.Display_Image(text_image, "Text converted to image"); // Print debugging statement
			
			Main.originalImage = text_image;
		}
		*/
		//File names and paths for the magnified images
		Main.save_key_magnified_path = Main.save_path + "_key_magnified.png";
		Main.save_cipher_magnified_path = Main.save_path + "_cipher_magnified.png";
		Main.key_magnified_file = new File(Main.save_key_magnified_path);
		Main.cipher_magnified_file = new File(Main.save_cipher_magnified_path);
		
		// Create Black and White image from original image
		BufferedImage black_white = new BufferedImage(
		        Main.originalImage.getWidth(), Main.originalImage.getHeight(),
		        BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D graphics = black_white.createGraphics();
		graphics.drawImage(Main.originalImage, 0, 0, null);

		// Save and display black and white image file
		Main.bw_file = new File(Main.save_path + ".png");
		ImageFunctions.Save(black_white, Main.bw_file);
		ImageFunctions.Display(Main.bw_file, "Original B/W");
		
		// Create image key
		BufferedImage key_image = new BufferedImage(
		        Main.originalImage.getWidth(), Main.originalImage.getHeight(),
		        BufferedImage.TYPE_BYTE_BINARY);
		
		// Generate a random key
		Random rand = new Random();
		try {
			SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
			
			for(int i = 0; i < key_image.getHeight(); i++){
				for(int j = 0; j < key_image.getWidth(); j++){
					
					int result = secureRandomGenerator.nextInt(100);
					if(result < 50){
						key_image.setRGB(j, i, WHITE);
					}
					else{
						key_image.setRGB(j, i, BLACK);
					}
				}
			}
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// Save and display key image file					
		//ImageFunctions.Display_Image(key_image, "Key");		
		ImageFunctions.Save(key_image, Main.key_file);
		
		// Save and display magnified key image file		
		BufferedImage magnified_key_image = ImageFunctions.Magnify(key_image);
		ImageFunctions.Save(magnified_key_image, Main.key_magnified_file);
		
		//ImageFunctions.Display_Image(magnified_key_image, "Magnified key");
		
		// Save and display magnified cipher image file
		
		Main.cipher_image = ImageFunctions.Create_Cipher(black_white, key_image);
		BufferedImage magnified_cipher_image = ImageFunctions.Magnify(Main.cipher_image);
		ImageFunctions.Save(magnified_cipher_image, Main.cipher_magnified_file);
		
		//ImageFunctions.Display_Image(magnified_cipher_image, "Magnified Cipher");
		
		// Save and display printer friendly images if button checked
		/*if (chckbxIncludePrintFriendly.isSelected()) {
			//System.out.println("The printer friendly check box is selected, outputting printer sized pics");  // Print debugging statement
			
			BufferedImage print_ready_test = ImageFunctions.make_print_friendly(black_white);
			//ImageFunctions.Display_Image(print_ready_test, "Print Ready");
			
			BufferedImage print_ready_key = ImageFunctions.make_print_friendly(magnified_key_image);
			String print_ready_key_path = Main.save_path + "_key_print_ready.png";
			File print_ready_key_file = new File(print_ready_key_path);
			ImageFunctions.Save(print_ready_key, print_ready_key_file);
			
			BufferedImage print_ready_cipher = ImageFunctions.make_print_friendly(magnified_cipher_image);
			String print_ready_cipher_path = Main.save_path + "_cipher_print_ready.png";
			File print_ready_cipher_file = new File(print_ready_cipher_path);
			ImageFunctions.Save(print_ready_cipher, print_ready_cipher_file);
			}
	
		*/
		
		BufferedImage print_ready_test = ImageFunctions.make_print_friendly(black_white);
		//ImageFunctions.Display_Image(print_ready_test, "Print Ready");
		
		BufferedImage print_ready_key = ImageFunctions.make_print_friendly(magnified_key_image);
		String print_ready_key_path = Main.save_path + "_key_print_ready.png";
		File print_ready_key_file = new File(print_ready_key_path);
		ImageFunctions.Save(print_ready_key, print_ready_key_file);
		
		BufferedImage print_ready_cipher = ImageFunctions.make_print_friendly(magnified_cipher_image);
		String print_ready_cipher_path = Main.save_path + "_cipher_print_ready.png";
		File print_ready_cipher_file = new File(print_ready_cipher_path);
		ImageFunctions.Save(print_ready_cipher, print_ready_cipher_file);
	}

}
