package risingWaters;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This class represents the second level. It takes in movement from the mouse
 * and animates bubbles falling from the sky. All the processing and score
 * calulation is also done in this level
 * 
 * @author Cindy Liu and Emily Hu
 * @version FINAL 
 * Due date: June 10th, 2019 
 * Time spent: 10 hours
 */
public class Level2 {
 // timer
 private AnimationTimer timer;
 // timeline
 private Timeline timeline;
 // objects to be dropped
 private List<Object> drop = new ArrayList<Object>();
 // x-coord of mouse
 private double mouseX;
 // bucket node
 private Node cont;
 // speed of the raindrops falling
 private double speed;
 // speed of increase
 private double falling;
 // label with the number of strike outs
 private Label lblStrikes;
 // label with the score
 private Label lblScore;
 // number of missed raindrops
 private int missed;
 // current score
 private int score;

 /**
  * Constructs the second level.
  * 
  * @param root  Groups each object together on the screen
  * @param scene Holds the current scene on the screen
  * @param stage Holds the stage as a platform for output
  */
 public Level2(Group root, Scene scene, Stage stage) {
  missed = 0;
  score = 0;
  level2Intro(root, scene, stage);
 }

 /**
  * Displays the intro screen for level 1.
  * 
  * @param root  Groups each object together on the screen
  * @param scene Holds the current scene on the screen
  * @param stage Holds the stage as a platform for output
  */
 public void level2Intro(Group root, Scene scene, Stage stage) {
  // creates the background
  Image background = new Image(ResourceLoader.getResourceLocation("Level2Intro.png"));
  ImageView bg = new ImageView(background);
  root.getChildren().add(bg);
  // creates the continue button
  Button cont = new Button();
  cont.setText("Continue");
  cont.setLayoutX(880);
  cont.setLayoutY(600);
  cont.setOnAction(new EventHandler<ActionEvent>() {
   @Override
   public void handle(ActionEvent event) {
    level2(root, scene, stage);
   }
  });
  root.getChildren().add(cont);
  stage.setScene(scene);
  stage.sizeToScene();
  stage.show();
 }

 /**
  * Displays the outro screen for level 1.
  * 
  * @param root  Groups each object together on the screen
  * @param scene Holds the current scene on the screen
  * @param stage Holds the stage as a platform for output
  */
 public void level2Outro(Group root, Scene scene, Stage stage) {
  // creates the background
  writeScore();
  timeline.stop();
  timer.stop();
  Image background = new Image(ResourceLoader.getResourceLocation("Level2Outro.png"));
  ImageView bg = new ImageView(background);
  root.getChildren().add(bg);

  // creates the score
  Text scoreText = new Text(530, 340, "Score: " + score);
  scoreText.setFont(Font.font("Montserrat", 36));
  root.getChildren().add(scoreText);

  // creates the continue button
  Button cont = new Button();
  cont.setText("Continue");
  cont.setLayoutX(880);
  cont.setLayoutY(600);
  cont.setOnAction(new EventHandler<ActionEvent>() {
   @Override
   public void handle(ActionEvent event) {
    new Level3(root, scene, stage);
   }
  });
  root.getChildren().add(cont);

  stage.setScene(scene);
  stage.sizeToScene();
  stage.show();
 }

