package MainEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;



public class Regex {
ArrayList<String> listOfUrl = new ArrayList<>();
	
	public ArrayList<String> findUrls(String fileData) {
		String wordsInFiles[];
		boolean flag;
		wordsInFiles=fileData.split(" ");
		for(String s: wordsInFiles) {
			flag=Pattern.matches("^(http|https)[\\S]*", s);
			if(flag==true) {
				listOfUrl.add(s);
			}
		}  
		return listOfUrl;
	}
	public static void urlFinder(String filesPath) {
		String fileData = "", line = "";
		Regex regexObj = new Regex();
		File folderOfFiles = new File(filesPath);
		File[] allFiles = folderOfFiles.listFiles();
		for(File singleFile: allFiles) {
			try {
				BufferedReader fileReader = new BufferedReader( new FileReader(singleFile));
				while((line = fileReader.readLine()) != null) {
	 			   fileData=fileData+line;
				}
				regexObj.findUrls(fileData);
				fileReader.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		System.out.println("Links found are: ");
		System.out.println("*****************************************************************************************************************");

		for(String s: regexObj.listOfUrl) {
			System.out.println(s);	
		}
		System.out.println("*****************************************************************************************************************");

	}
}
