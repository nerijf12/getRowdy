package controller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Comment;
import model.Post;
import model.User;
import view.DashBoardViewAndRoots;

public class CommentsDashBoardController implements Initializable{
	private static String title, body;
	private static CommentsController commentsController;
	
    @FXML private ImageView userProfilePic;
    @FXML private Text userFullName;
    @FXML private Button dashboardBtn;
    @FXML private Button logOutBtn;
    @FXML private ImageView userImages;
    @FXML private Text bodyText;
    @FXML private Text headerText;
    @FXML private TextArea postField;
    @FXML private Button publishPostBtn;
    @FXML private VBox postPane;
    @FXML private Button dashBoardBtn;
    @FXML private Button publishCommentBtn;
    @FXML private Text userTitle;
    
    @FXML void dashboard(ActionEvent event) {
	MainController.changeView(DashBoardViewAndRoots.VIEW_2);
	}
    
    @FXML void logOut(ActionEvent event) {
	MainController.changeView(DashBoardViewAndRoots.VIEW_1);
	}
    
    @FXML void publishComment(ActionEvent event) throws IOException {
    	//CommentsDashBoardController.title = titleField.getText();
    	CommentsDashBoardController.body = postField.getText();
    	
    	java.util.Date dateForm = new java.util.Date();  
    	String date  = dateForm.toString();
    	
    	if( body.length() != 0) {
    		loadListData();
    		commentsController.changeText(title, body);
    		commentsController.setImage(userProfilePic);
    		Post.getCurrentPost().getComments().add(new Comment(date,
					User.getCurrentUser().getUserName(),body));
    		try {
				File file = new File("posts.csv");
				FileWriter fr = new FileWriter(file);
				for (Post post : Post.everyPost.getAllPostAList()) {
					fr.append(post.getPostDate()+","+post.getPostUser()+","
							+post.getPostTitle()+","+post.getPostDescription()+"\n");
					for (Comment comment : post.getComments()) {
						fr.append("comment,"+comment.getTime()+","+comment.getName()+","+comment.getText());
					}
					if (Post.getCurrentPost().equals(post)) {
						fr.append(date+","+
						User.getCurrentUser().getUserName()+","+body+"\n");
					}
				}
				
				fr.close();
			}catch(IOException e) {
	            e.printStackTrace();
	        }
    	}
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
    
    private void loadListData() throws IOException{
    	commentsController = new CommentsController();
    	FXMLLoader commentsLoader = new FXMLLoader(
    			getClass().getResource(DashBoardViewAndRoots.getViewRoot() + "comments.fxml")
    	);
    	commentsLoader.setController(commentsController);
    	Pane newLoadedPane = (Pane) commentsLoader.load();
    	commentsController.setRootPane(newLoadedPane);
    	postPane.getChildren().add(newLoadedPane);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setName();setImage();setUserTitle();
	}

}
