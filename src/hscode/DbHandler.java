//Nicolas Caceda

package hscode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 * Manages everything database related.
 * It manages the connection, queries through 4 different tables, and keeps track of where it is.
 */
class DbHandler {

  private static final String DATABASE_URL = "jdbc:derby:lib//MyDbTest";
  private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";

  private Connection conn = null;
  private Statement stmt = null;
  private ResultSet rset = null;
  private ArrayList<String> cards = new ArrayList<>();
  private ArrayList<Boolean> inStandardrotation = new ArrayList<>();
  private int cardIterator = 0;
  private String selectQuery = null;
  private Random random = new Random();

  /**
   * Constructor for my database connection.
   */
  DbHandler() {
    try {

      Class.forName(Driver);
      conn = DriverManager.getConnection(DATABASE_URL);

    } catch (Exception e) {

      System.out.println("Error Making Connection");
      System.out.println(e.getMessage());

    }
  }

  /**
   * Gets the HunterSecrets table and initializes to beginning of the list.
   *
   * @throws Exception in case there is no connection made.
   */
  void getHunterSecrets() throws Exception {
    cards.clear();
    inStandardrotation.clear();
    cardIterator = -1;
    selectQuery = "SELECT * FROM HUNTERSECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(selectQuery);

    while (rset.next()) {
      cards.add(rset.getObject(1).toString());
      inStandardrotation.add(Boolean.valueOf(rset.getObject(2).toString()));
    }
  }

  /**
   * Gets the MageSecrets table and initializes to beginning of the list.
   *
   * @throws Exception in case there is no connection made.
   */
  void getMageSecrets() throws Exception {
    cards.clear();
    inStandardrotation.clear();
    cardIterator = -1;
    selectQuery = "SELECT * FROM MAGESECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(selectQuery);

    while (rset.next()) {
      cards.add(rset.getObject(1).toString());
      inStandardrotation.add(Boolean.valueOf(rset.getObject(2).toString()));
    }

  }

  /**
   * Gets the PaladinSecrets table and initializes to beginning of the list.
   *
   * @throws Exception in case there is no connection made.
   */
  void getPaladinSecrets() throws Exception {
    cards.clear();
    inStandardrotation.clear();
    cardIterator = -1;
    selectQuery = "SELECT * FROM PALADINSECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(selectQuery);

    while (rset.next()) {
      cards.add(rset.getObject(1).toString());
      inStandardrotation.add(Boolean.valueOf(rset.getObject(2).toString()));
    }

  }

  /**
   * Gets the RogueSecrets table and initializes to beginning of the list.
   *
   * @throws Exception in case there is no connection made.
   */
  void getRogueSecrets() throws Exception {
    cards.clear();
    inStandardrotation.clear();
    cardIterator = -1;
    selectQuery = "SELECT * FROM ROGUESECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(selectQuery);

    while (rset.next()) {
      cards.add(rset.getObject(1).toString());
      inStandardrotation.add(Boolean.valueOf(rset.getObject(2).toString()));
    }

  }

  /**
   * Gets the next card in the current table.
   *
   * @return Card as a string
   */
  String getnextCard() {
    try {
      cardIterator++;
      System.out.println(cards.get(cardIterator));
    } catch (Exception ex) {
      cardIterator = 0;
      System.out.println(cards.get(cardIterator));
    }
    return cards.get(cardIterator);
  }

  /**
   * Gets the previous card in the current table.
   *
   * @return Card as a string
   */
  String getprevCard() {
    try {
      cardIterator--;
      System.out.println(cards.get(cardIterator));
    } catch (Exception ex) {
      cardIterator = cards.size() - 1;
      System.out.println(cards.get(cardIterator));
    }
    return cards.get(cardIterator);
  }

  /**
   * Gets whether or not the card is in standard.
   *
   * @return true or false as a string
   */
  String getStandard() {
    try {
      System.out.println(inStandardrotation.get(cardIterator).toString());
    } catch (Exception ex) {
      System.out.println(inStandardrotation.get(cardIterator));
    }
    return inStandardrotation.get(cardIterator).toString();
  }

  /**
   * Gets a random card in the current table.
   *
   * @return Card as a string
   */
  String getRandomCard() {
    try {
      cardIterator = random.nextInt(cards.size());
      System.out.println(cards.get(cardIterator));
    } catch (Exception ex) {
      cardIterator = random.nextInt(cards.size());
    }
    return cards.get(cardIterator);
  }
}
