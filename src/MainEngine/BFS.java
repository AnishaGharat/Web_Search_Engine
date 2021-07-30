//Brute Force Search
package MainEngine;

//Importing all the necessary libraries
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//Creating a class BFS which implements the WordSearch Class
public class BFS implements WordSearch
{
//Declaring variables
  private String fName;
  private File files;
  private int count = 0;
 public BFS()
 {
	}
//Creating constructor which takes file as an argument and throws IOException
  public BFS(File files) throws IOException {
    this.files =  files;
    this.fName = files.getName();
    this.count = 0;
  }

//Method for performing the BruteForceSearch which takes search String as an argument and throws IO Exception
  public void BruteForceSearch(String search) throws IOException 
  {
	  //Creating an instance of FileInputStream taking files as an argument
      FileInputStream fstream = new FileInputStream(files);
      //Creating an instance of BufferedReader taking fstream as an argument
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String line = "";
      //Running a while loop with the condition that the readLine is not null
      while ((line = br.readLine()) != null) 
      {
    	  //Splitting the line and storing it in an array of Strings
        String[] words = line.split("\\W");
        //Running a for loop for each word in words array
        for (String text : words) 
        {
        	//Printing the text and search of text equals search.
          if (text.equalsIgnoreCase(search)) 
          {
        	System.out.println("Text:" + text + " and Search Text:" + search);
        	//Increasing the count by 1
            count++;
          }
        }
      }
      //Closing the BufferedReader
      br.close();
  }
//Method to return the filename
  public String getFile() {
    return fName;
  }
//Method to return the count
  public int getCount(String word) {
    return count;
  }
//Method to call the BruteForceSearch Method
  public void search(String search) throws IOException 
  {
    BruteForceSearch(search);
    //Printing the output if the count of the search is not equal to zero.
    if (getCount(search) != 0) 
    {
    	System.out.println();
        System.out.println(getCount(search) + " | " + getFile()); 
    } 
  }
}



