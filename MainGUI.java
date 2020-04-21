package application;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
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
		
		//Sets a new grid for a potential new window when display data is clicked
		GridPane displayGrid = new GridPane();
		displayGrid.setPadding(new Insets(80, 40, 80, 40));
		displayGrid.setVgap(25);
		displayGrid.setHgap(30);
		displayGrid.setStyle("-fx-background-color: #F0F8FF");
		
		//Sets a new scene if the display button is pushed
		Scene displayScene = new Scene(displayGrid, 600, 500);
		
		//Common styles for the buttons and labels with bold arial font and blue color
		String styles = "-fx-background-color: #00BFFF;" + "-fx-border-color: #008B8B;" + "-fx-font-size: 2em;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		String labelStyle = "-fx-font: bold italic 15pt \"Arial\";" + "-fx-font-size: 2em;";
		
		//Creates a new title label at the top of the main menu
		Label label = new Label("Milk Organizer Dashboard");
		label.setMaxSize(600, 300);
		label.setStyle(labelStyle);
		
		//Sets it to the 6th column and 1st row of the grid
		GridPane.setConstraints(label, 6, 1);
		
		//Creates a button that is used to upload files
		Button uploadData = new Button("Upload Data File");
		uploadData.setMaxSize(500, 200);
		uploadData.setStyle(styles);
		uploadData.setEffect(new DropShadow());
		
		//Button is in the 6th column and 2nd row
		GridPane.setConstraints(uploadData, 6, 2);
		
		//When the button is pressed, the uploadData method will be initiated
		uploadData.setOnAction(e -> uploadData(uploadGrid, uploadScene));
		
		//Creates a new button that is used to edit data
		Button editData = new Button("Edit Data");
		editData.setStyle(styles);
		editData.setEffect(new DropShadow());
		editData.setMaxWidth(500);
		editData.setMaxHeight(200);
		
		//Button is in the 6th column, 3rd row
		GridPane.setConstraints(editData, 6, 3);
		
		//When button is pressed, the editData method is called with the previous editGrid and the scene
		//incorporating editGrid
		editData.setOnAction(e -> editData(editGrid, scene2));
		
		//Creates a button that displays the data 
		Button displayData = new Button("Display Data");
		displayData.setStyle(styles);
		displayData.setEffect(new DropShadow());
		displayData.setMaxSize(500, 200);
		
		
		GridPane.setConstraints(displayData, 6, 4);
		
		//When display button is pressed, the displayData method is called 
		displayData.setOnAction(e -> displayData(displayGrid, displayScene));
		
		//Adds all the buttons and labels to the grid
		grid.getChildren().addAll(label, uploadData, editData, displayData);
		
		//Sets the background of the grid to light blue
		grid.setStyle("-fx-background-color: #F0F8FF");
		
		//Gives the grid shadow effect
		grid.setEffect(new DropShadow());
		
		//Creates the main scene with the main grid and a 600 / 500 window
		main = new Scene(grid, 600, 500);
		
		//Sets the scene of the stage to the main scene
		window.setScene(main);
		
		//Displays the window
		window.show();
		
		

	}
	
	/**
	 * This method is used when the upload button is pressed and a file needs to be uploaded
	 * @param grid the grid for the uploadData method (uploadGrid)
	 * @param scene the scene for the uploadData method (uploadScene)
	 */
	private void uploadData(GridPane grid, Scene scene) {
		
		//Common styles for the buttons and labels
		String styles = "-fx-background-color: #00BFFF;" + "-fx-border-color: #008B8B;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		
		String labelStyle = "-fx-font: bold italic 15pt \"Arial\";";
		
		//Creates a new label at the top of the screen 
		Label label = new Label("Upload a Data File:");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		
		//Places the label at 5th colum and 1st row
		GridPane.setConstraints(label, 5, 1);
		
		//Creates the window with the given scene
		window.setScene(scene);
		window.show();
		
		//File chooser used to allow user to choose a file 
		FileChooser fileChooser = new FileChooser();
		
		//The file chooser only takes in CSV files so extension filters allows only csv files
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
		 
		//Creates a new button to select a file
		Button fileSelect = new Button("Select A File");
		fileSelect.setMaxSize(500, 200);
		fileSelect.setStyle(styles);
		fileSelect.setEffect(new DropShadow());
		
		//Places button underneath label
		GridPane.setConstraints(fileSelect, 5, 2);
		
		//Creates a return home button that redirects to the main menu
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setEffect(new DropShadow());
		returnHome.setMaxSize(500, 200);
		
		//Button is placed underneath select file button
		GridPane.setConstraints(returnHome, 5, 3);
		
		//When the returnHome button is pressed, the user is redirected to the main scene
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
	
<<<<<<< HEAD
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayData(GridPane grid, Scene scene) {
		//Common styles for the buttons and labels
		String styles = "-fx-background-color: #00BFFF;" + "-fx-border-color: #008B8B;" +
						"-fx-font: bold italic 15pt \"Arial\";";
				
		String labelStyle = "-fx-font: bold italic 15pt \"Arial\";";
		
		//Creates a new label at the top of the screen 
		Label label = new Label("Available Data:");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
				
		//Places the label at 5th colum and 1st row
		GridPane.setConstraints(label, 5, 1);
		
=======
		public void displayData() {
		//creates the grid pane
		BorderPane displayBP= new BorderPane();
		displayBP.setStyle("-fx-background-color: #F0F8FF");
>>>>>>> 0ae60ec944d6e99421b50a2911ff34ed76ad7451
		//creates all of the different tree items and makes them children of year
		TreeView weights = new TreeView();
		TreeItem year= new TreeItem("2019");
		TreeItem jan= new TreeItem("January");
		TreeItem feb= new TreeItem("February");
		TreeItem mar= new TreeItem("March");
		TreeItem apr= new TreeItem("April");
		TreeItem may= new TreeItem("May");
		TreeItem jun= new TreeItem("June");
		TreeItem jul= new TreeItem("July");
		TreeItem aug= new TreeItem("August");
		TreeItem sep= new TreeItem("September");
		TreeItem oct= new TreeItem("Octover");
		TreeItem nov= new TreeItem("November");
		TreeItem dec= new TreeItem("December");
		year.getChildren().add(jan);
		year.getChildren().add(feb);
		year.getChildren().add(mar);
		year.getChildren().add(apr);
		year.getChildren().add(may);
		year.getChildren().add(jun);
		year.getChildren().add(jul);
		year.getChildren().add(aug);
		year.getChildren().add(sep);
		year.getChildren().add(oct);
		year.getChildren().add(nov);
		year.getChildren().add(dec);
		jan.getChildren().add(milkWeights(1));
		feb.getChildren().add(milkWeights(2));
		mar.getChildren().add(milkWeights(3));
		apr.getChildren().add(milkWeights(4));
		may.getChildren().add(milkWeights(5));
		jun.getChildren().add(milkWeights(6));
		jul.getChildren().add(milkWeights(7));
		aug.getChildren().add(milkWeights(8));
		sep.getChildren().add(milkWeights(9));
		oct.getChildren().add(milkWeights(10));
		nov.getChildren().add(milkWeights(11));
		dec.getChildren().add(milkWeights(12));
		
		weights.setRoot(year);
<<<<<<< HEAD
		GridPane.setConstraints(weights, 5, 2);
=======
>>>>>>> 0ae60ec944d6e99421b50a2911ff34ed76ad7451
		
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
<<<<<<< HEAD
		returnHome.setStyle(styles);
		returnHome.setOnAction(e -> window.setScene(main));
		GridPane.setConstraints(returnHome, 5, 3);
		
		grid.getChildren().addAll(weights, returnHome,label);
		
		window.setScene(scene);
		window.show();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
=======
		returnHome.setOnAction(e -> window.setScene(main));
		
		displayBP.setCenter(weights);
		displayBP.setBottom(returnHome);
		displayBP.setAlignment(returnHome, Pos.CENTER);
		//displayBP.setBottom();
		//sets a new scene for the display page
		Scene displayScene = new Scene(displayBP, 600, 500);
		
		
		window.setScene(displayScene);
		window.show();
	}
	
>>>>>>> 0ae60ec944d6e99421b50a2911ff34ed76ad7451
	public TreeItem milkWeights(int month) {
		
		TreeItem jan = new TreeItem("2019-1-9,Farm 1,8789\r\n" + 
				"2019-1-9,Farm 2,3635\r\n" + 
				"2019-1-10,Farm 0,6796\r\n" + 
				"2019-1-10,Farm 1,8775\r\n" + 
				"2019-1-10,Farm 2,3377\r\n" + 
				"2019-1-11,Farm 0,6614");
		TreeItem feb = new TreeItem("2019-2-13,Farm 1,8809\r\n" + 
				"2019-2-13,Farm 2,3450\r\n" + 
				"2019-2-14,Farm 0,6818\r\n" + 
				"2019-2-14,Farm 1,8697\r\n" + 
				"2019-2-14,Farm 2,3560\r\n" + 
				"2019-2-15,Farm 0,6801");
		TreeItem mar = new TreeItem("2019-3-6,Farm 2,3550\r\n" + 
				"2019-3-7,Farm 0,6780\r\n" + 
				"2019-3-7,Farm 1,8602\r\n" + 
				"2019-3-7,Farm 2,3522\r\n" + 
				"2019-3-8,Farm 0,6894\r\n" + 
				"2019-3-8,Farm 1,8837");
		TreeItem apr = new TreeItem("2019-4-8,Farm 0,6617\r\n" + 
				"2019-4-8,Farm 1,8672\r\n" + 
				"2019-4-8,Farm 2,3549\r\n" + 
				"2019-4-9,Farm 0,6763\r\n" + 
				"2019-4-9,Farm 1,8797\r\n" + 
				"2019-4-9,Farm 2,3597");
		TreeItem may = new TreeItem("2019-5-3,Farm 0,6737\r\n" + 
				"2019-5-3,Farm 1,8825\r\n" + 
				"2019-5-3,Farm 2,3468\r\n" + 
				"2019-5-4,Farm 0,6746\r\n" + 
				"2019-5-4,Farm 1,8604\r\n" + 
				"2019-5-4,Farm 2,3475");
		TreeItem jun = new TreeItem("2019-6-29,Farm 0,6893\r\n" + 
				"2019-6-29,Farm 1,8764\r\n" + 
				"2019-6-29,Farm 2,3479\r\n" + 
				"2019-6-30,Farm 0,6694\r\n" + 
				"2019-6-30,Farm 1,8735\r\n" + 
				"2019-6-30,Farm 2,3561");
		TreeItem jul = new TreeItem("2019-7-3,Farm 2,3536\r\n" + 
				"2019-7-4,Farm 0,6719\r\n" + 
				"2019-7-4,Farm 1,8828\r\n" + 
				"2019-7-4,Farm 2,3480\r\n" + 
				"2019-7-5,Farm 0,6815\r\n" + 
				"2019-7-5,Farm 1,8629");
		TreeItem aug = new TreeItem("2019-8-26,Farm 2,3427\r\n" + 
				"2019-8-27,Farm 0,6722\r\n" + 
				"2019-8-27,Farm 1,8681\r\n" + 
				"2019-8-27,Farm 2,3486\r\n" + 
				"2019-8-28,Farm 0,6780\r\n" + 
				"2019-8-28,Farm 1,8778");
		TreeItem sep = new TreeItem("2019-9-5,Farm 0,6767\r\n" + 
				"2019-9-5,Farm 1,8726\r\n" + 
				"2019-9-5,Farm 2,3614\r\n" + 
				"2019-9-6,Farm 0,6846\r\n" + 
				"2019-9-6,Farm 1,8682\r\n" + 
				"2019-9-6,Farm 2,3589");
		TreeItem oct = new TreeItem("2019-10-16,Farm 2,3560\r\n" + 
				"2019-10-17,Farm 0,6647\r\n" + 
				"2019-10-17,Farm 1,8787\r\n" + 
				"2019-10-17,Farm 2,3477\r\n" + 
				"2019-10-18,Farm 0,6866\r\n" + 
				"2019-10-18,Farm 1,8776");
		TreeItem nov = new TreeItem("2019-11-16,Farm 2,3505\r\n" + 
				"2019-11-17,Farm 0,6630\r\n" + 
				"2019-11-17,Farm 1,8796\r\n" + 
				"2019-11-17,Farm 2,3394\r\n" + 
				"2019-11-18,Farm 0,6770\r\n" + 
				"2019-11-18,Farm 1,8684");
		TreeItem dec = new TreeItem("2019-12-23,Farm 2,3400\r\n" + 
				"2019-12-24,Farm 0,6797\r\n" + 
				"2019-12-24,Farm 1,8698\r\n" + 
				"2019-12-24,Farm 2,3447\r\n" + 
				"2019-12-25,Farm 0,6755\r\n" + 
				"2019-12-25,Farm 1,8720");
		
		
		if(month == 1) {return jan;}
		if(month == 2) {return feb;}
		if(month == 3) {return mar;}
		if(month == 4) {return apr;}
		if(month == 5) {return may;}
		if(month == 6) {return jun;}
		if(month == 7) {return jul;}
		if(month == 8) {return aug;}
		if(month == 9) {return sep;}
		if(month == 10) {return oct;}
		if(month == 11) {return nov;}
		if(month == 12) {return dec;}
		
		return null;
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

