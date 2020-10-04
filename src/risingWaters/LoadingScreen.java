package risingWaters;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Creates a loading image and animation
 * 
 * @version Final
 * @author Cindy Liu and Emily Hu 
 * Due date: June 10th, 2019 
 * Time Spent: 1 hour
 */

public class LoadingScreen {

	/** Outputs an loading animation as soon as the user runs the game
	 * 
	 * @param root Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public LoadingScreen(Group root, Scene scene, Stage stage) {
		// creates a background image for the loading screen
		Image background = new Image (ResourceLoader.getResourceLocation("LoadingImage.jpg")); 
		ImageView iv = new ImageView(background);
		root.getChildren().add(iv);
		iv.setSmooth(true);
		iv.setCache(true);

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
			//new Level1 (root, scene, stage);
			//new Level2 (root, scene, stage);
			//new Level3 (root, scene, stage);
			//new Quit (root, scene, stage);
			new MainMenu (root, scene, stage);
			//new ProcessEnding (root, scene, stage);
		});

		// creates a new sequential transition
		SequentialTransition st = new SequentialTransition(new PauseTransition(Duration.seconds(1.0)),
				tt);
		st.play();

		stage.setScene(scene);
		stage.show();
	}
}
