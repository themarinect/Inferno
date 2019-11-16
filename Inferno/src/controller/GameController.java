package controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Character.Player;
import models.Map.Map;
import models.Room.Room;

public class GameController implements Initializable
{	
	
	public static Map readTextFile()
	{
		while(true)
		{
			String filename = "rooms.txt";
			return new Map(filename);
		}
	}
	
	@FXML private Label lblHP = new Label();
	@FXML private Label lblWeapon = new Label();
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		Player player = new Player();
		lblHP.textProperty().bind(player.getHP().asString());
		lblWeapon.textProperty().bind(player.getWeapon());
	}
	
	@FXML private Button btnStart;
	@FXML private TextArea txtGame;
	public void startNewGame(ActionEvent event)
	{
		Map newMap = readTextFile();
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
	public void quitGame(ActionEvent event)
	{
		Stage stage = Stage.class.cast(((Node) event.getSource()).getScene().getWindow());
		stage.close();
	}

}
