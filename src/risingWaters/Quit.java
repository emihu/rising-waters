package risingWaters;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Displays the quit screen and closes the program.
 * 
 * @version Final
 * @author Cindy Liu and Emily Hu 
 * Due date: June 10th, 2019 
 * Time Spent: 1 hour
 */
public class Quit {

	/** Displays the quit screen and closes the program.
	 * 
	 * @param root Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage for all objects to be outputed on
	 */
	public Quit(Group root, Scene scene, Stage stage) {
		// creates a background image
		Image image = new Image(ResourceLoader.getResourceLocation("QuitScreen.jpg"));
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setPreserveRatio(true);
		iv.setSmooth(true);
		iv.setCache(true);
		root.getChildren().add(iv);

		// creates a wave image
		Image wave = new Image(ResourceLoader.getResourceLocation("Wave.png")); 
		ImageView iv2 = new ImageView(wave); 
		iv2.setY(680);
		root.getChildren().add(iv2);

		// creates a translate transition
		TranslateTransition tt = new TranslateTransition(); 
		tt.setDuration(Duration.seconds(5.0)); // sets the duration of the transition
		tt.setNode(iv2); // sets the node for the transition
		tt.setByY(-800); // sets the value of the transition along the y axis
		tt.setCycleCount(1); // sets the cycle count for the transition
		tt.setAutoReverse(false); // sets auto reverse value to false
		tt.setOnFinished(e -> {
			Platform.exit(); // exits program
		});
		tt.play();

		stage.setScene(scene);
		stage.show();
	}
}