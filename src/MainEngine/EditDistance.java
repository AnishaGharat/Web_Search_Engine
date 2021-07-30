//Edit Distance
package MainEngine;

//Importing all the necessary libraries
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//Creating a class EditDistance
public class EditDistance {
	//Creating a static method which takes two arguments 
	static int EditDistDP(String string1, String string2)
	{
		//Creating variables 
	    int length1 = string1.length();
	    int length2 = string2.length();
	    
	    //Creating 2 Dimensional array named as DP
	    int [][]ED = new int[2][length1 + 1]; 
	    for (int i = 0; i <= length1; i++)
	        ED[0][i] = i;
	
	    for (int i = 1; i <= length2; i++)
	    {       
	        for (int j = 0; j <= length1; j++)
	        {           
	            if (j == 0)
	                ED[i % 2][j] = i; 
	            else if (string1.charAt(j - 1) == string2.charAt(i - 1)) 
	            {
	                ED[i % 2][j] = ED[(i - 1) % 2][j - 1];
	            }

	            else {
	                ED[i % 2][j] = 1 + Math.min(ED[(i - 1) % 2][j],
	                                       Math.min(ED[i % 2][j - 1],
	                                           ED[(i - 1) % 2][j - 1]));
	            }
	        }
	    } 
	    //Returning the 2 Dimensional array
	   return (ED[length2 % 2][length1]);
	}
	//Creating an empty main method which throws IOException
	public static void main(String[] args) throws IOException 
	{
	}
	
	public static Set<String> suggestedWord(String path, String search) throws IOException
	{
		//Creating an ArrayList of string values named as token
		ArrayList<String> token = new ArrayList<String>(); 
		//Calling the searchTokens method 
		token = searchTokens(path);
		//Creating an ArrayList of string values named as suggestion
		ArrayList<String> suggestion= new ArrayList<String>();
		//Running a for loop till the size of the arraylist token
		for(int i=0;i<token.size();i++)
		{
			int count = EditDistDP(token.get(i), search);
			if(count == 0) 
			{
				break;
			}
			else if(count==1) 
			{				
				if(!(token.get(i).contains(".") || token.get(i).contains(",") || token.get(i).contains(" ")))
				{
					suggestion.add(token.get(i));
				}
			}			
		}
		Set<String> suggestedWords = new HashSet<>(suggestion);		
		//Returning a set of String values
		return suggestedWords;
	}
	//Method to search tokens which throws IOException
	public static ArrayList<String> searchTokens(String path) throws IOException
	{
		//Creating an empty string
		String text = "";
		//Creating an ArrayList of string values named as token
		ArrayList<String> token = new ArrayList<String>();
		File fl= new File(path);
		//Listing all the files
		File[] lof = fl.listFiles();
		//Creating an empty string
		String datas = "";
		//Running a for loop for each file in list of files
		for(File f : lof)
		{
			//System.out.print(f.getName());
			//Creating an instance of BufferedReader which takes f as an argument
			BufferedReader br = new BufferedReader(new FileReader(f));   
			//Running a while loop with the condition that the readLine is not equal to null
			while((text = br.readLine()) != null) 
		   		   datas = datas + text;
			//Creating an instance of StringTokenizer which takes d as an argument
		   	StringTokenizer st = new StringTokenizer(datas); 
		   	//Running a while loop to add the token into st
		        while (st.hasMoreTokens())   
		      	  token.add(st.nextToken().toLowerCase());
		    //Closing the BufferedReader
			br.close();		 
		}
		//Returning token
		return token;
	}
}
