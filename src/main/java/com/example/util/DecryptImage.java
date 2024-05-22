package com.example.util;

import java.io.File;



public class DecryptImage {



	private static final long serialVersionUID = 1L;
	
	
	//private static final String Image_1 = "C:\\Users\\Server\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\vs2\\photos\\shares.png";
	//private static final String Image_2 = "C:\\Users\\Server\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\vs2\\photos\\shares_key.png";
	
	//private static final String Image_3 = "C:\\Users\\Server\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\vs2\\test.png_cipher_magnified.png";
	//private static final String Image_4 = "C:\\Users\\Server\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\vs2\\test.png_key_magnified.png";
	
	//private static final String Image_3 = "C:\\Users\\Server\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\vs2\\test.png_cipher_print_ready.png";
	//private static final String Image_4 = "C:\\Users\\Server\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\vs2\\test.png_key_print_ready.png";
	
	//private static final String Image_3 = "C:\\Users\\Server\\Documents\\vsData\\input\\test.png_cipher_magnified.png";
	//private static final String Image_4 = "C:\\Users\\Server\\Documents\\vsData\\input\\test.png_key_magnified.png";
	
	//private static final String OUTPUT_IMAGE = "output";
	
	public DecryptImage(String folderPath){
		

		
		// Create the decrypt page JFrame
		/*
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{440, 0};
		gbl_contentPane.rowHeights = new int[]{49, 56, 56, 56, 56, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		*/
		
		// Create decrypt page title
		/*
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		JLabel lblDecrypt = new JLabel("Decryption");
		lblDecrypt.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDecrypt.setBorder(loweredetched);
		lblDecrypt.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDecrypt = new GridBagConstraints();
		gbc_lblDecrypt.fill = GridBagConstraints.BOTH;
		gbc_lblDecrypt.insets = new Insets(0, 0, 5, 0);
		gbc_lblDecrypt.gridx = 0;
		gbc_lblDecrypt.gridy = 0;
		contentPane.add(lblDecrypt, gbc_lblDecrypt);
		*/
		// Allows user to select first image to decrypt
		
		imageOneActionPerformed(folderPath);
		imageTwoActionPerformed(folderPath);
		saveImageActionPerformed(folderPath);
		decryptImageActionPerformed();
		
		/*
		JButton btnImage1 = new JButton("Image 1");
		GridBagConstraints gbc_btnImage1 = new GridBagConstraints();
		gbc_btnImage1.fill = GridBagConstraints.BOTH;
		gbc_btnImage1.insets = new Insets(0, 50, 5, 50);
		gbc_btnImage1.gridx = 0;
		gbc_btnImage1.gridy = 1;
		contentPane.add(btnImage1, gbc_btnImage1);
		btnImage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Allow user to choose path
				Main.image1_path = ImageFunctions.GetPathName();
				
				// Attempt to open file as image
				try{
					Main.image1_file = new File(Main.image1_path);
				} catch (NullPointerException e) {
					System.out.println("An invalid file path was returned");
					return;
				}
				
				// Display image 1
				Main.image1 = ImageFunctions.Display(Main.image1_file, "Image 1");

			}
		});
		*/
		
		
		// Allow user to select second image to decrypt
		
		/*
		JButton btnImage2 = new JButton("Image 2");
		GridBagConstraints gbc_btnImage2 = new GridBagConstraints();
		gbc_btnImage2.fill = GridBagConstraints.BOTH;
		gbc_btnImage2.insets = new Insets(0, 50, 5, 50);
		gbc_btnImage2.gridx = 0;
		gbc_btnImage2.gridy = 2;
		contentPane.add(btnImage2, gbc_btnImage2);
		btnImage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Allow user to choose second file
				Main.image2_path = ImageFunctions.GetPathName();
				
				// Attempt to open file as image
				try{
					Main.image2_file = new File(Main.image2_path);
				} catch (NullPointerException e) {
					System.out.println("An invalid file path was returned");
					return;
				}
				
				// Display image 2
				Main.image2 = ImageFunctions.Display(Main.image2_file, "Image 2");
			}
		});
		*/
		
		// Choose a path for output to be saved
		/*
		JButton btnSaveImage = new JButton("Save Image");
		GridBagConstraints gbc_btnSaveImage = new GridBagConstraints();
		gbc_btnSaveImage.fill = GridBagConstraints.BOTH;
		gbc_btnSaveImage.insets = new Insets(0, 50, 5, 50);
		gbc_btnSaveImage.gridx = 0;
		gbc_btnSaveImage.gridy = 3;
		contentPane.add(btnSaveImage, gbc_btnSaveImage);
		btnSaveImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Allow user to choose path
				Main.image_decrypt_path = ImageFunctions.GetPathName();
				Main.normal_size_decrypted_path = Main.image_decrypt_path;
				
				// Format save string name
				Main.image_decrypt_path += ".png";
				Main.normal_size_decrypted_path += "_normal_size.png";
				
				// Attempt to create an output file
				try{
					Main.image_decrypt_file = new File(Main.image_decrypt_path);
					Main.normal_size_decrypted_file = new File(Main.normal_size_decrypted_path);
				} catch (NullPointerException e) {
					System.out.println("An invalid file path was returned");
					return;
				}
				
			}
		});
		*/
		
		// Convert encrypted images into decrypted output
		/*
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Decrypt and display the encoded images
				Main.decrypt_image = ImageFunctions.Decrypt(Main.image1, Main.image2);
				ImageFunctions.Display_Image(Main.decrypt_image, "Decrypted Image");
				
				// Save the decrypted image
				ImageFunctions.Save(Main.decrypt_image, Main.image_decrypt_file);

				// Create, display, and save scaled image (same size as original image
				Main.normal_size_decrypted_image = ImageFunctions.Shrink(Main.decrypt_image);
				ImageFunctions.Display_Image(Main.normal_size_decrypted_image, "Regular Sized Decrypted Image");				
				ImageFunctions.Save(Main.normal_size_decrypted_image, Main.normal_size_decrypted_file);
			}
		});
		*/
		
		/*
		GridBagConstraints gbc_btnDecrypt = new GridBagConstraints();
		gbc_btnDecrypt.fill = GridBagConstraints.BOTH;
		gbc_btnDecrypt.insets = new Insets(0, 50, 0, 50);
		gbc_btnDecrypt.gridx = 0;
		gbc_btnDecrypt.gridy = 4;
		contentPane.add(btnDecrypt, gbc_btnDecrypt);
		 */
	}

