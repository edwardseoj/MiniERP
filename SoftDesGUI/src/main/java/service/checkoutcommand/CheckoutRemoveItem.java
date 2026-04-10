package service.checkoutcommand;

import model.Product;

public class CheckoutRemoveItem implements Command{
    private CheckoutAction action;
    private Product product;

    public CheckoutRemoveItem(CheckoutAction action, Product product) {
        this.action = action;
        this.product = product;
    }

    @Override
    public void execute() {
        action.removeItem(product);
    }
}
