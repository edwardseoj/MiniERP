package service.checkoutcommand;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CheckoutAction {
    // add item
    // delete item
    // pay (checkout)
    // test code

    List<Product> cart =  new ArrayList<>();
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
    public double pay(){
        double totalPrice = 0;
        for(int i = 0; i<cart.size(); i++){
            totalPrice += cart.get(i).getPrice();
        }

        // insert code that calls receipt

        return totalPrice;
    }
}
