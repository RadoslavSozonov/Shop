import java.util.Calendar;
import java.util.Date;

public class Clothes extends Product implements Discount{

    private String size;
    private String color;

    public Clothes(String name, String brand, double price, String size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String[] productInfo(String quantity, Date date) {
        String[] information = new String[3];

        information[0] = this.toString(quantity);
        information[1] = String.valueOf(estimatePrice(quantity));
        information[2] = String.valueOf(discount(null,date,Double.parseDouble(information[1])));
        if(!information[2].equals("0.0")){
            if(Integer.parseInt(information[1])*0.1==Integer.parseInt(information[2])){
                information[0] = information[0]+"#discount 10%  -$"+information[2]+"\n";
            }
        }
        return information;
    }
    @Override
    public String toString(String quantity) {
        int numProducts = Integer.parseInt(quantity.substring(1));
        return this.getName()+" "+this.getBrand()+" "+this.getSize()+" "+this.getColor()+ "\n\n"
                +numProducts+" x $" +this.getPrice() +" = $"+estimatePrice(quantity)+"\n";
    }

    @Override
    public double discount(Date thisDate, Date providedDate, double price) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(providedDate);
        if(c1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
        {
            return price*0.1;
        }
        return 0.0;
    }
    protected double estimatePrice(String quantity){
        double weight = Double.parseDouble(quantity.substring(1));
        return weight* this.getPrice();
    }
}
