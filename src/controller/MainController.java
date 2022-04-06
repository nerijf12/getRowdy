package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.GetRowdy;
import model.Post;
import model.PostData;
import model.Profile;
import model.ProfileData;
import model.User;
import model.UserData;
import view.DashBoardViewAndRoots;

public class MainController implements Initializable{
	private static BorderPane rootPane;
	private static FXMLLoader loader = null;
	private static MainController myInstance;
	private String nameEntered;
	private String passEntered;
	private static String userFile = "users.csv";
	private static String postFile = "posts.csv";
	
	private static Profile profile;
	private static User user;
	private static Post post;
	private Map<String,String> profileMap = new HashMap<String,String>();
	
	public UserData userData = new UserData();
	public PostData postData = new PostData();
	public ProfileData profileData = new ProfileData();

    @FXML private PasswordField password;
    @FXML private TextField username;
    @FXML private Label error;
    @FXML private Button loginBtn;

    @FXML void login(ActionEvent event) {
    	this.nameEntered = username.getText();
		this.passEntered = password.getText();
		try {
			 User.validate(nameEntered, passEntered);
			if (User.getFlag()==0) {
				error.setText("Invaild username or password");
			}
			if(User.getFlag()==1) {
				// Redirect user to next view
				User.setFlag(0);
				System.out.println("redirect");
				this.setUsersProfile(nameEntered);
				User.setCurrentUser(this.getUsersProfile());
				Profile.setCurrentProfile(this.getProfile());
				Post.setCurrentPost(this.getPost());
				try {
			    	MainController.changeView(DashBoardViewAndRoots.VIEW_2);
					System.out.println("cool");
			    	Post.loadPosts();

				} catch(Exception e) {
					e.printStackTrace();
				}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Singleton constructor
     */
	private MainController() {
    	myInstance = null;
    }
    /**
     * gets the instance of the singleton
     * @return myInstance line up controller class singleton
     */
    public static MainController getInstance() {
    	if(myInstance == null) {
    		myInstance = new MainController();
    	}
    	return myInstance;
    }
    /**
     * sets the root pane for the border pane
     * @param borderPane
     */
    public void setRootPane(BorderPane borderPane) {
    	MainController.rootPane = borderPane;
	}
    /**
     * Changes the view of the GUI
     * @param viewType
     */
    public static void changeView(int viewType) {
		try {
			switch(viewType) {
				case DashBoardViewAndRoots.VIEW_1:
					loader = new FXMLLoader(GetRowdy.class.getResource(
							DashBoardViewAndRoots.getViewRoot() + "login.fxml"));
					loader.setController(new MainController());
					break;
				case DashBoardViewAndRoots.VIEW_2:
					//replace with the login view and controller
					loader = new FXMLLoader(GetRowdy.class.getResource(
							DashBoardViewAndRoots.getViewRoot() + "maindashboard.fxml"));
					loader.setController(new DashBoardController());
					break;
				case DashBoardViewAndRoots.VIEW_3:
					//replace with the comment view and controller
					loader = new FXMLLoader(GetRowdy.class.getResource(
							DashBoardViewAndRoots.getViewRoot() + "profile.fxml"));
					loader.setController(new ProfileController());
					break;
				case DashBoardViewAndRoots.VIEW_4:
					//replace with the profile view and controller
					loader = new FXMLLoader(GetRowdy.class.getResource(
							DashBoardViewAndRoots.getViewRoot() + "commentsdashboard.fxml"));
					loader.setController(new CommentsDashBoardController());
					break;
			}
			Parent view = loader.load();
			rootPane.setCenter(view);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//    public void setUserList(String userName){
//		for (String key: profileMap.keySet()) {
//			if(userName.equals(profileMap.get(key))) {
//				users.add(profileMap.get(key));
//			}
//		}
//		System.out.println(users);
//	}
	public void putIntoMap(){
		for(int i=0;i<userData.getUserArray().size();i++) {
			profileMap.put(postData.getPostsIndex(i).getPostUser(),
					postData.getPostsIndex(i).getPostTitle());
		}
	}
	/**
	 * gets the map used for the hash map
	 * @return Map<String, String>
	 */
	public Map<String, String> getMap(){
		return this.profileMap;
	}
	
    private void setUsersProfile(String userName) {
    	for(int i=0; i<userData.getUserArraySize(); i++) {
			if(userName.equals(userData.getUserArray().get(i).getUserName())) {
				user = new User();
				user.setUserName(userData.getUserArray().get(i).getUserName());
				user.setName(userData.getUserArray().get(i).getName());
				user.setTitle(userData.getUserArray().get(i).getTitle());
				user.setProfilePicSrc(userData.getUserArray().get(i).getProfilePicSrc());
				
				profile = new Profile();
				profile.setTitle(profileData.getProfileArray().get(i).getTitle());
				profile.setDescription(profileData.getProfileArray().get(i).getDescription());
				profile.setBirthday(profileData.getProfileArray().get(i).getBirthday());
				profile.setOneHobby(profileData.getProfileArray().get(i).getOneHobby());
			}
    	}
    	for(int i=0; i<postData.getPostArrayListSize();i++) {
    		if(userName.equals(postData.getPostArrayList().get(i).getPostUser())) {
				post = new Post();
				post.setPostDate(postData.getPostArrayList().get(i).getPostDate());
				post.setPostDescription(postData.getPostArrayList().get(i).getPostDescription());
				post.setPostTitle(postData.getPostArrayList().get(i).getPostTitle());
				post.setPostUser(postData.getPostArrayList().get(i).getPostUser());
    		}
    	}
    }
    
    private User getUsersProfile() {
    	return MainController.user;
    }
    
    private Profile getProfile() {
    	return MainController.profile;
    }
    
    private Post getPost() {
    	return MainController.post;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	postData.resetPostData();
    	userData.resetUserData();
    	profileData.resetProfileData();
		userData.searchData(userFile);
		profileData.searchData(userFile);
		postData.searchPostData(postFile);
	}

}

