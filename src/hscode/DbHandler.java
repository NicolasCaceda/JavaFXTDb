package hscode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

class DbHandler {

  private static final String DATABASE_URL = "jdbc:derby:lib//MyDbTest";
  private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";

  private Connection conn = null;
  private Statement stmt = null;
  private ResultSet rset = null;
  private ArrayList cards = new ArrayList<String>();
  private ArrayList inStandardrotation = new ArrayList<Boolean>();
  private int cardIterator = 0;
  private String selectQuery = null;
  private Random random = new Random();

  /**
   * Constructor for my database connection
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
   * Gets the HunterSecrets table.
   *
   * @throws Exception in case there is no connection made.
   */
  void getHunterSecrets() throws Exception {
    cards.clear();
    inStandardrotation.clear();
    selectQuery = "SELECT * FROM HUNTERSECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(selectQuery);

    while (rset.next()) {
      cards.add(rset.getObject(1));
      inStandardrotation.add(rset.getObject(2));
    }
  }

  /**
   * Gets the MageSecrets table.
   *
   * @throws Exception in case there is no connection made.
   */
  void getMageSecrets() throws Exception {
    cards.clear();
    inStandardrotation.clear();
    selectQuery = "SELECT * FROM MAGESECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(selectQuery);

    while (rset.next()) {
      cards.add(rset.getObject(1));
      inStandardrotation.add(rset.getObject(2));
    }

  }

  /**
   * Gets the PaladinSecrets table.
   *
   * @throws Exception in case there is no connection made.
   */
  void getPaladinSecrets() throws Exception {
    cards.clear();
    inStandardrotation.clear();
    selectQuery = "SELECT * FROM PALADINSECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(selectQuery);

    while (rset.next()) {
      cards.add(rset.getObject(1));
      inStandardrotation.add(rset.getObject(2));
    }

  }

  /**
   * Gets the RogueSecrets table.
   *
   * @throws Exception in case there is no connection made.
   */
  void getRogueSecrets() throws Exception {
    cards.clear();
    inStandardrotation.clear();
    selectQuery = "SELECT * FROM ROGUESECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(selectQuery);

    while (rset.next()) {
      cards.add(rset.getObject(1));
      inStandardrotation.add(rset.getObject(2));
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
      System.out.println(cards.get(cardIterator).toString());
    } catch (Exception ex) {
      cardIterator = 0;
      System.out.println(cards.get(cardIterator));
    }
    return cards.get(cardIterator).toString();
  }

  /**
   * Gets the previous card in the current table.
   *
   * @return Card as a string
   */
  String getprevCard() throws Exception {
    try {
      cardIterator--;
      System.out.println(cards.get(cardIterator).toString());
    } catch (Exception ex) {
      cardIterator = cards.size() - 1;
      System.out.println(cards.get(cardIterator));
    }
    return cards.get(cardIterator).toString();
  }

  /**
   * Gets whether or not the card is in standard.
   *
   * @return true or false as a string
   */
  String getStandard() throws Exception {
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
  String getRandomCard() throws Exception {
    try {
      cardIterator = random.nextInt(cards.size());
      //cardIterator = cards.indexOf(cards.get(cardIterator));
      System.out.println(cards.get(cardIterator).toString());
    } catch (Exception ex) {
      cardIterator = random.nextInt(cards.size());
    }
    return cards.get(cardIterator).toString();
  }
}
