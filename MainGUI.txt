package application;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainGUI extends Application {
	Stage window; //The main window
	Scene main; //The main menu scene
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Sets the current window to the main menu stage
		window = primaryStage;
		
		//Sets the title of the window to Milk Weight Organizer
		window.setTitle("Milk Weight Organizer");
		
		//Creates a new GridPlane and sets the padding for grid to be 80 top, 40 right,
		//80 from the bottom, 40 from the left
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(80, 40, 80, 40));
		
		//Sets the vertical gap to 35 pixels and horizontal gap to 20 pixels
		grid.setVgap(35);
		grid.setHgap(20);
		
		//Creates a new uploadGrid for a potential new window
		GridPane uploadGrid = new GridPane();
		uploadGrid.setPadding(new Insets(80, 40, 80, 40));
		uploadGrid.setVgap(25);
		uploadGrid.setHgap(30);
		
		//Sets the background color of the grid to the color
		uploadGrid.setStyle("-fx-background-color: #F0F8FF");
		
		//Creates a new scene if the upload button is pushed
		Scene uploadScene = new Scene(uploadGrid, 600, 500);
		
		//Creates a new grid for a potential new window when edit button is clicked
		GridPane editGrid = new GridPane();
		editGrid.setPadding(new Insets(80, 40, 80, 40));
		editGrid.setVgap(25);
		editGrid.setHgap(30);
		editGrid.setStyle("-fx-background-color: #F0F8FF");
		
		//sets a new scene if the edit button is pushed
		Scene scene2 = new Scene(editGrid, 600, 500);
		
		//Common styles for the buttons and labels with bold arial font and blue color
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
		uploadData.setOnAction(e -> uploadData(uploadGrid, uploadScene));
		
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
	
	private void uploadData(GridPane grid, Scene scene) {
		String styles = "-fx-background-color: #00BFFF;" + "-fx-border-color: #008B8B;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		
		String labelStyle = "-fx-font: bold italic 15pt \"Arial\";";
		
		Label label = new Label("Upload a Data File:");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 5, 1);
		
		window.setScene(scene);
		window.show();
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
		 
		Button fileSelect = new Button("Select A File");
		fileSelect.setMaxSize(500, 200);
		fileSelect.setStyle(styles);
		fileSelect.setEffect(new DropShadow());
		GridPane.setConstraints(fileSelect, 5, 2);
		
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setEffect(new DropShadow());
		returnHome.setMaxSize(500, 200);
		GridPane.setConstraints(returnHome, 5, 3);
		returnHome.setOnAction(e -> window.setScene(main));
		
        fileSelect.setOnAction(e -> {
        	File selectedFile = fileChooser.showOpenDialog(window);
        	
        	if(selectedFile != null) {
        		String entryStyles = "-fx-background-color: #7CFC00;" +
        				"-fx-font: bold italic 15pt \"Arial\";";
        		
        		Button fileHolder = new Button("Click to Upload " + selectedFile.getName());
        		fileHolder.setMaxSize(500, 200);
        		fileHolder.setStyle(entryStyles);
        		fileHolder.setEffect(new DropShadow());
        		GridPane.setConstraints(fileHolder, 5, 3);
        		
        		GridPane.setConstraints(returnHome, 5, 4);
        		
        		grid.getChildren().addAll(fileHolder);
        		
        	} 
        });
        
        grid.getChildren().addAll(fileSelect, label, returnHome);
	}

	/**
	 * 
	 * @param grid
	 * @param scene
	 */
	private void editData(GridPane grid, Scene scene) {
		GridPane addGrid = new GridPane();
		addGrid.setPadding(new Insets(80, 40, 80, 40));
		addGrid.setVgap(10);
		addGrid.setHgap(30);
		addGrid.setStyle("-fx-background-color: #F0F8FF");
		
		Scene addScene = new Scene(addGrid, 600, 500);
		
		GridPane removeGrid = new GridPane();
		removeGrid.setPadding(new Insets(80, 40, 80, 40));
		removeGrid.setVgap(10);
		removeGrid.setHgap(30);
		removeGrid.setStyle("-fx-background-color: #F0F8FF");
		
		Scene removeScene = new Scene(removeGrid, 600, 500);
		
		GridPane changeGrid = new GridPane();
		changeGrid.setPadding(new Insets(80, 40, 80, 40));
		changeGrid.setVgap(10);
		changeGrid.setHgap(30);
		changeGrid.setStyle("-fx-background-color: #F0F8FF");
		
		Scene changeScene = new Scene(changeGrid, 600, 500);
		
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
		
		addData.setOnAction(e -> addData(addGrid, addScene, styles, scene));
		removeData.setOnAction(e -> removeData(removeGrid, removeScene, styles, scene));
		changeData.setOnAction(e -> changeData(changeGrid, changeScene, styles, scene));
	}
	
	/**
	 * 
	 * @param grid
	 * @param scene
	 * @param styles
	 * @param returnScene
	 */
	private void addData(GridPane grid, Scene scene, String styles,
			Scene returnScene) {
		
		String labelStyle = "-fx-font: bold italic 10pt \"Arial\";";
		
		Label label = new Label("Add A New Milk Entry");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 2, 1);
		
		Label labelFarm = new Label("Enter the Farm ID:");
		labelFarm.setMaxSize(300, 200);
		labelFarm.setStyle(labelStyle);
		GridPane.setConstraints(labelFarm, 1, 2);
		
		TextField farmID = new TextField();
		farmID.setPromptText("Enter Farm ID");
		farmID.setMaxSize(300, 100);;
		GridPane.setConstraints(farmID, 2, 2);
		
		Label labelYear = new Label("Enter the Year:");
		labelYear.setMaxSize(300, 200);
		labelYear.setStyle(labelStyle);
		GridPane.setConstraints(labelYear, 1, 3);
		
		TextField year = new TextField();
		year.setPromptText("Enter Year");
		year.setMaxSize(300, 100);;
		GridPane.setConstraints(year, 2, 3);
		
		Label labelMonth = new Label("Enter the Month:");
		labelMonth.setMaxSize(300, 200);
		labelMonth.setStyle(labelStyle);
		GridPane.setConstraints(labelMonth, 1, 4);
		
		TextField month = new TextField();
		month.setPromptText("Enter Month");
		month.setMaxSize(300, 100);;
		GridPane.setConstraints(month, 2, 4);
		
		Label labelDay = new Label("Enter the Day:");
		labelDay.setMaxSize(300, 200);
		labelDay.setStyle(labelStyle);
		GridPane.setConstraints(labelDay, 1, 5);
		
		TextField day = new TextField();
		day.setPromptText("Enter Day");
		day.setMaxSize(300, 100);;
		GridPane.setConstraints(day, 2, 5);
		
		Label labelWeight = new Label("Enter the Milk Weight:");
		labelWeight.setMaxSize(300, 200);
		labelWeight.setStyle(labelStyle);
		GridPane.setConstraints(labelWeight, 1, 6);
		
		TextField weight = new TextField();
		weight.setPromptText("Enter Milk Weight");
		weight.setMaxSize(300, 100);
		GridPane.setConstraints(weight, 2, 6);
		
		Button addEntry = new Button("Click To Add Entry");
		String entryStyles = "-fx-background-color: #D3D3D3;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		addEntry.setStyle(entryStyles);
		addEntry.setMaxWidth(300);
		addEntry.setMaxHeight(200);
		GridPane.setConstraints(addEntry, 2, 7);
		addEntry.setOnAction(e -> window.setScene(returnScene));
		
		Button returnEdit = new Button("Return to Edit Menu");
		returnEdit.setStyle(styles);
		returnEdit.setMaxWidth(300);
		returnEdit.setMaxHeight(200);
		GridPane.setConstraints(returnEdit, 2, 8);
		returnEdit.setOnAction(e -> window.setScene(returnScene));
		
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 2, 9);
		returnHome.setOnAction(e -> window.setScene(main));
		
		grid.getChildren().addAll(farmID, year, month, day, weight, addEntry, returnEdit, 
				returnHome, labelFarm, labelYear, labelMonth, labelDay, labelWeight, label);
		window.setScene(scene);
		window.show();
	}

	/**
	 * 
	 * @param grid
	 * @param scene
	 * @param styles
	 * @param returnScene
	 */
	private void removeData(GridPane grid, Scene scene, String styles, Scene returnScene) {
		String labelStyle = "-fx-font: bold italic 10pt \"Arial\";";
		
		Label label = new Label("Remove An Existing Milk Entry");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 2, 1);
		
		Label labelFarm = new Label("Enter the Farm ID:");
		labelFarm.setMaxSize(300, 200);
		labelFarm.setStyle(labelStyle);
		GridPane.setConstraints(labelFarm, 1, 2);
		
		TextField farmID = new TextField();
		farmID.setPromptText("Enter Farm ID");
		farmID.setMaxSize(300, 100);;
		GridPane.setConstraints(farmID, 2, 2);
		
		Label labelYear = new Label("Enter the Year:");
		labelYear.setMaxSize(300, 200);
		labelYear.setStyle(labelStyle);
		GridPane.setConstraints(labelYear, 1, 3);
		
		TextField year = new TextField();
		year.setPromptText("Enter Year");
		year.setMaxSize(300, 100);;
		GridPane.setConstraints(year, 2, 3);
		
		Label labelMonth = new Label("Enter the Month:");
		labelMonth.setMaxSize(300, 200);
		labelMonth.setStyle(labelStyle);
		GridPane.setConstraints(labelMonth, 1, 4);
		
		TextField month = new TextField();
		month.setPromptText("Enter Month");
		month.setMaxSize(300, 100);;
		GridPane.setConstraints(month, 2, 4);
		
		Label labelDay = new Label("Enter the Day:");
		labelDay.setMaxSize(300, 200);
		labelDay.setStyle(labelStyle);
		GridPane.setConstraints(labelDay, 1, 5);
		
		TextField day = new TextField();
		day.setPromptText("Enter Day");
		day.setMaxSize(300, 100);;
		GridPane.setConstraints(day, 2, 5);
		
		Button removeEntry = new Button("Click To Remove Entry");
		String entryStyles = "-fx-background-color: #D3D3D3;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		removeEntry.setStyle(entryStyles);
		removeEntry.setMaxWidth(300);
		removeEntry.setMaxHeight(200);
		GridPane.setConstraints(removeEntry, 2, 7);
		removeEntry.setOnAction(e -> window.setScene(returnScene));
		
		Button returnEdit = new Button("Return to Edit Menu");
		returnEdit.setStyle(styles);
		returnEdit.setMaxWidth(300);
		returnEdit.setMaxHeight(200);
		GridPane.setConstraints(returnEdit, 2, 8);
		returnEdit.setOnAction(e -> window.setScene(returnScene));
		
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 2, 9);
		returnHome.setOnAction(e -> window.setScene(main));
		
		grid.getChildren().addAll(farmID, year, month, day, removeEntry, returnEdit, 
				returnHome, label, labelFarm, labelYear, labelMonth, labelDay);
		window.setScene(scene);
		window.show();
	}
	
	/**
	 * 
	 * @param grid
	 * @param scene
	 * @param styles
	 * @param returnScene
	 */
	private void changeData(GridPane grid, Scene scene, String styles, 
			Scene returnScene) {
		
		String labelStyle = "-fx-font: bold italic 10pt \"Arial\";";
		
		Label label = new Label("Change An Existing Milk Entry");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 2, 1);
		
		Label labelFarm = new Label("Enter the Farm ID:");
		labelFarm.setMaxSize(300, 200);
		labelFarm.setStyle(labelStyle);
		GridPane.setConstraints(labelFarm, 1, 2);
		
		TextField farmID = new TextField();
		farmID.setPromptText("Enter Farm ID");
		farmID.setMaxSize(300, 100);;
		GridPane.setConstraints(farmID, 2, 2);
		
		Label labelYear = new Label("Enter the Year:");
		labelYear.setMaxSize(300, 200);
		labelYear.setStyle(labelStyle);
		GridPane.setConstraints(labelYear, 1, 3);
		
		TextField year = new TextField();
		year.setPromptText("Enter Year");
		year.setMaxSize(300, 100);;
		GridPane.setConstraints(year, 2, 3);
		
		Label labelMonth = new Label("Enter the Month:");
		labelMonth.setMaxSize(300, 200);
		labelMonth.setStyle(labelStyle);
		GridPane.setConstraints(labelMonth, 1, 4);
		
		TextField month = new TextField();
		month.setPromptText("Enter Month");
		month.setMaxSize(300, 100);;
		GridPane.setConstraints(month, 2, 4);
		
		Label labelDay = new Label("Enter the Day:");
		labelDay.setMaxSize(300, 200);
		labelDay.setStyle(labelStyle);
		GridPane.setConstraints(labelDay, 1, 5);
		
		TextField day = new TextField();
		day.setPromptText("Enter Day");
		day.setMaxSize(300, 100);;
		GridPane.setConstraints(day, 2, 5);
		
		Label labelWeight = new Label("Enter A New Milk Weight:");
		labelWeight.setMaxSize(300, 200);
		labelWeight.setStyle(labelStyle);
		GridPane.setConstraints(labelWeight, 1, 6);
		
		TextField weight = new TextField();
		weight.setPromptText("Enter Milk Weight");
		weight.setMaxSize(300, 100);
		GridPane.setConstraints(weight, 2, 6);
		
		Button changeEntry = new Button("Click To Change An Entry");
		String entryStyles = "-fx-background-color: #D3D3D3;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		changeEntry.setStyle(entryStyles);
		changeEntry.setMaxWidth(300);
		changeEntry.setMaxHeight(200);
		GridPane.setConstraints(changeEntry, 2, 7);
		changeEntry.setOnAction(e -> window.setScene(returnScene));
		
		Button returnEdit = new Button("Return to Edit Menu");
		returnEdit.setStyle(styles);
		returnEdit.setMaxWidth(300);
		returnEdit.setMaxHeight(200);
		GridPane.setConstraints(returnEdit, 2, 8);
		returnEdit.setOnAction(e -> window.setScene(returnScene));
		
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 2, 9);
		returnHome.setOnAction(e -> window.setScene(main));
		
		grid.getChildren().addAll(farmID, year, month, day, weight, changeEntry, returnEdit,
				returnHome, label, labelFarm, labelYear, labelMonth, labelDay, labelWeight);
		window.setScene(scene);
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

