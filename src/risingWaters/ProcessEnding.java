package risingWaters;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import java.io.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

/** After the user has completed the game, this program processes their performance and displays the appropriate ending.
 * 
 * @version FINAL
 * @author Cindy Liu and Emily Hu
 * Due date: June 10th, 2019
 * Time Spent: 3 hours
 */
public class ProcessEnding {
 // text
 private String text;
 // total
 private int total;

 /** Constructs a new ending to the game.
  * 
  * @param root   Groups each object together on the screen
  * @param scene  Holds the current scene on the screen
  * @param stage  Holds the stage as a platform for output
  */
 public ProcessEnding (Group root, Scene scene, Stage stage) {
  total = 0;
  name(root, scene, stage); // General Instructions
 }

 /**
  * Takes in user name
  * 
  * @param root  the root to store everything.
  * @param scene the scene to display everything.
  * @param stage the stage to display everything.
  */
 public void name(Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("Name.png"), 1100, 680, false, false);
  ImageView bg = new ImageView(background);
  root.getChildren().add(bg);
  Rectangle back = new Rectangle(); // button
  back.setX(792);
  back.setY(575);
  back.setWidth(228);
  back.setHeight(79);
  back.setFill(Color.TRANSPARENT);
  TextField userInput = new TextField();
  userInput.setFont(Font.font("Montserrat", 30));
  root.getChildren().add(userInput);
  userInput.setLayoutX(300);
  userInput.setPrefWidth(400);
  userInput.setPrefHeight(50);
  userInput.setLayoutY(200);
  EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent f) {
    try {
     text = userInput.getText();
     if (text.length() <= 12 && text.length() != 0 && text.indexOf(" ") == -1) {
      score(root, scene, stage);
     } else {
      Text invalid = new Text(70, 300, "Please enter between 1-12 characters without spaces.");
      invalid.setFont(Font.font("Montserrat", 24));
      invalid.setFill(Color.WHITE);
      root.getChildren().add(invalid);
      userInput.setText("");
     }
    } catch (Exception e) {
    }
   }
  };
  root.getChildren().add(back);
  back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  stage.setTitle("Rising Waters");
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Reads from the Player class and returns the user's score
  * 
  * @return String score for a specific level.
  */
 private String getScore(int x) {
	 if (x == 0)
	 return Integer.toString(Introduction.p.getPoints1());
	 else if (x == 1)
		 return Integer.toString(Introduction.p.getPoints2());
	 else
		 return Integer.toString(Introduction.p.getPoints3());
 }

 /**
  * Ouputs the user's score.
  * 
  * @param root  the root to store everything.
  * @param scene the scene to display everything.
  * @param stage the stage to display everything.
  */
 public void score(Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("Score.png"), 1100, 680, false, false);
  ImageView bg = new ImageView(background);
  root.getChildren().add(bg);
  Rectangle back = new Rectangle();// button
  back.setX(792);
  back.setY(575);
  back.setWidth(228);
  back.setHeight(79);
  back.setFill(Color.TRANSPARENT);
  EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
    ending(root, scene, stage);
   }
  };
  Text score1 = new Text(250, 270, getScore(0));
  score1.setFont(Font.font("Montserrat", 25));
  score1.setFill(Color.WHITE);
  score1.setVisible(true);
  Text score2 = new Text(250, 305, getScore(1));
  score2.setFont(Font.font("Montserrat", 25));
  score2.setFill(Color.WHITE);
  score2.setVisible(true);
  Text score3 = new Text(250, 344, getScore(2));
  score3.setFont(Font.font("Montserrat", 25));
  score3.setFill(Color.WHITE);
  score3.setVisible(true);
  total = Integer.parseInt(getScore(0)) + Integer.parseInt(getScore(1)) + Integer.parseInt(getScore(2));
  Text score4 = new Text(240, 420, Integer.toString(total));
  score4.setFont(Font.font("Montserrat", 25));
  score4.setFill(Color.WHITE);
  score4.setVisible(true);
  root.getChildren().addAll(back, score1, score2, score3, score4);
  back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  stage.setTitle("Rising Waters");
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Outputs the appropriate ending.
  * 
  * @param root  the root to store everything.
  * @param scene the scene to display everything.
  * @param stage the stage to display everything.
  */
 public void ending(Group root, Scene scene, Stage stage) {
  String photo;
  if (total <= 140) {
   photo = "BadEnding.png";
  } else if (total > 140 && total <= 230) {
   photo = "AvgEnding.png";
  } else {
   photo = "GoodEnding.png";
  }
  Image background = new Image(ResourceLoader.getResourceLocation(photo), 1100, 680, false, false);
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
    advice(root, scene, stage);
   }
  };
  root.getChildren().add(back);
  back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  stage.setTitle("Rising Waters");
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Outputs the advice screen.
  * 
  * @param root  the root to store everything.
  * @param scene the scene to display everything.
  * @param stage the stage to display everything.
  */

 public void advice(Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("Advice.png"), 1100, 680, false, false);
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
    otherAdvice(root, scene, stage);
   }
  };
  root.getChildren().add(back);
  back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  stage.setTitle("Rising Waters");
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Writes the score to the file.
  *
  */
 public void writeFile() {
  PrintWriter out;
  try {
   out = new PrintWriter(new FileWriter("HighScores.txt", true));
   ;
   out.println(text);
   out.println(total);
   out.close();
  } catch (IOException d) {
  }
 }

 /**
  * Other Advice screen, allows user to return home.
  * 
  * @param root  the root to store everything.
  * @param scene the scene to display everything.
  * @param stage the stage to display everything.
  */
 public void otherAdvice(Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("OtherAdvice.png"), 1100, 680, false, false);
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
    new MainMenu(root, scene, stage);
    writeFile();
   }
  };
  root.getChildren().add(back);
  back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  stage.setTitle("Rising Waters");
  stage.setScene(scene);
  stage.show();
 }
}
