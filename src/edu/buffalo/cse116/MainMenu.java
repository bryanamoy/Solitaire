package edu.buffalo.cse116;

import java.util.List;

import javax.swing.ImageIcon;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.application.Application;
import javafx.application.Platform;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Skinnable;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Make a Gui class using the classes I made. 
 * 
 * End Result: Use the launch method within Main.java.
 * @author coreyalm
 * 
 * TODO:Draw a rectangle above the background color and put a black circle above rectangle FINISHED
 * TODO: Click button to switch to a different scene.
 * 
 * Defines a GUI application that includes the New Game menu with menu items to ... 
 * start a game of Freecell, 
 * start a game of Baker's Dozen, 
 * and Exit
 * 
 */
public class MainMenu extends Application {

	private double mainWidth = 900;
	private double mainHeight = 500;
	private SolitaireView view;
	private Stage stage;
	private static MediaPlayer mediaPlayer;

	//All gui code can be done within the start method
	@Override
	public void start(Stage mainWindow) throws Exception {

		stage = mainWindow;
		view = new SolitaireView();
		view.setCardImages("bakersdozen");
		
		Text text = new Text("Solitaire!");
		text.setFont(Font.font ("Verdana", 150));
		text.setFill(Color.ALICEBLUE);//
		
		Image image = new Image("http://i0.kym-cdn.com/photos/images/original/001/169/608/a43.gif", true);  								
		ImageView imageView =  view.displayImageViewOfCard(new Card(Suit.DIAMONDS,Rank.EIGHT));
		imageView.setFitHeight(150);
		imageView.setFitWidth(200);
		
		Media sound = new Media("http://www.mfiles.co.uk/mp3-downloads/gabriels-message-keyboard.mp3");
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
				mediaPlayer.seek(Duration.ZERO);
			}
		});
		mediaPlayer.play();

		BorderPane borderPane = new BorderPane();
		borderPane.getChildren().add(imageView);

		MenuItem bdMenuItm = new MenuItem("Baker's Dozen");
		bdMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	mediaPlayer.stop();
		    	changeScene(view.startBakersDozenGame());
		    }
		});
		
		MenuItem fcMenuItm = new MenuItem("Freecell");
		fcMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	mediaPlayer.stop();
		    	Freecell fc = new Freecell(8, 4, 4);
		    	changeScene(view.startfreeCellGame());
		    }
		});
		
		MenuItem quitMenuItm = new MenuItem("Quit");
		quitMenuItm.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//Closes the application
		    	Platform.exit();
		    }
		});

		Menu menu = new Menu("New Game");
		menu.getItems().addAll(bdMenuItm, fcMenuItm, quitMenuItm);
		MenuBar menuBar = new MenuBar(menu);
		menuBar.setPrefHeight(30);
		menuBar.prefWidthProperty().bind(mainWindow.widthProperty());

		borderPane.setCenter(text);
		borderPane.setBottom(menuBar);
		
		//Prepare a Scene with the required dimensions and add the scene graph (root node of the scene graph) to it.
		//This is basically the inside window.
		//Each scene object can only have one root node.
		Scene scene = new Scene(borderPane, mainWidth, mainHeight);  //, mainWidth, mainHeight);

		//A window		
		mainWindow.setTitle("Solitaire.exe");

		//Add the scene to the stage and display the contents of the stage.		
		mainWindow.setScene(scene);

		//Actually displays the contents
		mainWindow.show();	

		//Stage				 The window (BOOK)
		//Scene				 The space within the window (like a pane). (A PAGE) 
		//					 This is supposed to be like an area within the application.
		//Root Node			 The thing to hold all of the scene graphs (The stuff that holds all of the stuff in the page)
		//Scene graph(nodes) The stuff inside the scene(buttons, color, shape and other stuff) (THE STUFF WITHIN THE PAGE)
	}
	
	private Boolean changeScene(Pane pane){
		stage.getScene().setRoot(pane);
		if(pane == stage.getScene().getRoot()) {
			return true;
		}
		return false;
	}
	
	
	
	

	//stop() -An empty method which can be overridden, here you can write the logic to stop the application. So like when I want
	//to exit the game.

	//init() - An empty method which can be overridden, but you cannot create stage or scene in this method. Place to hold code 
	//before the start() method

	public static void main(String args[]){           
		
		//Implicitly calls start()
		launch(args);      
	} 
}
