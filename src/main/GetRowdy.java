package main;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.DashBoardViewAndRoots;

public class GetRowdy extends Application{
	private static Stage primaryStage;
	
	public static void main(String[] args) {
		//launch the app
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//create the login controller
		MainController loginController = MainController.getInstance();
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				DashBoardViewAndRoots.getViewRoot() + "login.fxml"));
		loader.setController(loginController);
		
		//loads the border pane and create the scene object with stylesheets
		BorderPane borderPane = (BorderPane) loader.load();
		loginController.setRootPane(borderPane);
		Scene scene = new Scene(borderPane);
		scene.getStylesheets().add(
				getClass().getResource(DashBoardViewAndRoots.getAssetsCssRoot() + "dashboardStyles.css").toExternalForm());
		
		//set the scene object  to the primary  stage
		GetRowdy.setPrimaryStage(primaryStage);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Time to get rowdy!");
		primaryStage.show();
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		GetRowdy.primaryStage = primaryStage;
	}

}
