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
import javafx.scene.paint.Color; 
import javafx.scene.control.*; 
import java.util.*;

/** Displays room 1 of the game where the user learns how to prepare for a flood.
 * 
 * @version Final
 * @author Cindy Liu and Emily Hu
 * Due date: June 10th, 2019
 * Time Spent: 6 hours
 */

public class Level1 {

	// array of the images on the cards
	private Image[] cardImage;
	// array of the explanations for the matches of items
	private String[] explanations;
	// the number of cards left on the board
	private int cardsLeft;
	// array of the position of the cards on the board
	private int[] board;
	// the total amount of pairs of cards
	private final int TOTAL_TERMS = 12;
	// score of the user
	private int userScore;

	/** Constructs a new level. Initializes the global variables and calls the Level 1 intro screen.
	 * 
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public Level1(Group root, Scene scene, Stage stage) {
		cardImage = new Image [TOTAL_TERMS * 2];
		explanations = new String[TOTAL_TERMS];
		board = new int[TOTAL_TERMS * 2];
		cardsLeft = 24;
		loadImages();
		loadExplanations();
		shuffle();
		level1Intro(root, scene, stage);
	}

	/** 
	 * Loads the images from the bin folder into the program.
	 */
	public void loadImages() {
		// loads the images of the cards
		cardImage [0] = new Image(ResourceLoader.getResourceLocation("Water.jpg")); 
		cardImage [1] = new Image(ResourceLoader.getResourceLocation("Food.jpg")); 
		cardImage [2] = new Image(ResourceLoader.getResourceLocation("Radio.jpg")); 
		cardImage [3] = new Image(ResourceLoader.getResourceLocation("Flashlight.jpg")); 
		cardImage [4] = new Image(ResourceLoader.getResourceLocation("Battery.jpg")); 
		cardImage [5] = new Image(ResourceLoader.getResourceLocation("Whistle.jpg")); 
		cardImage [6] = new Image(ResourceLoader.getResourceLocation("Tape.jpg")); 
		cardImage [7] = new Image(ResourceLoader.getResourceLocation("Mask.jpg")); 
		cardImage [8] = new Image(ResourceLoader.getResourceLocation("Tool.jpg")); 
		cardImage [9] = new Image(ResourceLoader.getResourceLocation("Map.jpg")); 
		cardImage [10] = new Image(ResourceLoader.getResourceLocation("Cellphone.jpg")); 
		cardImage [11] = new Image(ResourceLoader.getResourceLocation("Charger.jpg")); 
		for (int x = 12; x < TOTAL_TERMS * 2; x++) {
			cardImage [x] = new Image(ResourceLoader.getResourceLocation("Text".concat(Integer.toString(x-11))+".jpg"));
		}
	}

	/** 
	 * Loads the explanations from the text file.
	 */
	public void loadExplanations() {
		explanations[0] = "Water is important to keep you hydrated and alive.";
		explanations[1] = "Non-perishable food is important to give you energy.";
		explanations[2] = "A radio is important to keep you updated on the current situation.";
		explanations[3] = "A flashlight is important in case the electricity goes out.";
		explanations[4] = "Batteries are important in case old ones run out.";
		explanations[5] = "A whistle is important for someone to be able to locate you.";
		explanations[6] = "Duct tape is important as it is multi-functional.";
		explanations[7] = "A dust mask is important as dust and debris may fill the air.";
		explanations[8] = "Tools are important in case you need to fix or build something.";
		explanations[9] = "A map is important in order to evacuate the location.";
		explanations[10] = "A cell phone is important to help contact others and gather information.";
		explanations[11] = "A charger is important in case an electronic runs out of power.";
		
	}

	/**
	 * Shuffles the cards on the board.
	 */
	public void shuffle() {
		ArrayList<Integer> count = new ArrayList<Integer>();
		boolean check = false;
		int rand = 0;

		// shuffles the cards randomly
		for (int x = 0; x < TOTAL_TERMS * 2; x++) {
			check = false;
			while (check == false) {
				check = true;
				rand = (int) (Math.random() * 24);
				for (Integer n : count) {
					if (n == rand) {
						check = false;
					}
				}
			}
			board[x] = rand;
			count.add(rand);
		}
	}

	/** Checks whether the two cards are a match.
	 * 
	 * @param cardNum1		the position of the first card
	 * @param cardNum2		the position of the second card
	 * @return				whether the two cards match
	 */
	public boolean checkMatch(int cardNum1, int cardNum2) {
		// checks if the two cards are a match
		if (board[cardNum1] % 12 == board[cardNum2] % 12) {
			if (board[cardNum1] == -1 && board[cardNum2] == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/** Displays the intro screen for level 1.
	 * 
	 * @param root		Groups each object together on the screen
	 * @param scene		Holds the current scene on the screen
	 * @param stage		Holds the stage as a platform for output
	 */
	public void level1Intro (Group root, Scene scene, Stage stage) {
		// creates the background
		Image background = new Image(ResourceLoader.getResourceLocation("Level1Intro.jpg"));  
		ImageView bg = new ImageView(background);
		root.getChildren().add(bg); 

		// creates the continue button
		Button cont = new Button();
		cont.setText("Continue");
		cont.setLayoutX (880);
		cont.setLayoutY (600);
		cont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				level1 (root, scene, stage);
			}
		});
		root.getChildren().add(cont);

		stage.setScene(scene);
		stage.sizeToScene(); 
		stage.show();
	}

