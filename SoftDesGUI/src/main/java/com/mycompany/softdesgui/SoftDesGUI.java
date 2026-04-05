/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.softdesgui;

import Swing.AdminLogin;

import javax.swing.SwingUtilities;
import testcode.TestDatabaseConnection;

/**
 *
 * @author macbookpro
 */
public class SoftDesGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new AdminLogin().setVisible(true);
        });

//        TestDatabaseConnection.testConnection();


    }
}
