import java.util.Date;

public class Beverage extends PerishableProduct implements Discount{
    public Beverage(String name, String brand, double price, Date date) {
        super(name, brand, price, date);
    }

}