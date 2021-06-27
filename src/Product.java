import java.util.Date;

public abstract class Product {
    private String name;
    private String brand;
    private double price;

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected String toString(String quantity){
        return "";
    }

    public abstract String[] productInfo(String quantity, Date date);

    protected double estimatePrice(String quantity){
        double weight = Double.parseDouble(quantity);
        return Math.round(weight* this.getPrice()*100.0)/100.0;
    }
}
