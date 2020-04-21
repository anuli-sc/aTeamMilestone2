package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainGUI extends Application {
	Stage window;
	Scene main;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Milk Weight Organizer");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(80, 40, 80, 40));
		
		grid.setVgap(35);
		grid.setHgap(20);
		
		GridPane editGrid = new GridPane();
		editGrid.setPadding(new Insets(80, 40, 80, 40));
		editGrid.setVgap(25);
		editGrid.setHgap(30);
		editGrid.setStyle("-fx-background-color: #F0F8FF");
		
		Scene scene2 = new Scene(editGrid, 600, 500);
		
		
		String styles = "-fx-background-color: #00BFFF;" + "-fx-border-color: #008B8B;" + "-fx-font-size: 2em;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		String labelStyle = "-fx-font: bold italic 15pt \"Arial\";" + "-fx-font-size: 2em;";
		
		Label label = new Label("Milk Organizer Dashboard");
		label.setMaxSize(600, 300);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 6, 1);
		
		Button uploadData = new Button("Upload Data File");
		uploadData.setMaxSize(500, 200);
		
		
		uploadData.setStyle(styles);
		uploadData.setEffect(new DropShadow());
		GridPane.setConstraints(uploadData, 6, 2);
		
		Button editData = new Button("Edit Data");
		editData.setStyle(styles);
		editData.setEffect(new DropShadow());
		editData.setMaxWidth(500);
		editData.setMaxHeight(200);
		GridPane.setConstraints(editData, 6, 3);
		editData.setOnAction(e -> editData(editGrid, scene2));
		
		Button displayData = new Button("Display Data");
		displayData.setStyle(styles);
		displayData.setEffect(new DropShadow());
		displayData.setMaxSize(500, 200);
		GridPane.setConstraints(displayData, 6, 4);
		
		grid.getChildren().addAll(label, uploadData, editData, displayData);
		grid.setStyle("-fx-background-color: #F0F8FF");
		grid.setEffect(new DropShadow());
		
		main = new Scene(grid, 600, 500);
		window.setScene(main);
		window.show();
		
		

	}

	private void editData(GridPane grid, Scene scene) {
		GridPane addGrid = new GridPane();
		addGrid.setPadding(new Insets(80, 40, 80, 40));
		addGrid.setVgap(10);
		addGrid.setHgap(30);
		addGrid.setStyle("-fx-background-color: #F0F8FF");
		
		Scene addScene = new Scene(addGrid, 600, 500);
		
		String styles = "-fx-background-color: #00BFFF;" + "-fx-border-color: #008B8B;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		
		String labelStyle = "-fx-font: bold italic 15pt \"Arial\";";
		
		Label label = new Label("Choose what you would like to do:");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 3, 1);
		
		Button addData = new Button("Add Data");
		addData.setStyle(styles);
		addData.setEffect(new DropShadow());
		addData.setMaxWidth(400);
		addData.setMaxHeight(200);
		GridPane.setConstraints(addData, 3, 2);
		
		Button removeData = new Button("Remove Data");
		removeData.setStyle(styles);
		removeData.setEffect(new DropShadow());
		removeData.setMaxWidth(400);
		removeData.setMaxHeight(200);
		GridPane.setConstraints(removeData, 3, 3);
		
		Button changeData = new Button("Change Data");
		changeData.setStyle(styles);
		changeData.setEffect(new DropShadow());
		changeData.setMaxWidth(400);
		changeData.setMaxHeight(200);
		GridPane.setConstraints(changeData, 3, 4);
		
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setEffect(new DropShadow());
		returnHome.setMaxWidth(400);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 3, 5);
		returnHome.setOnAction(e -> window.setScene(main));
		
		grid.getChildren().addAll(label, addData, removeData, changeData, returnHome);
		window.setScene(scene);
		window.show();
		
		addData.setOnAction(e -> addData(addGrid, addScene, styles, labelStyle, scene));
	}
	
	private void addData(GridPane grid, Scene scene, String styles, String labelStyle, Scene returnScene) {
		TextField farmID = new TextField();
		farmID.setPromptText("Enter Farm ID");
		farmID.setMaxSize(300, 100);;
		GridPane.setConstraints(farmID, 3, 2);
		
		TextField year = new TextField();
		year.setPromptText("Enter Year");
		year.setMaxSize(300, 100);;
		GridPane.setConstraints(year, 3, 3);
		
		TextField month = new TextField();
		month.setPromptText("Enter Month");
		month.setMaxSize(300, 100);;
		GridPane.setConstraints(month, 3, 4);
		
		TextField day = new TextField();
		day.setPromptText("Enter Day");
		day.setMaxSize(300, 100);;
		GridPane.setConstraints(day, 3, 5);
		
		TextField weight = new TextField();
		weight.setPromptText("Enter Milk Weight");
		weight.setMaxSize(300, 100);
		GridPane.setConstraints(weight, 3, 6);
		
		Button addEntry = new Button("Click To Add Entry");
		String entryStyles = "-fx-background-color: #D3D3D3;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		addEntry.setStyle(entryStyles);
		addEntry.setMaxWidth(300);
		addEntry.setMaxHeight(200);
		GridPane.setConstraints(addEntry, 3, 7);
		addEntry.setOnAction(e -> window.setScene(returnScene));
		
		Button returnEdit = new Button("Return to Edit Menu");
		returnEdit.setStyle(styles);
		returnEdit.setMaxWidth(300);
		returnEdit.setMaxHeight(200);
		GridPane.setConstraints(returnEdit, 3, 8);
		returnEdit.setOnAction(e -> window.setScene(returnScene));
		
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 3, 9);
		returnHome.setOnAction(e -> window.setScene(main));
		
		grid.getChildren().addAll(farmID, year, month, day, weight, addEntry, returnEdit, returnHome);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
