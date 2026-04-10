package service.checkoutcommand;

import model.Product;

public class CheckoutAddItem implements Command{
    private CheckoutAction action;
    private Product product;

    public CheckoutAddItem(CheckoutAction action, Product product) {
        this.action = action;
        this.product = product;
    }

    @Override
    public void execute() {
        action.addItem(product);
    }
}
