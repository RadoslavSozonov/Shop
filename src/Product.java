import java.util.Date;

public abstract class Product {
    private String name;
    private String brand;
    private double price;

    /**
     * Constructor of the class
     * @param name - name of product
     * @param brand - brand of product
     * @param price  - price of product
     */
    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    /**
     * Get the name of the product
     * @return - the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name
     * @param name - new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the brand of the product
     * @return - the brand of the product
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set a new brand
     * @param brand - new brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get the price of the product
     * @return - the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set a new price
     * @param price - new price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    protected String toString(String quantity){
        return "";
    }

    /**
     * Return an array which contains the text which will be printed and the price and discount of the product
     * @param quantity - the quantity of the product
     * @param date - the date of creation of the cart
     * @return - an array which contains the text which will be printed and the price and discount of the product
     */
    public abstract String[] productInfo(String quantity, Date date);

    /**
     * Estimate the total price of a product
     * @param quantity - the quantity of the product
     * @return - the total price of the product
     */
    protected double estimatePrice(String quantity){
        double weight = Double.parseDouble(quantity);
        return Math.round(weight* this.getPrice()*100.0)/100.0;
    }
}
