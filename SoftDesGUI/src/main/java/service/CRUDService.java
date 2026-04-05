package service;

import dao.CRUDDao;
import model.Product;

import java.sql.Connection;

public class CRUDService {
    CRUDDao dao = new CRUDDao();


    // add
    public boolean isValidAddEntries(Product product){
        if(product.getName().isEmpty() || product.getStock() < 0 || product.getPrice() < 0){
            return false;
        }
        return true;
    }
    public void addEntries(Product product, Connection conn){
        if(isValidAddEntries(product)){
            dao.add(product, conn);
        }else{
            System.out.println("Invalid input: Name cannot be empty, Stock and Price cannot be negative.");
        }
    }



}
