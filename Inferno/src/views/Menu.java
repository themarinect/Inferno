package views;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menu extends Application {

	@Override
	public void start(Stage primaryStage) {
	
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Menu.class.getResource("/views/menu.fxml"));
			AnchorPane pane = loader.load();
			
			BorderPane root = new BorderPane();
			root.setCenter(pane);
			
			Scene scene = new Scene(root,600,420);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Inferno Adventure Game");
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
