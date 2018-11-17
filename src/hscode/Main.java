package hscode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Main file for the program that runs everything.
 */
public class Main extends Application {

  /**
   * Initializes the program.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("HearthStone Secrets");
    primaryStage.getIcons().add(new Image("file:src/Resources/Images/Hearthstone-Logo.png"));
    Font.loadFont(getClass().getResourceAsStream(
        "file:src/Resources/Font/OPTIBelwe-Medium.otf"), 12);
    primaryStage.setResizable(false);
    Parent root = FXMLLoader.load(getClass().getResource("Secrets.fxml"));
    Scene scene = new Scene(root, 425, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Starts the program.
   */
  public static void main(String[] args){
    launch(args);
  }
}
