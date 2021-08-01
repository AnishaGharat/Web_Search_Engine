/*Web Search Engine
 *ACC Project
 *Authors: Anisha Gharat, Sarwat Til Vusqa, Akhilesh Sharda, Manavdeep Batth, Adhiraj Singh
 */
package MainEngine;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WebSearchEngine {
	private static String filePath = null;
	public static boolean flag = false;
	private static String filePathAbs = "C:\\Users\\sarwa\\Documents\\Masters Course\\COMP 8547-Adv. Computing Concepts\\ACC Final Project\\ACC Final Project\\WebPages\\Text";
	private static String userWordSearchOption = "";
	static Indexer indexer = Indexer.getInstance();

	private WebSearchEngine() {
		WebSearchEngine.filePath = filePathAbs;
	}

	private WebSearchEngine(String directory) {
		if (directory.isEmpty()) {
			WebSearchEngine.filePath = filePathAbs;
		} else {
			WebSearchEngine.filePath = directory;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		if (flag == false) {
			System.out.println(
					"*************************************Hello, Welcome to Our Web Search Engine*************************************");
			System.out.println(
					"*****************************************************************************************************************");
			String url = null;
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter the URL to begin crawling:");
			url = scan.nextLine();
			System.out.println(
					"*****************************************************************************************************************");
			//Calling the initiate crawling method in Crawler java file followed by the indexer
			new Crawler().initiateCrawling(url);
			indexer.initiateIndexer();
			System.out.println("*****************************************************************************************************************");
			System.out.println("You may search for words in the files.");
			System.out.println("*****************************************************************************************************************");
			flag = true;
		}

		Scanner sc = new Scanner(System.in);
		String toSearch = "";
		String toSearchSuggested = "";

		Set<String> suggestedWords;
		String choice;

		System.out.println("Do you want to search?(Yes/No):");
		userWordSearchOption = sc.next();
		System.out.println("*****************************************************************************************************************");

		while (userWordSearchOption.equalsIgnoreCase("yes")) {

			System.out.println("Please enter the word you want to search: ");

			toSearch = sc.next();
			System.out.println("*****************************************************************************************************************");

			toSearch = toSearch.toLowerCase();
			//Suggested words are returned from the edit distance file
			suggestedWords = EditDistance.suggestedWord(filePathAbs, toSearch);

			for (String s : suggestedWords) {
				toSearchSuggested = s;
				System.out.print(s + " , ");
			}

			if (suggestedWords.size() == 0) {
				Operation(toSearch, userWordSearchOption);
				break;
			} else {
				System.out.println("\nDid you mean the above word(s)?(Yes/No): ");
				choice = sc.next().toLowerCase();
				if (choice.equals("yes")) {
					//the suggested word is searched 
					Operation(toSearchSuggested, userWordSearchOption);
					break;
				} else {
					//the word user entered is searched
					Operation(toSearch, userWordSearchOption);
					continue;
				}

			}
		}
		Operation("", userWordSearchOption);
	}

	private void filesList(File folder, Set<File> list) { //method returns all the files in the directory
		folder.setReadOnly();
		File[] files = folder.listFiles();
		for (int j = 0; j < files.length; j++) {
			list.add(files[j]);
			if (files[j].isDirectory())
				filesList(files[j], list);
		}
	}

	public static void Operation(String searchWord, String userSelection) throws IOException, InterruptedException {

		Scanner sc = new Scanner(System.in);
		WebSearchEngine webSearchEngine = new WebSearchEngine();
		if (userSelection.equalsIgnoreCase("no")) {
			System.out.println("You may also search for links. Do you want to search for links? (Yes/No): ");
			String linkSearchOption = sc.next().toLowerCase();
			System.out.println("*****************************************************************************************************************");

			if (linkSearchOption.equals("yes")) {
				//Using regex file to find any links in the parsed files
				Regex.urlFinder(filePathAbs);
				System.out.println("Good Bye!");
				System.exit(0);
			} else {
				System.out.println("Good Bye!");
				System.exit(0);
			}
		} else {
			String folderToSearch = WebSearchEngine.filePath;

			File folder = new File(folderToSearch);
			Set<File> list = new HashSet<File>();
			webSearchEngine.filesList(folder, list);

			System.out.println("Occurences | File Name");
			//BFS is being called to search for words that user enters
			for (File file : list) {
				BFS bSearch = new BFS(file);
				bSearch.search(searchWord);
			}
			System.out.println("*****************************************************************************************************************");

			BFS b = new BFS();
			main(null);
		}
	}
}