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
 * Displays the instructions for this game
 * 
 * @version Final
 * @author Cindy Liu and Emily Hu 
 * Due date: June 10th, 2019 
 * Time Spent: 1 hour
 */
public class Instructions {

 /** 
  * Constructs a instructions screen.
  * 
  * @param root   Groups each object together on the screen
  * @param scene  Holds the current scene on the screen
  * @param stage  Holds the stage as a platform for output
  */
 public Instructions (Group root, Scene scene, Stage stage) {
  general (root, scene, stage);
 }
 
 /**
  * Displays the main instructions screen.
  * 
  * @param root   Groups each object together on the screen
  * @param scene  Holds the current scene on the screen
  * @param stage  Holds the stage as a platform for output
  */
 public void general (Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("GI.png"), 1100, 680, false, false);
  ImageView bg = new ImageView(background);
  root.getChildren().add(bg);
  Rectangle home = new Rectangle();
  home.setX(953);
  home.setY(10);
  home.setWidth(124);
  home.setHeight(40);
  home.setFill(Color.TRANSPARENT);
  EventHandler<MouseEvent> eventHandler5 = new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
    new MainMenu(root, scene, stage); // Returns to MainMenu
   }
  };
  Rectangle L3 = new Rectangle();
  L3.setX(792);
  L3.setY(575);
  L3.setWidth(228);
  L3.setHeight(79);
  L3.setFill(Color.TRANSPARENT);
  EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
    level3Instructions(root, scene, stage); // Goes to Level 3
   }
  };
  Rectangle L1 = new Rectangle();
  L1.setX(60);
  L1.setY(575);
  L1.setWidth(228);
  L1.setHeight(79);
  L1.setFill(Color.TRANSPARENT);
  EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
    level1Instructions(root, scene, stage); // Goes to Level 1
   }
  };
  Rectangle L2 = new Rectangle();
  L2.setX(436);
  L2.setY(575);
  L2.setWidth(228);
  L2.setHeight(79);
  L2.setFill(Color.TRANSPARENT);
  EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
    level2Instructions(root, scene, stage); // Goes to Level 2
   }
  };
  // Processes Clicking
  L1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  L3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
  L2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler3);
  home.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler5);
  root.getChildren().addAll(L3, L1, L2, home);
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Displays the instructions for level 3.
  * 
  * @param root   Groups each object together on the screen
  * @param scene  Holds the current scene on the screen
  * @param stage  Holds the stage as a platform for output
  * 
  */
 public void level3Instructions(Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("IL3.png"), 1100, 680, false, false);
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
    general(root, scene, stage); // Returns to general
   }
  };
  root.getChildren().add(back);
  back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  stage.setTitle("Rising Waters");
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Displays the instructions for level 2.
  * 
  * @param root   Groups each object together on the screen
  * @param scene  Holds the current scene on the screen
  * @param stage  Holds the stage as a platform for output.
  * 
  */
 public void level2Instructions(Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("IL2.png"), 1100, 680, false, false);
  ImageView bg = new ImageView(background);
  root.getChildren().add(bg);
  Rectangle back = new Rectangle(); // button
  back.setX(792);
  back.setY(575);
  back.setWidth(228);
  back.setHeight(79);
  back.setFill(Color.TRANSPARENT);
  EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
    general(root, scene, stage); // returns to general
   }
  };
  root.getChildren().add(back);
  back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  stage.setTitle("Rising Waters");
  stage.setScene(scene);
  stage.show();
 }

 /**
  * Displays the instructions for level 1.
  * 
  * @param root   Groups each object together on the screen
  * @param scene  Holds the current scene on the screen
  * @param stage  Holds the stage as a platform for output
  * 
  */
 public void level1Instructions(Group root, Scene scene, Stage stage) {
  Image background = new Image(ResourceLoader.getResourceLocation("IL1.png"), 1100, 680, false, false);
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
    general(root, scene, stage); // returns to general
   }
  };
  root.getChildren().add(back);
  back.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  stage.setTitle("Rising Waters");
  stage.setScene(scene);
  stage.show();
 }
}
