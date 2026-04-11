package service.checkoutcommand;

import model.Product;
import model.receiptbuilder.Receipt;
import service.CRUDService;
import swing.Employee.ReceiptPopUp;

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
    public void pay(java.awt.Frame parentFrame, String empName) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        double totalPrice = 0;

        for (Product p : cart) {
            names.add(p.getName());
            prices.add(p.getPrice());
            totalPrice += p.getPrice();
            service.reduceStock(p.getName());
        }

        // hardcoded store name and employee name
        // builder call
        Receipt receipt = new Receipt.Builder("TindahanPRO", empName)
                .setProducts(names)
                .setProductPrices(prices)
                .setTotalPrice(totalPrice)
                .build();

        ReceiptPopUp popup = new ReceiptPopUp(parentFrame, true);
        popup.populate(receipt);
        popup.setVisible(true);
    }
    // return list
    public List<Product> getCart(){
        return cart;
    }
}
