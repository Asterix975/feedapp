package com.bptn.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils3 {

//	Create Logger
	public static final Logger logger = LoggerFactory.getLogger(FileUtils3.class);

//	Create Home Path Variable
	public static String home = System.getProperty("user.home");

//	Create File
	public static void createTextFileExample(String fileName) {
		Path p = Paths.get(home + "/" + fileName);

		if (!Files.exists(p)) {
			try {
				Files.createFile(p);
				logger.info("File " + fileName + " created in the" + home + " folder.");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

//	Write File
	public static void writeFileExample(String fileName) {
		Path p = Paths.get(home + "/" + fileName);

		try (FileWriter writer = new FileWriter(new File(p.toUri()))) {

			writer.write("Now, this is a story all about how\n" + "My life got flipped-turned upside down\n"
					+ "And I'd like to take a minute\n" + "Just sit right there\n");

			writer.close();

			logger.info("File Written Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	Update File
	static void updateFileExample(String fileName) {
		Path p = Paths.get(home + "/" + fileName);

		try (FileWriter writer = new FileWriter(new File(p.toUri()), true)) {
			writer.write("\n");
			writer.write("I'll tell you how I became the prince of a town called Bel-Air");
			logger.info("File Updated Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	Delete File
	public static void deleteFileExample(String fileName) {
		Path p = Paths.get(home + "/" + fileName);

			try {
				if (Files.exists(p)) {
					logger.info("DELETING... " + fileName);
					Files.delete(p);
					logger.info("File Delete Successfully");
				} else {
					System.out.println("No File Found");
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static void main(String[] args) {

		createTextFileExample("Team_2_Demo.txt");
		writeFileExample("Team_2_Demo.txt");
		updateFileExample("Team_2_Demo.txt");
		deleteFileExample("Team_2_Demo.txt");

	}

}