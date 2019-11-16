package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameController
{
	
	@FXML 
	private Button btnMap;

	@FXML
	public void openMap(ActionEvent event)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Map.fxml"));
			Parent root = (Parent)loader.load();
			Stage stage = new Stage();
			stage.setTitle("Map");
			stage.setScene(new Scene(root));
			stage.show();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