	private void imageOneActionPerformed(String folderPath) 
	{
		

		
		// Allow user to choose path
		//********* Amol add path of encrypted image ======>
		String shareImg1 = folderPath+File.separator+"modified.png_cipher_print_ready.png";
		System.out.println("#### shareImg1 "+shareImg1);
		File file = new File(shareImg1);
		
		Main.image1_path = ImageFunctions.GetPathName(file);
		
		// Attempt to open file as image
		try{
			Main.image1_file = new File(Main.image1_path);
		} catch (NullPointerException e) {
			System.out.println("An invalid file path was returned");
			return;
		}
		
		// Display image 1
		Main.image1 = ImageFunctions.Display(Main.image1_file, "Image 1");

	
		
	}

	private void imageTwoActionPerformed(String folderPath)
	{			
		// Allow user to choose second file
		//********* Amol add path of encrypted image ======>
		String shareImg2 = folderPath+File.separator+"modified.png_key_print_ready.png";
		System.out.println("#### shareImg2 "+shareImg2);
		File file = new File(shareImg2);
		Main.image2_path = ImageFunctions.GetPathName(file);
		
		// Attempt to open file as image
		try{
			Main.image2_file = new File(Main.image2_path);
		} catch (NullPointerException e) {
			System.out.println("An invalid file path was returned");
			return;
		}
		
		// Display image 2
		Main.image2 = ImageFunctions.Display(Main.image2_file, "Image 2");	
		
	}

	private void saveImageActionPerformed(String folderPath) 
	{
				
		// Allow user to choose path
		//********* Amol add path of blank image to save image ======>
		String decryptedImg = folderPath+File.separator+"output";
		File file = new File(decryptedImg);
		
		Main.image_decrypt_path = ImageFunctions.GetPathName(file);
		Main.normal_size_decrypted_path = Main.image_decrypt_path;
		
		// Format save string name
		Main.image_decrypt_path += ".png";
		Main.normal_size_decrypted_path += "_normal_size.png";
		
		// Attempt to create an output file
		try{
			Main.image_decrypt_file = new File(Main.image_decrypt_path);
			Main.normal_size_decrypted_file = new File(Main.normal_size_decrypted_path);
		} catch (NullPointerException e) {
			System.out.println("An invalid file path was returned");
			return;
		}
		
	
		
	}

	private void decryptImageActionPerformed() 
	{		
		// Decrypt and display the encoded images
		Main.decrypt_image = ImageFunctions.Decrypt(Main.image1, Main.image2);
		System.out.println("#### decrypt_image "+Main.decrypt_image);
		//ImageFunctions.Display_Image(Main.decrypt_image, "Decrypted Image");
		
		// Save the decrypted image
		ImageFunctions.Save(Main.decrypt_image, Main.image_decrypt_file);
		System.out.println("#### decrypt_image "+Main.image_decrypt_file);
		// Create, display, and save scaled image (same size as original image
		Main.normal_size_decrypted_image = ImageFunctions.Shrink(Main.decrypt_image);
		//ImageFunctions.Display_Image(Main.normal_size_decrypted_image, "Regular Sized Decrypted Image");				
		ImageFunctions.Save(Main.normal_size_decrypted_image, Main.normal_size_decrypted_file);
		
		System.out.println("#### normal_size_decrypted_image "+Main.normal_size_decrypted_image);
		System.out.println("#### normal_size_decrypted_file "+Main.normal_size_decrypted_file);
	
	}
}
