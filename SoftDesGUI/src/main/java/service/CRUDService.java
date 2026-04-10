package service;

import dao.CRUDDao;
import database.Database;
import database.DatabaseInit;
import model.Product;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CRUDService {
    CRUDDao dao = new CRUDDao();
    private Database db = Database.getDbInstance();
    private Connection conn = db.connect();

    // loginValidation
    // assume admin
    // next: differentiate admin and employee
    // next: correct invalid input logs


    // add
    public boolean isValidAddEntries(Product product){
        if(product.getName().isEmpty() || product.getStock() < 0 || product.getPrice() < 0){
            return false;
        }
        return true;
    }
    public void addEntries(Product product){
        if(isValidAddEntries(product)){
            dao.add(product);
            System.out.println("Successfully added product");
        }else{
            System.out.println("Invalid input: Name cannot be empty, Stock and Price cannot be negative.");
        }
    }

    // read
    public List<Product> getAllEntries(){
        return dao.getAllProducts();
    }

    // update
    public void updateEntry(String name, Product newProduct){
        List<Product> allProducts = getAllEntries();
        Product updatedProduct = null;

        // search for product
        for(int i = 0; i < allProducts.size(); i++){
            if(allProducts.get(i).getName().equalsIgnoreCase(name)){
                // update product
                updatedProduct = new Product(
                        newProduct.getName(),
                        newProduct.getStock(),
                        newProduct.getPrice(),
                        newProduct.getDescription()
                );
                dao.updateProduct(i+1, updatedProduct);
                System.out.println("Successfully updated product");
                return;
            }
        }
        System.out.println("Product not found");
    }

    // delete
    public void deleteEntry(String name){
        List<Product> allProducts = getAllEntries();

        // search for product
        for(int i = 0; i < allProducts.size(); i++){
            if(allProducts.get(i).getName().equalsIgnoreCase(name)){
                dao.deleteProduct(i + 1);
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void reduceStock(String name){
        List<Product> allProducts = getAllEntries();

        // search for product
        for(int i = 0; i < allProducts.size(); i++){
            if(allProducts.get(i).getName().equalsIgnoreCase(name)){
                dao.reduceStock(i + 1);
                return;
            }
        }
        System.out.println("Product not found");
    }



}
