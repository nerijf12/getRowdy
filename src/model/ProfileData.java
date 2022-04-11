package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProfileData {
	private static Profile profile;
	private static List<Profile> profileList = new LinkedList<Profile>();

	public List<Profile> getProfileArray() {
		return profileList;
	}
	public void resetProfileData() {
		profileList.clear();
	}
	public Profile getProfileIndex(int index) {
		return profileList.get(index);
	}
	
	public static void removeProfileInArray(int index) {
		profileList.remove(index);
	}
	public void setProfile(Profile profile) {
		ProfileData.profileList.add(profile);
	}
	public void searchData(String fileData) {
		Scanner input;
		try{
			input = new Scanner(new FileInputStream(fileData));
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String[] tokens = line.split(",");
				profile = new Profile();
				profile.setTitle(tokens[5]);
				profile.setDescription(tokens[6]);
				profile.setBirthday(tokens[7]);
				profile.setOneHobby(tokens[8]);
				profileList.add(profile);
			}
			input.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

}
