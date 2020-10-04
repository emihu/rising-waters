package risingWaters;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.animation.PauseTransition;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Displays room 3 of the game where the user must escape the flood area to
 * safety.
 * 
 * @version Final
 * @author Cindy Liu and Emily Hu Due date: June 10th, 2019 Time Spent: 6 hours
 */
public class Level3 {

	// the number of directions the user must remember
	private static final int NUM_DIRECTIONS = 6;
	// array of the order of the directions
	private char[] directionOrder;
	// the score of the user
	private int userScore;
	// the round number
	private int round;

	/**
	 * Constructs a new level. Initializes the global variables and calls the Level
	 * 3 intro screen.
	 * 
	 * @param root  Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public Level3(Group root, Scene scene, Stage stage) {
		userScore = 0;
		round = 1;
		directionOrder = new char[NUM_DIRECTIONS];
		// calls the method level3Intro
		level3Intro(root, scene, stage);
	}

	/**
	 * Generates a random sequence of directions and sets the values to
	 * directionOrder.
	 * 
	 */
	private void randDirections() {
		int temp = -1;
		// for loop - loops to store the random sequence of the directions
		for (int x = 0; x < NUM_DIRECTIONS; x++) {
			temp = (int) (Math.random() * 4); // stores a random number into the array
			if (temp == 0)
				directionOrder[x] = 'n';
			else if (temp == 1)
				directionOrder[x] = 'e';
			else if (temp == 2)
				directionOrder[x] = 's';
			else if (temp == 3)
				directionOrder[x] = 'w';
		}
	}

	/**
	 * Checks the input of the user to see how many are correct.
	 * 
	 * @param userInput the users input of the sequence of directions
	 * @return the amount of directions the user got correct
	 */
	public int checkScore(String userInput) {
		int check = 0;
		// for loop - gets and checks the user input
		for (int x = 0; x < NUM_DIRECTIONS; x++) {
			// checks if the users entry matches the answer
			if (userInput.toLowerCase().charAt(x) == directionOrder[x])
				check++;
			else if (userInput.toLowerCase().charAt(x) != ('n') && userInput.toLowerCase().charAt(x) != ('s')
					&& userInput.toLowerCase().charAt(x) != ('e') && userInput.toLowerCase().charAt(x) != ('w'))
				return -1;
		}
		return check;
	}

