package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.User;
import view.DashBoardViewAndRoots;

public class CommentsController implements Initializable{
	public static Pane rootPane;
	
    @FXML private BorderPane userPosts;
    @FXML private AnchorPane postHolder;
    @FXML private ImageView userImages;
    @FXML private Text bodyText;
    @FXML private Button postCommentBtn;

    private void setImage() {
    	Image image;
    	String userFileSrc = User.getCurrentUser().getProfilePicSrc();
    	image = new Image(
    			DashBoardViewAndRoots.getAssetsImagesRoot() + userFileSrc
    	);
    	userImages.setImage(image);
    }
    
    public void changeText(String headerText, String bodyText) {
    	this.bodyText.setText(bodyText);
    }
    
    public void setImage(ImageView userImages) {
    	this.userImages = userImages;
    }
    
    public void setRootPane(Pane postPane) {
    	PostController.rootPane = postPane;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setImage();
	}

}
