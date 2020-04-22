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
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainGUI extends Application {
	private Stage window; //The main window
	private Scene main; //The main menu scene
	private boolean buttonPressedAdd = false; //Checks if the add data was pressed
	private boolean buttonPressedRemove = false; //Checks if the remove data was pressed
	private boolean uploaded = false; //Checks if the upload button was pressed
	
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
		
		//When display button is pressed, the displayOptions method is called 
		displayData.setOnAction(e -> displayOptions(displayGrid, displayScene));
		
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
		
		//When button is pressed user must be able to select file 
        fileSelect.setOnAction(e -> {
        	
        	//Allows user to select a file
        	File selectedFile = fileChooser.showOpenDialog(window);
        	
        	//Checks if the user selected a file
        	if(selectedFile != null) {
        		
        		//If a user selected a file then allow the user to upload it
        		String entryStyles = "-fx-background-color: #7CFC00;" +
        				"-fx-font: bold italic 15pt \"Arial\";";
        		
        		//Creates a new button that allows the user to upload their file
        		Button fileHolder = new Button("Click to Upload " + selectedFile.getName());
        		fileHolder.setMaxSize(500, 200);
        		fileHolder.setStyle(entryStyles);
        		fileHolder.setEffect(new DropShadow());
        		GridPane.setConstraints(fileHolder, 5, 3);
        		
        		//Sets the button at column 5, row 4
        		GridPane.setConstraints(returnHome, 5, 4);
        		
        		//Creates a new confirmation window
        		GridPane confirm = new GridPane();
        		confirm.setPadding(new Insets(80, 40, 80, 40));
        		confirm.setVgap(25);
        		confirm.setHgap(30);
        		
        		//Creates a new confirmation scene
        		Scene confirmScene = new Scene(confirm, 600, 500);
        		
        		//When the upload button is pressed, the confirmation method is called
        		fileHolder.setOnAction(newEvent -> confirmation(confirm, confirmScene, styles, "upload"));
        		
        		//Sets the uploaded variable to true
        		this.uploaded = true;
        		
        		//adds the fileHolder button to the grid
        		grid.getChildren().addAll(fileHolder);
        		
        	} 
        });
        
        //Adds all the buttons and labels to the grid
        grid.getChildren().addAll(fileSelect, label, returnHome);
	}

	/**
	 * This method is used to edit data and call the add data, remove data, and
	 * change data methods
	 * @param grid the current grid
	 * @param scene the current scene
	 */
	private void editData(GridPane grid, Scene scene) {
		
		//Creates a new addGrid if user selects to add Data
		GridPane addGrid = new GridPane();
		addGrid.setPadding(new Insets(80, 40, 80, 40));
		addGrid.setVgap(10);
		addGrid.setHgap(30);
		addGrid.setStyle("-fx-background-color: #F0F8FF");
		
		//Creates a new addScene
		Scene addScene = new Scene(addGrid, 600, 500);
		
		//Creates a new removeGrid if user selects to remove Data
		GridPane removeGrid = new GridPane();
		removeGrid.setPadding(new Insets(80, 40, 80, 40));
		removeGrid.setVgap(10);
		removeGrid.setHgap(30);
		removeGrid.setStyle("-fx-background-color: #F0F8FF");
		
		//Create a new removeScene
		Scene removeScene = new Scene(removeGrid, 600, 500);
		
		//Creates a new changeGrid if user selects to changeData
		GridPane changeGrid = new GridPane();
		changeGrid.setPadding(new Insets(80, 40, 80, 40));
		changeGrid.setVgap(10);
		changeGrid.setHgap(30);
		changeGrid.setStyle("-fx-background-color: #F0F8FF");
		
		//Create a new changeScene
		Scene changeScene = new Scene(changeGrid, 600, 500);
		
		String styles = "-fx-background-color: #00BFFF;" + "-fx-border-color: #008B8B;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		
		String labelStyle = "-fx-font: bold italic 15pt \"Arial\";";
		
		//Label for the edit window
		Label label = new Label("Choose what you would like to do:");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 3, 1);
		
		//Button that allows user to add data
		Button addData = new Button("Add Data");
		addData.setStyle(styles);
		addData.setEffect(new DropShadow());
		addData.setMaxWidth(400);
		addData.setMaxHeight(200);
		GridPane.setConstraints(addData, 3, 2);
		
		//Button that allows user to remove data
		Button removeData = new Button("Remove Data");
		removeData.setStyle(styles);
		removeData.setEffect(new DropShadow());
		removeData.setMaxWidth(400);
		removeData.setMaxHeight(200);
		GridPane.setConstraints(removeData, 3, 3);
		
		//Button that allows user to change data
		Button changeData = new Button("Change Data");
		changeData.setStyle(styles);
		changeData.setEffect(new DropShadow());
		changeData.setMaxWidth(400);
		changeData.setMaxHeight(200);
		GridPane.setConstraints(changeData, 3, 4);
		
		//Button that allows user to return back to the main menu
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setEffect(new DropShadow());
		returnHome.setMaxWidth(400);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 3, 5);
		
		//When pressed, the button sets the scene back to the main scene
		returnHome.setOnAction(e -> window.setScene(main));
		
		//Adds all the buttons and labels to the grid
		grid.getChildren().addAll(label, addData, removeData, changeData, returnHome);
		window.setScene(scene);
		window.show();
		
		//When add data is selected, the addData method is called
		addData.setOnAction(e -> addData(addGrid, addScene, styles, scene));
		
		//When remove data is selected, the removeData method is called
		removeData.setOnAction(e -> removeData(removeGrid, removeScene, styles, scene));
		
		//When change data is selected, the changeData method is called
		changeData.setOnAction(e -> changeData(changeGrid, changeScene, styles, scene));
	}
	
	/**
	 * This method is used to add data to the list of current data and takes using
	 * farm id, year, month, day, and milk weight
	 * @param grid the current grid
	 * @param scene the current scene
	 * @param styles the commons styles used for buttons
	 * @param returnScene the scene used in the edit menu
	 */
	private void addData(GridPane grid, Scene scene, String styles,
			Scene returnScene) {
		
		//Label for the addData window
		String labelStyle = "-fx-font: bold italic 10pt \"Arial\";";
		
		//Creates a title for the window
		Label label = new Label("Add A New Milk Entry");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 2, 1);
		
		//Creates a label to show where to enter farm id
		Label labelFarm = new Label("Enter the Farm ID:");
		labelFarm.setMaxSize(300, 200);
		labelFarm.setStyle(labelStyle);
		GridPane.setConstraints(labelFarm, 1, 2);
		
		//Creates a text box for the user to enter a farm id
		TextField farmID = new TextField();
		
		//Text inside the box already and disappears when box is selected
		farmID.setPromptText("Enter Farm ID");
		farmID.setMaxSize(300, 100);;
		GridPane.setConstraints(farmID, 2, 2);
		
		//Creates a label to show where to enter year
		Label labelYear = new Label("Enter the Year:");
		labelYear.setMaxSize(300, 200);
		labelYear.setStyle(labelStyle);
		GridPane.setConstraints(labelYear, 1, 3);
		
		//Creates a text box for the user to enter a year
		TextField year = new TextField();
		year.setPromptText("Enter Year");
		year.setMaxSize(300, 100);;
		GridPane.setConstraints(year, 2, 3);
		
		//Label used to show user where to enter month
		Label labelMonth = new Label("Enter the Month:");
		labelMonth.setMaxSize(300, 200);
		labelMonth.setStyle(labelStyle);
		GridPane.setConstraints(labelMonth, 1, 4);
		
		//Creates a text box for the user to enter a month
		TextField month = new TextField();
		month.setPromptText("Enter Month");
		month.setMaxSize(300, 100);;
		GridPane.setConstraints(month, 2, 4);
		
		//Label used to show user where to enter day
		Label labelDay = new Label("Enter the Day:");
		labelDay.setMaxSize(300, 200);
		labelDay.setStyle(labelStyle);
		GridPane.setConstraints(labelDay, 1, 5);
		
		//Creates a text box for the user to enter a day
		TextField day = new TextField();
		day.setPromptText("Enter Day");
		day.setMaxSize(300, 100);;
		GridPane.setConstraints(day, 2, 5);
		
		//Label used to show where to enter milk weight
		Label labelWeight = new Label("Enter the Milk Weight:");
		labelWeight.setMaxSize(300, 200);
		labelWeight.setStyle(labelStyle);
		GridPane.setConstraints(labelWeight, 1, 6);
		
		//Creates a text box for the user to enter a weight
		TextField weight = new TextField();
		weight.setPromptText("Enter Milk Weight");
		weight.setMaxSize(300, 100);
		GridPane.setConstraints(weight, 2, 6);
		
		//Creates a new addEntry button that is used to allow the user to add their entry
		Button addEntry = new Button("Click To Add Entry");
		String entryStyles = "-fx-background-color: #D3D3D3;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		addEntry.setStyle(entryStyles);
		addEntry.setMaxWidth(300);
		addEntry.setMaxHeight(200);
		
		//Sets the button at column 2, row 7
		GridPane.setConstraints(addEntry, 2, 7);
			
		//When the button is pressed
		addEntry.setOnAction(e -> {
			
			//Check the farmID, year, month, day, and weight the user entered
			if(farmID.getText().equals("00700") && year.getText().equals("2019")
				&& month.getText().equals("March")&& day.getText().equals("15") 
				&& weight.getText().equals("5.5")) {
				
				//If it is the specified input set buttonPressedAdd to true
					this.buttonPressedAdd = true;
					
					//Create a new add grid to show confirmation
					GridPane newAddGrid = new GridPane();
					newAddGrid.setPadding(new Insets(80, 40, 80, 40));
					newAddGrid.setVgap(10);
					newAddGrid.setHgap(30);
					newAddGrid.setStyle("-fx-background-color: #F0F8FF");
					
					//Create a new confirmation scene
					Scene confirmationScene = new Scene(newAddGrid, 600, 500);
					
					//Call the confirmation method with newAddGrid and confirmation scene
					//with the add action
					confirmation(newAddGrid, confirmationScene, styles, "add");
				}
						
		});
		
		//Button used to return to the edit menu
		Button returnEdit = new Button("Return to Edit Menu");
		returnEdit.setStyle(styles);
		returnEdit.setMaxWidth(300);
		returnEdit.setMaxHeight(200);
		GridPane.setConstraints(returnEdit, 2, 8);
		
		//When pressed, sends the user back to the edit scene
		returnEdit.setOnAction(e -> window.setScene(returnScene));
		
		//Button used to return to the main menu
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 2, 9);
		returnHome.setOnAction(e -> window.setScene(main));
		
		//Adds all the labels, textboxes, and buttons to the grid
		grid.getChildren().addAll(farmID, year, month, day, weight, addEntry, returnEdit, 
				returnHome, labelFarm, labelYear, labelMonth, labelDay, labelWeight, label);
		window.setScene(scene);
		window.show();
	}
	
	/**
	 * This method is used as a confirmation screen to show an action has been done
	 * @param grid the current grid
	 * @param scene the current scene
	 * @param styles the set of common styes used throughout the program
	 * @param action the action that was done
	 */
	private void confirmation(GridPane grid, Scene scene, String styles, String action) {
		String labelStyle = "-fx-font: bold italic 10pt \"Arial\";";
		
		//If the action was to add data
		if(action.equals("add")){
			
			//Show the specific message for added data
			Label label = new Label("Your entry has been added, confirm in Display Data");
			label.setMaxSize(500, 200);
			label.setStyle(labelStyle);
			GridPane.setConstraints(label, 4, 1);
			grid.getChildren().add(label);
		}
		
		//If the action was to remove data 
		if(action.equals("remove")) {
			
			//Show the specific message for remove data
			Label label = new Label("Your entry has been removed, confirm in Display Data");
			label.setMaxSize(500, 200);
			label.setStyle(labelStyle);
			GridPane.setConstraints(label, 4, 1);
			grid.getChildren().add(label);
		}
		
		//If the action was to upload a file
		if(action.equals("upload")) {
			
			//Show the specific message for added file
			Label label = new Label("Your file has been uploaded, confirm in Display Data");
			label.setMaxSize(500, 200);
			label.setStyle(labelStyle);
			GridPane.setConstraints(label, 4, 1);
			grid.getChildren().add(label);
		}
		
		//Button used to return back to the main menu
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 4, 2);
		returnHome.setOnAction(e -> window.setScene(main));
		
		//Adds the button to the grid
		grid.getChildren().addAll(returnHome);
		
		window.setScene(scene);
		window.show();
	}
	
	/**
	 * Private helper method to see if the added entry was valid
	 * @return true if valid and false if not
	 */
	private boolean addEntry() {
		
		//Checks if the buttonPressedAdd was pressed
		if(buttonPressedAdd == true) {
			
			//sets it to false
			buttonPressedAdd = false;
			
			//returns true
			return true;
		}
		
		
		return false;
	}
	
	/**
	 * Private helper method used to check if a remove entry was valid
	 * @return true if valid and false if not
	 */
	private boolean removeEntry() {
		
		//Checks if the button was pressed and was valid
		if(buttonPressedRemove == true) {
			
			//If valid set remove and add to false
			buttonPressedRemove = false;
			buttonPressedAdd = false;
			
			//Return true
			return true;
		}
		
		
		return false;
	}

	/**
	 * This method is used to remove data from the list of data with input from the user
	 * for what farm id, year, month, and day of the entry to remove
	 * @param grid the current grid
	 * @param scene the current scene
	 * @param styles the common styles throughout the program
	 * @param returnScene the edit scene menu
	 */
	private void removeData(GridPane grid, Scene scene, String styles, Scene returnScene) {
		String labelStyle = "-fx-font: bold italic 10pt \"Arial\";";
		
		//Creates a title for the window
		Label label = new Label("Remove An Existing Milk Entry");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 2, 1);
		
		//Creates a label to show user where to enter farm id
		Label labelFarm = new Label("Enter the Farm ID:");
		labelFarm.setMaxSize(300, 200);
		labelFarm.setStyle(labelStyle);
		GridPane.setConstraints(labelFarm, 1, 2);
		
		//Text box used for user to input farm id
		TextField farmID = new TextField();
		farmID.setPromptText("Enter Farm ID");
		farmID.setMaxSize(300, 100);;
		GridPane.setConstraints(farmID, 2, 2);
		
		//Label used to show user where to enter year
		Label labelYear = new Label("Enter the Year:");
		labelYear.setMaxSize(300, 200);
		labelYear.setStyle(labelStyle);
		GridPane.setConstraints(labelYear, 1, 3);
		
		//Text box used for user to enter year
		TextField year = new TextField();
		year.setPromptText("Enter Year");
		year.setMaxSize(300, 100);;
		GridPane.setConstraints(year, 2, 3);
		
		//Label used to show user where to enter month
		Label labelMonth = new Label("Enter the Month:");
		labelMonth.setMaxSize(300, 200);
		labelMonth.setStyle(labelStyle);
		GridPane.setConstraints(labelMonth, 1, 4);
		
		//Text box used for user to enter year
		TextField month = new TextField();
		month.setPromptText("Enter Month");
		month.setMaxSize(300, 100);;
		GridPane.setConstraints(month, 2, 4);
		
		//Label used to show user where to enter day
		Label labelDay = new Label("Enter the Day:");
		labelDay.setMaxSize(300, 200);
		labelDay.setStyle(labelStyle);
		GridPane.setConstraints(labelDay, 1, 5);
		
		//Text box used for user to enter day
		TextField day = new TextField();
		day.setPromptText("Enter Day");
		day.setMaxSize(300, 100);;
		GridPane.setConstraints(day, 2, 5);
		
		//Button that allows the user to remove the entry given the users inputs
		Button removeEntry = new Button("Click To Remove Entry");
		String entryStyles = "-fx-background-color: #D3D3D3;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		removeEntry.setStyle(entryStyles);
		removeEntry.setMaxWidth(300);
		removeEntry.setMaxHeight(200);
		GridPane.setConstraints(removeEntry, 2, 7);
		
		//If the button is clicked
		removeEntry.setOnAction(e -> {
			
			//Check if the specified values were entered correctly
			if(farmID.getText().equals("00700") && year.getText().equals("2019")
				&& month.getText().equals("March")&& day.getText().equals("15")) {
					
					//Sets the buttonPressedRemove to true
					this.buttonPressedRemove = true;
					
					//Creates a new grid for the confirmation method
					GridPane newRemoveGrid = new GridPane();
					newRemoveGrid.setPadding(new Insets(80, 40, 80, 40));
					newRemoveGrid.setVgap(10);
					newRemoveGrid.setHgap(30);
					newRemoveGrid.setStyle("-fx-background-color: #F0F8FF");
					
					//Creates a new confirmation scene
					Scene confirmationScene = new Scene(newRemoveGrid, 600, 500);
					
					//Calls the confirmation method with the action remove
					confirmation(newRemoveGrid, confirmationScene, styles, "remove");
				}
						
		});
		
		//Button used to return back to the edit menu
		Button returnEdit = new Button("Return to Edit Menu");
		returnEdit.setStyle(styles);
		returnEdit.setMaxWidth(300);
		returnEdit.setMaxHeight(200);
		GridPane.setConstraints(returnEdit, 2, 8);
		
		//Returns when clicked
		returnEdit.setOnAction(e -> window.setScene(returnScene));
		
		//Button used to return back to the main menu
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 2, 9);
		
		//Returns when clicked
		returnHome.setOnAction(e -> window.setScene(main));
		
		//Adds the text boxes, buttons, and labels to the grid
		grid.getChildren().addAll(farmID, year, month, day, removeEntry, returnEdit, 
				returnHome, label, labelFarm, labelYear, labelMonth, labelDay);
		window.setScene(scene);
		window.show();
	}
	
	/**
	 * This method is used to change data within the given list given the farm id
	 * year, month, day, and new weight of the changed entry
	 * @param grid the current grid
	 * @param scene the current scene
	 * @param styles the common styles throughout the program
	 * @param returnScene the edit scene menu
	 */
	private void changeData(GridPane grid, Scene scene, String styles, 
			Scene returnScene) {
		
		String labelStyle = "-fx-font: bold italic 10pt \"Arial\";";
		
		//Label for the title of the window
		Label label = new Label("Change An Existing Milk Entry");
		label.setMaxSize(500, 200);
		label.setStyle(labelStyle);
		GridPane.setConstraints(label, 2, 1);
		
		//The label used to show user where to enter farm id
		Label labelFarm = new Label("Enter the Farm ID:");
		labelFarm.setMaxSize(300, 200);
		labelFarm.setStyle(labelStyle);
		GridPane.setConstraints(labelFarm, 1, 2);
		
		//The text box for user to enter farm id
		TextField farmID = new TextField();
		farmID.setPromptText("Enter Farm ID");
		farmID.setMaxSize(300, 100);;
		GridPane.setConstraints(farmID, 2, 2);
		
		//The label used to show user where to enter year
		Label labelYear = new Label("Enter the Year:");
		labelYear.setMaxSize(300, 200);
		labelYear.setStyle(labelStyle);
		GridPane.setConstraints(labelYear, 1, 3);
		
		//The text box for user to enter year
		TextField year = new TextField();
		year.setPromptText("Enter Year");
		year.setMaxSize(300, 100);;
		GridPane.setConstraints(year, 2, 3);
		
		//The label used to show user where to enter the month
		Label labelMonth = new Label("Enter the Month:");
		labelMonth.setMaxSize(300, 200);
		labelMonth.setStyle(labelStyle);
		GridPane.setConstraints(labelMonth, 1, 4);
		
		//The text box used for user to enter month
		TextField month = new TextField();
		month.setPromptText("Enter Month");
		month.setMaxSize(300, 100);;
		GridPane.setConstraints(month, 2, 4);
		
		//The label to show the user where to enter the day
		Label labelDay = new Label("Enter the Day:");
		labelDay.setMaxSize(300, 200);
		labelDay.setStyle(labelStyle);
		GridPane.setConstraints(labelDay, 1, 5);
		
		//The text box for the user to enter the day
		TextField day = new TextField();
		day.setPromptText("Enter Day");
		day.setMaxSize(300, 100);;
		GridPane.setConstraints(day, 2, 5);
		
		//Label used for weight
		Label labelWeight = new Label("Enter A New Milk Weight:");
		labelWeight.setMaxSize(300, 200);
		labelWeight.setStyle(labelStyle);
		GridPane.setConstraints(labelWeight, 1, 6);
		
		//Text box for user to enter the new milk weight
		TextField weight = new TextField();
		weight.setPromptText("Enter Milk Weight");
		weight.setMaxSize(300, 100);
		GridPane.setConstraints(weight, 2, 6);
		
		//Button to allow user to change an entry when all inputs are put in
		Button changeEntry = new Button("Click To Change An Entry");
		String entryStyles = "-fx-background-color: #D3D3D3;" +
				"-fx-font: bold italic 15pt \"Arial\";";
		changeEntry.setStyle(entryStyles);
		changeEntry.setMaxWidth(300);
		changeEntry.setMaxHeight(200);
		GridPane.setConstraints(changeEntry, 2, 7);
		
		//Button to return to the edit menu
		Button returnEdit = new Button("Return to Edit Menu");
		returnEdit.setStyle(styles);
		returnEdit.setMaxWidth(300);
		returnEdit.setMaxHeight(200);
		GridPane.setConstraints(returnEdit, 2, 8);
		returnEdit.setOnAction(e -> window.setScene(returnScene));
		
		//BUtton to return to the main menu
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setStyle(styles);
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		GridPane.setConstraints(returnHome, 2, 9);
		returnHome.setOnAction(e -> window.setScene(main));
		
		//Adds all the text boxes, labels, and buttons to the grid
		grid.getChildren().addAll(farmID, year, month, day, weight, changeEntry, returnEdit,
				returnHome, label, labelFarm, labelYear, labelMonth, labelDay, labelWeight);
		window.setScene(scene);
		window.show();
	}

	/**

	 * 

	 * @param grid

	 * @param scene

	 */

	private void displayOptions(GridPane grid, Scene scene) {

		GridPane farmReportGrid = new GridPane();

		farmReportGrid.setPadding(new Insets(80, 40, 80, 40));

		farmReportGrid.setVgap(10);

		farmReportGrid.setHgap(30);

		farmReportGrid.setStyle("-fx-background-color: #F0F8FF");

		

		Scene farmReportScene = new Scene(farmReportGrid, 600, 500);

		

		GridPane anualReportGrid = new GridPane();

		anualReportGrid.setPadding(new Insets(80, 40, 80, 40));

		anualReportGrid.setVgap(10);

		anualReportGrid.setHgap(30);

		anualReportGrid.setStyle("-fx-background-color: #F0F8FF");

		

		Scene anualReportScene = new Scene(anualReportGrid, 600, 500);

		

		GridPane monthlyReportGrid = new GridPane();

		monthlyReportGrid.setPadding(new Insets(80, 40, 80, 40));

		monthlyReportGrid.setVgap(10);

		monthlyReportGrid.setHgap(30);

		monthlyReportGrid.setStyle("-fx-background-color: #F0F8FF");

		

		Scene monthlyReportScene = new Scene(monthlyReportGrid, 600, 500);
		
		
		GridPane dateRangeReportGrid = new GridPane();

		dateRangeReportGrid.setPadding(new Insets(80, 40, 80, 40));

		dateRangeReportGrid.setVgap(10);

		dateRangeReportGrid.setHgap(30);

		dateRangeReportGrid.setStyle("-fx-background-color: #F0F8FF");

		

		Scene dateRangeReportScene = new Scene(dateRangeReportGrid, 600, 500);

		

		String styles = "-fx-background-color: #00BFFF;" + "-fx-border-color: #008B8B;" +

				"-fx-font: bold italic 15pt \"Arial\";";

		

		String labelStyle = "-fx-font: bold italic 15pt \"Arial\";";

		

		Label label = new Label("Choose a report type:");

		label.setMaxSize(500, 200);

		label.setStyle(labelStyle);

		GridPane.setConstraints(label, 3, 1);

		

		Button farmReport = new Button("Farm Report");

		farmReport.setStyle(styles);

		farmReport.setEffect(new DropShadow());

		farmReport.setMaxWidth(400);

		farmReport.setMaxHeight(200);

		GridPane.setConstraints(farmReport, 3, 2);

		

		Button anualReport = new Button("Anual Report");

		anualReport.setStyle(styles);

		anualReport.setEffect(new DropShadow());

		anualReport.setMaxWidth(400);

		anualReport.setMaxHeight(200);

		GridPane.setConstraints(anualReport, 3, 3);

		

		Button monthlyReport = new Button("Monthly Report");

		monthlyReport.setStyle(styles);

		monthlyReport.setEffect(new DropShadow());

		monthlyReport.setMaxWidth(400);

		monthlyReport.setMaxHeight(200);

		GridPane.setConstraints(monthlyReport, 3, 4);
		
		
		Button dateRangeReport = new Button("Date Range Report");

		dateRangeReport.setStyle(styles);

		dateRangeReport.setEffect(new DropShadow());

		dateRangeReport.setMaxWidth(400);

		dateRangeReport.setMaxHeight(200);

		GridPane.setConstraints(dateRangeReport, 3, 4);

		

		Button returnHome = new Button("Return to Main Menu");

		returnHome.setStyle(styles);

		returnHome.setEffect(new DropShadow());

		returnHome.setMaxWidth(400);

		returnHome.setMaxHeight(200);

		GridPane.setConstraints(returnHome, 3, 5);

		returnHome.setOnAction(e -> window.setScene(main));

		

		grid.getChildren().addAll(label, farmReport, anualReport, monthlyReport, dateRangeReport, returnHome);

		window.setScene(scene);

		window.show();

		

		farmReport.setOnAction(e -> getFarmReport());

		anualReport.setOnAction(e -> getAnualReport());

		monthlyReport.setOnAction(e -> getMonthlyReport());
		
		dateRangeReport.setOnAction(e -> getDateRangeReport());
	}

	public void getFarmReport() {

		//Sets a new grid for a potential new window when Farm Report is clicked
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(80, 40, 80, 40));
		grid.setVgap(25);
		grid.setHgap(30);
		grid.setStyle("-fx-background-color: #F0F8FF");
		
		//Sets a new scene if the Farm Report button is pushed
		Scene scene = new Scene(displayGrid, 600, 500);

		displayData(grid, scene);

	}
	
	public void getAnualReport() {

		//Sets a new grid for a potential new window when Anual Report is clicked
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(80, 40, 80, 40));
		grid.setVgap(25);
		grid.setHgap(30);
		grid.setStyle("-fx-background-color: #F0F8FF");
		
		//Sets a new scene if the Anual Report button is pushed
		Scene scene = new Scene(displayGrid, 600, 500);

		displayData(grid, scene);

	}
	
	public void getMonthlyReport() {

		//Sets a new grid for a potential new window when Monthly Report is clicked
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(80, 40, 80, 40));
		grid.setVgap(25);
		grid.setHgap(30);
		grid.setStyle("-fx-background-color: #F0F8FF");
		
		//Sets a new scene if the Montly Report button is pushed
		Scene scene = new Scene(displayGrid, 600, 500);

		displayData(grid, scene);

	}
	
	public void getDateRangeReport() {

		//Sets a new grid for a potential new window when Date Range Report is clicked
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(80, 40, 80, 40));
		grid.setVgap(25);
		grid.setHgap(30);
		grid.setStyle("-fx-background-color: #F0F8FF");
		
		//Sets a new scene if the Date Range Report button is pushed
		Scene scene = new Scene(displayGrid, 600, 500);

		displayData(grid, scene);

	}
	
	/**
	 * This method is used to display the list of data that was uploaded, added,
	 * removed, and changed
	 * @param grid the current grid
	 * @param scene the current scene
	 */
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
		
		//creates all of the different tree items and makes them children of year
		TreeView weights = new TreeView();
		
		//Checks if a file was uploaded
		if(uploaded == true) {
			
			//Adds all the specific tree items to the weights
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
			
			//Calls the milkweights method to get the specific data needed
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
			
			//When a new item is added
			TreeItem newAdd = new TreeItem();
			
			//Check if the add button was clicked
			if(addEntry() == true) {
				
				//Then add the specific value
				newAdd.setValue("2019-3-15,Farm 00700,Weight 5.5");
				
				//Add it to the weights
				mar.getChildren().add(newAdd);
			}
			
			//Check if the remove button was clicked
			if(removeEntry() == true) {
				
				//Then remove the specific value from the list
				newAdd.setValue(null);
				mar.getChildren().remove(newAdd);
			}
			
			
			weights.setRoot(year);
		}
		
		//Sets the weights to the 5th column, second row
		GridPane.setConstraints(weights, 5, 2);
		
		//Button used to return to the main menu
		Button returnHome = new Button("Return to Main Menu");
		returnHome.setMaxWidth(300);
		returnHome.setMaxHeight(200);
		returnHome.setStyle(styles);
		returnHome.setOnAction(e -> window.setScene(main));
		GridPane.setConstraints(returnHome, 5, 3);
		
		//Adds the weights, the buttons, and labels to the grid
		grid.getChildren().addAll(weights, returnHome,label);
		
		window.setScene(scene);
		window.show();
	}
	
	/**
	 * This method is used to get the specific milk weights as TreeItems
	 * @param month the month of the milk weight
	 * @return the inputs of the month
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TreeItem milkWeights(int month) {
		
		TreeItem jan = new TreeItem("2019-1-9,Farm 18789,Weight 5.3\r\n" + 
				"2019-1-9,Farm 23635,Weight 5.3\r\n" + 
				"2019-1-10,Farm 06796,Weight 5.3\r\n" + 
				"2019-1-10,Farm 18775,Weight 5.3\r\n" + 
				"2019-1-10,Farm 23377,Weight 5.3\r\n" + 
				"2019-1-11,Farm 06614,Weight 5.3");
		TreeItem feb = new TreeItem("2019-2-13,Farm 18809,Weight 5.3\r\n" + 
				"2019-2-13,Farm 23450,Weight 5.3\r\n" + 
				"2019-2-14,Farm 06818,Weight 5.3\r\n" + 
				"2019-2-14,Farm 18697,Weight 5.3\r\n" + 
				"2019-2-14,Farm 23560,Weight 5.3\r\n" + 
				"2019-2-15,Farm 06801,Weight 5.3");
		TreeItem mar = new TreeItem("2019-3-6,Farm 23550\r\n" + 
				"2019-3-7,Farm 06780,Weight 5.3\r\n" + 
				"2019-3-7,Farm 18602,Weight 5.3\r\n" + 
				"2019-3-7,Farm 23522,Weight 5.3\r\n" + 
				"2019-3-8,Farm 06894,Weight 5.3\r\n" + 
				"2019-3-8,Farm 18837,Weight 5.3");
		TreeItem apr = new TreeItem("2019-4-8,Farm 06617,Weight 5.3\r\n" + 
				"2019-4-8,Farm 18672,Weight 5.3\r\n" + 
				"2019-4-8,Farm 23549,Weight 5.3\r\n" + 
				"2019-4-9,Farm 06763,Weight 5.3\r\n" + 
				"2019-4-9,Farm 18797,Weight 5.3\r\n" + 
				"2019-4-9,Farm 23597,Weight 5.3");
		TreeItem may = new TreeItem("2019-5-3,Farm 06737,Weight 5.3\r\n" + 
				"2019-5-3,Farm 18825,Weight 5.3\r\n" + 
				"2019-5-3,Farm 23468,Weight 5.3\r\n" + 
				"2019-5-4,Farm 06746,Weight 5.3\r\n" + 
				"2019-5-4,Farm 18604,Weight 5.3\r\n" + 
				"2019-5-4,Farm 23475,Weight 5.3");
		TreeItem jun = new TreeItem("2019-6-29,Farm 06893,Weight 5.3\r\n" + 
				"2019-6-29,Farm 18764,Weight 5.3\r\n" + 
				"2019-6-29,Farm 23479,Weight 5.3\r\n" + 
				"2019-6-30,Farm 06694,Weight 5.3\r\n" + 
				"2019-6-30,Farm 18735,Weight 5.3\r\n" + 
				"2019-6-30,Farm 23561,Weight 5.3");
		TreeItem jul = new TreeItem("2019-7-3,Farm 23536,Weight 5.3\r\n" + 
				"2019-7-4,Farm 06719,Weight 5.3\r\n" + 
				"2019-7-4,Farm 18828,Weight 5.3\r\n" + 
				"2019-7-4,Farm 23480,Weight 5.3\r\n" + 
				"2019-7-5,Farm 06815,Weight 5.3\r\n" + 
				"2019-7-5,Farm 18629,Weight 5.3");
		TreeItem aug = new TreeItem("2019-8-26,Farm 23427,Weight 5.3\r\n" + 
				"2019-8-27,Farm 06722,Weight 5.3\r\n" + 
				"2019-8-27,Farm 18681,Weight 5.3\r\n" + 
				"2019-8-27,Farm 23486,Weight 5.3\r\n" + 
				"2019-8-28,Farm 06780,Weight 5.3\r\n" + 
				"2019-8-28,Farm 18778,Weight 5.3");
		TreeItem sep = new TreeItem("2019-9-5,Farm 06767,Weight 5.3\r\n" + 
				"2019-9-5,Farm 18726,Weight 5.3\r\n" + 
				"2019-9-5,Farm 23614,Weight 5.3\r\n" + 
				"2019-9-6,Farm 06846,Weight 5.3\r\n" + 
				"2019-9-6,Farm 18682,Weight 5.3\r\n" + 
				"2019-9-6,Farm 23589,Weight 5.3");
		TreeItem oct = new TreeItem("2019-10-16,Farm 23560,Weight 5.3\r\n" + 
				"2019-10-17,Farm 06647,Weight 5.3\r\n" + 
				"2019-10-17,Farm 18787,Weight 5.3\r\n" + 
				"2019-10-17,Farm 23477,Weight 5.3\r\n" + 
				"2019-10-18,Farm 06866,Weight 5.3\r\n" + 
				"2019-10-18,Farm 18776,Weight 5.3");
		TreeItem nov = new TreeItem("2019-11-16,Farm 23505\r\n" + 
				"2019-11-17,Farm 06630,Weight 5.3\r\n" + 
				"2019-11-17,Farm 18796,Weight 5.3\r\n" + 
				"2019-11-17,Farm 23394,Weight 5.3\r\n" + 
				"2019-11-18,Farm 06770,Weight 5.3\r\n" + 
				"2019-11-18,Farm 18684,Weight 5.3");
		TreeItem dec = new TreeItem("2019-12-23,Farm 23400,Weight 5.3\r\n" + 
				"2019-12-24,Farm 06797,Weight 5.3\r\n" + 
				"2019-12-24,Farm 18698,Weight 5.3\r\n" + 
				"2019-12-24,Farm 23447,Weight 5.3\r\n" + 
				"2019-12-25,Farm 06755,Weight 5.3\r\n" + 
				"2019-12-25,Farm 18720,Weight 5.3");
		
		
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

