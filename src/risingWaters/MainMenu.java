package risingWaters;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

/**
 * This class represents the home screen which will redirect to all the other
 * screens.
 * 
 * @author Cindy Liu and Emily Hu
 * @version FINAL 
 * Due Date: June 10th, 2019 
 * Time spent: 10 hours
 */
public class MainMenu {

	/** Creates a main menu.
	 * 
	 * @param root Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public MainMenu(Group root, Scene scene, Stage stage) {
		Image background = new Image(ResourceLoader.getResourceLocation("HomeScreen.png"), 1100, 680, false, false);
		ImageView bg = new ImageView(background);
		root.getChildren().add(bg);
		Rectangle scores = new Rectangle();
		scores.setX(80);
		scores.setY(423);
		scores.setWidth(228);
		scores.setHeight(79);
		scores.setFill(Color.TRANSPARENT);
		EventHandler<MouseEvent> eventHandler4 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				new HighScores (root, scene, stage);
			}
		};
		Rectangle play = new Rectangle();
		play.setX(437);
		play.setY(423);
		play.setWidth(228);
		play.setHeight(79);
		play.setFill(Color.TRANSPARENT);
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				new Introduction (root, scene, stage);
			}
		};
		Rectangle exit = new Rectangle();
		exit.setX(792);
		exit.setY(423);
		exit.setWidth(228);
		exit.setHeight(79);
		exit.setFill(Color.TRANSPARENT);
		EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				new Quit (root, scene, stage);
			}
		};
		Rectangle instructions = new Rectangle();
		instructions.setX(380);
		instructions.setY(552);
		instructions.setWidth(335);
		instructions.setHeight(70);
		instructions.setFill(Color.TRANSPARENT);
		EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				new Instructions (root, scene, stage);
			}
		};

		exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
		play.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		instructions.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler3);
		scores.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler4);
		root.getChildren().addAll(play, exit, instructions, scores);
		
		stage.setScene(scene);
		stage.show();
	}
}
