package service.stockobserver;


// Concrete Observer
public class Stock implements Observer{
    private String productName;
    private double stockAmount;

    public Stock(String productName, double stockAmount){
        this.productName = productName;
        this.stockAmount = stockAmount;
    }

    @Override
    public void update(String msg) {
        // sout for now
        // next: update ui

        System.out.println(msg);
    }
}
