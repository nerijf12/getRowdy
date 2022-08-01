package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserData {
	private static User user;
	private static List<User> usersList = new ArrayList<User>();
	public static List<Post> postsList = new ArrayList<Post>();

	public List<User> getUserArray() {
		return usersList;
	}
	
	public int getUserArraySize() {
		return usersList.size();
	}
	
	public static List<User> getUserArrayStatic() {
		return usersList;
	}
	/**
	 * returns the stage index from the stage array list
	 * @param index
	 * @return
	 */
	public User getUserIndex(int index) {
		return usersList.get(index);
	}
	
	public static void removeUserInArray(int index) {
		usersList.remove(index);
	}
	/**
	 * adds the stage objects into the stage array list
	 * @param image
	 */
	public void setUser(User user) {
		UserData.usersList.add(user);
	}
	
	public void resetUserData() {
		usersList.clear();
	}

	public static AllPosts everyPost = new AllPosts();
	
	/**
	 * Factory method implementation that searches through a csv file for the stage data
	 * @param file data
	 * @return stage array list
	 */
	public void searchData(String fileData) {
		Scanner input;
		try{
			input = new Scanner(new FileInputStream(fileData));
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] tokens = line.split(",");
				user = new User();
				user.setProfilePicSrc(tokens[4]);
				user.setTitle(tokens[3]);
				user.setName(tokens[2]);
				user.setPassword(tokens[1]);
				user.setUserName(tokens[0]);
				
				usersList.add(user);
			}
			input.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static List<User> searchAndReturnData(String fileData) {
		Scanner input;
		postsList = PostData.searchAndReturnPostData("posts.csv");
		try{
			input = new Scanner(new FileInputStream(fileData));
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] tokens = line.split(",");
				user = new User();
				user.setName(tokens[2]);
				user.setPassword(tokens[1]);
				user.setUserName(tokens[0]);
				usersList.add(user);
			}
			input.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return usersList;
	}

}
