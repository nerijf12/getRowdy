package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Comment {
//-------------------------------------------- Class variables --------------------------------------------------
	private String text;
	private String time;
	private String name;
	private ArrayList<Likes> likes;

/********************************************************************************************************* 
 * Loads the entire comment content from file and then assigns them into the GUI
 * dashboard.
 *********************************************************************************************************/
//-------------------------------------------- loadPosts method -----------------------------------------------
	public static void loadComments(Post post,String rv) throws IOException{
		Scanner scan;
		Comment tempComment = new Comment();
		try {
			System.out.println("loading comments");
			File file = new File( "comments.csv" );
			scan = new Scanner( file );
			while ( scan.hasNextLine() ) // while there is more to read
	        {
	        	String fileLine = scan.nextLine();
	            String[] tokens = fileLine.split(",");
            	tempComment.setTime(tokens[1]);
            	tempComment.setName(tokens[2]);
            	tempComment.setText(tokens[3]);
		    }
		} catch( FileNotFoundException e ) {
		         e.printStackTrace();
	    }
		
	}
/********************************************************************************************************* 
 * Saves the entire comment content from file and then assigns them into the GUI
 * dashboard.
 *********************************************************************************************************/
//-------------------------------------------- savePosts method -----------------------------------------------
	public void saveComments() {
		FileWriter writer;
		List<List<String>> rowsInFile = Arrays.asList(
			    Arrays.asList("", "", ""),
			    Arrays.asList("", "", "")
			);
		
		try {
			writer = new FileWriter(new File("comments.csv"));
			
			for( List<String> rowData : rowsInFile ) {
				writer.append(String.join(",", rowData));
				writer.append("\n");
			}
			writer.flush();
			writer.close();
				
		}catch(IOException e) {
	           e.printStackTrace();
	       }
	}
	
/********************************************************************************************************* 
 * The following methods are self-explanatory,
 * hence require no comments to understand their purpose.
 *********************************************************************************************************/
//-------------------------------------------- Constructor method -----------------------------------------------
	public Comment() {
		String localText = "";
		String localTime = "0";
		String localName = "";
		
		this.text = localText;
		this.time = localTime;
		this.name = localName;
	}
	
	public Comment(String date, String name, String text) {
		String localText = text;
		String localTime = date;
		String localName = name;
		
		this.text = localText;
		this.time = localTime;
		this.name = localName;
	}
//----------------------------------------- getters and setters methods ----------------------------------
//Getters
	public String getText() {
		return text;
	}

	public String getName() {
		return name;
	}
	
	public String getTime() {
		return time;
	}
	
	public ArrayList<Likes> getLikes() {
		return likes;
	}
	
//Setters
	public void setTime(String tokens) {
		this.time = tokens;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setLikes(ArrayList<Likes> likes) {
		this.likes = likes;
	}
	

}

