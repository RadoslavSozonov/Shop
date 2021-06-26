import java.sql.Time;
import java.util.Date;

public class Cashier {
    CatalogOfProducts catalog;

    public Cashier(CatalogOfProducts catalog) {
        this.catalog = catalog;
    }

    public void printReceipt(Cart cart, Date date, Time time){
        double sum=0;
        double discountSum=0;
        String[] information;
        beginningOfReceipt(date,time);
        for(Purchase purchase :cart.getList()){
            information=catalog.readPurchase(purchase,date);
            System.out.println(information[0]);
            sum+= Double.parseDouble(information[1]);
            discountSum+= Double.parseDouble(information[2]);
        }

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("SUBTOTAL: $"+sum);
        System.out.println("DISCOUNT: $"+discountSum+"\n");
        System.out.println("TOTAL: $"+(sum-discountSum));
    }

    public void beginningOfReceipt(Date date, Time time){
        System.out.println("Date: "+date.toString()+" "+time.toString());
        System.out.println("");
        System.out.println("---Products---\n\n");
    }
}
