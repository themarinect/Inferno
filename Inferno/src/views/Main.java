package views;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import model.Game;
import model.Room;
import model.Item;
import model.Puzzle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	private TextArea txtGame = new TextArea();
	private TextField txtCommand = new TextField();
	private Button north = new Button("North");
	private Button south = new Button("South");
	private Button west = new Button("West");
	private Button east = new Button("East");
	
	private Label lblHP = new Label("HP: ");
	private Label lblCurrentWeapon = new Label("Current Weapon: ");
	private Button btnInventory = new Button("Open Inventory");
	
	@Override
	public void start(Stage primaryStage) {
		try 
		{
			txtGame.setPrefSize(620, 230);
			txtGame.setEditable(false);
			HBox navigation = new HBox();
			navigation.setAlignment(Pos.CENTER);
			navigation.getChildren().addAll(txtCommand, north, south, west, east);
			VBox vboxGame = new VBox();
			vboxGame.setAlignment(Pos.TOP_CENTER);
			vboxGame.setPadding( new Insets(15, 12, 15, 12));
			vboxGame.setSpacing(10);
			vboxGame.getChildren().addAll(txtGame, navigation);
			
			VBox playerInfo = new VBox();
			playerInfo.setAlignment(Pos.BOTTOM_LEFT);
			playerInfo.setPadding(new Insets(15, 12, 15, 12));;
			playerInfo.getChildren().addAll(lblHP, lblCurrentWeapon, btnInventory);
			
			//runs Game
			Game newGame = readTextFile();
			txtGame.appendText(newGame.getTitle() + "\n");
			txtGame.appendText("Type 'quit' to quit game any time\n\n");
			int currentRoomNumber = 1;
			
			Room room = newGame.getRooms(currentRoomNumber);
			txtGame.appendText(room.getRoomName() + "\n");
			for(String roomDesc : room.getRoomDesc())
				txtGame.appendText(roomDesc + "\n");
		
			for(Item item : room.getItems())
				txtGame.appendText("There is a " + item.getItemName() + " here\n");
		
			for(Puzzle puzzle : room.getPuzzles())
				txtGame.appendText("There is a puzzle here\n");
		
			if(room.isVisited())
				txtGame.appendText("You have visited this room\n");
			/*while(currentRoomNumber != 0)
			{
				Room room = newGame.getRooms(currentRoomNumber);
				txtGame.appendText(room.getRoomName() + "\n");
				for(String roomDesc : room.getRoomDesc())
					txtGame.appendText(roomDesc + "\n");
			
				for(Item item : room.getItems())
					txtGame.appendText("There is a " + item.getItemName() + " here\n");
			
				for(Puzzle puzzle : room.getPuzzles())
					txtGame.appendText("There is a puzzle here\n");
			
				if(room.isVisited())
					txtGame.appendText("You have visited this room\n");
			}*/
			north.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					Room room = newGame.getRooms(currentRoomNumber+1);
					txtGame.setText(room.getRoomName() + "\n");
					for(String roomDesc : room.getRoomDesc())
						txtGame.appendText(roomDesc + "\n");
					
					for(Item item : room.getItems())
						txtGame.appendText("There is a " + item.getItemName() + " here\n");
					
					for(Puzzle puzzle : room.getPuzzles())
						txtGame.appendText("There is a puzzle here\n");
					
					if(room.isVisited())
						txtGame.appendText("You have visited this room\n");
				}
			});
			
			
			
			
			BorderPane root = new BorderPane();
			//root.setPadding(new Insets(0));
			root.setCenter(vboxGame);
			root.setBottom(playerInfo);
			
			Scene scene = new Scene(root,650,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Game readTextFile()
	{
		while(true)
		{
			String filename = "rooms.txt";
			return new Game(filename);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
