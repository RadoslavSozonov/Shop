import java.util.Date;

public abstract class PerishableProduct extends Product implements Discount{
    private Date date;

    public PerishableProduct(String name, String brand, double price, Date date) {
        super(name, brand, price);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public abstract String toString(String quantity);

    public abstract String[] productInfo(String quantity, Date date);

    protected double estimatePrice(String quantity){
        double weight = Double.parseDouble(quantity.substring(1));
        return weight* this.getPrice();
    }

    @Override
    public double discount(Date thisDate,Date providedDate, double price) {
        if(thisDate.equals(providedDate)){
            return 0.5*price;
        }
        if (Math.abs(thisDate.getDay() - providedDate.getDay()) > 5) {
            return 0.1*price;
        }
        return 0.0;
    }

}
