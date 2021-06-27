import java.util.Date;

public abstract class PerishableProduct extends Product implements Discount{
    private Date date;

    /**
     * Constructor of the class
     * @param name - the name of product
     * @param brand - the brand of the product
     * @param price - the price of the product
     * @param date - the expired day of the product
     */
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

    /**
     * Return an array which contains the text which will be printed and the price and discount of the product
     * @param quantity - the quantity of the product
     * @param date - the date of creation of the cart
     * @return - an array which contains the text which will be printed and the price and discount of the product
     */
    public String[] productInfo(String quantity, Date date) {
        String[] information = new String[3];

        information[0] = this.toString(quantity);                       //the text which will be printed - the name of the product, brand, model, total price and discount
        information[1] = String.valueOf(estimatePrice(quantity));       //the total price of the product
        information[2] = String.valueOf(discount(this.getDate(),date,Double.parseDouble(information[1])));      //the total discount of the product
        if(!information[2].equals("0.0")){                              //if the discount is not 0.0 add text of the discount to that which will be printed
            if(Math.round(Double.parseDouble(information[1])*0.1*100.0)/100.0==Double.parseDouble(information[2])){
                information[0] = information[0]+"#discount 10%  -$"+information[2]+"\n";
            }
            else if(Math.round(Double.parseDouble(information[1])*0.5*100.0)/100.0==Double.parseDouble(information[2])){
                information[0] = information[0]+"#discount 50%  -$"+information[2]+"\n";
            }

        }
        return information;
    }

    /**
     * Create the text which will be printed - the name of the product, brand and total price
     * @param quantity - the number of products
     * @return - text which will be printed - the name of the product, brand and total price
     */
    @Override
    protected String toString(String quantity) {
        double weight = Double.parseDouble(quantity);
        return this.getName()+" - "+this.getBrand()+"\n"
                +weight+" x $" +this.getPrice() +" = $"+estimatePrice(quantity)+"\n";
    }

    /**
     *
     * @param thisDate - the expired date of the product
     * @param providedDate - the day of the creation of the cart
     * @param price - the total price of the product
     * @return - the discount for that product
     * - if the expired day and provided one are equal discount of 50%
     * - if the expired day is in maximum of 5 days to the provided one - 10%
     * - else no discount
     */
    @Override
    public double discount(Date thisDate, Date providedDate, double price) {
        if(thisDate.equals(providedDate)){
            return Math.round(price*0.5*100.0)/100.0;
        }
        if (Math.abs(thisDate.getDay() - providedDate.getDay()) > 5) {
            return Math.round(price*0.1*100.0)/100.0;
        }
        return 0.0;
    }

}
