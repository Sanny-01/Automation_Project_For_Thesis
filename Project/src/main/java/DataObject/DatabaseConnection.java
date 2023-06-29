//package DataObject;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DatabaseConnection {
//    final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=users";
//    final String USERNAME = "TestAutomation";
//    final String PASSWORD = "TestAutomation123";
//
//    Connection conn = null;
//
//    public Connection getConnection() {
//
//        try {
//            // connecting to the database
//            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//            System.out.println("Connected to database named " + conn.getCatalog());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    public void closeConnection() {
//
//        // closing connection
//        try {
//            if (conn != null)
//                conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
