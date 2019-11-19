package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.text.TabExpander;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Character.Monster;
import models.Character.NPC;
import models.Character.Player;
import models.Item.CombatItem;
import models.Item.GuideItem;
import models.Item.HealingItem;
import models.Item.Item;
import models.Item.KeyItem;
import models.Item.TradableItem;
import models.Item.WeaponItem;
import models.Map.Map;
import models.Puzzle.Puzzle;
import models.Room.Room;

public class GameController implements Initializable, Serializable
{	
	
	Player player = new Player();
	Map map = new Map("Room.txt");
	String currentRoom = player.getCurrentRoom();
	Room room = map.getRooms(currentRoom);
	
	//Alert box used through out the game
	Alert alert;
	
	@FXML private Label lblHP = new Label();
	@FXML private Label lblWeapon = new Label();
	@FXML private TextArea txtGame = new TextArea();
	
	public void displayRoom(Room room)
	{
		//Room's description
		for(String roomDesc : room.getRoomDesc())
			txtGame.appendText(roomDesc + "\n");
		
		//Puzzle's name
		for(Puzzle puzzle : room.getPuzzles())
			txtGame.appendText("PUZZLE: " + puzzle.getPuzzleName().toUpperCase() + " \n");
		
		//Item's name
		for(Item item : room.getItems())
			txtGame.appendText("ITEM: " + item.getItemName().toUpperCase() + " \n");
		
		//Monster's name
		for(Monster monster : room.getMonsters())
			txtGame.appendText("MONSTER: " + monster.getName().toUpperCase() + " \n");
		
		//NPC's name
		for(NPC npc : room.getNPCs())
		{
			txtGame.appendText("NON-PLAYABLE CHARACTER: " + npc.getName().toUpperCase() + " \n");
			for(TradableItem tradableItem : npc.getItems()) //Tradable item associated with NPC
				txtGame.appendText("NPC'S ITEM: " + tradableItem.getItemName().toUpperCase() + " \n");
		}
		
		//Check if room visited
		if(room.isVisited())
			txtGame.appendText("\nYou have visited this room.");
		room.setVisited(true);
	}
	
	//When the game is loaded
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		lblHP.textProperty().bind(player.HPProperty().asString());
		lblWeapon.textProperty().bind(player.weaponNameProperty());
		txtGame.appendText("WELCOME TO THE INFERNO ADVENTURE GAME!!!\n\n");
		txtGame.appendText(room.getRoomName() + "\n");
		displayRoom(room);
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
	
