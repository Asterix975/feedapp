package com.bptn.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileUtils1 {

	//private static final Logger logger = LoggerFactory.getLogger(FileUtils1.class); 
	
	public static void main(String[] args) throws IOException {
		
		
		String home = System.getProperty("user.home"); 
		
		System.out.println(home); 
		
		Path p = Paths.get(home);
		
		System.out.println("Check if a folder exists: " + home + ", " + Files.exists(p)); 
		
		Path p1 = Paths.get(home + "/test.txt"); 
		System.out.println("Check if a file exists in home folder: test.txt,  " + home + ", " + Files.exists(p1)); 
		
		
		//check if file exists
		
		String fileName = "test.txt";
		p = Paths.get(home + "/" + fileName);
		if (!Files.exists(p)) {
			Files.createFile(p); 
		}
		
		
        //isFileExistsWithExceptionHandling, handle the exception using throws IOException 
		Path p2 = Paths.get(home);
		System.out.println(Files.isSameFile(p, p2)); 
		
		
		//Create a text file by generating random id:UUID
		String fileName1 = "my_file_" + UUID.randomUUID().toString() + ".txt";
		p = Paths.get(home + "/" + fileName1); 
				
		if (!Files.exists(p)) {
			Files.createFile(p); 
		}
		System.out.println("Check if a file exists in" + home + "folder: " + fileName1 + ", " + Files.exists(p)); 
		
		
		
	}
}
		