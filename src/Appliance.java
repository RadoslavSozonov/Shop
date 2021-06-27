import java.util.Calendar;
import java.util.Date;

public class Appliance extends Product implements Discount{

    private String model;
    private Date date;
    private double weight;

    /**
     * Constructor of the class
     * @param name - name of appliance
     * @param brand - brand of appliance
     * @param price - price of appliance
     * @param model - model of appliance
     * @param date - date of appliance
     * @param weight - weight of appliance
     */
    public Appliance(String name, String brand, double price, String model, Date date, double weight) {
        super(name, brand, price);
        this.model = model;
        this.date = date;
        this.weight = weight;
    }

    /**
     * Get the name of the model
     * @return - the name of the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Set a new model name to the product
     * @param model - the model name of the product
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Get the date product
     * @return - the date of product
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set a new date to the product
     * @param date - the date of the product
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the weight of the product
     * @return - the weight of the model
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set a new weight to the product
     * @param weight - the weight of the product
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Return an array which contains the text which will be printed and the price and discount of the product
     * @param quantity - the quantity of the product
     * @param date - the date of creation of the cart
     * @return - an array which contains the text which will be printed and the price and discount of the product
     */
    public String[] productInfo(String quantity, Date date) {
        String[] information = new String[3];

        information[0] = this.toString(quantity);                   //the text which will be printed - the name of the product, brand, model, total price and discount
        information[1] = String.valueOf(estimatePrice(quantity));   //the total price of the product
        information[2] = String.valueOf(discount(null,date,Double.parseDouble(information[1])));    //the total discount of the product
        if(!information[2].equals("0.0")){                          //if the discount is not 0.0 add text of the discount to that which will be printed
            if(Math.round(Double.parseDouble(information[1])*0.05*100.0)/100.0==Double.parseDouble(information[2])){
                information[0] = information[0]+"#discount 5%  -$"+information[2]+"\n";
            }
        }
        return information;
    }

    /**
     * Create the text which will be printed - the name of the product, brand, model and total price
     * @param quantity - the number of products
     * @return - text which will be printed - the name of the product, brand, model and total price
     */
    @Override
    public String toString(String quantity) {
        int numProducts = Integer.parseInt(quantity);
        return this.getName()+" "+this.getBrand()+" "+this.getModel()+"\n"
                +numProducts+" x $" +this.getPrice() +" = $"+estimatePrice(quantity)+"\n";
    }

    /**
     *
     * @param thisDate - the day of creation of the product
     * @param providedDate - the day of the creation of the cart
     * @param price - the total price of the product
     * @return - the discount for that product
     * - if purchase is during the weekend 5%
     * - else no discount
     */
    @Override
    public double discount(Date thisDate, Date providedDate, double price) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(providedDate);
        if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            return Math.round(price*0.05*100.0)/100.0;
        }
        return 0.0;
    }

}
