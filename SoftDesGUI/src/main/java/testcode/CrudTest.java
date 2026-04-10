package testcode;

import dao.CRUDDao;
import model.Product;
import service.CRUDService;

public class CrudTest {
    static CRUDService service= new CRUDService();

    // hardcoded values
    public static void testAdd(){
        Product addProduct = new Product("testAdd", 25, 59.76, "Testing add");
        service.addEntries(addProduct);
    }

    public static void testUpdate(){
        String name = "Smartphone"; // change values here
        Product updateProduct = new Product("testUpdate", 56, 89.7, "Testing update");
        service.updateEntry(name, updateProduct);
    }

    public static void testDelete(){
        String name = "testAdd";
        service.deleteEntry(name);
    }
}
