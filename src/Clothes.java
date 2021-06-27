import java.util.Calendar;
import java.util.Date;

public class Clothes extends Product implements Discount{

    private String size;
    private String color;

    /**
     * Constructor of the class
     * @param name - name of the clothes
     * @param brand - brand of the clothes
     * @param price - price of the clothes
     * @param size - size of the clothes
     * @param color - color of the clothes
     */
    public Clothes(String name, String brand, double price, String size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    /**
     * Get the size of the clothes
     * @return - the size of the clothes
     */
    public String getSize() {
        return size;
    }

    /**
     * Set new size of the clothes
     * @param size - the new size of the clothes
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Get the color of the clothes
     * @return - the color of the clothes
     */
    public String getColor() {
        return color;
    }

    /**
     * Set new color of the clothes
     * @param color - the new color of the clothes
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return an array which contains the text which will be printed and the price and discount of the product
     * @param quantity - the quantity of the product
     * @param date - the date of creation of the cart
     * @return - an array which contains the text which will be printed and the price and discount of the product
     */
    public String[] productInfo(String quantity, Date date) {
        String[] information = new String[3];

        information[0] = this.toString(quantity);                                //the text which will be printed - the name of the product, brand, model, total price and discount
        information[1] = String.valueOf(estimatePrice(quantity));               //the total price of the product
        information[2] = String.valueOf(discount(null,date,Double.parseDouble(information[1])));    //the total discount of the product
        if(!information[2].equals("0.0")){                                      //if the discount is not 0.0 add text of the discount to that which will be printed
            if(Math.round(Double.parseDouble(information[1])*0.1*100.0)/100.0==Double.parseDouble(information[2])){
                information[0] = information[0]+"#discount 10%  -$"+information[2]+"\n";
            }
        }
        return information;
    }

    /**
     * Create the text which will be printed - the name of the product, brand, size, color and total price
     * @param quantity - the number of products
     * @return - text which will be printed - the name of the product, brand, size, color and total price
     */
    @Override
    public String toString(String quantity) {
        int numProducts = Integer.parseInt(quantity);
        return this.getName()+" "+this.getBrand()+" "+this.getSize()+" "+this.getColor()+ "\n"
                +numProducts+" x $" +this.getPrice() +" = $"+estimatePrice(quantity)+"\n";
    }

    /**
     *
     * @param thisDate - null
     * @param providedDate - the day of the creation of the cart
     * @param price - the total price of the product
     * @return - the discount for that product
     * - if purchase is during a working day 10%
     * - else no discount
     */
    @Override
    public double discount(Date thisDate, Date providedDate, double price) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(providedDate);
        if(c1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
        {
            return Math.round(price*0.1*100.0)/100.0;
        }
        return 0.0;
    }
}
