package application;
	
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class PersonInfo extends Application {
	
	private String userName;
	private String userAddress;
	private String userPhoneNumber;
	
	public  PersonInfo() {
	userName="Badar Shahzad";
	userAddress="T 212";
	userPhoneNumber="03470766786";
	}
	
	  	@FXML
	    private JFXTextField userNameField;

	    @FXML
	    private JFXTextField userAddressField;

	    @FXML
	    private JFXTextField userPhoneNumebrField;

	    @FXML
	    private JFXButton submit;

	    @FXML
	    private JFXButton exit;
	    
	    @FXML
	    private Label userNameLabel;

	    @FXML
	    private Label userAddressLabel;

	    @FXML
	    private Label userPhoneNumLabel;

	    @FXML
	    private JFXButton OkButton;
	
	    public void setUserName(){
			userName=userNameField.getText();
		}
		public void setAddress(){
			userAddress=userAddressField.getText();
		}
		public void setPhoneNumber(){
			userPhoneNumber=userPhoneNumebrField.getText();
			
		}
		
		public void Listener(){
			submit.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					System.out.println(userName + userAddress +userPhoneNumber);
					
				}
			});
			exit.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
				System.exit(0);
					
				}
				
			});
		}
		
	    
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Input.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
