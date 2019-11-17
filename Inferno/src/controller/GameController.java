package controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Character.Player;
import models.Item.Item;
import models.Map.Map;
import models.Room.Room;

public class GameController implements Initializable
{	
	
	Player player = new Player();
	Map map = new Map("Room.txt");
	String currentRoom = player.getCurrentRoom();
	Room room = map.getRooms(currentRoom);
	
	//When the game is loaded
	@FXML private Label lblHP = new Label();
	@FXML private Label lblWeapon = new Label();
	@FXML private TextArea txtGame = new TextArea();
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		lblHP.textProperty().bind(player.HPProperty().asString());
		lblWeapon.textProperty().bind(player.weaponProperty());
		txtGame.appendText("WELCOME TO THE INFERNO ADVENTURE GAME!!!\n\n");
		txtGame.appendText(room.getRoomName() + "\n");
		for(String roomDesc : room.getRoomDesc())
			txtGame.appendText(roomDesc + "\n");
	}
	
	//When player clicks Start New Game
	@FXML private Button btnStart;
	public void startNewGame(ActionEvent event)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/main.fxml"));
			Parent root = (Parent)loader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Inferno Adventure Game");
			stage.setScene(new Scene(root));
			stage.show();	
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//When player clicks north
	@FXML private Button btnNorth;
	public void north(ActionEvent event)
	{
		String northRoom = "";
		northRoom = room.lookupNavigation("north");
		if(northRoom == null)
			txtGame.setText("Nothing here!!!");
		else
		{
			currentRoom = northRoom;
			player.CurrentRoomProperty().set(currentRoom);
			room = map.getRooms(currentRoom);
			txtGame.setText(room.getRoomName() + "\n");
			for(String roomDesc : room.getRoomDesc())
				txtGame.appendText(roomDesc + "\n");
			if(room.isVisited())
				txtGame.appendText("\nYou have visited this room.");
			room.setVisited(true);
		}
	}
	//When player clicks south
	@FXML private Button btnSouth;
	public void south(ActionEvent event)
	{
		String southRoom = "";
		southRoom = room.lookupNavigation("south");
		if(southRoom == null)
			txtGame.setText("Nothing here!!!");
		else
		{
			currentRoom = southRoom;
			player.CurrentRoomProperty().set(currentRoom);
			room = map.getRooms(currentRoom);
			txtGame.setText(room.getRoomName() + "\n");
			for(String roomDesc : room.getRoomDesc())
				txtGame.appendText(roomDesc + "\n");
			if(room.isVisited())
				txtGame.appendText("\nYou have visited this room.");
			room.setVisited(true);
		}
	}
	//When player clicks west
	@FXML private Button btnWest;
	public void west(ActionEvent event)
	{
		String westRoom = "";
		westRoom = room.lookupNavigation("west");
		if(westRoom == null)
			txtGame.setText("Nothing here!!!");
		else
		{
			currentRoom = westRoom;
			player.CurrentRoomProperty().set(currentRoom);
			room = map.getRooms(currentRoom);
			txtGame.setText(room.getRoomName() + "\n");
			for(String roomDesc : room.getRoomDesc())
				txtGame.appendText(roomDesc + "\n");
			if(room.isVisited())
				txtGame.appendText("\nYou have visited this room.");
			room.setVisited(true);
		}
	}
	//When player clicks east
	@FXML private Button btnEast;
	public void east(ActionEvent event)
	{
		String eastRoom = "";
		eastRoom = room.lookupNavigation("east");
		if(eastRoom == null)
			txtGame.setText("Nothing here!!!");
		else
		{
			currentRoom = eastRoom;
			player.CurrentRoomProperty().set(currentRoom);
			room = map.getRooms(currentRoom);
			txtGame.setText(room.getRoomName() + "\n");
			for(String roomDesc : room.getRoomDesc())
				txtGame.appendText(roomDesc + "\n");
			if(room.isVisited())
				txtGame.appendText("\nYou have visited this room.");
			room.setVisited(true);
			
		}
	}
	
	public void addTableData(TableView<Item> tableView, SortedList<Item> sortedData)
	{
        TableColumn<Item,String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<Item,String>("itemName"));
        tableView.getColumns().add(name);
        
        TableColumn<Item,String> type = new TableColumn<>("Type");
        type.setCellValueFactory(new PropertyValueFactory<Item,String>("itemType"));
        tableView.getColumns().add(type);
        
        //sets the data for table using the sorted list of MP3 files
        tableView.setItems(sortedData);
	}
	//When player clicks Inventory
	@FXML private Button btnInventory;
	public void openInventory(ActionEvent event)
	{
		//creates an instance of TableView control and sets its width and height size
		TableView<Item> tableView = new TableView<>();
		tableView.setMinWidth(400);
		tableView.setMinHeight(150);
		
		//creates an ObservableList object which keeps track of a list of Item in inventory
		ObservableList<Item> data = FXCollections.observableArrayList(player.getInventory());
		
		//creates a filtered list of Item
        FilteredList<Item> filteredData = new FilteredList<>(data);
        
        //creates a sorted list of Item from filtered list
        SortedList<Item> sortedData = new SortedList<>(filteredData);
        //sorts the list ascending or descending when user clicks the column headings
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        
        //calls the method with tableview control and sorted list as parameters
        addTableData(tableView, sortedData);
		
		//Creates a ScrollPane
		ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(tableView);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
      
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding( new Insets(15, 12, 15, 12) ); 
        hbox.setSpacing(10);
        //This makes table grows automatically, as HBox grows (table is inside HBox)
        HBox.setHgrow(tableView, Priority.ALWAYS);
        
        //Set the resizing policy of the table.  As a column's width is changed, the
        // width of all of the remaining columns is adjusted so that all of the visible
        // columns fill out the whole width of the table.  Other policies are possible, too.
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        Button btnEquip = new Button("Equip");
        btnEquip.setOnAction(new EventHandler<ActionEvent>()
		{
			
			@Override
			public void handle(ActionEvent event)
			{
				player.weaponProperty().set("Laser Gun");
			}
		});
        
        Button btnUnequip = new Button("Unequip");
        btnUnequip.setOnAction(new EventHandler<ActionEvent>()
		{
        	@Override
			public void handle(ActionEvent event)
			{
        		player.weaponProperty().set(null);
			}
		});
        
        Button btnDrop = new Button("Drop");
        btnDrop.setOnAction(new EventHandler<ActionEvent>()
		{
        	@Override
			public void handle(ActionEvent event)
			{
				
			}
		});
        
        Button btnExamine = new Button("Examine");
        btnExamine.setOnAction(new EventHandler<ActionEvent>()
		{
        	@Override
			public void handle(ActionEvent event)
			{
				
			}
		});
        
        Button btnTrade = new Button("Trade");
        btnTrade.setOnAction(new EventHandler<ActionEvent>()
		{
        	@Override
			public void handle(ActionEvent event)
			{
				
			}
		});
        
        //adds children nodes from left to right
        hbox.getChildren().addAll(btnEquip, btnUnequip, btnDrop, btnExamine, btnTrade);
        
        //creates VBox, which is the top node (root) of the scene
        VBox root = new VBox();
        //adds children nodes from top to bottom
        root.getChildren().addAll(hbox,scrollPane, tableView);
        //This makes table grows automatically, as VBox grows (table is inside HBox, thus inside VBox)
        VBox.setVgrow(tableView, Priority.ALWAYS);
        
        Stage stage = new Stage();
        stage.setResizable(false);
		stage.setTitle("Inventory");
		stage.setScene(new Scene(root, 620, 460));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
	
	//When player clicks Map
	@FXML private Button btnMap;
	public void openMap(ActionEvent event)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Map.fxml"));
			Parent root = (Parent)loader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Map");
			stage.setScene(new Scene(root));
			stage.show();
			
			if(player.getHP() > 0)
				player.HPProperty().set(player.getHP()-10);
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//When player clicks Quit
	@FXML private Button btnQuit;
	public void quitGame(ActionEvent event)
	{
		Stage stage = Stage.class.cast(((Node) event.getSource()).getScene().getWindow());
		stage.close();
	}

}