	/** Displays the outro screen for level 1.
	 * 
	 * @param root		Groups each object together on the screen
	 * @param scene		Holds the current scene on the screen
	 * @param stage		Holds the stage as a platform for output
	 */
	public void level1Outro (Group root, Scene scene, Stage stage) {
		writeScore();
		// creates the background
		Image background = new Image(ResourceLoader.getResourceLocation("Level1Outro.jpg"));  
		ImageView bg = new ImageView(background);
		root.getChildren().add(bg); 

		// creates the score
		Text score = new Text (530, 340, "Score: " + userScore);
		score.setFont(Font.font ("Montserrat", 36));
		root.getChildren().add(score);

		// creates the continue button
		Button cont = new Button();
		cont.setText("Continue");
		cont.setLayoutX (880);
		cont.setLayoutY (600);
		cont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Level2 (root, scene, stage);
			}
		});
		root.getChildren().add(cont);

		stage.setScene(scene);
		stage.sizeToScene(); 
		stage.show();
	}

	/** Writes the score onto the Player class.
	 * 
	 */
	public void writeScore()
	{
		Introduction.p.setPoints1(userScore);
	}
	
	/** Displays the level 1 game.
	 * 
	 * @param root		Groups each object together on the screen
	 * @param scene		Holds the current scene on the screen
	 * @param stage		Holds the stage as a platform for output
	 */
	public void level1 (Group root, Scene scene, Stage stage) {
		if (cardsLeft == 0) {
			userScore = 100;
			level1Outro (root, scene, stage);
		}
		else {
			// creating a background image 
			Image background = new Image(ResourceLoader.getResourceLocation("GreyBackground.jpg"));  
			ImageView wb = new ImageView(background);
			root.getChildren().add(wb); 

			// creates an array of cards
			Image image = new Image(ResourceLoader.getResourceLocation("Card.png"));  
			ImageView imageView[] = new ImageView [24];

			// displays the cards on the screen
			int count = 0;
			for (int y = 150; y < 600; y += 130) {
				for (int x = 50; x < 800; x+=130) {
					if (board[count] != -1){
						imageView [count] = new ImageView(image);
						imageView [count].setX(x); 
						imageView [count].setY(y); 
						imageView [count].setFitHeight(110); 
						imageView [count].setFitWidth(90); 
						root.getChildren().add(imageView [count]);
						Text num = new Text (x + 10, y + 20, Integer.toString (count + 1));
						num.setFont(Font.font ("Montserrat", 14));
						num.setFill(Color.WHITE);
						root.getChildren().add(num);
					}
					count++;
				}
			}

			// creates the title
			Text title = new Text (450, 100, "Level 1");
			title.setFont(Font.font ("Montserrat", 64));
			root.getChildren().add(title);

			// creates a new text to help the user
			Text selectedCards = new Text (880, 350, "Selected Cards: ");
			selectedCards.setFont(Font.font ("Montserrat", 20));
			root.getChildren().add(selectedCards);

			// creates a new text field for the user to enter the first card
			TextField userInput1 = new TextField();
			userInput1.setLayoutX (880);
			userInput1.setLayoutY (370);
			root.getChildren().add(userInput1); 

			// creates a new text field for the user to enter the second card
			TextField userInput2 = new TextField();
			userInput2.setLayoutX (880);
			userInput2.setLayoutY (405);
			root.getChildren().add(userInput2); 
			
			// creates an error message
			Text invalid = new Text (880, 540, "Invalid input!");
			invalid.setFont(Font.font ("Montserrat", 18));
			invalid.setVisible (false);
			root.getChildren().add(invalid);

			// creates a new button to check if the cards are a match
			Button check = new Button();
			check.setText("Check Match");
			check.setLayoutX (880);
			check.setLayoutY (450);
			check.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String text = userInput1.getText();
					String text2 = userInput2.getText();
					int cardNum1 = 0;
					int cardNum2 = 0;
					try {
						cardNum1 = Integer.parseInt (text) - 1;
						cardNum2 = Integer.parseInt (text2) - 1;
						if (cardNum1 >= 0 && cardNum1 < 24 && cardNum2 >= 0 && cardNum2 < 24 && cardNum1 != cardNum2) {
							if (checkMatch (cardNum1, cardNum2) && board[cardNum1] != -1){
								right (root, scene, stage, cardNum1, cardNum2);
								cardsLeft -= 2;
								board[cardNum1] = -1;
								board[cardNum2] = -1;
							}
							else if (board[cardNum1] != -1 && board[cardNum2] != -1) {
								wrong(root, scene, stage, cardNum1, cardNum2);
							}
							else {
								invalid.setVisible (true);
							}
						}
						else {
							invalid.setVisible (true);
						}
					}
					catch (NumberFormatException e) {
						invalid.setVisible (true);
					}
				}
			});
			root.getChildren().add(check);
			
			// creates a new button to give up
			Button giveUp = new Button();
			giveUp.setText("Give Up");
			giveUp.setLayoutX (880);
			giveUp.setLayoutY (490);
			giveUp.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					userScore = 0;
					level1Outro(root, scene, stage);
				}
			});
			root.getChildren().add(giveUp);

			stage.setTitle("Rising Waters");
			stage.setScene(scene);
			stage.show();
		}
	}

	/** Displays a message if the answer is correct.
	 * 
	 * @param root  Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 * @param cardNum1 Holds the number of the first card
	 * @param cardNum2 Holds the number of the second card
	 */
	public void right (Group root, Scene scene, Stage stage, int cardNum1, int cardNum2) {
		ImageView iv = new ImageView();
		Image bg = new Image(ResourceLoader.getResourceLocation("RightScreen.png"));
		iv.setImage(bg);
		iv.setX(0);
		iv.setY(0);

		int card1 = board[cardNum1];
		int card2 = board[cardNum2];
		
		// creates the first card's picture
		ImageView picture1 = new ImageView();
		picture1.setImage(cardImage[card1]);
		picture1.setX(265);
		picture1.setY(225);

		// creates the second card's picture
		ImageView picture2 = new ImageView();
		picture2.setImage(cardImage[card2]);
		picture2.setX(595);
		picture2.setY(225);

		// creates a new explanation for the match
		Text expl;
		if (card1 < card2)
		 expl = new Text(270, 570, explanations[card1]);
		else
			expl = new Text(270, 570, explanations[card2]);
		expl.setFont(Font.font("Montserrat", 18));
		expl.setVisible(true);
		
		// creates the number of the first card
		Text num1 = new Text(270, 240, Integer.toString(cardNum1 + 1));
		num1.setFont(Font.font("Montserrat", 18));

		// creates the number of the second card
		Text num2 = new Text(600, 240, Integer.toString(cardNum2 + 1));
		num2.setFont(Font.font("Montserrat", 18));

		// creates a new continue button
		Button cont = new Button();
		cont.setText("Continue");
		cont.setLayoutX (880);
		cont.setLayoutY (600);
		cont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				level1 (root, scene, stage);
			}
		});

		root.getChildren().add(iv);
		root.getChildren().add(picture1);
		root.getChildren().add(picture2);
		root.getChildren().add(expl);
		root.getChildren().add(num1);
		root.getChildren().add(num2);
		root.getChildren().add(cont);
		
		stage.setScene(scene);
		stage.sizeToScene(); 
		stage.show();
	}

	/** Displays a message if the answer is wrong.
	 * 
	 * @param root  Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 * @param cardNum1 Holds the number of the first card
	 * @param cardNum2 Holds the number of the second card
	 */
	public void wrong (Group root, Scene scene, Stage stage, int cardNum1, int cardNum2)
	{
		ImageView iv = new ImageView();
		Image bg = new Image(ResourceLoader.getResourceLocation("WrongScreen.png"));
		iv.setImage(bg);

		int card1 = board[cardNum1];
		int card2 = board[cardNum2];
		
		// creates the first card's picture
		ImageView picture1 = new ImageView();
		picture1.setImage(cardImage[card1]);
		picture1.setX(265);
		picture1.setY(225);

		// creates the second card's picture
		ImageView picture2 = new ImageView();
		picture2.setImage(cardImage[card2]);
		picture2.setX(595);
		picture2.setY(225);

		// creates the number of the first card
		Text num1 = new Text(270, 240, Integer.toString(cardNum1 + 1));
		num1.setFont(Font.font("Montserrat", 18));

		// creates the number of the second card
		Text num2 = new Text(600, 240, Integer.toString(cardNum2 + 1));
		num2.setFont(Font.font("Montserrat", 18));
		
		// creates new continue button
		Button cont = new Button();
		cont.setText("Continue");
		cont.setLayoutX (880);
		cont.setLayoutY (600);
		cont.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				level1 (root, scene, stage);
			}
		});
		
		root.getChildren().add(iv);
		root.getChildren().add(picture1);
		root.getChildren().add(picture2);
		root.getChildren().add(num1);
		root.getChildren().add(num2);
		root.getChildren().add(cont);
		
		stage.setScene(scene);
		stage.sizeToScene(); 
		stage.show();
	}
}
