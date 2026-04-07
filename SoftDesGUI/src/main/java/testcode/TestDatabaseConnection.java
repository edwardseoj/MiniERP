package testcode;

import database.Database;
import database.DatabaseInit;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void testConnection(){
        System.out.println("Testing database");
        System.out.println("======================");

        // Singleton test
        Database db1 = Database.getDbInstance();
        Database db2 = Database.getDbInstance();
        if(db1 == db2){
            System.out.printf("%-15s %s", "Singleton test: ","True\n\n");
        }else{
            System.out.printf("%-15s %s", "Singleton test: ","False\n\n");
        }

        // Connection test
        Connection conn = db1.connect();
        DatabaseInit.intializeDatabase(conn);
        db1.disconnect();
        System.out.println();

        // Connection after closing test
        try{
            if(conn.isClosed()){
                System.out.printf("%-15s %s", "Connection test (after close): ", "False");
            } else {
                System.out.printf("%-15s %s", "Connection test (after close): ", "True");
            }
        }catch (SQLException e){
            e.getErrorCode();
        }
    }
}
