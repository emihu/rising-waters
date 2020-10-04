package risingWaters;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * Runs the game
 * 
 * @version Final
 * @author Cindy Liu and Emily Hu 
 * Date: June 10th, 2019 
 * Time Spent: 1 hour
 */

public class Driver extends Application {

	/** Override of the javafx start method
	 * 
	 * @param primaryStage The stage in which everything is displayed
	 */
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root, 1100, 680);
		primaryStage.setTitle("Rising Waters");
		new LoadingScreen(root, scene, primaryStage);
	}

	/** Starts the execution of the animation
	 * 
	 * @param args outputs everything to the screen
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
