import java.util.Date;

public class Food extends PerishableProduct implements Discount {
    public Food(String name, String brand, double price, Date date) {
        super(name, brand, price, date);
    }

}