package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		startActivity(primaryStage);
	}
	
	//This method calls when activity starts. It initializes main window.
	public void startActivity(Stage primaryStage){
		
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/application/AddEntryLayout.fxml"));
			Scene scene = new Scene(root,1280,677);
			
			//Getting the screen boundries to visible  bounds of the mains sceen
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			primaryStage.setX(primaryScreenBounds.getMinX());
			primaryStage.setY(primaryScreenBounds.getMinY());
			primaryStage.setWidth(primaryScreenBounds.getWidth());
			primaryStage.setHeight(primaryScreenBounds.getHeight());
			
			scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Telenor Software");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public static void main(String[] args) {
		launch(args);
	}
}