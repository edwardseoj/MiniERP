package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInit {
    public static void initializeDatabase(Connection conn) {

        String[] setupStatements = {
                "CREATE DATABASE IF NOT EXISTS CSELEC11Finals",

                "USE CSELEC11Finals",

                "CREATE TABLE IF NOT EXISTS products (" +
                        "    id INT AUTO_INCREMENT PRIMARY KEY," +
                        "    name VARCHAR(100) NOT NULL," +
                        "    stock INT NOT NULL," +
                        "    price DECIMAL(10,2) NOT NULL," +
                        "    description TEXT" +
                        ")"
        };

        String insertStatement = "INSERT INTO products (name, stock, price, description) VALUES " +
                "('Rice (1kg)', 100, 55.00, 'Regular milled rice')," +
                "('Instant Noodles', 200, 12.00, 'Quick snack instant noodles')," +
                "('Canned Sardines', 150, 22.00, 'Sardines in tomato sauce')," +
                "('Coffee Sachet', 180, 8.00, '3-in-1 instant coffee')," +
                "('Sugar (500g)', 90, 35.00, 'Refined white sugar')," +
                "('Cooking Oil (250ml)', 80, 45.00, 'Vegetable cooking oil')," +
                "('Biscuits Pack', 120, 10.00, 'Sweet snack biscuits')," +
                "('Soft Drinks (1.5L)', 60, 65.00, 'Carbonated soft drink')," +
                "('Bath Soap', 110, 25.00, 'Antibacterial bar soap')";

        try {
            // Execute setup statements
            for (String sql : setupStatements) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.execute();
                ps.close();
            }
            
            // Check if products table is empty
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM products");
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            
            // Insert sample data only if table is empty
            if (count == 0) {
                PreparedStatement ps = conn.prepareStatement(insertStatement);
                ps.execute();
                ps.close();
                System.out.println("Sample data inserted successfully.");
            } else {
                System.out.println("Products table already contains data. Skipping insert.");
            }
            
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
