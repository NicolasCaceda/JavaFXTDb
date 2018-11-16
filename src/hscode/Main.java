package hscode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

  /**
   * Starts the program
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("HearthStone Secrets");
    primaryStage.getIcons().add(new Image("file:src/Resources/Images/Hearthstone-Logo.png"));
    Font.loadFont(getClass().getResourceAsStream(
        "file:src/Resources/Font/OPTIBelwe-Medium.otf"), 14);
    primaryStage.setResizable(false);
    Parent root = FXMLLoader.load(getClass().getResource("Secrets.fxml"));
    Scene scene = new Scene(root, 425, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) throws Exception {
    launch(args);
  }
}
