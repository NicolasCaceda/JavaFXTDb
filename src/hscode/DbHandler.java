package hscode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

class DbHandler {

  //private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
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


  DbHandler() {
    try {

      Class.forName(Driver);
      conn = DriverManager.getConnection(DATABASE_URL);

    } catch (Exception e) {

      System.out.println("Error Making Connection");
      System.out.println(e);
      System.out.println(e.getMessage());

    }
  }

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

  String getnextCard() throws Exception {
    try {
      cardIterator++;
      System.out.println(cards.get(cardIterator).toString());
    } catch (Exception ex) {
      cardIterator = 0;
      System.out.println(cards.get(cardIterator));
    }
    return cards.get(cardIterator).toString();
  }

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

  String getStandard() throws Exception {
    try {
      System.out.println(inStandardrotation.get(cardIterator).toString());
    } catch (Exception ex) {
      System.out.println(inStandardrotation.get(cardIterator));
    }
    return inStandardrotation.get(cardIterator).toString();
  }

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
