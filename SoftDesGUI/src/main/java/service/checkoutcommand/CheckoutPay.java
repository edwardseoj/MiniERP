package service.checkoutcommand;

import model.Product;
import model.receiptbuilder.Receipt;
import service.discounttype.BulkPurchase;
import service.discounttype.DiscountContext;
import service.discounttype.PromoCode;
import service.discounttype.SeniorPWD;
import swing.Employee.ReceiptPopUp;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPay implements Command {
    private CheckoutAction action;
    private java.awt.Frame parentFrame;
    private String empName;
    private String discountType;   // NEW
    private boolean useLoyalty;    // NEW

    public CheckoutPay(CheckoutAction action, java.awt.Frame parentFrame, String empName,
                       String discountType, boolean useLoyalty) {
        this.action = action;
        this.parentFrame = parentFrame;
        this.empName = empName;
        this.discountType = discountType;
        this.useLoyalty = useLoyalty;
    }

    @Override
    public void execute() {
        List<Product> cart = action.getCart();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        double rawTotal = 0;

        for (Product p : cart) {
            names.add(p.getName());
            prices.add(p.getPrice());
            rawTotal += p.getPrice();
        }

        // Strategy Pattern: apply discount to raw total
        DiscountContext context = new DiscountContext();
        switch (discountType) {
            case "SENIOR": context.setStrategy(new SeniorPWD());    break;
            case "BULK":   context.setStrategy(new BulkPurchase()); break;
            case "PROMO":  context.setStrategy(new PromoCode());    break;
            default:       context.setStrategy(cost -> cost);       break;
        }
        double discountedTotal = context.applyDiscount(rawTotal); // needs fix in DiscountContext too

        // Builder Pattern: build the receipt
        Receipt receipt = new Receipt.Builder("TindahanPRO", empName)
                .setProducts(names)
                .setProductPrices(prices)
                .setTotalPrice(discountedTotal)
                .setDiscountType(discountType)
                .setUseLoyalty(useLoyalty)
                .build();

        // Show receipt popup (consistent with how CheckoutAction.pay() does it)
        ReceiptPopUp popup = new ReceiptPopUp(parentFrame, true);
        popup.populate(receipt);
        popup.setVisible(true);
    }
}