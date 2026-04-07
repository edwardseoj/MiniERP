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
                "('Laptop', 10, 45000.00, 'Mid-range laptop for work and gaming')," +
                "('Smartphone', 25, 15000.00, 'Android smartphone with good camera')," +
                "('Headphones', 50, 1200.00, 'Noise-cancelling over-ear headphones')," +
                "('Keyboard', 30, 800.00, 'Mechanical keyboard with RGB lighting')," +
                "('Mouse', 40, 500.00, 'Wireless ergonomic mouse')";

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
