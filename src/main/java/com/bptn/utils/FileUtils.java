package com.bptn.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class); 

	
	public static void main(String[] args) throws IOException {
		
		
		String home = System.getProperty("user.home"); 
		
		System.out.println(home); 
		
		Path p = Paths.get(home);
		
		System.out.println("Check if a folder exists: " + home + ", " + Files.exists(p)); 
		
		Path p1 = Paths.get(home + "/hello.txt"); 
		System.out.println("Check if a file exists in home folder: hello.txt,  " + home + ", " + Files.exists(p1)); 
		
		//checks if a path is a folder or a file
		System.out.println( home + "is a regular file: " + Files.isRegularFile(p)); 
		
		//checks if a path file or directory denoted by the abstract filename is Directory or not.
		//The function returns true if the abstract file path is Directory else returns false.
		System.out.println( home + "is a regular file: " + Files.isDirectory(p)); 
		
		//checks if a path file is readable 
		System.out.println( home + "is a readable: " + Files.isReadable(p)); 
		
		System.out.println( home + "is a writable: " + Files.isWritable(p)); 
		
		System.out.println( home + "is a executable: " + Files.isExecutable(p)); 

		
		Path p2 = Paths.get(home);
		
		System.out.println(Files.isSameFile(p, p2));  // handle the exception 
		
		
		
		//Create a text file
		
		String fileName = "my_file_" + UUID.randomUUID().toString() + ".txt"; //GENERATE RANDOM id: UUID
		p = Paths.get(home + "/" + fileName); 
		
		if (Files.exists(p)) {
			Files.createFile(p); 
		}
		
		
		System.out.println("Check if a file exists in" + home + "folder: " + fileName + ", " + Files.exists(p)); 
		
		
		String dirName = "my_dir_" + UUID.randomUUID().toString(); 
		
		p = Paths.get(home + "/" + dirName); 
		
		if (!Files.exists(p)) {
			Files.createDirectory(p);
		}
		
		System.out.println("Check if a directory exists: " + dirName + " ," + Files.exists(p)); 
		
		
		//delete a file
		
		p = Paths.get(home + "/" + "hello.txt");
		if (Files.exists(p)) {
			Files.createFile(p); 
		}
		
		Files.delete(p); 
		
		System.out.println("Check if a file exists in  " + home + " folder: helo.txt," + Files.exists(p)); 
		
		
		
	    //write a file
		p = Paths.get(home + "/hello.txt");
		if (Files.exists(p)) {
			Files.createFile(p); 
		}
		
		FileWriter writer = new FileWriter(new File(p.toUri()));
		
		writer.write("I love java");
		System.out.println("File Written Succesfully!"); 
		
		//writer.close(); 
		
		
		//read a file
		
		Scanner scanner = new Scanner( new File(p.toUri()));
		
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			System.out.println(str); 
			
			logger.debug(str); 
		}
		
		//update a file 
		
		
		
		
	}

}