 /**
  * Displays level 2 of the game.
  * 
  * @param root  Groups each object together on the screen
  * @param scene Holds the current scene on the screen
  * @param stage Holds the stage as a platform for output
  */
 public void level2(Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("L2BG.jpg"), 1100, 680, false, false);
  ImageView bg = new ImageView(background);
  root.getChildren().add(bg);
  // creates the title
  Text title = new Text(450, 100, "Level 2");
  title.setFont(Font.font("Montserrat", 64));
  root.getChildren().add(title);
  lblStrikes = new Label("Strikes: 0");
  lblStrikes.setFont(new Font("Arial", 18));
  lblStrikes.setLayoutX(10);
  lblStrikes.setLayoutY(12);
  lblScore = new Label("Score: 0");
  lblScore.setFont(new Font("Arial", 18));
  lblScore.setLayoutX(10);
  lblScore.setLayoutY(34);
  missed = 0;
  speed = 0;
  falling = 2500;
  timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
   if (missed < 4) {
    speed += falling / 2500;
    drop.add(bubble());
    root.getChildren().add(((ImageView) drop.get(drop.size() - 1)));
   }
  }));
  timeline.setCycleCount(100);
  timeline.play();
  timer = new AnimationTimer() {
   @Override
   public void handle(long arg0) {
    gameUpdate(root, scene, stage);
   }
  };
  timeline.setOnFinished(e -> {
   level2Outro(root, scene, stage);
  });
  timer.start();
  cont = bucket();
  root.getChildren().addAll(cont, lblStrikes, lblScore);
  scene.setOnMouseMoved(e -> {
   mouseX = e.getX();
  });
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Method to generate random bubbles falling from the sky.
  * 
  * @return a Node that represents the image of one of 10 bubbles.
  */
 public Node bubble() {
  String[] images = new String[10];
  images[0] = "Battery.png";
  images[1] = "Cellphone.png";
  images[2] = "First Aid Kit.png";
  images[3] = "Flashlight.png";
  images[4] = "Food.png";
  images[5] = "GPS.png";
  images[6] = "Insurance.png";
  images[7] = "Money.png";
  images[8] = "News.png";
  images[9] = "Radio.png";
  Image bucketImage = new Image(ResourceLoader.getResourceLocation(images[rand(0, 9)]), 120, 120, false, false);
  Node bucket = new ImageView(bucketImage);
  bucket.setLayoutX(rand(0, 980));
  bucket.setLayoutY(76);
  return bucket;
 }

 /**
  * Method to generate the bucket.
  * 
  * @return Node that represents the bucket image.
  */
 public Node bucket() {
  Image bucketImage = new Image(ResourceLoader.getResourceLocation("Bucket.png"), 200, 70, false, false);
  Node bucket = new ImageView(bucketImage);
  bucket.setLayoutX(0);
  bucket.setLayoutY(580);
  return bucket;
 }

 /**
  * Randomly generates a number
  * 
  * @param min minimum value
  * @param max maximum value
  * @return int a random integer
  */
 public int rand(int min, int max) {
  return (int) (Math.random() * max + min);
 }

 /**
  * Updates the animations of the game
  * 
  * @param root  Groups each object together on the screen
  * @param scene Holds the current scene on the screen
  * @param stage Holds the stage as a platform for output
  */
 public void gameUpdate(Group root, Scene scene, Stage stage) {
  cont.setLayoutX(mouseX);
  for (int i = 0; i < drop.size(); i++) {
   if (missed < 3) {
    ((ImageView) drop.get(i)).setLayoutY(
      ((ImageView) drop.get(i)).getLayoutY() + speed + ((ImageView) drop.get(i)).getLayoutY() / 150);
    if ((((ImageView) drop.get(i)).getLayoutX() > cont.getLayoutX()
      && ((ImageView) drop.get(i)).getLayoutX() < cont.getLayoutX() + 120)
      && ((ImageView) drop.get(i)).getLayoutY() >= 485) {
     root.getChildren().remove(((ImageView) drop.get(i)));
     drop.remove(i);
     score += 10;
     lblScore.setText("Score: " + String.valueOf(score));
    } else if (((ImageView) drop.get(i)).getLayoutY() >= 540) {
     root.getChildren().remove(((ImageView) drop.get(i)));
     drop.remove(i);
     missed += 1;
     lblStrikes.setText("Strikes: " + String.valueOf(missed));
    }
   } else {
    level2Outro(root, scene, stage);
    break;
   }
  }
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Writes the score onto the Player class.
  * 
  */
 public void writeScore() {
	 Introduction.p.setPoints2(score);
 }
}
