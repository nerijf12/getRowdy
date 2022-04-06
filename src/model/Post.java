package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Post {
	private User setUser;
	private String postUser, postTitle, postDescription, postDate, postFilePath;
	private static Post currentPost;
	private int postNumber, time;
	
	private ArrayList<Comment> comments;
	private ArrayList<Likes> likes;
	
	public static AllPosts everyPost = new AllPosts();
	
/********************************************************************************************************* 
 * Saves the entire post content from file and then assigns them into the GUI
 * dashboard.
 *********************************************************************************************************/
//-------------------------------------------- savePosts method -----------------------------------------------
	public void savePosts() {
		FileWriter writer;
		List<List<String>> rowsInFile = Arrays.asList(
			    Arrays.asList("", "", "", ""),
			    Arrays.asList("", "", "", "")
			);
		
		try {
			writer = new FileWriter(new File("posts.csv"));
			
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
 * Loads the entire post content from file and then assigns them into the GUI
 * dashboard.
 *********************************************************************************************************/
//-------------------------------------------- loadPosts method -----------------------------------------------
	public static void loadPosts() throws IOException{
			Scanner scan;
			Post tempPost = new Post();
			Comment tempComment = new Comment();

			try {
				System.out.println("loading posts");
				File file = new File( "posts.csv" );
				scan = new Scanner( file );
				while ( scan.hasNextLine() ) // while there is more to read
		        {
		        	String fileLine = scan.nextLine();
		            String[] tokens = fileLine.split(",");
		            if (tokens[0] != "comment") {
		            	if (tempPost.postTitle != "") {
		            		everyPost.addPost(tempPost);
		            	}
		            	tempPost.setPostDate(tokens[0]);
		            	tempPost.setPostUser(tokens[1]);
		            	tempPost.setPostTitle(tokens[2]);
		            	tempPost.setPostDescription(tokens[3]);
		            }
		            else{
		            	tempComment.setTime(tokens[1]);
		            	tempComment.setName(tokens[2]);
		            	tempComment.setText(tokens[3]);
		            	tempPost.comments.add(tempComment);
		            }
//					System.out.println(tokens);
//		            System.out.println(tempPost);
		        }
		    } catch( FileNotFoundException e ) {
		         e.printStackTrace();
		    }
		
	}
	public void addpost(Post post) {
		everyPost.addPost(post);
	}
/********************************************************************************************************* 
 * The following methods are self-explanatory,
 * hence require no comments to understand their purpose.
 *********************************************************************************************************/
//-------------------------------------------- Constructor method -----------------------------------------------
	public Post() {
		String postUser = "", postTitle = "",  postDescription = "", postDate  = "";
		this.postUser = postUser;
		this.postTitle = postTitle;
		this.postDescription = postDescription;
		this.postDate = postDate;
	}
	
	public Post(String postUser, String postTitle, String postDescription, String postDate) {
		this.postUser = postUser;
		this.postTitle = postTitle;
		this.postDescription = postDescription;
		this.postDate = postDate;
	}

	
//----------------------------------------- getters and setters methods ----------------------------------
//Getters
	public String getPostDate() {
		return postDate;
	}
	
	public String getPostDescription() {
		return postDescription;
	}
	
	public int getPostNumber() {
		return postNumber;
	}

    public int getPostNumber(Post post) {
    	return postNumber;
    }
	
	public int getTime() {
		return time;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public ArrayList<Likes> getLikes() {
		return likes;
	}
	
	public String getPostFilePath() {
		return postFilePath;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public String getPostUser() {
		return postUser;
	}
	
	public User getSetUser() {
		return setUser;
	}
	
	public static Post getCurrentPost() {
		return currentPost;
	}
	
//Setters
	public void setTime(int time) {
		this.time = time;
	}
	
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public void setLikes(ArrayList<Likes> likes) {
		this.likes = likes;
	}
	
	public void setPostFilePath(String postFilePath) {
		this.postFilePath = postFilePath;
	}

	public void setPostUser(String postUser) {
		this.postUser = postUser;
	}

	public static void setCurrentPost(Post currentPost) {
		Post.currentPost = currentPost;
	}
	
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	
	
//    public void setPostNumber(String postTitle) {
//		int number = 0;
//		for(int i=0;i<UserData.getUserArray().size();i++) {
//			if(postTitle.equals((i).getUserName())){
//				postNumber = ++number;
//			}
//		}
//	}
	
	
}

