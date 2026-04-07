package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInit {
    public static void intializeDatabase(Connection conn){
        try {
            String statement = "-- 1. Create schema (database)\n" +
                    "CREATE DATABASE IF NOT EXISTS CSELEC11Finals;\n" +
                    "\n" +
                    "-- 2. Use the schema\n" +
                    "USE CSELEC11Finals;\n" +
                    "\n" +
                    "-- 3. Create table\n" +
                    "CREATE TABLE IF NOT EXISTS products (\n" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    name VARCHAR(100) NOT NULL,\n" +
                    "    stock INT NOT NULL,\n" +
                    "    price DECIMAL(10,2) NOT NULL,\n" +
                    "    description TEXT\n" +
                    ");\n" +
                    "\n" +
                    "-- 4. Insert 5 sample products\n" +
                    "INSERT INTO products (name, stock, price, description) VALUES\n" +
                    "('Laptop', 10, 45000.00, 'Mid-range laptop for work and gaming'),\n" +
                    "('Smartphone', 25, 15000.00, 'Android smartphone with good camera'),\n" +
                    "('Headphones', 50, 1200.00, 'Noise-cancelling over-ear headphones'),\n" +
                    "('Keyboard', 30, 800.00, 'Mechanical keyboard with RGB lighting'),\n" +
                    "('Mouse', 40, 500.00, 'Wireless ergonomic mouse');";

            PreparedStatement ps = conn.prepareStatement(statement);
            ps.executeUpdate();
            System.out.println("Database initialized");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
