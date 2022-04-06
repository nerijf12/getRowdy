package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Profile;
import model.User;
import view.DashBoardViewAndRoots;

public class ProfileController implements Initializable{
    @FXML private ImageView userProfilePic;
    @FXML private Text userFullName;
    @FXML private Button dashBoardBtn;
    @FXML private Button logOutBtn;
    @FXML private Text profileTitle;
    @FXML private Text profileDescription;
    @FXML private FlowPane userTopPosts;
    @FXML private VBox postPane;
    @FXML private Text dob;
    @FXML private Text hobbies;
    @FXML private Text userTitle;
    
    @FXML void logOut(ActionEvent event) {
    	MainController.changeView(DashBoardViewAndRoots.VIEW_1);
    }

    @FXML void dashboard(ActionEvent event) {
    	MainController.changeView(DashBoardViewAndRoots.VIEW_2);

    }
    
    private void setName() {
    	String userName = User.getCurrentUser().getName();
    	userFullName.setText(userName);
    }
    
    private void setUserTitle() {
    	String currentUserTitle = User.getCurrentUser().getTitle();
    	userTitle.setText(currentUserTitle);
    }
    
    private void setImage() {
    	Image image;
    	String userFileSrc = User.getCurrentUser().getProfilePicSrc();
    	image = new Image(
    			DashBoardViewAndRoots.getAssetsImagesRoot() + userFileSrc
    	);
    	userProfilePic.setImage(image);
    }
    
    private void setTitle() {
    	String currentProfileTitle = Profile.getCurrentProfile().getTitle();
    	profileTitle.setText(currentProfileTitle);
    }
    
    private void setDescription() {
    	String currentProfileDesc = Profile.getCurrentProfile().getDescription();
    	profileDescription.setText(currentProfileDesc);
    }
   
    private void setDOB() {
    	String currentProfileDOB = Profile.getCurrentProfile().getBirthday();
    	dob.setText(currentProfileDOB);
    }
    
    private void setHobbies() {
    	String currentProfileHobbies = Profile.getCurrentProfile().getOneHobby();
    	hobbies.setText(currentProfileHobbies);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setUserTitle();setName();setImage();setTitle();setDescription();setDOB();setHobbies();
	}

}