	/*----------------FOR NAVIGATION----------------*/
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
			displayRoom(room);
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
			displayRoom(room);
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
			displayRoom(room);
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
			displayRoom(room);
		}
	}
	/*----------------------------------------------*/
	
	
	/*----------------FOR ITEM----------------------*/
	//When player clicks Pickup
	@FXML private Button btnPickup;
	public void pickup(ActionEvent event)
	{
		for(Item item : room.getItems())
			item.pickup(room, player, txtGame);
	}
	
	public void addTableData(TableView<Item> tableView, SortedList<Item> sortedData)
	{
        TableColumn<Item,String> name = new TableColumn<>("Item Name");
        name.setCellValueFactory(new PropertyValueFactory<Item,String>("itemName"));
        tableView.getColumns().add(name);
        
        TableColumn<Item,String> type = new TableColumn<>("Item Type");
        type.setCellValueFactory(new PropertyValueFactory<Item,String>("itemType"));
        tableView.getColumns().add(type);
        
        //sets the data for table using the sorted list of Items
        tableView.setItems(sortedData);
	}
	//When player clicks Inventory
	@FXML private Button btnInventory;
	public void openInventory(ActionEvent event)
	{
		//creates an instance of TableView control and sets its width and height size
		TableView<Item> tableView = new TableView<>();
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setMinWidth(400);
		tableView.setMinHeight(150);
		tableView.setEditable(true);
		
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
        
        Button btnUse = new Button("Use");
        btnUse.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event)
			{
				int index = tableView.getSelectionModel().getFocusedIndex();
				if(index >= 0)
				{
					Item selectedItem = tableView.getSelectionModel().getSelectedItem();
					if(selectedItem instanceof HealingItem)
					{
						int strength = Integer.parseInt(((HealingItem)selectedItem).getStrength());
						if(player.getHP() < 100)
							player.HPProperty().set(player.getHP() + strength);	
						
						//index of the filtered and sorted list
		        		int sortedIndex = tableView.getSelectionModel().getSelectedIndex();
		        		//index of actual data
		        		int sourceIndex = sortedData.getSourceIndexFor(data, sortedIndex);
		        		data.remove(sourceIndex);
					}
					else
					{
						alert = new Alert(AlertType.NONE);
						alert.setAlertType(AlertType.ERROR);
						String info = "You can only use Healing item.";
						alert.setContentText(info);
						alert.show();
					}
				}
			}
        	
		});
        
        Button btnEquip = new Button("Equip");
        btnEquip.setOnAction(new EventHandler<ActionEvent>()
		{
			
			@Override
			public void handle(ActionEvent event)
			{
				int index = tableView.getSelectionModel().getFocusedIndex();
				if(index >= 0)
				{
					Item selectedItem = tableView.getSelectionModel().getSelectedItem();
					if(selectedItem instanceof WeaponItem)
					{
						selectedItem = (WeaponItem)selectedItem;
						player.setCurrentWeapon(selectedItem);
						player.weaponNameProperty().set(tableView.getItems().get(index).getItemName());
					}
					else
					{
						alert = new Alert(AlertType.NONE);
						alert.setAlertType(AlertType.ERROR);
						String info = "You can only equip Weapon item.";
						alert.setContentText(info);
						alert.show();
					}
				}
			}
		});
        
        Button btnUnequip = new Button("Unequip");
        btnUnequip.setOnAction(new EventHandler<ActionEvent>()
		{
        	@Override
			public void handle(ActionEvent event)
			{
        		player.weaponNameProperty().set(null);
			}
		});
        
        Button btnDrop = new Button("Drop");
        btnDrop.setOnAction(new EventHandler<ActionEvent>()
		{
        	@Override
			public void handle(ActionEvent event)
			{
        		Item item = tableView.getSelectionModel().getSelectedItem();
        		room.addItem(item);
        		player.getInventory().remove(item);
        		player.setCurrentWeapon(null);
        		player.weaponNameProperty().set(null);        		 
        		txtGame.appendText("\nItem " + item.getItemName().toUpperCase() + " has been dropped");
        		
        		//index of the filtered and sorted list
        		int sortedIndex = tableView.getSelectionModel().getSelectedIndex();
        		//index of actual data
        		int sourceIndex = sortedData.getSourceIndexFor(data, sortedIndex);
        		data.remove(sourceIndex);
			}
		});
        
        Button btnExamine = new Button("Examine");
        btnExamine.setOnAction(new EventHandler<ActionEvent>()
		{
        	@Override
			public void handle(ActionEvent event)
			{
        		Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        		String itemDesc = "";
        		for(String temp : selectedItem.getItemDesc())
        			itemDesc = temp;
        		alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("Item Description");
        		String itemName = tableView.getSelectionModel().getSelectedItem().getItemName();
        		alert.setHeaderText(itemName);
        		alert.setContentText(itemDesc);
        		alert.show();
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
        hbox.getChildren().addAll(btnUse, btnEquip, btnUnequip, btnDrop, btnExamine, btnTrade);
        
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
	/*----------------------------------------------*/
	
	
	//When player clicks Map
	@FXML private Button btnMap;
	public void openMap(ActionEvent event)
	{	
		Optional<Item> mapItem = player.getInventory().stream().filter(item->item.getItemName().equals("Map")).findAny();
		if(mapItem.isPresent())
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
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		else
		{
			alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.ERROR);
			String info = "You need to have Map item in your inventory to open the Map.";
			alert.setContentText(info);
			alert.show();
		}
	}
	
	//When player clicks Save Game
	@FXML private Button btnSave;
	public void saveGame(ActionEvent event)
	{
		File file = new File("game1.txt");
		
		try
		{
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			if(!file.exists())
			{
				file.createNewFile();
			}
			os.writeObject(this.getClass());
			os.flush();
			os.close();
			System.out.println(this.getClass());
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
	
	/*----------------FOR MONSTER----------------------*/
	@FXML private Button btnInspect;
	 public void inspectMonster(ActionEvent event) 
	 {
		 Monster[] monsters = map.getRooms(currentRoom).getMonsters();
		 if(monsters.length == 0)
		 {
			 alert = new Alert(AlertType.NONE);
			 alert.setAlertType(AlertType.ERROR);
			 String info = "No monster in this room";
			 alert.setContentText(info);
			 alert.show();
		 }
		 else
		 {
			 for(Monster m : monsters)
			 {
				 if(room.containsMonster(m))
				 {
					 txtGame.setText("MONSTER INFORMATION\n\n");
					 txtGame.appendText(m.getName().toUpperCase() + "\n");
					 for(String desc : m.getDesc())
						 txtGame.appendText(desc);
					 txtGame.appendText("\nHP: " + m.getHealth());
					 txtGame.appendText("\nAttack Damage: " + m.getAttack());
				 }
			 } 
		 }
	 }
	 /*-------------------------------------------------*/

}
