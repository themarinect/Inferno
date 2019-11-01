package views;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			TextArea txtGame = new TextArea();
			txtGame.setPrefSize(620, 230);
			VBox vboxGame = new VBox();
			vboxGame.setAlignment(Pos.TOP_CENTER);
			vboxGame.setPadding( new Insets(15, 12, 15, 12));
			vboxGame.setSpacing(10);
			vboxGame.getChildren().add(txtGame);
			
			Label lblHP = new Label("HP: ");
			Label lblCurrentWeapon = new Label("Current Weapon: ");
			VBox playerInfo = new VBox();
			playerInfo.setAlignment(Pos.BOTTOM_LEFT);
			playerInfo.setPadding(new Insets(15, 12, 15, 12));;
			playerInfo.getChildren().addAll(lblHP, lblCurrentWeapon);
			
			
			BorderPane root = new BorderPane();
			//root.setPadding(new Insets(0));
			root.setCenter(vboxGame);
			root.setBottom(playerInfo);
			
			Scene scene = new Scene(root,620,460);
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
