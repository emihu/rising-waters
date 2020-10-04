package risingWaters;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Displays the top 10 high scores.
 * 
 * @version Final
 * @author Cindy Liu and Emily Hu 
 * Due date: June 10th, 2019
 * Time Spent: 2 hour
 * 
 */
public class HighScores {
	// adds all the high scoring names to the screen
	private Text[] text = new Text[10];
	// adds all the high scores to the screen
	private Text[] scores = new Text[10];
	// counts the amount of users who have played the game
	private int count;
	// temporary scores
	String[] scoresTemp;
	// names of players
	String[] names;
	// integer scores
	int[] scoresI;
	/*
	 * Outputs high scores to the screen
	 * 
	 * @param root Groups each object together on the screen
	 * 
	 * @param scene Holds the current scene on the screen
	 * 
	 * @param stage Holds the stage as a platform for output
	 */
	public HighScores(Group root, Scene scene, Stage stage) {
		Image image = new Image(ResourceLoader.getResourceLocation("Highscores.png"));
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setPreserveRatio(true);

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("highScores.txt")); // accesses the file
			while (in.readLine() != null) {
				count++;
			}
			count /= 2;
			in.close();
			in = new BufferedReader(new FileReader("highScores.txt")); // accesses the file
			scoresTemp = new String[count];
			names = new String[count];
			scoresI = new int[count];
			for (int i = 0; i < count; i++) {
				names[i] = in.readLine();
				scoresTemp[i] = in.readLine();
			}
			in.close();
		} catch (IOException e) {
		}
		int num = Integer.min(count, 10);
		for (int i = 0; i < num; i++) {
			scoresI[i] = Integer.parseInt(scoresTemp[i]);
		}
		for (int a = 0; a < count - 1; a++) {
			// for loop that determines the number of comparisons
			for (int b = 0; b < count - 1 - a; b++) {
				// if statement to check if the elements should be swapped
				if (scoresI[b] < scoresI[b + 1]) {
					int temp = scoresI[b];
					String temp2 = names[b];
					scoresI[b] = scoresI[b + 1];
					scoresI[b + 1] = temp;
					names[b] = names[b + 1];
					names[b + 1] = temp2;
				}
			}
		}


		for (int i = 0; i < num; i++) {
			text[i] = new Text(70, 240 + i * 35, names[i]);
			text[i].setFont(Font.font("Calibri", 28)); // sets the text
			text[i].setFill(Color.WHITE); // sets the text
			scores[i] = new Text(600, 240 + i * 35, Integer.toString(scoresI[i]));
			scores[i].setFont(Font.font("Calibri", 28)); // sets the scores
			scores[i].setFill(Color.WHITE); // sets the text
		}

		for (int i = num; i < 10; i++) {
			text[i] = new Text(70, 240 + i * 35, "");
			scores[i] = new Text(600, 240 + i * 35, "");
		}

		Rectangle menu = new Rectangle(); // creates a new rectangle object
		menu.setX(792);
		menu.setY(575);
		menu.setWidth(228);
		menu.setHeight(79);
		menu.setFill(Color.TRANSPARENT);
		EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() { // creates an eventhandler
			@Override
			public void handle(MouseEvent e) {
				new MainMenu(root, scene, stage);
			}
		};
		menu.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
		root.getChildren().addAll(iv);
		if (count !=0) {
			root.getChildren().addAll (text);
			root.getChildren().addAll (scores);
		}
		root.getChildren().add(menu);
		stage.setScene(scene);
		stage.show();
	}
}