	/**
	 * Displays the intro screen for level 3.
	 * 
	 * @param root  Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void level3Intro(Group root, Scene scene, Stage stage) {
		// creates the background image
		Image background = new Image(ResourceLoader.getResourceLocation("Level3Intro.jpg"));
		ImageView bg = new ImageView(background);
		root.getChildren().add(bg);

		// creates a continue button
		Button cont = new Button();
		cont.setText("Continue");
		cont.setLayoutX(880);
		cont.setLayoutY(600);
		cont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				level3(root, scene, stage);
			}
		});
		root.getChildren().add(cont);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	/**
	 * Displays the outro screen for level 3.
	 * 
	 * @param root  Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void level3Outro(Group root, Scene scene, Stage stage) {
		// creates the background
		writeScore();
		Image background = new Image(ResourceLoader.getResourceLocation("Level3Outro.jpg"));
		ImageView bg = new ImageView(background);
		root.getChildren().add(bg);

		// creates the score
		Text score = new Text(530, 340, "Score: " + Integer.toString(userScore));
		score.setFont(Font.font("Montserrat", 36));
		root.getChildren().add(score);

		// creates the continue button
		Button cont = new Button();
		cont.setText("Continue");
		cont.setLayoutX(880);
		cont.setLayoutY(600);
		cont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new ProcessEnding(root, scene, stage);
			}
		});
		root.getChildren().add(cont);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	/**
	 * Displays level 3 of the game.
	 * 
	 * @param root  Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void level3(Group root, Scene scene, Stage stage) {
		if (round < 9) {
			// creates the background image
			Image background = new Image(ResourceLoader.getResourceLocation("Level3Background.jpg"));
			ImageView wb = new ImageView(background);
			root.getChildren().add(wb);

			// creates the title
			Text title = new Text(450, 100, "Level 3");
			title.setFont(Font.font("Montserrat", 64));
			root.getChildren().add(title);

			// creates the user's score
			Text score = new Text(900, 100, "Score: " + Integer.toString(userScore));
			score.setFont(Font.font("Montserrat", 20));
			root.getChildren().add(score);

			// creates the round number
			Text roundNum = new Text(900, 70, "Round: " + Integer.toString(round));
			roundNum.setFont(Font.font("Montserrat", 20));
			root.getChildren().add(roundNum);

			// creates the north direction
			Text north = new Text(500, 155, "North");
			north.setFont(Font.font("Montserrat", 36));
			north.setVisible(false);
			root.getChildren().add(north);

			// creates the east direction
			Text east = new Text(690, 300, "East");
			east.setFont(Font.font("Montserrat", 36));
			east.setVisible(false);
			root.getChildren().add(east);

			// creates the south direction
			Text south = new Text(500, 450, "South");
			south.setFont(Font.font("Montserrat", 36));
			south.setVisible(false);
			root.getChildren().add(south);

			// creates the west direction
			Text west = new Text(330, 300, "West");
			west.setFont(Font.font("Montserrat", 36));
			west.setVisible(false);
			root.getChildren().add(west);

			// calls the ranDirections method to randomize the directions
			randDirections();

			Timeline[] timeline = new Timeline[NUM_DIRECTIONS];
			// for loop - loops through all of the sequence and flashes the colors
			// accordingly
			for (int x = 0; x < NUM_DIRECTIONS; x++) {

				// if else - determines which color to flash
				if (directionOrder[x] == 'n') {
					timeline[x] = new Timeline(new KeyFrame(Duration.seconds(1.0), evt -> north.setVisible(false)),
							new KeyFrame(Duration.seconds(0.1), evt -> north.setVisible(true)));
				} else if (directionOrder[x] == 'e') {
					timeline[x] = new Timeline(new KeyFrame(Duration.seconds(1.0), evt -> east.setVisible(false)),
							new KeyFrame(Duration.seconds(0.1), evt -> east.setVisible(true)));
				} else if (directionOrder[x] == 's') {
					timeline[x] = new Timeline(new KeyFrame(Duration.seconds(1.0), evt -> south.setVisible(false)),
							new KeyFrame(Duration.seconds(0.1), evt -> south.setVisible(true)));
				} else {
					timeline[x] = new Timeline(new KeyFrame(Duration.seconds(1.0), evt -> west.setVisible(false)),
							new KeyFrame(Duration.seconds(0.1), evt -> west.setVisible(true)));
				}
				timeline[x].setCycleCount(1);
			}

			// creates a new sequential transition to flash the directions in order and add
			// pauses inbetween
			SequentialTransition seqTrans = new SequentialTransition(timeline[0],
					new PauseTransition(Duration.seconds(0.8)), timeline[1], new PauseTransition(Duration.seconds(0.8)),
					timeline[2], new PauseTransition(Duration.seconds(0.8)), timeline[3],
					new PauseTransition(Duration.seconds(0.8)), timeline[4], new PauseTransition(Duration.seconds(0.8)),
					timeline[5], new PauseTransition(Duration.seconds(0.8)));
			seqTrans.play();

			// creates a reminder for the user
			Text reminder = new Text(350, 600, "Remember the directions of the escape route!");
			reminder.setFont(Font.font("Montserrat", 20));
			root.getChildren().add(reminder);

			// creates instructions
			Text instructions = new Text(300, 570,
					"North = 'n'        East = 'e'        South = 's'        West = 'w'");
			instructions.setFont(Font.font("Montserrat", 20));

			// creates a prompt for the user to enter the directions
			Text directionsPrompt = new Text(200, 620, "Enter the directions: ");
			directionsPrompt.setFont(Font.font("Montserrat", 20));

			// creates a text field for the user to enter their guess
			TextField userInput = new TextField();
			userInput.setLayoutX(420);
			userInput.setLayoutY(600);

			// creates a button to check the user's answer
			Button check = new Button();
			check.setText("Check");
			check.setFont(Font.font("Montserrat", 20));
			check.setLayoutX(800);
			check.setLayoutY(590);
			check.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						String text = userInput.getText();
						int score = checkScore(text);
						if (text.length() == 6) {
							if (score == NUM_DIRECTIONS) {
								userScore += 10;
								round++;
								right(root, scene, stage);
								check.setVisible(false);
								userInput.setText("");
							} else if (score >= 0) {
								round++;
								wrong(root, scene, stage);
								check.setVisible(false);
							} else {
								Text invalid = new Text(600, 620, "Invalid input!");
								invalid.setFont(Font.font("Montserrat", 18));
								root.getChildren().add(invalid);
								userInput.setText("");
							}
						} else {
							Text invalid = new Text(600, 620, "Invalid input!");
							invalid.setFont(Font.font("Montserrat", 18));
							root.getChildren().add(invalid);
							userInput.setText("");
						}
					} catch (Exception e) {
						Text invalid = new Text(600, 620, "Invalid input!");
						invalid.setFont(Font.font("Montserrat", 18));
						root.getChildren().add(invalid);
						userInput.setText("");
					}
				}
			});

			// pauses the program and hides the user input until the animation is finished
			PauseTransition pt = new PauseTransition();
			pt.setDuration(new Duration(11000));
			pt.setOnFinished(e -> {
				reminder.setVisible(false);
				root.getChildren().add(instructions);
				root.getChildren().add(directionsPrompt);
				root.getChildren().add(userInput);
				root.getChildren().add(check);
			});
			pt.play();

			stage.setScene(scene);
			stage.show();
		} else
			level3Outro(root, scene, stage);
	}

	/**
	 * Displays a message if the answer is correct.
	 * 
	 * @param root  Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void right(Group root, Scene scene, Stage stage) {
		// creates a right screen
		ImageView iv = new ImageView();
		Image image = new Image(ResourceLoader.getResourceLocation("RightScreen2.jpg"));
		iv.setImage(image);
		iv.setX(150);
		iv.setY(150);
		root.getChildren().add(iv);

		// creates a fade transition
		FadeTransition ft = new FadeTransition();
		ft.setNode(iv);
		ft.setDuration(new Duration(2000));
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.setOnFinished(e -> {
			level3(root, scene, stage);
		});
		ft.play();

		// creates a pause transition
		PauseTransition pt = new PauseTransition();
		pt.setDuration(new Duration(1000));
		pt.setOnFinished(e -> {
			if (round <= 8) {
				ft.play();
			} else {
				level3Outro(root, scene, stage);
			}
		});

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	/**
	 * Displays a message if the answer is wrong.
	 * 
	 * @param root  Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void wrong(Group root, Scene scene, Stage stage) {
		// creates the wrong screen
		ImageView iv = new ImageView();
		Image image = new Image(ResourceLoader.getResourceLocation("WrongScreen2.jpg"));
		iv.setImage(image);
		iv.setX(150);
		iv.setY(150);
		root.getChildren().add(iv);

		// creates a fade transition
		FadeTransition ft = new FadeTransition();
		ft.setNode(iv);
		ft.setDuration(new Duration(2000));
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.setOnFinished(e -> {
			level3(root, scene, stage);
		});
		ft.play();

		// creates a pause transition
		PauseTransition pt = new PauseTransition();
		pt.setDuration(new Duration(1000));
		pt.setOnFinished(e -> {
			if (round <= 8) {
				ft.play();
			} else {
				level3Outro(root, scene, stage);
			}
		});

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
	
	/** Writes the score onto the Player class.
	 * 
	 */
	public void writeScore()
	{
		Introduction.p.setPoints3(userScore);
	}
}