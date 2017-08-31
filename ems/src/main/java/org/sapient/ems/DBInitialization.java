package org.sapient.ems;

	import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBInitialization {
      public DBInitialization() throws Exception {
            this.initCreateTable();
      }
      public void initCreateTable() throws Exception {
            String dbURL = "jdbc:derby:emsdev;create=true";
            Connection conn = null;
            try {
                  Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                  // Get a connection
                  conn = DriverManager.getConnection(dbURL);
                  DatabaseMetaData dbm = conn.getMetaData();
                  Statement stmt = conn.createStatement();
                  String tables[] = {"EMP"};
                  for (int i = 0 ; i< tables.length; i++) {
                        ResultSet check = dbm.getTables(null,null,tables[i],null);
                        if (check.next()) {
                              stmt.executeUpdate("DROP TABLE "+ tables[i]);
                              stmt.executeUpdate("CREATE TABLE "+ tables[i] +" ( employeeId VARCHAR(255), employeeName VARCHAR(255), deptName VARCHAR(255), salary INTEGER)");
                              }
                        else  {    
                              stmt.executeUpdate("CREATE TABLE "+ tables[i] +" ( employeeId VARCHAR(255), employeeName VARCHAR(255), deptName VARCHAR(255), salary INTEGER)");
                        }
                  }
            } catch (java.sql.SQLException sqle) {
                  sqle.printStackTrace();
                  throw sqle;
            }
      }
}
