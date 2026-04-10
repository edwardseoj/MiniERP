package service.checkoutcommand;

public class CheckoutPay implements Command{
    private CheckoutAction action;

    public CheckoutPay(CheckoutAction action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.pay();
    }
}
