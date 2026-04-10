package service.checkoutcommand;

import model.Product;
import service.CRUDService;

import java.util.ArrayList;
import java.util.List;

public class CheckoutAction {
    // add item
    // delete item
    // pay (checkout)
    // test code
    private static CRUDService service = new CRUDService();
    public List<Product> cart =  new ArrayList<>();

    public void addItem(Product product){
        cart.add(product);
    }

    public void removeItem(Product product){
        for (int i = 0; i < cart.size(); i++){
            if(cart.get(i).getName().equals(product.getName())){
                cart.remove(i);
                break;
            }
        }
        System.out.println("Item to be removed not in cart");
    }

    // accessed by receipt
    public void pay(){
        double totalPrice = 0;
        for(int i = 0; i<cart.size(); i++){
            totalPrice += cart.get(i).getPrice();

            String productName = cart.get(i).getName();
            service.reduceStock(productName);


        }

        // insert code that calls receipt

    }
}
