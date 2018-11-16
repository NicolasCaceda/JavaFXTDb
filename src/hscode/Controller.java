package hscode;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Controls the flow of the program.
 */
public class Controller {

  /**
   * Creates a variable so all other methods in this class can use it.
   */
  private DbHandler db = null;

  /**
   * Create a string that contains a file path to the resources folder.
   */
  private static final String resourcesFilePath = "file:src/Resources/";

  /**
   * Creates a label that will either say true or false.
   */
  @FXML
  private Label isInStandard;

  /**
   * Creates a label to show what isInStadard means by true or false.
   */
  @FXML
  private Label standard;

  /**
   * Will hold all images for the program.
   */
  @FXML
  private HBox secret;

  /**
   * Creates a heartstone logo of type Image in a 200x200 resolution.
   */
  private Image secretImage = new Image(resourcesFilePath + "Images/Hearthstone-Logo.png",
      200,200, true, true);

  /**
   * Creates a Jaina portrait of type Image in a 200x200 resolution.
   */
  @FXML
  private Image jainaPortrait = new Image(resourcesFilePath + "Images/Portraits/Jaina.jpg",
      200,200, false, true);

  /**
   * Creates a Uther portrait of type Image in a 200x200 resolution.
   */
  @FXML
  private Image utherPortrait = new Image(resourcesFilePath + "Images/Portraits/Uther.jpg",
      200,200, false, true);

  /**
   * Creates a Rexxar portrait of type Image in a 200x200 resolution.
   */
  @FXML
  private Image rexxarPortrait = new Image(resourcesFilePath + "Images/Portraits/Rexxar.jpg",
      200,200, false, true);


  /**
   * Creates a Valeera portrait of type Image in a 200x200 resolution.
   */
  @FXML
  private Image valeeraPortrait = new Image(resourcesFilePath + "Images/Portraits/Valeera.jpg",
      200,200, false, true);

  /**
   * Automatically runs to initialize the pane and start up the database.
   */
  @FXML
  public void initialize() {
    secret.getChildren().add(new ImageView(secretImage));
    secret.setAlignment(Pos.CENTER);
    standard.setText("");
    isInStandard.setText("");
    db = new DbHandler();
  }

  /**
   * Selects the Hunter table, clears the pane, shows a picture of Rexxar, and sets the labels.
   */
  @FXML
  void getHunter() throws Exception {
    db.getHunterSecrets();
    secret.getChildren().clear();
    secret.getChildren().add(new ImageView(rexxarPortrait));
    standard.setText("Standard:");
    isInStandard.setText("");
  }

  /**
   * Selects the Mage table, clears the pane, shows a picture of Jaina, and sets the labels.
   */
  @FXML
  void getMage() throws Exception {
    db.getMageSecrets();
    secret.getChildren().clear();
    secret.getChildren().add(new ImageView(jainaPortrait));
    standard.setText("Standard:");
    isInStandard.setText("");
  }

  /**
   * Selects the Paladin table, clears the pane, shows a picture of Uther, and sets the labels.
   */
  @FXML
  void getPaladin() throws Exception {
    db.getPaladinSecrets();
    secret.getChildren().clear();
    secret.getChildren().add(new ImageView(utherPortrait));
    standard.setText("Standard:");
    isInStandard.setText("");
  }

  /**
   * Selects the Rogue table, clears the pane, shows a picture of Valeera, and sets the labels.
   */
  @FXML
  void getRogue() throws Exception {
    db.getRogueSecrets();
    secret.getChildren().clear();
    secret.getChildren().add(new ImageView(valeeraPortrait));
    standard.setText("Standard:");
    isInStandard.setText("");
  }

  /**
   * Clears the secret pane, adds an image of the next secret on the list, and sets the label.
   */
  @FXML
  void next() {
    try {
      secret.getChildren().clear();
      secret.getChildren().add(new ImageView(new Image(resourcesFilePath + "Images/Secrets/"
          + db.getnextCard() + ".png", 200, 200, true,
          true)));
      isInStandard.setText(db.getStandard());
    } catch (Exception ex) {
      noClassError();
    }
  }

  /**
   * Clears the secret pane, adds an image of the previous secret on the list, and sets the label.
   */
  @FXML
  void back() {
    try {
      secret.getChildren().clear();
      secret.getChildren().add(new ImageView(new Image(resourcesFilePath + "Images/Secrets/"
          + db.getprevCard() + ".png", 200, 200, true,
          true)));
      isInStandard.setText(db.getStandard());
    } catch (Exception ex) {
      noClassError();
    }
  }

  /**
   * Clears the secret pane, adds an image of a random secret on the list, and sets the label.
   */
  @FXML
  void randomSelection() {
    try {
      secret.getChildren().clear();
      secret.getChildren().add(new ImageView(new Image(resourcesFilePath + "Images/Secrets/"
          + db.getRandomCard() + ".png", 200, 200, true,
          true)));
      isInStandard.setText(db.getStandard());
    } catch (Exception ex) {
      noClassError();
    }
  }

  /**
   * Shows an alert box when no class is selected and other buttons are being used.
   */
  private void noClassError() {
    secret.getChildren().add(new ImageView(secretImage));
    Alert nextButton = new Alert(AlertType.WARNING);
    nextButton.setTitle("Warning");
    nextButton.setHeaderText("No class alert!");
    nextButton.setContentText("Please select a class.");
    nextButton.showAndWait();
  }
}