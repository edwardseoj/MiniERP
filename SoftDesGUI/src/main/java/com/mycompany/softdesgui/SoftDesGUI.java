/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.softdesgui;


import swing.AdminLogin;
import javax.swing.SwingUtilities;

import database.Database;
import database.DatabaseInit;

import java.sql.Connection;

/**
 *
 * @author macbookpro
 */
public class SoftDesGUI {

    public static void main(String[] args) {
        Database db1 = Database.getDbInstance();
        Connection conn = db1.connect();
        DatabaseInit.initializeDatabase(conn);

        SwingUtilities.invokeLater(() -> {
            new AdminLogin().setVisible(true);
        });


//        TestDatabaseConnection.testConnection();


    }
}
