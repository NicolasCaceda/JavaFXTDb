package HSCode;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Controller {

  private dbHandler db = null;

  @FXML
  public Button NextButton;

  @FXML
  public Button PrevButton;

  @FXML
  public Button RandomButton;

  @FXML
  private HBox Secret;
  private Image secretImage = new Image("file:Resources/Images/Hearthstone-Logo.png", 200,
      200, true, true);


  @FXML
  public Button Jaina = new Button();
  private Image jainaPortrait = new Image("file:Resources/Images/Portraits/Jaina.jpg", 200,
      200, false, true);

  @FXML
  public Button Uther;
  private Image utherPortrait = new Image("file:Resources/Images/Portraits/Uther.jpg", 200,
      200, false, true);

  @FXML
  public Button Rexxar;
  private Image rexxarPortrait = new Image("file:Resources/Images/Portraits/Rexxar.jpg", 200,
      200, false, true);


  @FXML
  public Button Valeera;
  private Image valeeraPortrait = new Image("file:Resources/Images/Portraits/Valeera.jpg", 200,
      200, false, true);

  @FXML
  public void initialize() {
    Secret.getChildren().add(new ImageView(secretImage));
    Secret.setAlignment(Pos.CENTER);
    db = new dbHandler();
  }

  @FXML
  void getHunter() throws Exception {
    db.getHunterSecrets();
    Secret.getChildren().clear();
    Secret.getChildren().add(new ImageView(rexxarPortrait));
  }

  ;

  @FXML
  void getMage() throws Exception {
    db.getMageSecrets();
    Secret.getChildren().clear();
    Secret.getChildren().add(new ImageView(jainaPortrait));
  }

  ;

  @FXML
  void getPaladin() throws Exception {
    db.getPaladinSecrets();
    Secret.getChildren().clear();
    Secret.getChildren().add(new ImageView(utherPortrait));
  }

  ;

  @FXML
  void getRogue() throws Exception {
    db.getRogueSecrets();
    Secret.getChildren().clear();
    Secret.getChildren().add(new ImageView(valeeraPortrait));
  }

  ;

  @FXML
  void next() throws Exception {
    try {
      Secret.getChildren().clear();
      Secret.getChildren().add(new ImageView(new Image("file:Resources/Images/Secrets/"
          + db.getnextCard() + ".png", 200, 200, true, true)));

    } catch (Exception ex) {
      noClassError();
    }
  }

  @FXML
  void back() throws Exception {
    try {
      Secret.getChildren().clear();
      Secret.getChildren().add(new ImageView(new Image("file:Resources/Images/Secrets/"
          + db.getprevCard() + ".png", 200, 200, true, true)));

    } catch (Exception ex) {
      noClassError();
    }
  }


  @FXML
  void randomSelection() throws Exception {
    try {
      Secret.getChildren().clear();
      Secret.getChildren().add(new ImageView(new Image("file:Resources/Images/Secrets/"
          + db.getRandomCard() + ".png", 200, 200, true, true)));
    } catch (Exception ex) {
      noClassError();
    }
  }


  private void noClassError() {
    Secret.getChildren().add(new ImageView(secretImage));
    Alert nextButton = new Alert(AlertType.WARNING);
    nextButton.setTitle("Warning");
    nextButton.setHeaderText("No class alert!");
    nextButton.setContentText("Please select a class.");
    nextButton.showAndWait();
  }
}