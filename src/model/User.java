package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
	private String name, userName, password, title, profilePicSrc;
	private static int flag;
	private static User currentUser;
	private static List<User> users = new ArrayList<User>();
	
	public User() {
		String localName = "";
		this.name = localName;
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password, String name,
			String title, String profilePicSrc) {
		this.userName = userName;
		this.password = password;
		this.name  = name;
		this.title = title;
		this.profilePicSrc = profilePicSrc;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public static int getFlag() {
		return flag;
	}

	public static void setFlag(int flag) {
		User.flag = flag;
	}
	
	public static void setCurrentUser(User user) {
		User.currentUser = user;
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}
	
	public static User getUserIndex(int index) {
		return User.users.get(index);
	}

	// load Users and validate them
	public static User validate(String userName, String password) throws IOException {
		try {
			Scanner scan = new Scanner(new File("users.csv"));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				User temp = new User(tokens[0],tokens[1]);
				if (temp.getUserName().equals(userName)) {
					if (password.equals(temp.getPassword())) {
						flag = 1;
					}else {
						flag = 0;
					}
				}
				if (flag == 1) {
					scan.close();
					return temp;
				}
			}
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static List<User> getUsers() throws IOException {
		users = UserData.searchAndReturnData("users.csv");
		return users;
	}

	public static int exists(String userName) {
		try {
			List<User> users = getUsers();
			for (User user : users) {
				if (user.getUserName().compareTo(userName) == 0)
					return 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public String getProfilePicSrc() {
		return profilePicSrc;
	}

	public void setProfilePicSrc(String profilePicSrc) {
		this.profilePicSrc = profilePicSrc;
	}
	
	
}
