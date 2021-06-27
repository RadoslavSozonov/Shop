import java.util.Date;

public class Beverage extends PerishableProduct implements Discount{

    /**
     * Constructor of the class
     * @param name - the name of product
     * @param brand - the brand of the product
     * @param price - the price of the product
     * @param date - the expired day of the product
     */
    public Beverage(String name, String brand, double price, Date date) {
        super(name, brand, price, date);
    }

}