package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameController
{

	@FXML
	private Button btnStart;
	@FXML
	private Label lblHP;
	@FXML
	public void startNewGame(ActionEvent event)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/main.fxml"));
			Parent root = (Parent)loader.load();
			Stage stage = new Stage();
			stage.setTitle("Inferno Adventure Game");
			stage.setScene(new Scene(root));
			stage.show();
			
			//((Scene) event.getSource()).getWindow().hide();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
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
	
	@FXML
	private Button btnQuit;
	@FXML
	public void quitGame(ActionEvent event)
	{
		Stage stage = Stage.class.cast(((Node) event.getSource()).getScene().getWindow());
		stage.close();
	}

}
