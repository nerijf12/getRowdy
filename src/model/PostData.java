package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostData {
	private static Post post;
	private static List<Post> postsList = new ArrayList<Post>();
	
	public PostData() {}
	
	/**
	 * returns the festival index from the festival array list
	 * @param index
	 * @return
	 */
	public Post getPostsIndex(int index) {
		return postsList.get(index);
	}
	/**
	 * returns the festival array list
	 * @return
	 */
	public List<Post> getPostArrayList() {
		return postsList;
	}
	public int getPostArrayListSize() {
		return getPostArrayList().size();
	}
	/**
	 * adds the festival objects into the festival array list
	 * @param image
	 */
	public void setPost(Post posts) {
		PostData.postsList.add(posts);
	}
	
	public void resetPostData() {
		postsList.clear();
	}
	
	public void searchPostData(String fileName){
		Scanner input;
		try {
			input = new Scanner(new FileInputStream(fileName));
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] tokens = line.split(",");
				post = new Post();
				post.setPostDate(tokens[0]);
				post.setPostUser(tokens[1]);
				post.setPostTitle(tokens[2]);
				post.setPostDescription(tokens[3]);
				postsList.add(post);
			}
			input.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static List<Post> searchAndReturnPostData(String fileName){
		Scanner input;
		try {
			input = new Scanner(new FileInputStream(fileName));
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] tokens = line.split(",");
				post = new Post();
				post.setPostDate(tokens[0]);
				post.setPostUser(tokens[1]);
				post.setPostTitle(tokens[2]);
				post.setPostDescription(tokens[3]);
				postsList.add(post);
			}
			input.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return postsList;
	}


}