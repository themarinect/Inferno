package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import models.Item.HealingItem;
import models.Item.Item;
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
			txtGame.appendText("\nYou have visited this room.\n");
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
		if(player.isInCombat())
		{
			alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.ERROR);
			String info = "YOU CANNOT GO TO ANOTHER ROOM WHILE IN COMBAT MODE.";
			alert.setContentText(info);
			alert.show();
		}
		else
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
	}
	//When player clicks south
	@FXML private Button btnSouth;
	public void south(ActionEvent event)
	{
		if(player.isInCombat())
		{
			alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.ERROR);
			String info = "YOU CANNOT GO TO ANOTHER ROOM WHILE IN COMBAT MODE.";
			alert.setContentText(info);
			alert.show();
		}
		else
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
	}
	//When player clicks west
	@FXML private Button btnWest;
	public void west(ActionEvent event)
	{
		if(player.isInCombat())
		{
			alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.ERROR);
			String info = "YOU CANNOT GO TO ANOTHER ROOM WHILE IN COMBAT MODE.";
			alert.setContentText(info);
			alert.show();
		}
		else
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
	}
	//When player clicks east
	@FXML private Button btnEast;
	public void east(ActionEvent event)
	{
		if(player.isInCombat())
		{
			alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.ERROR);
			String info = "YOU CANNOT GO TO ANOTHER ROOM WHILE IN COMBAT MODE.";
			alert.setContentText(info);
			alert.show();
		}
		else
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
	}
	/*----------------------------------------------*/
	
	
	/*----------------FOR PUZZLE----------------------*/
	//When player clicks Look puzzle
	@FXML private Button btnLook;
	public void lookPuzzle(ActionEvent event)
	{
		for(Puzzle puzzle : room.getPuzzles())
		{
			txtGame.appendText("\n" + puzzle.getPuzzleName() + "\n");
			for(String desc : puzzle.getPuzzleDesc())
				txtGame.appendText(desc);
		}
			
	}
	//When player clicks Hint
	@FXML private Button btnHint;
	public void hint(ActionEvent event)
	{
		for(Puzzle puzzle : room.getPuzzles())
			txtGame.appendText("\nPuzzle Hint: " + puzzle.getPuzzleHint());
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
	
	//When player clicks Trade
	@FXML private Button btnTrade;
	public void trade(ActionEvent event)
	{
		NPC[] NPCs = room.getNPCs();
		NPC npc = new NPC();
		for(NPC temp : NPCs)
			npc = temp;
		
		for(Item item : npc.getItems())
		{
			npc.removeItem((TradableItem) item);
			player.getInventory().add(item);
			txtGame.appendText("\nThe " + item.getItemName().toUpperCase() + " has been traded and added to inventory.\n");
		}
	}	
	
	//When player clicks Inventory
	@FXML private Button btnInventory;
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
        
        //adds children nodes from left to right
        hbox.getChildren().addAll(btnUse, btnEquip, btnUnequip, btnDrop, btnExamine);
        
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
	
	
	/*----------------FOR MONSTER----------------------*/
	@FXML private Button btnInspect;
	public void inspectMonster(ActionEvent event) 
	{
		Monster[] monsters = room.getMonsters();
		
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
				player.setInCombat(true);
				txtGame.setText("YOU ARE NOW IN THE COMBAT MODE\n\n");
				txtGame.appendText("Monster Information\n");
				txtGame.appendText(m.getName().toUpperCase() + "\n");
				for(String desc : m.getDesc())
					txtGame.appendText(desc);
				txtGame.appendText("\nHP: " + m.getHealth());
				txtGame.appendText("\nAttack Damage: " + m.getAttack());
			}
		}
	}
	
	@FXML private Button btnAttack;
	public void attack(int playerHP, int weaponDmg, Monster currentMonster, int monsterHP, int monsterAttack, ActionEvent event)
	{	
		int dmgTaken = monsterAttack;
		int dmgDealt = weaponDmg;
		monsterHP = monsterHP - dmgDealt;
		playerHP -= dmgTaken;
		txtGame.setText("You strike for: " + dmgDealt + "\n");
		txtGame.appendText("You have been hit for: " + dmgTaken + "\n");
		txtGame.appendText("You have " + playerHP + " HP left. " + currentMonster.getName().toUpperCase() + " has " + monsterHP + " HP left\n\n");
		player.HPProperty().set(playerHP);
		currentMonster.setHealth(monsterHP);
		
		if(playerHP <= 0)
		{
			alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.ERROR);
			String info = "YOU DIED. THE GAME IS OVER!!!";
			alert.setContentText(info);
			alert.show();
			quitGame(event);
		}
		if(monsterHP <= 0)
		{
			player.setInCombat(false);
			txtGame.setText("CONGRATS!!! THE MONSTER HAS BEEN DEFEATED AND REMOVED FROM THE ROOM\n\n");
			room.removeMonster(currentMonster);
			displayRoom(room);
		}
	}
	public void attackMonster(ActionEvent event)
	{
		if(player.isInCombat())
		{
			if(player.getWeaponName() == null)
			{
				alert = new Alert(AlertType.NONE);
				alert.setAlertType(AlertType.ERROR);
				String info = "Please equip a Weapon item before attacking.";
				alert.setContentText(info);
				alert.show();
			}
			else
			{
				Monster[] monsters = room.getMonsters();
				Monster currentMonster = new Monster();
				for(Monster m : monsters)
				{
					currentMonster = m;
				}
				
				//Player's info
				int playerHP = player.getHP();
				Item item = player.getCurrentWeapon();
				WeaponItem currentWeapon = new WeaponItem();
				if(item instanceof WeaponItem)
					currentWeapon = (WeaponItem) item;
				int weaponDmg = Integer.parseInt(currentWeapon.getAttack());
				
				//Monster's info
				int monsterHP = currentMonster.getHealth();
				int monsterAttack = currentMonster.getAttack();
				
				//attack
				attack(playerHP, weaponDmg, currentMonster, monsterHP, monsterAttack, event);
			}
		}
		else
		{
			alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.ERROR);
			String info = "Please Inspect monster before attacking.";
			alert.setContentText(info);
			alert.show();
		}
	}
	
	@FXML private Button btnFlee;
	public void fleeMonster(ActionEvent event)
	{
		if(player.isInCombat())
		{
			player.setInCombat(false);
			txtGame.setText(room.getRoomName() + "\n");
			displayRoom(room);
		}
		else
		{
			alert = new Alert(AlertType.NONE);
			alert.setAlertType(AlertType.ERROR);
			String info = "You are not in Combat mode.";
			alert.setContentText(info);
			alert.show();
		}
	}
	/*-------------------------------------------------*/
	
	
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
}
	 


