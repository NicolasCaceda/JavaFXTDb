package HSCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("Secrets.fxml"));
    primaryStage.setTitle("HearthStone Secrets");
    primaryStage.getIcons().add(new Image("file:Images/Hearthstone-Logo.png"));
    primaryStage.setResizable(false);
    Scene scene = new Scene(root, 423.53125, 275);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) throws Exception {
    launch(args);
  }
}
