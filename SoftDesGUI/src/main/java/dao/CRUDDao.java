package dao;

import database.Database;
import model.Product;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDDao {
    Database db = Database.getDbInstance();
    Connection conn = db.connect();

    // Create
    public void add(Product product){
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

    // Read
    public List<Product> getAllProducts(){
        List<Product> allProducts = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product product = new Product(
                        rs.getString("name"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getString("description")
                );
                allProducts.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return allProducts;
    }

    // Update
    public void updateProduct(int id, Product product){
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE products " +
                    "SET name = ?, stock = ?, price = ?, description = ? " +
                    "WHERE id = ?");
            ps.setString(1, product.getName());
            ps.setInt(2, product.getStock());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getDescription());
            ps.setInt(5, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM products WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reduceStock(int id){
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE products " +
                    "SET stock = stock - 1 " +
                    "WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
