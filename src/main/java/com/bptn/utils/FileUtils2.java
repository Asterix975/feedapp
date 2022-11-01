package com.bptn.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileUtils2 {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtils1.class);
	
	//isFileExist  method 
	public static void isFileExist (Path k) {
		if (Files.exists(k))
		System.out.println("This file" + k + ", exists!");
		
		else
			System.out.println("This file does not exist!");
	}
	
	// isFileExistsWithExceptionHandling method 
	public static void isFileExistsWithExceptionHandling (Path k) throws FileNotFoundException {
		Scanner scanner; 
		
		try {
		scanner = new Scanner ( new File(k.toUri()));
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			logger.debug(str);           // Implement the concept of logging refering to line 19 
			}
		}
		catch ( IOException e) {
			e.printStackTrace();
		}
	}
	
	//createFileIfNotExist method 
	public static void createFileIfNotExist (Path k) throws IOException {
		
		if (!Files.exists(k)) {
			Files.createFile(k);
			System.out.println( "The file" + k + " is created"); 
		}
		else 
			System.out.println("The file already exists");
	}


	
	public static void main(String[] args) throws IOException {
		
		String home = System.getProperty("user.home");
		System.out.println(home);
		
		Path p = Paths.get(home); 
		System.out.println("Check if a folder exists: " + home + ", " + Files.exists(p));
		
		Path p1 = Paths.get(home + "/test.txt");
		
		if (!Files.exists(p1)) {
			Files.createFile(p1);
			
		}
		
		try (FileWriter writer = new FileWriter (new File(p1.toUri()))){
			
			for (int i = 0; i < 5; i++) {
			writer.write("This is my file\n");
			}
			System.out.println("File Written Successfully");
		}
		
		isFileExist(p1);
		isFileExistsWithExceptionHandling(p1);
		createFileIfNotExist(p1);

	}

}
