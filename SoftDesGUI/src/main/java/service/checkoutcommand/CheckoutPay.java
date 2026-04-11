package service.checkoutcommand;

public class CheckoutPay implements Command {
    private CheckoutAction action;
    private java.awt.Frame parentFrame;
    private String empName;

    public CheckoutPay(CheckoutAction action, java.awt.Frame parentFrame, String empName) {
        this.action = action;
        this.parentFrame = parentFrame;
        this.empName = empName;
    }

    @Override
    public void execute() {
        action.pay(parentFrame, empName);
    }
}