package MainEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Document;


public class Parser {

	private static List<File> listOfFiles = new ArrayList<File>();

	public static List<File> getListOfWebpages() {
		if (listOfFiles.isEmpty()) {
			generateFilesList();
		}
		return listOfFiles;
	}

	public static void generateFilesList() {
		try {
			File FolderWithFiles = new File("C:\\Users\\sarwa\\Documents\\Masters Course\\COMP 8547-Adv. Computing Concepts\\ACC Final Project\\ACC Final Project\\WebPages\\Text");
			File[] allFiles = FolderWithFiles.listFiles();
			for (File file : allFiles) {
				if (file.isFile()) {
					listOfFiles.add(file);
				}
			}
		} catch (Exception e) {
			System.out.println("Error while file is being added:" + e);
		}
	}

	

	public static void saveDoc(Document webpage) {
		try {
			BufferedWriter webpageWriter = new BufferedWriter(
					new FileWriter(Path.pathToWebpageDirectory + webpage.title().replace('/', '-') + ".html"));
			webpageWriter.write(webpage.toString());
			webpageWriter.close();

			BufferedWriter textWriter = new BufferedWriter(
					new FileWriter(Path.pathToTextDirectory + webpage.title().replace('/', '-') + ".txt"));
			textWriter.write(webpage.body().text().toLowerCase());
			textWriter.close();

		} catch (Exception e) {
			
		}
	}
}
