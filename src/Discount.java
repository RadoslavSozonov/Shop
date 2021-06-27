import java.util.Date;

public interface Discount {

    /**
     * Calculate a discount for a product
     * @param thisDate - the date of the product
     * @param providedDate - the date of the cart
     * @param price - the price of the product
     * @return - the discount of a product
     */
    double discount(Date thisDate,Date providedDate, double price);
}
