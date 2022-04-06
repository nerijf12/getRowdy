package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.PostData;

import model.User;
import model.UserData;
import view.DashBoardViewAndRoots;

public class PostController implements Initializable{
    public static Pane rootPane;
    public UserData userData = new UserData();
    private PostData postData = new PostData();
    
    @FXML private AnchorPane postHolder;
	@FXML private BorderPane userPosts;
    @FXML private ImageView userImages;
    @FXML private Text bodyText;
    @FXML private Text headerText;
    @FXML private Button postCommentBtn;

    @FXML void postComment(ActionEvent event) {
    	MainController.changeView(DashBoardViewAndRoots.VIEW_4);
    	//Post.setCurrentPost(currentPost);
    }
    
    public void loadProfile(String userName) {
    	Image image;
    	String userFileSrc = "", userTitle = "", userBody = "";
    	for(int i=0; i<userData.getUserArray().size();i++) {
    		for(int j=0; j<postData.getPostArrayList().size();j++) {
	    		if(userName.equals(
	    				postData.getPostArrayList().get(j).getPostUser())) {
	    			if(userName.equals(userData.getUserArray().get(i).getUserName())) {
	    				userFileSrc = userData.getUserArray().get(i).getProfilePicSrc();
	    			}
					userTitle = postData.getPostArrayList().get(j).getPostTitle();
	    			userBody = postData.getPostArrayList().get(j).getPostDescription();
			    	image = new Image(DashBoardViewAndRoots.getAssetsImagesRoot() + userFileSrc);
			    	userImages.setImage(image);
			    	headerText.setText(userTitle);
	    	    	bodyText.setText(userBody);
	    		}
    		}
    	}
    }
    
    private void setImage() {
    	Image image;
    	String userFileSrc = User.getCurrentUser().getProfilePicSrc();
    	image = new Image(
    			DashBoardViewAndRoots.getAssetsImagesRoot() + userFileSrc
    	);
    	userImages.setImage(image);
    }
    
    public void setImage(ImageView userImages) {
    	this.userImages = userImages;
    }
    
    public void changeText(String HeaderText, String BodyText) {
    	headerText.setText(HeaderText);
    	bodyText.setText(BodyText);
    }
    

    
    public void setRootPane(Pane postPane) {
    	PostController.rootPane = postPane;
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setImage();
	}

}
