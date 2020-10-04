package risingWaters;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

/**
 * Displays the intro for this game.
 * 
 * @version Final
 * @author Cindy Liu and Emily Hu 
 * Due date: June 10th, 2019 
 * Time Spent: 1 hour
 */
public class Introduction {
	// creates a player 
	public static Player p;
	
	/** Constructs a new introduction to the game.
	 * 
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public Introduction(Group root, Scene scene, Stage stage) {
		p = new Player();
		intro(root, scene, stage); // General Instructions
	}

	/**
	 * Sets up the stage
	 * 
	 * @param root  the root to store everything.
	 * @param scene the scene to display everything.
	 * @param stage the stage to display everything.
	 */
	public void intro(Group root, Scene scene, Stage stage) {
		Image background = new Image(ResourceLoader.getResourceLocation("Intro.png"), 1100, 680, false, false);
		ImageView bg = new ImageView(background);
		root.getChildren().add(bg);
		Rectangle back = new Rectangle();// button
		back.setX(850);
		back.setY(599);
		back.setWidth(228);
		back.setHeight(79);
		back.setFill(Color.TRANSPARENT);
		EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				new Level1 (root, scene, stage);
			}
		};
		root.getChildren().add(back);
		back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
		stage.setTitle("Rising Waters");
		stage.setScene(scene);
		stage.show();
	}
}