package views;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/views/main.fxml"));
			AnchorPane pane = loader.load();
			
			BorderPane root = new BorderPane();
			root.setCenter(pane);
			
			Scene scene = new Scene(root,645,570);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Inferno Adventure Game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
