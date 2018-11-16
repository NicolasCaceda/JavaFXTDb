package hscode;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class Controller {

  private DbHandler db = null;

  private final String RESOURCES_FILE_PATH = "file:src/Resources/";

  @FXML
  private Label isInStandard;

  @FXML
  private Label standard;

  @FXML
  private HBox secret;
  private Image secretImage = new Image(RESOURCES_FILE_PATH + "Images/Hearthstone-Logo.png", 200,
      200, true, true);

  @FXML
  private Image jainaPortrait = new Image(RESOURCES_FILE_PATH + "Images/Portraits/Jaina.jpg", 200,
      200, false, true);

  @FXML
  private Image utherPortrait = new Image(RESOURCES_FILE_PATH + "Images/Portraits/Uther.jpg", 200,
      200, false, true);

  @FXML
  private Image rexxarPortrait = new Image(RESOURCES_FILE_PATH + "Images/Portraits/Rexxar.jpg", 200,
      200, false, true);


  @FXML
  private Image valeeraPortrait = new Image(RESOURCES_FILE_PATH + "Images/Portraits/Valeera.jpg",
      200,
      200, false, true);

  @FXML
  public void initialize() {
    secret.getChildren().add(new ImageView(secretImage));
    secret.setAlignment(Pos.CENTER);
    standard.setText("");
    isInStandard.setText("");
    db = new DbHandler();
  }

  @FXML
  void getHunter() throws Exception {
    db.getHunterSecrets();
    secret.getChildren().clear();
    secret.getChildren().add(new ImageView(rexxarPortrait));
    standard.setText("Standard:");
    isInStandard.setText("");
  }

  @FXML
  void getMage() throws Exception {
    db.getMageSecrets();
    secret.getChildren().clear();
    secret.getChildren().add(new ImageView(jainaPortrait));
    standard.setText("Standard:");
    isInStandard.setText("");
  }

  @FXML
  void getPaladin() throws Exception {
    db.getPaladinSecrets();
    secret.getChildren().clear();
    secret.getChildren().add(new ImageView(utherPortrait));
    standard.setText("Standard:");
    isInStandard.setText("");
  }

  @FXML
  void getRogue() throws Exception {
    db.getRogueSecrets();
    secret.getChildren().clear();
    secret.getChildren().add(new ImageView(valeeraPortrait));
    standard.setText("Standard:");
    isInStandard.setText("");
  }

  @FXML
  void next() throws Exception {
    try {
      secret.getChildren().clear();
      secret.getChildren().add(new ImageView(new Image(RESOURCES_FILE_PATH + "Images/Secrets/"
          + db.getnextCard() + ".png", 200, 200, true, true)));
      isInStandard.setText(db.getStandard());
    } catch (Exception ex) {
      noClassError();
    }
  }

  @FXML
  void back() throws Exception {
    try {
      secret.getChildren().clear();
      secret.getChildren().add(new ImageView(new Image(RESOURCES_FILE_PATH + "Images/Secrets/"
          + db.getprevCard() + ".png", 200, 200, true, true)));
      isInStandard.setText(db.getStandard());
    } catch (Exception ex) {
      noClassError();
    }
  }


  @FXML
  void randomSelection() throws Exception {
    try {
      secret.getChildren().clear();
      secret.getChildren().add(new ImageView(new Image(RESOURCES_FILE_PATH + "Images/Secrets/"
          + db.getRandomCard() + ".png", 200, 200, true, true)));
      isInStandard.setText(db.getStandard());
    } catch (Exception ex) {
      noClassError();
    }
  }


  private void noClassError() {
    secret.getChildren().add(new ImageView(secretImage));
    Alert nextButton = new Alert(AlertType.WARNING);
    nextButton.setTitle("Warning");
    nextButton.setHeaderText("No class alert!");
    nextButton.setContentText("Please select a class.");
    nextButton.showAndWait();
  }
}