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
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.GetRowdy;
import model.Post;
import model.PostData;
import model.User;
import view.DashBoardViewAndRoots;

public class DashBoardController implements Initializable{
	private static String title, body;
	private static ImageView profilePic;
	private static PostController postControllers =  new PostController();
	public PostData postData = new PostData();
	
	@FXML private Button logOutBtn;
    @FXML private ImageView userProfilePic;
    @FXML private Text userFullName;
    @FXML private TextField titleField;
    @FXML private TextArea postField;
    @FXML private Button publishPostBtn;
    @FXML private ListView<BorderPane> postListView;
    @FXML private VBox postPane;
    @FXML private Pane postTempPane;
    @FXML private ScrollPane postSectionPane;
    @FXML private Button profileBtn;
    @FXML private Text userTitle;

    @FXML void logOut(ActionEvent event) {
    	MainController.changeView(DashBoardViewAndRoots.VIEW_1);
    }
    
    @FXML void profile(ActionEvent event) {
    	MainController.changeView(DashBoardViewAndRoots.VIEW_3);
    }

    @FXML void publishPost(ActionEvent event) throws IOException {
    	DashBoardController.title = titleField.getText();
    	DashBoardController.body = postField.getText();
    	java.util.Date dateForm =new java.util.Date();  
    	String date  = dateForm.toString();
    	
    	if(title.length() != 0 && body.length() != 0) {
			postControllers.changeText(title, body);
			postControllers.setImage(profilePic);
			Post.everyPost.addPost(new Post(date,
					User.getCurrentUser().getUserName(),title,body));
			//FileWriter writer;


			try {
				//System.out.println("hello i am trying to write rn");
				
				File file = new File("posts.csv");
				FileWriter fr = new FileWriter(file, true);
				fr.write(date+","+
						User.getCurrentUser().getUserName()+","+title+","+body+"\n");
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
		for(int i=0;i<postData.getPostLinkedListSize();i++) {
	    	postControllers = new PostController();
	    	FXMLLoader postLoader = new FXMLLoader(getClass().getResource(DashBoardViewAndRoots.getViewRoot() + "posts.fxml"));
	    	postLoader.setController(postControllers);
	    	Pane newLoadedPane = (Pane) postLoader.load();
	    	postControllers.setRootPane(newLoadedPane);
	    	postControllers.loadProfile(postData.getPostLinkedList().get(i).getPostUser());    	
	    	postPane.getChildren().add(newLoadedPane);
		}
		publishPostData();
    }
    
    private void publishPostData() throws IOException{
	    	postControllers = new PostController();
	    	FXMLLoader postLoader = new FXMLLoader(getClass().getResource(DashBoardViewAndRoots.getViewRoot() + "posts.fxml"));
	    	postLoader.setController(postControllers);
	    	Pane newLoadedPane = (Pane) postLoader.load();
	    	postControllers.setRootPane(newLoadedPane);    	
	    	postPane.getChildren().add(newLoadedPane);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GetRowdy.getPrimaryStage().setTitle(
				User.getCurrentUser().getName() + " | " + User.getCurrentUser().getTitle()
		);
		setName(); setImage(); setUserTitle();
		try {
			loadListData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
