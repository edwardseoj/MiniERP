package dao;

import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDDao {

    public void add(Product product, Connection conn){
        // sql query to add
        String statement = "INSERT INTO products (name, stock, price, description) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getStock());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getDescription());

            ps.executeUpdate();
            System.out.println("Product added");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Failed to add product");
        }
    }
}
