package model;

public class Profile {
	private String title, description, birthday, oneHobby;
	private static Profile currentProfile;
	
	public Profile() {
		String title = "", description = "", birthday = "", oneHobby = "";
		this.title = title;
		this.description = description;
		this.birthday = birthday;
		this.oneHobby = oneHobby;
	}
	
	public Profile(String title, String description, String birthday, String oneHobby) {
		this.title = title;
		this.description = description;
		this.birthday = birthday;
		this.oneHobby = oneHobby;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getOneHobby() {
		return oneHobby;
	}
	public void setOneHobby(String oneHobby) {
		this.oneHobby = oneHobby;
	}

	public static Profile getCurrentProfile() {
		return currentProfile;
	}

	public static void setCurrentProfile(Profile currentProfile) {
		Profile.currentProfile = currentProfile;
	}
	

}
