package HSCode;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

class dbHandler {

  //private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
  private static final String DATABASE_URL = "jdbc:derby:lib//MyDbTest";
  private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";

  private Connection conn = null;
  private Statement stmt = null;
  private ResultSet rset = null;
  private ResultSetMetaData rsetMeta = null;
  private int columnNumber = 0;
  private ArrayList cards = new ArrayList<String>();
  private int cardIterator = 0;


  dbHandler() {
    try {

      Class.forName(Driver);
      conn = DriverManager.getConnection(DATABASE_URL);

    } catch (Exception e) {

      System.out.println("Error Making Connection");
      System.out.println(e.getMessage());

    }
  }

  void getHunterSecrets() throws Exception {
    cards.clear();
    final String SELECT_QUERY = "SELECT * FROM HUNTERSECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(SELECT_QUERY);
    rsetMeta = rset.getMetaData();
    columnNumber = rsetMeta.getColumnCount();

    while (rset.next()) {
      cards.add(rset.getObject(1));
    }
  }

  void getMageSecrets() throws Exception {
    cards.clear();
    final String SELECT_QUERY = "SELECT * FROM MAGESECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(SELECT_QUERY);
    rsetMeta = rset.getMetaData();
    columnNumber = rsetMeta.getColumnCount();

    while (rset.next()) {
      cards.add(rset.getObject(1));
    }

  }

  void getPaladinSecrets() throws Exception {
    cards.clear();
    final String SELECT_QUERY = "SELECT * FROM PALADINSECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(SELECT_QUERY);
    rsetMeta = rset.getMetaData();
    columnNumber = rsetMeta.getColumnCount();

    while (rset.next()) {
      cards.add(rset.getObject(1));
    }

  }

  void getRogueSecrets() throws Exception {
    cards.clear();
    final String SELECT_QUERY = "SELECT * FROM ROGUESECRETS";
    stmt = conn.createStatement();
    rset = stmt.executeQuery(SELECT_QUERY);
    rsetMeta = rset.getMetaData();
    columnNumber = rsetMeta.getColumnCount();

    while (rset.next()) {
      cards.add(rset.getObject(1));
    }

  }

  String nextCard() throws Exception {
    try {
      System.out.println(cards.get(cardIterator).toString());
    } catch (Exception ex) {
      cardIterator = 0;
      System.out.println(cards.get(cardIterator));
    }
    return cards.get(cardIterator++).toString();
  }

  String prevCard() throws Exception {
    try {
      System.out.println(cards.get(cardIterator).toString());
    } catch (Exception ex) {
      cardIterator = cards.size() - 1;
      System.out.println(cards.get(cardIterator));
    }
    return cards.get(cardIterator--).toString();
  }

}
