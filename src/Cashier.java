import java.sql.Time;
import java.util.Date;

public class Cashier {
    CatalogOfProducts catalog;

    /**
     * Constructor for this class
     * @param catalog - list of all products available in the store
     */
    public Cashier(CatalogOfProducts catalog) {
        this.catalog = catalog;
    }

    /**
     * Print the Receipt
     * @param cart - list of purchases
     * @param date - the date of the created cart
     * @param time - time of the created cart
     */
    public void printReceipt(Cart cart, Date date, Time time){
        Double[] arrayOfSumAndDiscount = new Double[2];
        beginningOfReceipt(date,time);                                      //Print the beginning of the receipt
        arrayOfSumAndDiscount=bodyOfReceipt(cart,date);                     //Print the body of the receipt
        endOfReceipt(arrayOfSumAndDiscount[0],arrayOfSumAndDiscount[1]);    //Print the end part of the receipt
    }

    /**
     * Print the beginning of the receipt
     * @param date - the date of the created cart
     * @param time - time of the created cart
     */
    public void beginningOfReceipt(Date date, Time time){
        System.out.println("Date: "+date.toString()+" "+time.toString());
        System.out.println("");
        System.out.println("---Products---\n");
    }

    /**
     * Print the body of the receipt.
     * Print the purchases with their prices and discounts
     * @param cart - the list of purchases
     * @param date - the date of the created cart
     * @return - return an array containing the total sum of the receipt and its discount
     */
    public Double[] bodyOfReceipt(Cart cart, Date date){
        Double[] arrayOfSumAndDiscount = new Double[2];
        double sum=0;
        double discountSum=0;
        String[] information;
        for(Purchase purchase :cart.getList()){                 //Go through the cart (the list of purchases)
            information=catalog.readPurchase(purchase,date);    //Find the purchase in the catalog
            System.out.println(information[0]);                 //Print the purchase information - product name, price and discount
            sum+= Double.parseDouble(information[1]);           //add the product price to the total
            discountSum+= Double.parseDouble(information[2]);   //add the product discount to the total
        }
        arrayOfSumAndDiscount[0]=sum;
        arrayOfSumAndDiscount[1]=discountSum;
        return arrayOfSumAndDiscount;
    }

    /**
     * Print the end of the receipt
     * @param sum - the total sum of the receipt
     * @param discountSum - the total discount of the receipt
     */
    public void endOfReceipt(double sum, double discountSum){
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("SUBTOTAL: $"+sum);
        System.out.println("DISCOUNT: -$"+discountSum+"\n");
        System.out.println("TOTAL: $"+(sum-discountSum));
    }
}
